#!/usr/bin/env python3
"""
Portfolio Image WebP Converter & URL Updater

1. Converts heavy PNG/JPG assets to modern WebP format (visual quality 85).
2. Updates all source code references (.kt, .kts, .html, etc.) from .png/.jpg to .webp.
3. Removes original PNGs to immediately save disk and deployment size.

Usage:
  python3 scripts/convert_to_webp.py --dry-run      # Preview conversions and code updates without making changes
  python3 scripts/convert_to_webp.py                # Perform full conversion and update source references
  python3 scripts/convert_to_webp.py --keep-png     # Keep original PNGs alongside the new WebP files
"""

import os
import sys
import argparse

try:
    from PIL import Image
except ImportError:
    print("Error: Pillow is required. Install it using: pip3 install Pillow")
    sys.exit(1)

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
PROJECT_ROOT = os.path.abspath(os.path.join(SCRIPT_DIR, ".."))
PUBLIC_DIR = os.path.join(PROJECT_ROOT, "site/src/jsMain/resources/public")
SRC_DIR = os.path.join(PROJECT_ROOT, "site")

CODE_EXTENSIONS = {".kt", ".kts", ".html", ".css", ".js", ".json", ".yaml", ".yml", ".md"}

# Folders to optimize (skipping favicon icons which require legacy PNG format)
TARGET_FOLDERS = ["project", "services", "articles", "blog"]


def find_convertible_images(min_size_kb=50):
    """Finds all PNG and JPG images in target folders that meet the size threshold."""
    candidates = []
    for folder in TARGET_FOLDERS:
        folder_path = os.path.join(PUBLIC_DIR, folder)
        if not os.path.exists(folder_path):
            continue
        for root, dirs, files in os.walk(folder_path):
            for f in files:
                ext = os.path.splitext(f)[1].lower()
                if ext in {".png", ".jpg", ".jpeg"}:
                    full_path = os.path.join(root, f)
                    size_bytes = os.path.getsize(full_path)
                    if size_bytes >= min_size_kb * 1024:
                        rel_path = os.path.relpath(full_path, PUBLIC_DIR)
                        web_path_orig = "/" + rel_path.replace("\\", "/")
                        
                        base_name, _ = os.path.splitext(f)
                        webp_filename = base_name + ".webp"
                        webp_full_path = os.path.join(root, webp_filename)
                        webp_rel_path = os.path.relpath(webp_full_path, PUBLIC_DIR)
                        web_path_webp = "/" + webp_rel_path.replace("\\", "/")

                        candidates.append({
                            "orig_full": full_path,
                            "orig_filename": f,
                            "orig_web_path": web_path_orig,
                            "orig_size": size_bytes,
                            "webp_full": webp_full_path,
                            "webp_filename": webp_filename,
                            "webp_web_path": web_path_webp,
                        })
    return candidates


def update_source_code_references(replacement_map, dry_run=False):
    """Updates all source code references from old image paths to new WebP paths."""
    modified_files = {}

    for root, dirs, files in os.walk(SRC_DIR):
        normalized_root = root.replace("\\", "/")
        # Skip resources/public, build output, .kobweb cache, and .gradle
        if any(skip in normalized_root for skip in ["resources/public", "/build", "/.kobweb", "/.gradle"]):
            continue
        for f in files:
            ext = os.path.splitext(f)[1].lower()
            if ext in CODE_EXTENSIONS:
                file_path = os.path.join(root, f)
                try:
                    with open(file_path, "r", encoding="utf-8") as file:
                        content = file.read()

                    new_content = content
                    replacements_in_file = 0

                    for orig_web, webp_web in replacement_map.items():
                        if orig_web in new_content:
                            new_content = new_content.replace(orig_web, webp_web)
                            replacements_in_file += content.count(orig_web)

                    if replacements_in_file > 0:
                        modified_files[file_path] = replacements_in_file
                        if not dry_run:
                            with open(file_path, "w", encoding="utf-8") as file:
                                file.write(new_content)
                except Exception as e:
                    print(f"Error reading/writing {file_path}: {e}")

    return modified_files


