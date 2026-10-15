#!/usr/bin/env python3
"""
Color Centralization Script for Portfolio-Kobweb
Safely replaces hardcoded colors across Kotlin files with centralized Theme tokens:
- Colors.White -> Theme.White.rgb
- Color.lightgray -> Theme.LightGray.color
- Color.transparent -> Theme.Transparent.color
- rgba(16, 185, 129, alpha) -> Theme.Primary.toRgba(alpha)
- rgba(0, 0, 0, alpha) -> Theme.Black.toRgba(alpha)
- rgba(255, 255, 255, alpha) -> Theme.White.toRgba(alpha)
"""

import os
import re
import sys

SRC_DIR = os.path.abspath(os.path.join(os.path.dirname(__file__), "..", "site", "src", "jsMain", "kotlin"))
EXCLUDED_FILES = {"Theme.kt", "MediumContent.kt"}

REPLACEMENTS = [
    # Named colors
    (re.compile(r'\bColors\.White\b'), 'Theme.White.rgb'),
    (re.compile(r'\bColor\.lightgray\b'), 'Theme.LightGray.color'),
    (re.compile(r'\bColor\.transparent\b'), 'Theme.Transparent.color'),

    # Primary Emerald rgba variations
    (re.compile(r'(?:org\.jetbrains\.compose\.web\.css\.)?rgba\(\s*16\s*,\s*185\s*,\s*129\s*,\s*([0-9\.]+)\s*\)'),
     r'Theme.Primary.toRgba(\1)'),

    # Black rgba variations
    (re.compile(r'(?:org\.jetbrains\.compose\.web\.css\.)?rgba\(\s*0\s*,\s*0\s*,\s*0\s*,\s*([0-9\.]+)\s*\)'),
     r'Theme.Black.toRgba(\1)'),

    # White rgba variations
    (re.compile(r'(?:org\.jetbrains\.compose\.web\.css\.)?rgba\(\s*255\s*,\s*255\s*,\s*255\s*,\s*([0-9\.]+)\s*\)'),
     r'Theme.White.toRgba(\1)'),
]

THEME_IMPORT = "import com.coding.meet.util.Theme"

def ensure_theme_import(content):
    if "import com.coding.meet.util.Theme" in content or "package com.coding.meet.util" in content:
        return content

    # Insert after package statement or after last import
    lines = content.split('\n')
    package_idx = -1
    last_import_idx = -1

    for idx, line in enumerate(lines):
        if line.startswith('package '):
            package_idx = idx
        elif line.startswith('import '):
            last_import_idx = idx

    if last_import_idx != -1:
        lines.insert(last_import_idx + 1, THEME_IMPORT)
    elif package_idx != -1:
        lines.insert(package_idx + 1, '\n' + THEME_IMPORT)
    else:
        lines.insert(0, THEME_IMPORT)

    return '\n'.join(lines)

def run(dry_run=True):
    total_files_changed = 0
    total_replacements = 0

    for root, _, files in os.walk(SRC_DIR):
        for f in sorted(files):
            if f.endswith('.kt') and f not in EXCLUDED_FILES:
                filepath = os.path.join(root, f)
                rel_path = os.path.relpath(filepath, SRC_DIR)

                with open(filepath, 'r', encoding='utf-8') as file:
                    content = file.read()

                new_content = content
                file_replacements = 0

                for pattern, repl in REPLACEMENTS:
                    matches = list(pattern.finditer(new_content))
                    if matches:
                        file_replacements += len(matches)
                        new_content = pattern.sub(repl, new_content)

                if file_replacements > 0:
                    total_files_changed += 1
                    total_replacements += file_replacements
                    print(f"[{'DRY-RUN' if dry_run else 'APPLY'}] {rel_path}: {file_replacements} replacements")

                    if not dry_run:
                        new_content = ensure_theme_import(new_content)
                        with open(filepath, 'w', encoding='utf-8') as file:
                            file.write(new_content)

    print("\n" + "=" * 60)
    print(f"Total: {total_replacements} replacements across {total_files_changed} files.")
    print("=" * 60)

if __name__ == "__main__":
    is_dry = "--apply" not in sys.argv
    if is_dry:
        print("🔍 RUNNING IN DRY-RUN MODE (pass --apply to execute changes)...")
    else:
        print("🚀 APPLYING CENTRALIZED THEME CHANGES...")
    run(dry_run=is_dry)
