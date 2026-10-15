#!/usr/bin/env python3
"""
Standardize Opacity Tiers for Portfolio-Kobweb
Consolidates 50+ random alpha values into 4 standardized Design System tiers:
- alpha <= 0.10: .subtle (0.08)
- 0.11 <= alpha <= 0.22: .soft (0.15)
- 0.23 <= alpha <= 0.44: .medium (0.30)
- alpha >= 0.45: .strong (0.60)
"""

import os
import re
import sys

SRC_DIR = os.path.abspath(os.path.join(os.path.dirname(__file__), "..", "site", "src", "jsMain", "kotlin"))
EXCLUDED_FILES = {"Theme.kt", "MediumContent.kt"}

# Match Theme.<Color>.toRgba(<alpha>)
TO_RGBA_PATTERN = re.compile(r'Theme\.([A-Za-z0-9_]+)\.toRgba\(\s*([0-9\.]+)\s*\)')
# Match Theme.<Color>.toRgbColor(<alpha>)
TO_RGBCOLOR_PATTERN = re.compile(r'Theme\.([A-Za-z0-9_]+)\.toRgbColor\(\s*([0-9\.]+)f?\s*\)')

def map_alpha_to_tier(alpha_str):
    try:
        val = float(alpha_str)
    except ValueError:
        return None

    if val <= 0.10:
        return "subtle"
    elif val <= 0.22:
        return "soft"
    elif val <= 0.44:
        return "medium"
    else:
        return "strong"

def process_file(content):
    changes = 0

    def repl_rgba(match):
        nonlocal changes
        color = match.group(1)
        alpha = match.group(2)
        tier = map_alpha_to_tier(alpha)
        if tier:
            changes += 1
            return f"Theme.{color}.{tier}"
        return match.group(0)

    def repl_rgbcolor(match):
        nonlocal changes
        color = match.group(1)
        alpha = match.group(2)
        tier = map_alpha_to_tier(alpha)
        if tier:
            changes += 1
            return f"Theme.{color}.{tier}Rgb"
        return match.group(0)

    new_content = TO_RGBA_PATTERN.sub(repl_rgba, content)
    new_content = TO_RGBCOLOR_PATTERN.sub(repl_rgbcolor, new_content)

    return new_content, changes

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

                new_content, changes = process_file(content)

                if changes > 0:
                    total_files += 1
                    total_changes += changes
                    print(f"[{'DRY-RUN' if dry_run else 'APPLY'}] {rel}: {changes} replacements")

                    if not dry_run:
                        with open(path, "w", encoding="utf-8") as file:
                            file.write(new_content)

    print("\n" + "=" * 60)
    print(f"Total: {total_changes} replacements across {total_files} files.")
    print("=" * 60)

if __name__ == "__main__":
    is_dry = "--apply" not in sys.argv
    if is_dry:
        print("🔍 RUNNING IN DRY-RUN MODE (pass --apply to execute changes)...")
    else:
        print("🚀 APPLYING STANDARDIZED TIERS...")
    run(dry_run=is_dry)
