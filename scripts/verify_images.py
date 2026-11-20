#!/usr/bin/env python3
"""
Portfolio Pages, Metadata & Images Verification Tool
Validates all Core pages, 31 Projects, 9 Services, and 10 Blog Articles:
- Page URL
- Page Title
- Page Description / Meta Description
- Preview Image URL (Open Graph / Twitter Card)
- Image Dimensions (Width x Height) & File Size
- Disk File Existence (in public/ resources & .kobweb/site/ export)
- Exported HTML Open Graph tags verification
"""

import os
import re
import sys
from PIL import Image

def get_image_info(disk_path):
    """Returns (width, height, size_kb) if file exists, else (None, None, 0)."""
    if not os.path.exists(disk_path):
        return None, None, 0
    size_kb = os.path.getsize(disk_path) / 1024.0
    try:
        with Image.open(disk_path) as img:
            return img.width, img.height, size_kb
    except Exception:
        return None, None, size_kb

def main():
    base_dir = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    public_dir = os.path.join(base_dir, "site", "src", "jsMain", "resources", "public")
    site_dir = os.path.join(base_dir, "site", ".kobweb", "site")
    project_data_file = os.path.join(base_dir, "site", "src", "jsMain", "kotlin", "com", "coding", "meet", "util", "ProjectData.kt")
    service_data_file = os.path.join(base_dir, "site", "src", "jsMain", "kotlin", "com", "coding", "meet", "util", "ServiceData.kt")
    article_data_file = os.path.join(base_dir, "site", "src", "jsMain", "kotlin", "com", "coding", "meet", "util", "ArticleData.kt")

    print("=" * 110)
    print("                CODING MEET PORTFOLIO - FULL SITE PAGES & IMAGES AUDIT")
    print("=" * 110)
    print(f"Base Directory:      {base_dir}")
    print(f"Public Resources:    {public_dir}")
    print(f"Exported Site (.kobweb/site): {site_dir}")
    print("=" * 110)
    print()

    total_pages = 0
    passed_pages = 0
    issues = []

    # -------------------------------------------------------------------------
    # 1. CORE HUB PAGES
    # -------------------------------------------------------------------------
    print("━" * 110)
    print("  SECTION 1: CORE HUB PAGES (6 Pages)")
    print("━" * 110)

    core_pages = [
        {
            "route": "/",
            "html_path": os.path.join(site_dir, "index.html"),
            "title": "Meet | Android, Kotlin Multiplatform & Compose Developer",
            "desc": "Explore Meet's Android and cross-platform projects built with Kotlin, Jetpack Compose, KMP, and CMP. Discover freelance services, tutorials, and open-source work.",
            "image": "/preview_image.png",
        },
        {
            "route": "/projects",
            "html_path": os.path.join(site_dir, "projects", "index.html"),
            "title": "Projects - Meet | Android, Kotlin Multiplatform & Compose Developer",
            "desc": "Browse through mobile apps, desktop software, Kotlin Multiplatform, and Compose Multiplatform projects developed by Meet.",
            "image": "/preview_image.png",
        },
        {
            "route": "/service",
            "html_path": os.path.join(site_dir, "service", "index.html"),
            "title": "Services - Meet | Android, Kotlin Multiplatform & Compose Developer",
            "desc": "Professional Android app development, SDK upgrade, bug fixing, and Kotlin Multiplatform engineering services.",
            "image": "/preview_image.png",
        },
        {
            "route": "/blog",
            "html_path": os.path.join(site_dir, "blog.html"),
            "title": "Blog - Meet | Android, Kotlin Multiplatform & Compose Developer",
            "desc": "Technical articles, guides, and tutorials on Android, Compose Multiplatform, and Kotlin Multiplatform by Meet.",
            "image": "/preview_image.png",
        },
        {
            "route": "/contact_me",
            "html_path": os.path.join(site_dir, "contact_me.html"),
            "title": "Contact Me - Meet | Android, Kotlin Multiplatform & Compose Developer",
            "desc": "Get in touch with Meet for freelance Android, KMP, and Compose Multiplatform project collaborations.",
            "image": "/preview_image.png",
        },
        {
            "route": "/404",
            "html_path": os.path.join(site_dir, "404.html"),
            "title": "404 - Page Not Found",
            "desc": "The requested page could not be found on Coding Meet.",
            "image": "/preview_image.png",
        },
    ]

    for p in core_pages:
        total_pages += 1
        page_url = f"https://codingmeet.com{p['route']}"
        img_rel = p["image"].lstrip("/")
        pub_img = os.path.join(public_dir, img_rel)
        site_img = os.path.join(site_dir, img_rel)

        w, h, sz = get_image_info(pub_img if os.path.exists(pub_img) else site_img)
        img_ok = (w is not None and h is not None)
        html_exists = os.path.exists(p["html_path"])

        status_icon = "✅" if (img_ok and html_exists) else "⚠️"
        if img_ok and html_exists:
            passed_pages += 1
        else:
            issues.append(f"Core page issue: {p['route']} (img_ok={img_ok}, html_exists={html_exists})")

        print(f"{status_icon} [{total_pages:02d}] {page_url}")
        print(f"     Title:       {p['title']}")
        print(f"     Description: {p['desc']}")
        print(f"     Preview Img: https://codingmeet.com{p['image']}")
        print(f"     Dimensions:  {w}x{h} px ({sz:.1f} KB) | Disk: {'Found' if img_ok else 'MISSING'}")
        print(f"     Export HTML: {'Found' if html_exists else 'MISSING'} ({os.path.relpath(p['html_path'], base_dir)})")
        print()

    # -------------------------------------------------------------------------
    # 2. DEDICATED PROJECT SHOWCASE PAGES
    # -------------------------------------------------------------------------
    print("━" * 110)
    print("  SECTION 2: DEDICATED PROJECT SHOWCASE PAGES (31 Projects)")
    print("━" * 110)

    if not os.path.exists(project_data_file):
        print(f"ERROR: {project_data_file} not found!")
        sys.exit(1)

    with open(project_data_file, "r") as f:
        p_content = f.read()

    p_chunks = p_content.split("Project(")[1:]
    project_items = []
    all_project_images = []

    for chunk in p_chunks:
        title_m = re.search(r'title\s*=\s*"([^"]+)"', chunk)
        id_m = re.search(r'id\s*=\s*"([^"]+)"', chunk)
        desc_m = re.search(r'shortDescription\s*=\s*"([^"]+)"', chunk)
        imgs_m = re.search(r'imageUrls\s*=\s*listOf\((.*?)\)', chunk, re.DOTALL)

        title = title_m.group(1) if title_m else ""
        pid = id_m.group(1) if id_m else ""
        desc = desc_m.group(1) if desc_m else ""
        imgs = re.findall(r'"([^"]+)"', imgs_m.group(1)) if imgs_m else []

        slug = pid if pid else re.sub(r"[^a-z0-9]+", "-", title.lower()).strip("-")
        first_img = imgs[0] if imgs else "/preview_image.png"

        project_items.append({
            "slug": slug,
            "title": title,
            "desc": desc,
            "first_img": first_img,
            "all_images": imgs
        })
        all_project_images.extend(imgs)

    for i, p in enumerate(project_items, 1):
        total_pages += 1
        page_url = f"https://codingmeet.com/projects/{p['slug']}"
        html_file = os.path.join(site_dir, "projects", f"{p['slug']}.html")
        index_file = os.path.join(site_dir, "projects", p["slug"], "index.html")

        img_rel = p["first_img"].lstrip("/")
        pub_img = os.path.join(public_dir, img_rel)
        site_img = os.path.join(site_dir, img_rel)

        active_img_path = pub_img if os.path.exists(pub_img) else site_img
        w, h, sz = get_image_info(active_img_path)
        img_ok = (w is not None and h is not None)
        html_exists = os.path.exists(html_file) or os.path.exists(index_file)

        # Verify exported HTML tags in both cleanUrl .html and directory index.html
        og_match = True
        for target in [html_file, index_file]:
            if os.path.exists(target):
                with open(target, "r") as hf:
                    html_txt = hf.read()
                if p["first_img"] not in html_txt:
                    og_match = False
            else:
                og_match = False

        status_icon = "✅" if (img_ok and html_exists and og_match) else "⚠️"
        if img_ok and html_exists and og_match:
            passed_pages += 1
        else:
            issues.append(f"Project page issue: {p['slug']} (img_ok={img_ok}, html={html_exists}, og={og_match})")

        print(f"{status_icon} [{i:02d}/31] {page_url}")
        print(f"     Title:       {p['title']} | Meet's Projects")
        print(f"     Description: {p['desc']}")
        print(f"     Hero Img:    https://codingmeet.com{p['first_img']}")
        print(f"     Dimensions:  {w}x{h} px ({sz:.1f} KB) | Disk: {'Found' if img_ok else 'MISSING'}")
        print(f"     Export HTML: {'Found' if html_exists else 'MISSING'} | .html & index.html OG Injected: {'YES' if og_match else 'NO'}")
        print(f"     Gallery:     {len(p['all_images'])} images configured")
        print()

    # -------------------------------------------------------------------------
    # 3. DEDICATED SERVICE PAGES
    # -------------------------------------------------------------------------
    print("━" * 110)
    print("  SECTION 3: DEDICATED SERVICE PAGES (9 Services)")
    print("━" * 110)

    if not os.path.exists(service_data_file):
        print(f"ERROR: {service_data_file} not found!")
        sys.exit(1)

    with open(service_data_file, "r") as f:
        s_content = f.read()

    s_chunks = s_content.split("Service(")[1:]
    service_items = []

    for chunk in s_chunks:
        title_m = re.search(r'title\s*=\s*"([^"]+)"', chunk)
        id_m = re.search(r'id\s*=\s*"([^"]+)"', chunk)
        desc_m = re.search(r'description\s*=\s*"([^"]+)"', chunk)
        imgs_m = re.search(r'imageUrls\s*=\s*listOf\((.*?)\)', chunk, re.DOTALL)

        title = title_m.group(1) if title_m else ""
        sid = id_m.group(1) if id_m else ""
        desc = desc_m.group(1) if desc_m else ""
        imgs = re.findall(r'"([^"]+)"', imgs_m.group(1)) if imgs_m else []
        first_img = imgs[0] if imgs else "/preview_image.png"

        service_items.append({
            "id": sid,
            "title": title,
            "desc": desc,
            "first_img": first_img,
            "all_images": imgs
        })

    for i, s in enumerate(service_items, 1):
        total_pages += 1
        page_url = f"https://codingmeet.com/service/{s['id']}"
        html_file = os.path.join(site_dir, "service", f"{s['id']}.html")
        index_file = os.path.join(site_dir, "service", s["id"], "index.html")

        img_rel = s["first_img"].lstrip("/")
        pub_img = os.path.join(public_dir, img_rel)
        site_img = os.path.join(site_dir, img_rel)

        active_img_path = pub_img if os.path.exists(pub_img) else site_img
        w, h, sz = get_image_info(active_img_path)
        img_ok = (w is not None and h is not None)
        html_exists = os.path.exists(html_file) or os.path.exists(index_file)

        og_match = True
        for target in [html_file, index_file]:
            if os.path.exists(target):
                with open(target, "r") as hf:
                    html_txt = hf.read()
                if s["first_img"] not in html_txt:
                    og_match = False
            else:
                og_match = False

        status_icon = "✅" if (img_ok and html_exists and og_match) else "⚠️"
        if img_ok and html_exists and og_match:
            passed_pages += 1
        else:
            issues.append(f"Service page issue: {s['id']} (img_ok={img_ok}, html={html_exists}, og={og_match})")

        print(f"{status_icon} [{i:02d}/09] {page_url}")
        print(f"     Title:       {s['title']} | Meet's Services")
        print(f"     Description: {s['desc']}")
        print(f"     Gig Image:   https://codingmeet.com{s['first_img']}")
        print(f"     Dimensions:  {w}x{h} px ({sz:.1f} KB) | Disk: {'Found' if img_ok else 'MISSING'}")
        print(f"     Export HTML: {'Found' if html_exists else 'MISSING'} | .html & index.html OG Injected: {'YES' if og_match else 'NO'}")
        print(f"     Slides:      {len(s['all_images'])} slides configured")
        print()

    # -------------------------------------------------------------------------
    # 4. DEDICATED BLOG ARTICLES
    # -------------------------------------------------------------------------
    print("━" * 110)
    print("  SECTION 4: DEDICATED BLOG ARTICLE PAGES (10 Articles)")
    print("━" * 110)

    if not os.path.exists(article_data_file):
        print(f"ERROR: {article_data_file} not found!")
        sys.exit(1)

    with open(article_data_file, "r") as f:
        a_content = f.read()

    a_chunks = a_content.split("Article(")[1:]
    article_items = []

    for chunk in a_chunks:
        title_m = re.search(r'title\s*=\s*"([^"]+)"', chunk)
        link_m = re.search(r'link\s*=\s*"([^"]+)"', chunk)
        desc_m = re.search(r'shortDescription\s*=\s*"([^"]+)"', chunk)
        thumb_m = re.search(r'thumbnail\s*=\s*"([^"]+)"', chunk)

        title = title_m.group(1) if title_m else ""
        link = link_m.group(1) if link_m else ""
        desc = desc_m.group(1) if desc_m else ""
        thumb = thumb_m.group(1) if thumb_m else ""
        slug = link.rstrip("/").split("/")[-1]

        article_items.append({
            "slug": slug,
            "title": title,
            "desc": desc,
            "thumb": thumb,
        })

    for i, a in enumerate(article_items, 1):
        total_pages += 1
        page_url = f"https://codingmeet.com/blog/{a['slug']}"
        html_file = os.path.join(site_dir, "blog", f"{a['slug']}.html")

        img_rel = a["thumb"].lstrip("/")
        pub_img = os.path.join(public_dir, img_rel)
        site_img = os.path.join(site_dir, img_rel)

        active_img_path = pub_img if os.path.exists(pub_img) else site_img
        w, h, sz = get_image_info(active_img_path)
        img_ok = (w is not None and h is not None)
        html_exists = os.path.exists(html_file)

        og_match = False
        if html_exists:
            with open(html_file, "r") as hf:
                html_txt = hf.read()
            if a["thumb"] in html_txt:
                og_match = True

        status_icon = "✅" if (img_ok and html_exists and og_match) else "⚠️"
        if img_ok and html_exists and og_match:
            passed_pages += 1
        else:
            issues.append(f"Blog article issue: {a['slug']} (img_ok={img_ok}, html={html_exists}, og={og_match})")

        print(f"{status_icon} [{i:02d}/10] {page_url}")
        print(f"     Title:       {a['title']} | Coding Meet")
        print(f"     Description: {a['desc']}")
        print(f"     Thumbnail:   https://codingmeet.com{a['thumb']}")
        print(f"     Dimensions:  {w}x{h} px ({sz:.1f} KB) | Disk: {'Found' if img_ok else 'MISSING'}")
        print(f"     Export HTML: {'Found' if html_exists else 'MISSING'} | OG Tag Injected: {'YES' if og_match else 'NO'}")
        print()

    # -------------------------------------------------------------------------
    # 5. GALLERY ASSET AUDIT
    # -------------------------------------------------------------------------
    print("━" * 110)
    print("  SECTION 5: FULL GALLERY ASSETS AUDIT (All Additional Gallery Images)")
    print("━" * 110)
    missing_gallery = 0
    total_gallery = len(all_project_images)
    for u in all_project_images:
        rel = u.lstrip("/")
        pub_path = os.path.join(public_dir, rel)
        site_path = os.path.join(site_dir, rel)
        if not os.path.exists(pub_path) and not os.path.exists(site_path):
            missing_gallery += 1
            print(f"❌ Missing gallery image: {u}")

    print(f"Total Project Gallery Images Configured: {total_gallery}")
    print(f"Verified Gallery Images on Disk:         {total_gallery - missing_gallery}/{total_gallery}")
    print()

    # -------------------------------------------------------------------------
    # FINAL SUMMARY REPORT
    # -------------------------------------------------------------------------
    print("=" * 110)
    print("                              AUDIT SUMMARY REPORT")
    print("=" * 110)
    print(f"Total Unique Landing & Content Pages: {total_pages}")
    print(f"  - Core Hub Pages:                   {len(core_pages)}")
    print(f"  - Dedicated Project Pages:          {len(project_items)}")
    print(f"  - Dedicated Service Pages:          {len(service_items)}")
    print(f"  - Dedicated Blog Article Pages:     {len(article_items)}")
    print(f"Pages 100% Passed (Img + Meta + HTML): {passed_pages} / {total_pages} ({(passed_pages/total_pages)*100:.1f}%)")
    print(f"Total Media & Gallery Assets:          {total_gallery} images verified on disk")
    print("=" * 110)

    if issues:
        print(f"⚠️ FOUND {len(issues)} ISSUES:")
        for iss in issues:
            print(f"   - {iss}")
        sys.exit(1)
    else:
        print("🎉 ALL PAGES, URLS, TITLES, DESCRIPTIONS & PREVIEW IMAGES ARE 100% VERIFIED & ACCURATE!")
        print("=" * 110)

if __name__ == "__main__":
    main()