def run_conversion(quality=85, min_size_kb=50, dry_run=False, keep_png=False):
    print("=" * 74)
    print(" 🖼️  Portfolio WebP Image Optimizer & URL Updater")
    print("=" * 74)
    if dry_run:
        print("🔍 RUNNING IN DRY-RUN MODE (No files will be modified or deleted)\n")

    candidates = find_convertible_images(min_size_kb=min_size_kb)
    if not candidates:
        print("No images found meeting the criteria.")
        return

    print(f"Found {len(candidates)} images in {TARGET_FOLDERS} (>= {min_size_kb} KB)")
    total_orig_size = sum(c["orig_size"] for c in candidates)
    print(f"Total current size: {total_orig_size / (1024 * 1024):.2f} MB\n")

    total_webp_size = 0
    replacement_map = {}

    print("Converting images:")
    print("-" * 74)

    for i, item in enumerate(candidates, 1):
        orig_p = item["orig_full"]
        webp_p = item["webp_full"]

        try:
            im = Image.open(orig_p)
            # Handle RGBA / Palette mode transparency smoothly
            if im.mode in ("RGBA", "LA") or (im.mode == "P" and "transparency" in im.info):
                im = im.convert("RGBA")
            else:
                im = im.convert("RGB")

            if not dry_run:
                im.save(webp_p, format="WEBP", quality=quality, method=4)
                webp_size = os.path.getsize(webp_p)
                if not keep_png and os.path.exists(webp_p) and webp_size > 0:
                    os.remove(orig_p)
            else:
                # In dry run, simulate in-memory conversion to get exact size
                import io
                buf = io.BytesIO()
                im.save(buf, format="WEBP", quality=quality, method=4)
                webp_size = buf.tell()

            total_webp_size += webp_size
            replacement_map[item["orig_web_path"]] = item["webp_web_path"]

            reduction = ((item["orig_size"] - webp_size) / item["orig_size"]) * 100
            print(f" [{i:3d}/{len(candidates)}] {item['orig_web_path']}")
            print(f"       {item['orig_size'] / 1024:6.1f} KB -> {webp_size / 1024:6.1f} KB (-{reduction:.1f}%)")

        except Exception as e:
            print(f" Error converting {item['orig_web_path']}: {e}")
            total_webp_size += item["orig_size"]

    # Now update source code references
    print("\nUpdating source code references:")
    print("-" * 74)
    modified_files = update_source_code_references(replacement_map, dry_run=dry_run)

    for fpath, count in modified_files.items():
        rel_fpath = os.path.relpath(fpath, PROJECT_ROOT)
        status = "[WOULD UPDATE]" if dry_run else "[UPDATED]"
        print(f" {status} {rel_fpath} ({count} URLs updated)")

    saved_bytes = total_orig_size - total_webp_size
    saved_mb = saved_bytes / (1024 * 1024)
    pct = (saved_bytes / total_orig_size) * 100

    print("\n" + "=" * 74)
    print(" 🎉 OPTIMIZATION SUMMARY:")
    print("=" * 74)
    print(f" Images Converted:      {len(candidates)}")
    print(f" Original Total Size:   {total_orig_size / (1024 * 1024):.2f} MB")
    print(f" Optimized WebP Size:   {total_webp_size / (1024 * 1024):.2f} MB")
    print(f" Total Space Saved:     {saved_mb:.2f} MB ({pct:.1f}% reduction)")
    print(f" Source Files Updated:  {len(modified_files)}")
    print("=" * 74)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Convert heavy images to WebP and update code URLs.")
    parser.add_argument("--dry-run", action="store_true", help="Preview conversions without writing changes.")
    parser.add_argument("--quality", type=int, default=85, help="WebP quality (0-100, default: 85).")
    parser.add_argument("--min-size-kb", type=int, default=50, help="Minimum file size in KB to convert (default: 50).")
    parser.add_argument("--keep-png", action="store_true", help="Keep original PNG files instead of deleting them.")
    args = parser.parse_args()

    run_conversion(
        quality=args.quality,
        min_size_kb=args.min_size_kb,
        dry_run=args.dry_run,
        keep_png=args.keep_png
    )
