#!/usr/bin/env python3
"""
Color Analysis and Centralization Helper for Portfolio-Kobweb
Scans all Kotlin files in site/src/jsMain/kotlin for non-Theme colors:
1. Named Colors: Colors.White, Color.transparent, Color.lightgray, etc.
2. Direct rgb/rgba: rgba(16, 185, 129, ...), rgba(0, 0, 0, ...), rgba(255, 255, 255, ...)
3. Hex Color("#...")
"""

import os
import re
from collections import defaultdict

SRC_DIR = os.path.abspath(os.path.join(os.path.dirname(__file__), "..", "site", "src", "jsMain", "kotlin"))
EXCLUDED_FILES = {"Theme.kt", "MediumContent.kt"}

# Matchers
NAMED_COLOR_RE = re.compile(r'\b(Color|Colors)\.(White|Black|lightgray|transparent|red|green|blue|Transparent)\b')
DIRECT_RGB_RE = re.compile(r'(?:(?:Color|rgbColor)\.)?(?:rgba|rgb)\s*\([^)]+\)')
HEX_COLOR_RE = re.compile(r'Color\s*\(\s*["\']#[0-9a-fA-F]{3,8}["\']\s*\)')

def analyze_all_colors():
    findings = defaultdict(list)
    file_stats = defaultdict(int)

    for root, _, files in os.walk(SRC_DIR):
        for f in sorted(files):
            if f.endswith(".kt") and f not in EXCLUDED_FILES:
                path = os.path.join(root, f)
                rel = os.path.relpath(path, SRC_DIR)
                with open(path, "r", encoding="utf-8") as file:
                    for line_no, line in enumerate(file, 1):
                        if line.strip().startswith("import "):
                            continue

                        for m in NAMED_COLOR_RE.finditer(line):
                            findings["Named Colors (Colors.White, Color.transparent, etc.)"].append(
                                (rel, line_no, m.group(0), line.strip())
                            )
                            file_stats[rel] += 1

                        for m in DIRECT_RGB_RE.finditer(line):
                            findings["Direct rgb / rgba"].append(
                                (rel, line_no, m.group(0), line.strip())
                            )
                            file_stats[rel] += 1

                        for m in HEX_COLOR_RE.finditer(line):
                            findings["Hex Color(#...)"].append(
                                (rel, line_no, m.group(0), line.strip())
                            )
                            file_stats[rel] += 1

    total = sum(len(v) for v in findings.values())
    print("=" * 80)
    print(f"🎨 COMPLETE COLOR AUDIT: {total} raw/non-Theme color occurrences found in {len(file_stats)} files")
    print("=" * 80)

    for cat, items in findings.items():
        print(f"\n📂 {cat} ({len(items)} total):")
        print("-" * 80)
        grouped = defaultdict(list)
        for rel, line_no, val, _ in items:
            grouped[val].append((rel, line_no))
        for val, locs in sorted(grouped.items(), key=lambda x: len(x[1]), reverse=True):
            sample = locs[0]
            print(f"  • {len(locs):2d}x  {val:<35} (e.g. {sample[0]}:{sample[1]})")

    print("\n" + "=" * 80)
    print("📋 TOP FILES WITH NON-THEME COLORS:")
    print("-" * 80)
    for f, c in sorted(file_stats.items(), key=lambda x: x[1], reverse=True)[:10]:
        print(f"  {c:2d} in {f}")

    print("\n💡 RECOMMENDED ACTIONS FOR Theme.kt:")
    print("  1. Add Transparent token: Theme.Transparent (Color.transparent, rgbColor.rgba(0,0,0,0))")
    print("  2. Replace Colors.White with Theme.White.rgb or Theme.White.color")
    print("  3. Replace Color.lightgray with Theme.LightGray.color")
    print("  4. Centralize rgba helpers: Theme.Primary.toRgba(alpha), Theme.White.toRgba(alpha), Theme.Black.toRgba(alpha)")
    print("=" * 80)

if __name__ == "__main__":
    analyze_all_colors()
