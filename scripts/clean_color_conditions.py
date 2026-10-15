#!/usr/bin/env python3
"""
Clean Color Conditions Script for Portfolio-Kobweb
1. Eliminates redundant conditions where light == dark
2. Replaces common glass/card patterns with semantic tokens (colorMode.glassSubtle, colorMode.glassSoft, colorMode.cardBg)
3. Simplifies remaining if (colorMode.isLight) A else B into colorMode.select(A, B)
"""

import os
import re
import sys

SRC_DIR = os.path.abspath(os.path.join(os.path.dirname(__file__), "..", "site", "src", "jsMain", "kotlin"))
EXCLUDED_FILES = {"Theme.kt", "MediumContent.kt"}

REDUNDANT_PATTERN = re.compile(r'if\s*\(\s*colorMode\.isLight\s*\)\s*([A-Za-z0-9_\.]+)\s+else\s+\1\b')
GLASS_SUBTLE_PATTERN = re.compile(r'if\s*\(\s*colorMode\.isLight\s*\)\s*Theme\.Black\.subtle\s+else\s+Theme\.White\.subtle\b')
GLASS_SOFT_PATTERN = re.compile(r'if\s*\(\s*colorMode\.isLight\s*\)\s*Theme\.Black\.soft\s+else\s+Theme\.White\.soft\b')
CARD_BG_PATTERN = re.compile(r'if\s*\(\s*colorMode\.isLight\s*\)\s*Theme\.White\.color\s+else\s+Theme\.DarkCardBackGroundColor\.(?:color|strong)\b')
SELECT_PATTERN = re.compile(r'if\s*\(\s*colorMode\.isLight\s*\)\s*([A-Za-z0-9_\.]+(?:\([^\)]*\))?)\s+else\s+([A-Za-z0-9_\.]+(?:\([^\)]*\))?)')

def clean_content(content):
    changes = 0

    # 1. Redundant identical branches (if light A else A -> A)
    def repl_redundant(m):
        nonlocal changes
        changes += 1
        return m.group(1)
    content = REDUNDANT_PATTERN.sub(repl_redundant, content)

    # 2. Semantic tokens
    def repl_glass_subtle(m):
        nonlocal changes
        changes += 1
        return "colorMode.glassSubtle"
    content = GLASS_SUBTLE_PATTERN.sub(repl_glass_subtle, content)

    def repl_glass_soft(m):
        nonlocal changes
        changes += 1
        return "colorMode.glassSoft"
    content = GLASS_SOFT_PATTERN.sub(repl_glass_soft, content)

    def repl_card_bg(m):
        nonlocal changes
        changes += 1
        return "colorMode.cardBg"
    content = CARD_BG_PATTERN.sub(repl_card_bg, content)

    # 3. Simple single-line colorMode.select(A, B)
    def repl_select(m):
        nonlocal changes
        a = m.group(1).strip()
        b = m.group(2).strip()
        # Only replace if both are simple tokens/expressions (avoid complex nested multiline blocks)
        if "\n" not in a and "\n" not in b and len(a) < 50 and len(b) < 50:
            changes += 1
            return f"colorMode.select({a}, {b})"
        return m.group(0)

    content = SELECT_PATTERN.sub(repl_select, content)

    return content, changes

def ensure_imports(content):
    if "package com.coding.meet.util" in content:
        return content

    needed = []
    if "colorMode.select(" in content and "import com.coding.meet.util.select" not in content and "import com.coding.meet.util.*" not in content:
        needed.append("import com.coding.meet.util.select")
    if "colorMode.glassSubtle" in content and "import com.coding.meet.util.glassSubtle" not in content and "import com.coding.meet.util.*" not in content:
        needed.append("import com.coding.meet.util.glassSubtle")
    if "colorMode.glassSoft" in content and "import com.coding.meet.util.glassSoft" not in content and "import com.coding.meet.util.*" not in content:
        needed.append("import com.coding.meet.util.glassSoft")
    if "colorMode.cardBg" in content and "import com.coding.meet.util.cardBg" not in content and "import com.coding.meet.util.*" not in content:
        needed.append("import com.coding.meet.util.cardBg")

    if not needed:
        return content

    lines = content.split('\n')
    last_import = -1
    for i, l in enumerate(lines):
        if l.startswith("import "):
            last_import = i
    if last_import != -1:
        for imp in reversed(needed):
            lines.insert(last_import + 1, imp)
    return '\n'.join(lines)

def run(dry_run=True):
    total_files = 0
    total_changes = 0

    for root, _, files in os.walk(SRC_DIR):
        for f in sorted(files):
            if f.endswith(".kt") and f not in EXCLUDED_FILES:
                path = os.path.join(root, f)
                rel = os.path.relpath(path, SRC_DIR)

                with open(path, "r", encoding="utf-8") as file:
                    content = file.read()

                new_content, changes = clean_content(content)

                if changes > 0:
                    total_files += 1
                    total_changes += changes
                    print(f"[{'DRY-RUN' if dry_run else 'APPLY'}] {rel}: {changes} cleanups")

                    if not dry_run:
                        new_content = ensure_imports(new_content)
                        with open(path, "w", encoding="utf-8") as file:
                            file.write(new_content)

    print("\n" + "=" * 60)
    print(f"Total: {total_changes} cleanups across {total_files} files.")
    print("=" * 60)

if __name__ == "__main__":
    is_dry = "--apply" not in sys.argv
    if is_dry:
        print("🔍 RUNNING IN DRY-RUN MODE (pass --apply to execute changes)...")
    else:
        print("🚀 APPLYING CLEANUPS...")
    run(dry_run=is_dry)
