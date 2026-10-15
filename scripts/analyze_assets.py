#!/usr/bin/env python3
"""
Portfolio Asset & Image Analyzer

Scans the Kobweb project to identify:
1. Unused images in `site/src/jsMain/resources/public`
2. Heaviest assets currently in use
3. Potential storage and network savings via WebP compression

Usage:
  python3 scripts/analyze_assets.py
  python3 scripts/analyze_assets.py --delete-unused   # Prompts and deletes unused files
"""

import os
import sys
import argparse

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
PROJECT_ROOT = os.path.abspath(os.path.join(SCRIPT_DIR, ".."))
PUBLIC_DIR = os.path.join(PROJECT_ROOT, "site/src/jsMain/resources/public")

SCAN_TARGETS = [
    os.path.join(PROJECT_ROOT, "site/src/jsMain"),
    os.path.join(PROJECT_ROOT, "site/build.gradle.kts"),
    os.path.join(PROJECT_ROOT, "build.gradle.kts"),
    os.path.join(PROJECT_ROOT, "settings.gradle.kts"),
    os.path.join(PROJECT_ROOT, "site/.kobweb/conf.yaml"),
    os.path.join(PROJECT_ROOT, "firebase.json"),
]

IMAGE_EXTENSIONS = {".png", ".jpg", ".jpeg", ".svg", ".webp", ".gif", ".ico"}
CODE_EXTENSIONS = {".kt", ".kts", ".html", ".css", ".js", ".json", ".xml", ".yaml", ".yml", ".md"}


def gather_code_content():
    """Reads all project source and configuration files into memory."""
    parts = []
    file_count = 0
    for target in SCAN_TARGETS:
        if os.path.isfile(target):
            try:
                with open(target, "r", encoding="utf-8", errors="ignore") as f:
                    parts.append(f.read())
                    file_count += 1
            except Exception:
                pass
        elif os.path.isdir(target):
            for root, dirs, files in os.walk(target):
                # Don't scan raw media in public as code, but scan public html/css/js/yaml if any
                for f in files:
                    ext = os.path.splitext(f)[1].lower()
                    if ext in CODE_EXTENSIONS:
                        path = os.path.join(root, f)
                        try:
                            with open(path, "r", encoding="utf-8", errors="ignore") as fl:
                                parts.append(fl.read())
                                file_count += 1
                        except Exception:
                            pass
    return "\n".join(parts), file_count


def scan_images():
    """Finds all image files in public directory."""
    images = []
    for root, dirs, files in os.walk(PUBLIC_DIR):
        for f in files:
            if f == ".DS_Store":
                continue
            ext = os.path.splitext(f)[1].lower()
            if ext in IMAGE_EXTENSIONS:
                full_path = os.path.join(root, f)
                rel_path = os.path.relpath(full_path, PUBLIC_DIR)
                size_bytes = os.path.getsize(full_path)
                images.append({
                    "filename": f,
                    "rel_path": rel_path,
                    "web_path": "/" + rel_path.replace("\\", "/"),
                    "full_path": full_path,
                    "size_bytes": size_bytes,
                    "size_mb": size_bytes / (1024 * 1024)
                })
    return images


def analyze_assets(delete_unused=False):
    if not os.path.exists(PUBLIC_DIR):
        print(f"Error: Public directory not found at {PUBLIC_DIR}")
        return

    print("=" * 72)
    print(" 🚀 Portfolio Image & Asset Analyzer")
    print("=" * 72)

    code_text, code_file_count = gather_code_content()
    images = scan_images()

    print(f"• Scanned source files: {code_file_count}")
    print(f"• Total images in public: {len(images)}")
    total_size = sum(img["size_bytes"] for img in images)
    print(f"• Total assets size: {total_size / (1024 * 1024):.2f} MB\n")

    used_images = []
    unused_images = []

    for img in images:
        f = img["filename"]
        web_path = img["web_path"]
        rel_path = img["rel_path"].replace("\\", "/")

        # Favicons and web app icons are auto-resolved by browser standards
        if "favicon" in f:
            used_images.append(img)
            continue

        if f in code_text or web_path in code_text or rel_path in code_text:
            used_images.append(img)
        else:
            unused_images.append(img)

    unused_images.sort(key=lambda x: x["size_bytes"], reverse=True)
    used_images.sort(key=lambda x: x["size_bytes"], reverse=True)

    used_size = sum(img["size_bytes"] for img in used_images)
    unused_size = sum(img["size_bytes"] for img in unused_images)

    print("📊 USAGE SUMMARY:")
    print("-" * 72)
    print(f"  Used Images:   {len(used_images):3d}  |  {used_size / (1024 * 1024):6.2f} MB")
    print(f"  Unused Images: {len(unused_images):3d}  |  {unused_size / (1024 * 1024):6.2f} MB")
    print("-" * 72)

    if unused_images:
        print("\n🔍 UNUSED IMAGES (Candidates for removal):")
        print("-" * 72)
        for i, img in enumerate(unused_images, 1):
            size_str = f"{img['size_bytes'] / 1024:6.1f} KB" if img['size_mb'] < 1 else f"{img['size_mb']:6.2f} MB"
            print(f"  {i:2d}. [{size_str}] {img['web_path']}")

        if delete_unused:
            confirm = input(f"\nAre you sure you want to delete these {len(unused_images)} unused files? [y/N]: ")
            if confirm.strip().lower() == "y":
                deleted_count = 0
                for img in unused_images:
                    try:
                        os.remove(img["full_path"])
                        deleted_count += 1
                    except Exception as e:
                        print(f"Error removing {img['web_path']}: {e}")
                print(f"Successfully deleted {deleted_count} unused images ({unused_size / (1024 * 1024):.2f} MB freed)!")
    else:
        print("\n✅ All images are referenced in the project.")

    # Show top heaviest used images
    print("\n📦 TOP 10 HEAVIEST USED IMAGES:")
    print("-" * 72)
    for i, img in enumerate(used_images[:10], 1):
        print(f"  {i:2d}. [{img['size_mb']:5.2f} MB] {img['web_path']}")

    # Check for Pillow and show WebP potential
    try:
        from PIL import Image
        import io

        heavy_imgs = [img for img in used_images if img["full_path"].endswith((".png", ".jpg", ".jpeg"))]
        if heavy_imgs:
            sample_orig = 0
            sample_webp = 0
            # Test first 10 heaviest images for quick projection
            for img in heavy_imgs[:10]:
                try:
                    im = Image.open(img["full_path"])
                    buf = io.BytesIO()
                    im.save(buf, format="WEBP", quality=85, method=4)
                    sample_orig += img["size_bytes"]
                    sample_webp += buf.tell()
                except Exception:
                    pass

            if sample_orig > 0:
                savings_pct = ((sample_orig - sample_webp) / sample_orig) * 100
                print("\n💡 WEBP OPTIMIZATION ESTIMATE (Quality 85):")
                print("-" * 72)
                print(f"  Sample tested: 10 heaviest banners")
                print(f"  Current PNG:   {sample_orig / (1024 * 1024):.2f} MB")
                print(f"  WebP Output:   {sample_webp / (1024 * 1024):.2f} MB")
                print(f"  Potential Savings: ~{savings_pct:.1f}% reduction")
    except ImportError:
        pass

    print("\n" + "=" * 72)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Analyze portfolio assets and find unused images.")
    parser.add_argument("--delete-unused", action="store_true", help="Delete identified unused images.")
    args = parser.parse_args()
    analyze_assets(delete_unused=args.delete_unused)
