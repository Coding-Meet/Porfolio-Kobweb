package com.coding.meet.util

import com.coding.meet.models.Project
import com.coding.meet.models.ProjectCategory

object ProjectData {
    val projects = mutableListOf(
        Project(
            title = "News Kotlin Multiplatform App",
            shortDescription = "A production-grade Kotlin Multiplatform & Compose Multiplatform news app with Clean Architecture & MVI across Android, iOS, macOS, Windows, and Linux.",
            longDescription = "News KMP App is a production-grade, open-source Kotlin Multiplatform (KMP) and Compose Multiplatform application providing a cohesive, native news-reading experience across Android, iOS, macOS, Windows, and Linux. Built with AGP 9.1, Kotlin 2.4, and Compose Multiplatform 1.12, the project adopts a decoupled multi-module Clean Architecture with the MVI (Model-View-Intent) pattern. It features top headlines across 7 dynamic channels, debounced search, Room Multiplatform offline bookmark persistence, dynamic Material 3 theming (OLED Dark / Light / System Default), adaptive navigation suites (Bottom Bar & Navigation Drawer), and hardware-accelerated 60/120 FPS rendering powered by Skiko.",
            features = listOf(
                "Cross-platform native support: Android, iOS, macOS, Windows, and Linux",
                "Clean Architecture + MVI pattern with unidirectional State, Intent, and Effect flows",
                "Top news headlines across 7 curated channels (Business, Tech, Sports, Science, Health, Entertainment, General)",
                "Immersive article reader with rich typography, hero imagery, publisher badges, and web links",
                "Instant debounced search across global news sources with zero latency",
                "100% offline reading with Room Multiplatform SQLite database persistence",
                "Dynamic Material 3 theming with OLED Dark, Light, and System Default modes via DataStore",
                "Adaptive Navigation Suite: dynamic bottom navigation on phones (<840dp) and permanent drawer on desktop (≥840dp)",
                "Hardware-accelerated 60/120 FPS scrolling powered by Skiko and Compose Multiplatform",
                "Asynchronous image loading and memory caching powered by Coil 3",
                "Type-safe navigation routing and high-performance JSON serialization"
            ),
            technologies = listOf(
                "Kotlin",
                "Kotlin Multiplatform",
                "Compose Multiplatform",
                "Clean Architecture",
                "MVI Architecture",
                "Material 3",
                "Room Database",
                "DataStore",
                "Ktor",
                "Koin"
            ),
            libraries = listOf(
                "Compose Multiplatform",
                "Ktor Client",
                "Room Multiplatform",
                "AndroidX DataStore",
                "Koin",
                "Coil 3",
                "kotlinx.serialization",
                "Material Icons Extended",
                "BuildKonfig",
                "Kermit"
            ),
            githubUrl = "https://github.com/Coding-Meet/News-KMP-App",
            imageUrls = listOf(
                "/projects/news-kmp-app/01_hero_showcase.webp",
                "/projects/news-kmp-app/02_headlines_categories.webp",
                "/projects/news-kmp-app/03_article_detail.webp",
                "/projects/news-kmp-app/04_search_bookmarks.webp",
                "/projects/news-kmp-app/05_desktop_experience.webp",
                "/projects/news-kmp-app/06_theme_light_dark.webp",
                "/projects/news-kmp-app/07_grand_showcase.webp"
            ),
            platform = listOf("Android", "iOS", "macOS", "Windows", "Linux"),
            youtubeVideoLink = "https://www.youtube.com/embed/Dq1jcsVQmtY",
            topics = listOf(
                "Kotlin Multiplatform",
                "Compose Multiplatform",
                "Clean Architecture",
                "MVI Architecture",
                "News App",
                "Material 3",
                "Room Database",
                "Ktor",
                "Offline Support",
                "Adaptive UI"
            ),
            stargazersCount = 215,
            categories = listOf(ProjectCategory.ANDROID, ProjectCategory.KMP, ProjectCategory.DESKTOP)
        ),
        Project(
            title = "DevAnalyzer",
            shortDescription = "A cross-platform desktop tool to analyze Gradle and Kotlin Multiplatform projects, clean build folders, manage SDK resources, and optimize development environments.",
            longDescription = "DevAnalyzer is a cross-platform desktop application built with Compose Multiplatform and Kotlin Multiplatform (KMP) to help Android and Kotlin Multiplatform developers understand, optimize, and maintain their development environment. It provides project analysis across Android, iOS, JVM, JS, Wasm, and Server targets, safe build folder cleanup, workspace resource analysis, and detailed storage insights across Android SDKs, Gradle caches, Kotlin/Native toolchains, JDKs, AVDs, and IDE data. With smart path discovery, custom toolchain configuration, privacy controls, and GitHub release update checks, DevAnalyzer helps developers manage their development ecosystem efficiently.",
            features = listOf(
                "Analyze Gradle modules, plugins, dependencies, and configurations across Android, iOS, JVM, JS, Wasm, and Server targets",
                "Inspect project metadata, including Kotlin, AGP, Gradle, SDK, NDK, and CMake versions",
                "Browse Kotlin, Java, XML, Gradle scripts, and Version Catalog libraries inside the app",
                "Scan module build folders, calculate folder sizes, and safely delete selected build directories in batches",
                "Analyze multiple workspace directories to identify active and potentially unused development resources",
                "Cross-reference Android SDK Platforms, Build Tools, Sources, NDK, CMake, and Gradle resources with projects",
                "Identify potentially unused Kotlin/Native toolchains, Gradle caches, JDKs, Android System Images, and AVDs",
                "Analyze storage usage across Android SDKs, Gradle caches, Kotlin/Native toolchains, JDKs, AVDs, and IDE data",
                "Track storage scan progress with elapsed timers and support custom JDK and IDE locations",
                "Discover JDK, Android SDK, and IDE installations, including custom locations",
                "Configure and validate custom SDK, Gradle, Kotlin/Native, JDK, Android Studio, and IntelliJ IDEA paths",
                "Manage privacy controls for local crash logging, anonymous crash reporting, and usage analytics",
                "Process project and filesystem analysis locally without uploading source code, project names, or file paths",
                "Collect optional anonymous usage analytics without user identification or personal information",
                "Rate the app, suggest features, and report issues through the in-app feedback dialog",
                "Check GitHub releases on startup and display release notes inside the app"
            ),
            technologies = listOf(
                "Kotlin",
                "Kotlin Multiplatform",
                "Compose Multiplatform",
                "MVVM Architecture"
            ),
            libraries = listOf(
                "Koin",
                "Jetpack Navigation",
                "Coil3",
                "DataStore",
                "kotlinx.serialization",
                "Kermit",
                "FileKit",
                "JSystemThemeDetector",
                "SemVer",
                "kotlinx.coroutines",
                "Sentry",
                "BuildKonfig"
            ),
            githubUrl = "https://github.com/Coding-Meet/DevAnalyzer",
            platform = listOf("Desktop", "Windows", "macOS", "Linux"),
            topics = listOf(
                "Developer Tools",
                "Android Development",
                "Kotlin Multiplatform",
                "Compose Multiplatform",
                "Gradle",
                "Project Analysis",
                "Workspace Analysis",
                "Storage Analysis",
                "SDK Management",
                "Development Environment Optimization"
            ),
            stargazersCount = 88,
            categories = listOf(ProjectCategory.KMP, ProjectCategory.DESKTOP),
            youtubeVideoLink = "https://www.youtube.com/embed/U7UPpqcjdLA",
            imageUrls = listOf(
                "/projects/dev-analyzer/01_hero_showcase.webp",
                "/projects/dev-analyzer/02_project_analyzer.webp",
                "/projects/dev-analyzer/03_storage_analyzer.webp",
                "/projects/dev-analyzer/04_workspace_analyzer.webp",
                "/projects/dev-analyzer/05_clean_build_recovery.webp",
                "/projects/dev-analyzer/06_settings_diagnostics.webp",
                "/projects/dev-analyzer/07_grand_showcase.webp"
            ),
            websiteUrl = "https://coding-meet.github.io/DevAnalyzer/",
        ),
        Project(
            title = "Pepper Robot AI Assistant",
            shortDescription = "An Android tablet app for SoftBank Pepper robots featuring voice-based AI conversations powered by Google Gemini.",
            longDescription = "Pepper Robot AI Assistant is an Android tablet application built for the SoftBank Pepper robot, combining Pepper's native QiSDK with Google's Gemini AI to deliver interactive speech-to-speech conversations. It captures free-form voice input, generates contextual AI responses, and speaks them back through Pepper's native Text-to-Speech engine. The app features a premium split-screen dashboard with chat history, animated interaction states, and Start, Stop, and Reset controls. GPS-based location context enables locally relevant recommendations, while an emulator testing mode supports UI, animation, and AI integration testing without physical robot hardware.",
            features = listOf(
                "Capture free-form speech using custom QiChat wildcard rules",
                "Integrate Google Gemini AI for real-time conversational responses",
                "Convert AI responses into spoken output using Pepper's native Text-to-Speech engine",
                "Prevent recursive microphone input with processing state management",
                "Display chat history with user and Pepper-themed message bubbles",
                "Provide a split-screen tablet interface with a chat panel and interaction dashboard",
                "Visualize Ready, Listening, Thinking, and Speaking states with animations",
                "Control robot interactions using Start, Stop, and Reset actions",
                "Retrieve GPS coordinates and reverse-geocode location context for relevant AI recommendations",
                "Test UI, animations, location context, and Gemini responses in emulator mode without physical robot hardware",
                "Integrate Firebase Crashlytics for crash reporting and diagnostics"
            ),
            technologies = listOf(
                "Kotlin",
                "Android",
                "QiSDK",
                "Google Gemini AI",
                "Jetpack Compose",
                "MVVM Architecture"
            ),
            libraries = listOf(
                "QiSDK",
                "QiSDK Design",
                "OkHttp",
                "Retrofit",
                "Google Play Services Location",
                "kotlinx.serialization",
                "Firebase Crashlytics",
                "Timber"
            ),
            platform = listOf("Android", "Pepper Robot", "Android Tablet"),
            topics = listOf(
                "Android Development",
                "Robotics",
                "SoftBank Pepper",
                "QiSDK",
                "Google Gemini AI",
                "Voice Assistant",
                "Speech-to-Speech",
                "Conversational AI",
                "GPS Integration",
                "Firebase Crashlytics"
            ),
            stargazersCount = 0,
            categories = listOf(ProjectCategory.ANDROID),
            youtubeVideoLink = "https://www.youtube.com/embed/9R6y0NyqYF8",
            imageUrls = listOf(
                "/projects/pepper-app/01_hero_showcase.webp",
                "/projects/pepper-app/02_speech_to_speech_pipeline.webp",
                "/projects/pepper-app/03_interaction_lifecycle_dashboard.webp",
                "/projects/pepper-app/04_split_screen_conversational_ux.webp",
                "/projects/pepper-app/05_location_context_diagnostics.webp",
                "/projects/pepper-app/06_grand_showcase.webp"
            ),
        ),
        Project(
            title = "Gemini AI Kotlin Multiplatform App",
            shortDescription = "A production-ready Kotlin Multiplatform & Compose Multiplatform AI chat app powered by Gemini 3.8 Flash & Gemini 4 Argon across Android, iOS, Desktop, and Web (Wasm).",
            longDescription = "Gemini AI KMP App is a production-ready, open-source Kotlin Multiplatform (KMP) and Compose Multiplatform application targeting Android, iOS, Desktop (macOS, Windows, Linux), and Web (Wasm). Powered by Google's latest Gemini AI models (including Gemini 3.8 Flash and Gemini 4 Argon), the app delivers intelligent multimodal conversations supporting rich text prompts and image attachments. Built with Clean Architecture and the MVI pattern, it features live model discovery (/v1beta/models), token and context limit badges, local SQLite conversation persistence with SQLDelight (SQL.js on Web), encrypted runtime API key management with Multiplatform Settings, dynamic Material 3 theming (Dark / Light / System Default), adaptive navigation suites, cross-platform vertical scrollbars, and native file/image picking via FileKit.",
            features = listOf(
                "Multiplatform support across 6 targets: Android, iOS, macOS, Windows, Linux, and Web (Wasm)",
                "Multimodal conversational AI supporting rich text prompts and multiplatform image attachments",
                "Powered by the latest Gemini models: gemini-3.8-flash, gemini-4-argon, and gemini-3.6-flash",
                "Live model discovery with token and context limit badges (Recommended, Thinking, Fast & Lite)",
                "Clean Architecture + MVI pattern with unidirectional State, Intent, and Effect flows",
                "Local chat persistence using SQLDelight (SQLite on mobile/desktop, SQL.js on Web)",
                "Dynamic Material 3 UI with Adaptive Navigation Suite (Phones, Foldables, Tablets, Desktops)",
                "Reactive theme management with Dark, Light, and System Default modes",
                "Custom cross-platform vertical scrollbars with reverse-layout sync for chat messages",
                "Runtime API key configuration with mask/reveal toggle and secure key-value persistence via Multiplatform Settings",
                "Native cross-platform image and file picking powered by FileKit"
            ),
            technologies = listOf(
                "Kotlin",
                "Kotlin Multiplatform",
                "Compose Multiplatform",
                "Clean Architecture",
                "MVI Architecture",
                "Material 3",
                "Generative AI",
                "SQLDelight",
                "Multiplatform Settings",
                "Wasm"
            ),
            libraries = listOf(
                "Compose Multiplatform",
                "Ktor Client",
                "SQLDelight",
                "Multiplatform Settings",
                "Koin",
                "FileKit",
                "kotlinx.serialization",
                "kotlinx.coroutines",
                "kotlinx.datetime",
                "BuildKonfig",
                "Kermit"
            ),
            githubUrl = "https://github.com/Coding-Meet/Gemini-AI-KMP-App",
            websiteUrl = "https://coding-meet.github.io/Gemini-AI-KMP-App/",
            imageUrls = listOf(
                "/projects/gemini-ai-kmp-app/01_hero_showcase.webp",
                "/projects/gemini-ai-kmp-app/02_multimodal_vision.webp",
                "/projects/gemini-ai-kmp-app/03_smart_chat.webp",
                "/projects/gemini-ai-kmp-app/04_group_chats_persistence.webp",
                "/projects/gemini-ai-kmp-app/05_desktop_experience.webp",
                "/projects/gemini-ai-kmp-app/06_wasm_web_client.webp",
                "/projects/gemini-ai-kmp-app/07_custom_api_key_settings.webp",
                "/projects/gemini-ai-kmp-app/08_grand_showcase.webp"
            ),
            platform = listOf("Android", "iOS", "macOS", "Windows", "Linux", "Web"),
            youtubeVideoLink = "https://www.youtube.com/embed/YhWhR6IVs_Y",
            topics = listOf(
                "AI",
                "Gemini AI",
                "Kotlin Multiplatform",
                "Compose Multiplatform",
                "MVI Architecture",
                "Clean Architecture",
                "Chatbot",
                "Multimodal",
                "SQLDelight",
                "Wasm"
            ),
            stargazersCount = 114,
            categories = listOf(ProjectCategory.ANDROID, ProjectCategory.KMP, ProjectCategory.WEB, ProjectCategory.DESKTOP)
        ),
        Project(
            title = "Store App - MVI Compose Multiplatform Template",
            shortDescription = "A modern E-Commerce app built with Compose Multiplatform featuring MVI architecture, type-safe navigation, and dynamic theming across Android, Desktop, and iOS.",
            longDescription = "Store App is a beautiful, modern E-Commerce template application built using Compose Multiplatform with MVI architecture, type-safe navigation, and dynamic theming. It features a complete shopping experience with infinite scroll product catalog, instant debounced search & category filters, dynamic sorting, Room-persisted shopping cart with discount calculations, JWT authentication with DataStore token persistence, favorites/wishlist, and multiplatform support across Android, Desktop, and iOS powered by the DummyJSON API.",
            features = listOf(
                "Multiplatform support: Android, Desktop, and iOS with shared business logic and UI",
                "MVI architecture with clean unidirectional data flow (Intent -> ViewModel -> State & Effect)",
                "Type-safe navigation using Kotlin Serialization with adaptive Bottom Bar & Navigation Rail",
                "Material 3 design with dynamic theming (Dark / Light / System) & Android 12+ Dynamic Colors",
                "Product catalog with infinite scroll pagination, pull-to-refresh, and shimmer loading",
                "Instant debounced search, category pill filters, and sorting by Price & Rating",
                "Persistent shopping cart & favorites using Room Multiplatform database with SQLite",
                "User authentication & profile management with DataStore JWT token persistence",
                "Rich product details view with image carousel, specs, reviews, and stock status",
                "Optimized performance with Coil3 caching, Room query flows, and lazy composables"
            ),
            technologies = listOf(
                "Kotlin",
                "Kotlin Multiplatform",
                "Compose Multiplatform",
                "MVI Architecture",
                "Clean Architecture",
                "StateFlow",
                "SharedFlow"
            ),
            libraries = listOf(
                "Ktor",
                "Room Multiplatform",
                "DataStore Preferences",
                "Koin",
                "Coil3",
                "kotlinx.serialization",
                "Navigation Compose",
                "Material 3"
            ),
            githubUrl = "https://github.com/Coding-Meet/CMP-MVI-Template",
            platform = listOf("Android", "Desktop", "iOS"),
            topics = listOf(
                "Kotlin Multiplatform",
                "Compose Multiplatform",
                "MVI Architecture",
                "E-Commerce",
                "Store App",
                "Clean Architecture",
                "Room Database",
                "Material 3",
                "Dynamic Theming"
            ),
            stargazersCount = 64,
            categories = listOf(ProjectCategory.ANDROID, ProjectCategory.KMP),
            imageUrls = listOf(
                "/projects/cmp-mvi-template/01_hero_showcase.webp",
                "/projects/cmp-mvi-template/02_catalog_and_search.webp",
                "/projects/cmp-mvi-template/03_product_detail.webp",
                "/projects/cmp-mvi-template/04_cart_and_checkout.webp",
                "/projects/cmp-mvi-template/05_adaptive_desktop.webp",
                "/projects/cmp-mvi-template/06_theme_light_dark.webp",
                "/projects/cmp-mvi-template/07_grand_showcase.webp"
            )
        ),
        Project(
            title = "Text-to-Speech with Real-time Highlighting",
            shortDescription = "A cross-platform Text-to-Speech app with real-time word highlighting and seamless Swift-Kotlin interoperability.",
            longDescription = "Text-to-Speech CMP is a modern cross-platform application built with Kotlin Multiplatform and Compose Multiplatform. It demonstrates real-time word highlighting synchronized with speech, along with smooth pause/resume functionality. The project showcases advanced concepts like Swift-Kotlin interoperability, expect/actual abstraction, and clean architecture for building scalable cross-platform apps.",
            features = listOf(
                "Real-time word highlighting synchronized with speech",
                "Pause and resume with accurate position tracking",
                "Cross-platform support: Android and iOS",
                "Custom text input and pre-loaded sample texts",
                "Clean expect/actual implementation for platform abstraction",
                "Seamless Swift-Kotlin interoperability",
                "Type-safe communication between Kotlin and Swift",
                "Unified interface using provider pattern",
                "Modern UI with Compose Multiplatform"
            ),
            technologies = listOf(
                "Kotlin",
                "Kotlin Multiplatform",
                "Compose Multiplatform",
                "StateFlow",
            ),
            libraries = listOf(
                "Compose Multiplatform",
                "kotlinx.coroutines",
                "Lifecycle Compose",
                "Material 3"
            ),
            githubUrl = "https://github.com/Coding-Meet/TextToSpeech-CMP",
            platform = listOf("Android", "iOS"),
            topics = listOf(
                "Kotlin Multiplatform",
                "Compose Multiplatform",
                "Text-to-Speech",
                "Swift Interoperability",
                "Real-time Highlighting",
                "Cross-platform App"
            ),
            stargazersCount = 47,
            categories = listOf(ProjectCategory.ANDROID, ProjectCategory.KMP),
            youtubeVideoLink = "https://www.youtube.com/embed/SzuDWWdEkqE",
            imageUrls = listOf(
                "/projects/text-to-speech-app/01_hero_showcase.webp",
                "/projects/text-to-speech-app/02_synchronized_speech_highlighting.webp",
                "/projects/text-to-speech-app/03_sample_texts_and_input.webp",
                "/projects/text-to-speech-app/04_cross_platform_architecture.webp",
                "/projects/text-to-speech-app/05_grand_showcase.webp"
            )
        ),
        Project(
            title = "Git Backup Hub",
            shortDescription = "A cross-platform desktop tool to back up GitHub repositories with progress tracking and modern UI.",
            longDescription = "Git Backup Hub is a developer-focused desktop application built with Kotlin Multiplatform and Compose for Desktop. It enables seamless backup of GitHub repositories (public and private) with real-time progress tracking, filtering, and flexible storage options. Designed for reliability and ease of use, it helps developers securely manage and archive their codebases.",
            features = listOf(
                "Fetch all public and private GitHub repositories",
                "Support for private repositories using Personal Access Token (PAT)",
                "Select one or multiple repositories for backup",
                "Choose custom local destination for backups",
                "Real-time progress tracking with percentage, ETA, and logs",
                "Search and filter repositories",
                "Cancel ongoing downloads anytime",
                "Modern Material 3 UI with dark and light theme support"
            ),
            technologies = listOf(
                "Kotlin",
                "Kotlin Multiplatform",
                "Compose for Desktop"
            ),
            libraries = listOf(
                "Ktor",
                "Koin",
                "kotlinx.serialization",
                "Kermit"
            ),
            githubUrl = "https://github.com/Coding-Meet/Git-Backup-Hub",
            platform = listOf("Desktop", "Windows", "macOS", "Linux"),
            topics = listOf(
                "Developer Tools",
                "GitHub",
                "Backup Tool",
                "Kotlin Multiplatform",
                "Compose Desktop",
                "Automation"
            ),
            stargazersCount = 27,
            categories = listOf(ProjectCategory.KMP, ProjectCategory.DESKTOP),
            youtubeVideoLink = "https://www.youtube.com/embed/SKgjtKWt4VQ",
            websiteUrl = "https://github.com/Coding-Meet/Git-Backup-Hub/releases",
            imageUrls = listOf(
                "/projects/git-backup-hub/01_hero_showcase.webp",
                "/projects/git-backup-hub/02_repository_discovery.webp",
                "/projects/git-backup-hub/03_clone_progress_tracking.webp",
                "/projects/git-backup-hub/04_backup_completion.webp",
                "/projects/git-backup-hub/05_light_and_dark_theming.webp",
                "/projects/git-backup-hub/06_grand_showcase.webp"
            )
        ),
        Project(
            title = "Shader Compose Multiplatform App",
            shortDescription = "A cross-platform shader showcase app with 23+ animated effects using Compose Multiplatform.",
            longDescription = "Shader CMP App is a visually rich cross-platform application built with Kotlin Multiplatform and Compose Multiplatform. It demonstrates how to implement and run GPU shaders across Android, iOS, Desktop, and Web using a unified approach. The project includes 23+ real-time animated shader effects and showcases advanced rendering techniques, expect/actual architecture, and performance-optimized UI rendering.",
            features = listOf(
                "23+ animated shader screens with real-time rendering",
                "Cross-platform support: Android, iOS, Desktop, Web (WASM/JS)",
                "Unified shader logic using AGSL (Android) and SkSL (others)",
                "ShaderProvider for handling uniforms (time, resolution, colors)",
                "Advanced rendering using drawBehind and graphicsLayer",
                "Touch-based interactive shader animations",
                "Safe fallback support for Android below API 33",
                "High-performance GPU-based visual effects"
            ),
            technologies = listOf(
                "Kotlin",
                "Kotlin Multiplatform",
                "Compose Multiplatform",
                "AGSL",
                "SkSL"
            ),
            libraries = listOf(
                "Compose Multiplatform",
                "kotlinx.coroutines"
            ),
            githubUrl = "https://github.com/Coding-Meet/Shader-Animation-CMP",
            websiteUrl = "https://coding-meet.github.io/Shader-Animation-CMP/",
            platform = listOf("Android", "iOS", "Desktop", "Web"),
            topics = listOf(
                "Shaders",
                "Compose Multiplatform",
                "Kotlin Multiplatform",
                "Graphics Programming",
                "Animation",
                "GPU Rendering"
            ),
            stargazersCount = 12,
            categories = listOf(ProjectCategory.ANDROID, ProjectCategory.KMP, ProjectCategory.WEB),
            youtubeVideoLink = "https://www.youtube.com/embed/zIDrScVQjhg",
            imageUrls = listOf(
                "/articles/shader-cmp.webp"
            )
        ),
        Project(
            title = "Coding Meet Kobweb",
            shortDescription = "My personal portfolio website built using Kobweb.",
            longDescription = "Coding Meet Kobweb is my personal portfolio website built using Kobweb. It showcases my projects, services, blog articles, and achievements. The website features smooth animations, organized sections, and an interactive UI for visitors.",
            categories = listOf(ProjectCategory.WEB),
            websiteUrl = "https://codingmeet.com",
            githubUrl = "https://github.com/Coding-Meet/Porfolio-Kobweb",
            features = listOf(
                "Portfolio showcasing projects, services, and blog articles",
                "Achievements highlighting YouTube, GitHub, and Fiverr milestones",
                "Interactive UI with smooth animations and transitions",
                "Contact form with social media links",
                "Built with Kobweb for enhanced performance and SEO",
                "Deployed on Firebase Hosting for fast and reliable delivery"
            ),
            technologies = listOf("Firebase Hosting"),
            libraries = listOf("Kotlin", "Kobweb", "Compose HTML", "Jetpack Compose"),
            imageUrls = listOf(
                "/projects/coding_meet_website/kobweb_banner.webp",
                "/projects/coding_meet_website/kobweb_img_1.webp",
                "/projects/coding_meet_website/kobweb_img_2.webp",
                "/projects/coding_meet_website/kobweb_img_3.webp",
                "/projects/coding_meet_website/kobweb_img_4.webp",
                "/projects/coding_meet_website/kobweb_img_5.webp",
                "/projects/coding_meet_website/kobweb_img_6.webp",
                "/projects/coding_meet_website/kobweb_img_7.webp",
                "/projects/coding_meet_website/kobweb_img_8.webp"
            ),
            platform = listOf("Web"),
            stargazersCount = 20,
            topics = listOf("Portfolio", "Web Development", "Kobweb", "SEO Optimization"),
        ),
        Project(
            title = "String Translator Desktop App",
            shortDescription = "A Jetpack Compose desktop app for translating multiple strings effortlessly.",
            longDescription = "String Translator Desktop App is a powerful desktop application built with Jetpack Compose, aiming to streamline the translation of strings for developers. It empowers users to seamlessly translate multiple strings into various languages, thereby optimizing the localization process.",
            githubUrl = "https://github.com/Coding-Meet/String-Translator-Desktop-App",
            imageUrls = listOf(
                "/projects/string-translator-desktop-app/01_hero_showcase.webp",
                "/projects/string-translator-desktop-app/02_source_xml_input.webp",
                "/projects/string-translator-desktop-app/03_language_selection.webp",
                "/projects/string-translator-desktop-app/04_batch_translation_progress.webp",
                "/projects/string-translator-desktop-app/05_android_studio_export.webp",
                "/projects/string-translator-desktop-app/06_grand_showcase.webp"
            ),
            features = listOf(
                "Bulk Translation: Translate multiple strings at once to target languages.",
                "Language Selection: Choose from a variety of supported languages for translation.",
                "Jetpack Compose UI: Enjoy an intuitive and visually appealing interface built with Jetpack Compose.",
                "Translation with Google Translate: Effortlessly translate your text using Google Translate without the need for an API key.",
                "Export to XML Format: Export translated strings to XML for seamless integration into your projects."
            ),
            technologies = listOf(
                "Kotlin",
                "Jetpack Compose Desktop",
                "Web Scraping"
            ),
            libraries = listOf(
                "Jetpack Compose",
                "Json",
                "Compose Multiplatform"
            ),
            platform = listOf("Windows", "macOS", "Linux"),
            topics = listOf(
                "Translation",
                "Localization",
                "Jetpack Compose Desktop",
                "Web Scraping"
            ),
            youtubeVideoLink = "https://www.youtube.com/embed/EDbxJkgJDf8",
            stargazersCount = 13,
            categories = listOf(ProjectCategory.KMP, ProjectCategory.DESKTOP)
        ),
        Project(
            title = "Custom LCD Pattern Generator",
            shortDescription = "An Android app that generates Arduino C code for custom LCD patterns.",
            longDescription = "Custom LCD Pattern Generator is an Android application that allows users to create custom patterns for LCD screens and automatically generates Arduino C code for the given input pattern. It supports 16x2 and 20x4 LCD screens, enabling users to design single-character patterns effortlessly. The app features an intuitive UI, automatic code generation, and options to copy, share, and save patterns in .txt and .ino formats. Live on Play Store with 1K+ downloads.",
            githubUrl = null,
            appStoreUrl = "https://play.google.com/store/apps/details?id=com.Custom_LCD_Pattern_Generator&pcampaignid=web_share",
            features = listOf(
                "Create patterns for 16x2 LCD screens.",
                "Create patterns for 20x4 LCD screens.",
                "Create a pattern for a single character.",
                "Easily create any pattern with a user-friendly UI.",
                "Automatically generate code for input patterns.",
                "Easily copy code and share.",
                "Save files in .txt and .ino formats."
            ),
            topics = listOf(
                "LCD Pattern Generator",
                "Embedded Systems",
                "Code Generation",
                "Arduino",
                "Android App"
            ),
            technologies = listOf(
                "Kotlin",
                "XML",
                "Arduino C",
                "Android SDK"
            ),
            libraries = listOf(
                "Gson",
                "Material Design",
                "Google Play In-App Review",
                "Firebase Crashlytics",
                "Firebase Analytics",
                "AndroidX SplashScreen"
            ),
            imageUrls = listOf(
                "/projects/custom-LCD-pattern-generator/01_hero_showcase.webp",
                "/projects/custom-LCD-pattern-generator/02_16x2_canvas.webp",
                "/projects/custom-LCD-pattern-generator/03_20x4_canvas.webp",
                "/projects/custom-LCD-pattern-generator/04_pixel_editor.webp",
                "/projects/custom-LCD-pattern-generator/05_code_generation.webp",
                "/projects/custom-LCD-pattern-generator/06_export_and_library.webp",
                "/projects/custom-LCD-pattern-generator/07_grand_showcase.webp"
            ),
            platform = listOf("Android"),
            categories = listOf(ProjectCategory.ANDROID, ProjectCategory.IOT)
        ),
        Project(
            title = "Third Eye - AI Assistant App for Blind People",
            shortDescription = "An AI-powered Android app designed to assist blind people with voice commands, image descriptions, and text extraction.",
            longDescription = "Third Eye is an innovative Android application that leverages Gemini AI to enhance accessibility for blind individuals. It offers features like custom prompts, image-to-text conversion, and detailed image descriptions to support daily tasks through voice commands and AI-powered insights.",

            youtubeVideoLink = "https://www.youtube.com/embed/cRTjUSgXhKY",
            features = listOf(
                "Custom Prompt for text-based queries and instructions",
                "Custom Prompt with Image for context-aware AI responses",
                "Image Description feature to generate detailed descriptions of uploaded images",
                "Image to Text functionality for extracting text from images",
                "User-friendly interface powered by Jetpack Compose",
                "Seamless navigation with Jetpack Navigation",
                "CameraX integration for image capture",
                "Lightweight and efficient with Koin for Dependency Injection"
            ),
            technologies = listOf(
                "Kotlin",
                "Jetpack Compose",
                "Gemini API",
                "CameraX",
                "Koin",
                "Markdown"
            ),
            libraries = listOf(
                "Gemini API",
                "Splash API",
                "Lifecycle and ViewModel",
                "Jetpack Navigation",
                "Koin",
                "CameraX",
                "Markdown"
            ),
            imageUrls = listOf(
                "/projects/third-eye/01_hero_showcase.webp",
                "/projects/third-eye/02_gesture_navigation.webp",
                "/projects/third-eye/03_multimodal_perception.webp",
                "/projects/third-eye/04_scene_description.webp",
                "/projects/third-eye/05_image_to_text_ocr.webp",
                "/projects/third-eye/06_voice_dialogs.webp",
                "/projects/third-eye/07_grand_showcase.webp"
            ),
            platform = listOf("Android"),
            topics = listOf(
                "Accessibility",
                "AI Assistant",
                "Image Processing",
                "Voice Commands",
                "Jetpack Compose"
            ),
            categories = listOf(ProjectCategory.ANDROID)
        ),

        Project(
            title = "Home Automation System",
            shortDescription = "Arduino-based real-time home automation system for remote control of appliances via a mobile app.",
            longDescription = "This project presents an Arduino-based real-time home automation system that allows users to remotely control and monitor home appliances like fans, lights, etc., using a mobile application. The system stores real-time data on the cloud, providing access from anywhere. The implementation integrates NodeMCU ESP8266 Wi-Fi Module, relay module, and IR receiver for communication and control. The Android application facilitates authentication, device control, and appliance state monitoring.",
            features = listOf(
                "Remote appliance control via mobile app",
                "Wi-Fi-based real-time control",
                "Appliance state monitoring and restoration",
                "User authentication for security",
                "Temperature monitoring",
                "Fan speed control",
                "IR sensor-based device control"
            ),
            technologies = listOf(
                "IoT", "Android", "Kotlin",
                "Arduino",
                "NodeMCU ESP8266",
                "Firebase (Realtime Database)",
                "Wi-Fi Communication"
            ),
            libraries = listOf(
                "Material Design",
                "Arduino IDE 2.0",
                "ESP8266WiFi Library",
                "Firebase Database KTX"
            ),
            githubUrl = null,
            youtubeVideoLink = "https://user-images.githubusercontent.com/71074485/203806866-debcef11-a8d1-4f91-99f3-f76b0423aba3.mp4",
            imageUrls = listOf(
                "/projects/home-automation-app/01_hero_showcase.webp",
                "/projects/home-automation-app/02_appliance_dashboard_dual_state.webp",
                "/projects/home-automation-app/03_hardware_testbed_ac_relays.webp",
                "/projects/home-automation-app/04_wifi_esp8266_provisioning.webp",
                "/projects/home-automation-app/05_firebase_auth_ir_control.webp",
                "/projects/home-automation-app/06_grand_showcase.webp"
            ),
            platform = listOf("Android"),
            topics = listOf("Home Automation", "IoT", "Arduino", "Smart Home"),
            categories = listOf(ProjectCategory.ANDROID, ProjectCategory.IOT)
        ),
        Project(
            title = "Electric Vehicle",
            shortDescription = "An electric vehicle powered by a 3-phase induction motor using SPWM control via Arduino.",
            longDescription = "This project demonstrates an electric vehicle powered by a 3-phase induction motor controlled using the Sinusoidal Pulse Width Modulation (SPWM) technique. The Arduino microcontroller efficiently manages the motor's speed and direction through precise pulse control, ensuring optimal performance. The system is designed for improved energy efficiency and enhanced motor control for electric vehicle applications.",
            features = listOf(
                "3-phase induction motor control using SPWM",
                "Arduino-based control system for precise operation"
            ),
            technologies = listOf(
                "Arduino",
                "SPWM Technique",
                "3-Phase Induction Motor",
                "Power Electronics",
                "C++ (Arduino IDE)"
            ),
            libraries = listOf("Wire.h", "LiquidCrystal.h", "PWM Control Library"),
            imageUrls = listOf(
                "/projects/electric-vehicle/01_hero_showcase.webp",
                "/projects/electric-vehicle/02_motor_and_chassis_drive.webp",
                "/projects/electric-vehicle/03_arduino_spwm_inverter_bench.webp",
                "/projects/electric-vehicle/04_cockpit_dashboard_controls.webp",
                "/projects/electric-vehicle/05_grand_showcase.webp"
            ),
            platform = listOf("Arduino"),
            topics = listOf("IoT", "Automation", "Electric Vehicles", "Motor Control"),
            categories = listOf(ProjectCategory.IOT)
        ),
        Project(
            title = "Quillbot Web Scraper",
            shortDescription = "Automates content rewriting using Selenium and Apache POI.",
            longDescription = "The Quillbot Web Scraper is an automation tool designed to streamline content rewriting tasks. It leverages Selenium WebDriver to interact with Quillbot's web interface and Apache POI to read and write content in Excel sheets. The tool efficiently handles large text by dynamically splitting content, automates text submission, and retrieves the rewritten content for seamless workflow integration.",
            technologies = listOf("Kotlin", "Selenium", "Apache POI", "ChromeDriver"),
            libraries = listOf("Selenium WebDriver", "Apache POI"),
            imageUrls = listOf(
                "/projects/quill_bot_web/quill_bot_web_banner.webp"
            ),
            platform = listOf("Web"),
            features = listOf(
                "Excel Integration with Apache POI for reading and writing content",
                "Selenium Web Automation for text input, rephrasing, and copying results",
                "Dynamic Content Splitting for handling large text efficiently",
                "Clipboard Management for capturing and saving rewritten text",
                "Execution Time Tracking with detailed logs"
            ),
            categories = listOf(ProjectCategory.WEB)
        ),
        Project(
            title = "ChatGPT Android App",
            shortDescription = "An AI-powered chat application with text, image generation, and voice interaction features.",
            longDescription = "This ChatGPT app leverages AI for an engaging chat experience, offering text-based conversations, image generation, and voice interaction features. Built using MVVM architecture, the app ensures secure API key management, local storage for chat history, and enhanced user controls for a seamless experience.",
            features = listOf(
                "Text input for generating AI-powered images",
                "Image size customization (256x256, 512x512, 1024x1024)",
                "Generated images displayed in a RecyclerView",
                "Full-screen image view with download option",
                "OpenAI API integration using Retrofit",
                "Secure API key management with encrypted SharedPreferences",
                "Clipboard Manager for copying text",
                "Share Intents for easy message sharing",
                "Text-to-Speech (TTS) for audio playback of messages",
                "Voice-to-Text (VTT) for sending messages via voice input",
                "Local chat history storage using Room database",
                "Popup menus for message actions (copy, share, delete)",
                "Robot management functionality for enhanced interactions",
                "MVVM architecture for improved data management",
                "Resource sealed class for standardized loading, success, and error handling"
            ),
            technologies = listOf("Kotlin", "Android Studio", "Retrofit", "Room Database"),
            libraries = listOf(
                "Retrofit",
                "Room Database",
                "Material Design",
                "Text-to-Speech (TTS)",
                "Voice-to-Text (VTT)",
                "Encrypted SharedPreferences"
            ),
            imageUrls = listOf(
                "/projects/chatgpt-app/01_hero_showcase.webp",
                "/projects/chatgpt-app/02_persona_robots.webp",
                "/projects/chatgpt-app/03_chat_and_markdown.webp",
                "/projects/chatgpt-app/04_dalle_image_gen.webp",
                "/projects/chatgpt-app/05_voice_and_actions.webp",
                "/projects/chatgpt-app/06_room_and_security.webp",
                "/projects/chatgpt-app/07_grand_showcase.webp"
            ),
            platform = listOf("Android"),
            topics = listOf(
                "AI Integration",
                "Chat Application",
                "Image Generation",
                "Voice Interaction",
                "MVVM Architecture"
            ),
            categories = listOf(ProjectCategory.ANDROID)
        ),
        Project(
            title = "Multi-Factor Authenticator App",
            shortDescription = "A secure Android app that generates time-based verification codes for enhanced online account security.",
            longDescription = "An authenticator app is an Android application designed to provide an additional layer of security to online accounts. The app generates a unique, time-based code that is used to verify the user's identity when logging into an account. This code is typically valid for a short period of time, typically 30 seconds, and is generated using a secret key shared between the authenticator app and the online account. Authenticator apps are commonly used to provide two-factor authentication (2FA) to online accounts, which requires users to provide both a password and a verification code generated by the authenticator app. This makes it much more difficult for hackers to gain access to the user's account.",
            githubUrl = null,
            features = listOf(
                "Generates secure time-based codes",
                "Provides 2FA support",
                "Ensures user identity verification",
                "Easy integration with online accounts"
            ),
            technologies = listOf("Kotlin", "Android Studio", "XML"),
            libraries = listOf(
                "Material Design",
                "Commons Codec",
                "ZXing",
                "Gson",
                "Lottie",
                "Glide"
            ),
            imageUrls = listOf(
                "/projects/multi-factor-authenticator-app/01_hero_showcase.webp",
                "/projects/multi-factor-authenticator-app/02_qr_scanner.webp",
                "/projects/multi-factor-authenticator-app/03_time_based_codes.webp",
                "/projects/multi-factor-authenticator-app/04_manual_key_entry.webp",
                "/projects/multi-factor-authenticator-app/05_offline_privacy.webp",
                "/projects/multi-factor-authenticator-app/06_production_overview.webp"
            ),
            platform = listOf("Android"),
            topics = listOf("Security", "Two-Factor Authentication", "Privacy"),
            categories = listOf(ProjectCategory.ANDROID)
        ),
        Project(
            title = "Daily Affirmation App",
            shortDescription = "An app providing daily affirmations, positive quotes, and customizable wallpapers for personal growth.",
            longDescription = "Daily Affirmation with Wallpaper is a mobile application designed to provide daily affirmations and positive quotes to users, combined with a wallpaper feature that displays beautiful and inspiring images. The app aims to help users start their day on a positive note, increase their self-confidence, and improve their overall well-being.",
            features = listOf(
                "Displays a new daily affirmation",
                "Allows custom affirmation creation",
                "Offers various affirmation categories like self-love, success, and health",
                "Customizable wallpaper with affirmation quotes",
                "Offline mode for accessing affirmations without internet",
                "Dynamic lock screen quotes that change on unlock"
            ),
            technologies = listOf("Kotlin", "Android Studio", "XML"),
            libraries = listOf(
                "Glide",
                "Lottie",
                "Volley",
                "Material Design",
                "PRDownloader",
                "uCrop",
                "Play Services Ads",
                "Core SplashScreen",
                "MultiWaveHeader"
            ),
            imageUrls = listOf(
                "/projects/daily-affirmation-app/01_hero_showcase.webp",
                "/projects/daily-affirmation-app/02_lock_screen_and_widget.webp",
                "/projects/daily-affirmation-app/03_curated_categories.webp",
                "/projects/daily-affirmation-app/04_live_wallpaper_studio.webp",
                "/projects/daily-affirmation-app/05_typography_and_customizer.webp",
                "/projects/daily-affirmation-app/06_personal_quotes_and_export.webp",
                "/projects/daily-affirmation-app/07_showcase_overview.webp"
            ),
            platform = listOf("Android"),
            topics = listOf("Motivation", "Well-being", "Productivity"),
            categories = listOf(ProjectCategory.ANDROID)
        ),
        Project(
            title = "Document Scanner App",
            shortDescription = "A powerful document scanning and management tool with PDF creation, storage, and sharing features.",
            longDescription = "The Document Scanner app streamlines document capture, management, and organization using Google Doc ML Kit, Room database, and Jetpack Compose. With features like PDF creation, renaming, deletion, and sharing, this app offers a user-friendly experience with both light and dark mode support.",
            youtubeVideoLink = "https://www.youtube.com/embed/cfEbZJDpeZ0",
            features = listOf(
                "Document scanning with Google Doc ML Kit",
                "PDF creation and storage with Room database",
                "Options to rename, delete, and share documents",
                "MVVM architecture for improved data management",
                "Sealed class Resource for handling loading, success, and error states",
                "Jetpack Compose UI for a modern and intuitive interface",
                "Light and dark mode support with Shared Preferences"
            ),
            technologies = listOf("Kotlin", "Android Studio", "Jetpack Compose", "Room Database"),
            libraries = listOf(
                "Google Doc ML Kit",
                "Room Database",
                "Material Design",
                "Jetpack Compose",
                "Shared Preferences"
            ),
            imageUrls = listOf(
                "/projects/doc-scanner-app/01_hero_showcase.webp",
                "/projects/doc-scanner-app/02_mlkit_scanner.webp",
                "/projects/doc-scanner-app/03_room_persistence.webp",
                "/projects/doc-scanner-app/04_light_and_dark_theme.webp",
                "/projects/doc-scanner-app/05_document_management.webp",
                "/projects/doc-scanner-app/06_grand_showcase.webp"
            ),
            platform = listOf("Android"),
            topics = listOf(
                "Document Scanning",
                "PDF Creation",
                "Data Management",
                "MVVM Architecture",
                "Jetpack Compose"
            ),
            categories = listOf(ProjectCategory.ANDROID)
        ),
        Project(
            title = "Math Workout - Brain Exercise",
            shortDescription = "A fun and engaging math game designed to improve your math skills and keep your brain sharp.",
            longDescription = "Looking to improve your math skills and keep your brain sharp? Look no further than Math Workout - Math Games! Our free app offers a fun and engaging way to train your brain and challenge yourself with a variety of math categories, including addition, subtraction, multiplication, division, square root, cube root, and more. But don't worry, this isn't your typical boring math class. Our game is designed to be both entertaining and educational, so you can enjoy yourself while improving your math abilities. Plus, with categories like 'Find Missing' and 'Guess The Sign,' you'll never get bored!",
            appStoreUrl = "https://play.google.com/store/apps/details?id=com.math.workout",
            features = listOf(
                "Multiple math categories including addition, subtraction, and more",
                "Fun and educational gameplay",
                "Interactive categories like 'Find Missing' and 'Guess The Sign'",
                "Engaging visuals and smooth animations",
                "Supports Firebase Crashlytics and Analytics"
            ),
            technologies = listOf("Kotlin", "Android Studio", "XML"),
            libraries = listOf(
                "Material Design",
                "MultiWaveHeader",
                "CircularProgressBar",
                "YPWaveView",
                "Firebase Crashlytics",
                "Firebase Analytics",
                "Play Core App Update",
                "Play Core Review",
                "Core SplashScreen"
            ),
            imageUrls = listOf(
                "/projects/math-workout-app/01_hero_showcase.webp",
                "/projects/math-workout-app/02_game_modes.webp",
                "/projects/math-workout-app/03_speed_quizzes.webp",
                "/projects/math-workout-app/04_logic_puzzles.webp",
                "/projects/math-workout-app/05_true_false_number_grid.webp",
                "/projects/math-workout-app/06_dual_player_battle.webp",
                "/projects/math-workout-app/07_table_practice_customization.webp",
                "/projects/math-workout-app/08_grand_showcase.webp"
            ),
            platform = listOf("Android"),
            topics = listOf("Math", "Education", "Brain Training"),
            categories = listOf(ProjectCategory.ANDROID)
        ),
        Project(
            title = "Bluetooth Arduino Communication Android App",
            shortDescription = "An Android app that establishes communication with Arduino devices via Bluetooth HC05/HC06 modules.",
            longDescription = "This Android application enables seamless Bluetooth communication with Arduino hardware, allowing users to send commands and receive real-time data. The app offers an intuitive interface for controlling devices, monitoring sensor data, and supporting various IoT and automation use cases.",
            youtubeVideoLink = "https://www.youtube.com/embed/cOfPIwNZwQY",
            features = listOf(
                "Bluetooth connectivity with HC05/HC06 modules",
                "Command transmission for controlling Arduino devices",
                "Real-time data monitoring from sensors and peripherals",
                "User-friendly interface with intuitive controls",
            ),
            technologies = listOf("Kotlin", "Android Studio", "Arduino"),
            libraries = listOf(
                "Bluetooth API",
                "Material Design"
            ),
            imageUrls = listOf(
                "/projects/bluetooth-arduino-communication-app/01_hero_showcase.webp",
                "/projects/bluetooth-arduino-communication-app/02_device_discovery_pairing.webp",
                "/projects/bluetooth-arduino-communication-app/03_serial_terminal_monitor.webp",
                "/projects/bluetooth-arduino-communication-app/04_interactive_commands.webp",
                "/projects/bluetooth-arduino-communication-app/05_grand_showcase.webp"
            ),
            platform = listOf("Android"),
            topics = listOf("Bluetooth Communication", "Arduino", "IoT", "Home Automation"),
            categories = listOf(ProjectCategory.ANDROID, ProjectCategory.IOT)
        ),
        Project(
            title = "Truth Or Dare App",
            shortDescription = "A fun and interactive Truth or Dare game featuring thousands of questions and dares in multiple languages.",
            longDescription = "The Truth or Dare app offers a fun way to connect with friends, family, or your partner through engaging questions and dares. With six exciting levels — Classic, Naughty Couple, Extreme, Funny Party, Kids, and Hilarious — the app keeps the fun going for everyone. Available in multiple languages, it’s perfect for house parties, dates, or family gatherings.",
            features = listOf(
                "6 levels: Classic, Naughty Couple, Extreme, Funny Party, Kids, and Hilarious",
                "Thousands of original questions and dares",
                "Multi-language support: English, Japanese, Chinese, Spanish, German, French, Portuguese, Italian, Arabic, Russian, Korean, Sinhala, Hindi, Indonesian, Catalan",
                "Player name setup for group play",
                "Sound on/off feature for better customization",
                "Frequently updated with fresh content",
                "Perfect for parties, dates, and family fun"
            ),
            technologies = listOf("Kotlin", "Android Studio", "XML", "Multilingual Support"),
            libraries = listOf(
                "Material Design",
                "Glide",
                "Card Stack View",
                "Volley",
                "Lottie",
                "RecyclerView",
                "Google Play Services Ads",
                "AndroidX Core Splash Screen"
            ),
            imageUrls = listOf(
                "/projects/truth-dare-app/01_hero_showcase.webp",
                "/projects/truth-dare-app/02_game_packs_and_levels.webp",
                "/projects/truth-dare-app/03_group_and_couple_modes.webp",
                "/projects/truth-dare-app/04_swipeable_card_stack.webp",
                "/projects/truth-dare-app/05_multilingual_support.webp",
                "/projects/truth-dare-app/06_rules_and_customization.webp",
                "/projects/truth-dare-app/07_grand_showcase.webp"
            ),
            platform = listOf("Android"),
            topics = listOf(
                "Entertainment",
                "Party Game",
                "Multiplayer",
                "Fun & Games",
                "Jetpack Compose"
            ),
            categories = listOf(ProjectCategory.ANDROID)
        ),
        Project(
            title = "MeetMyShow",
            shortDescription = "An online movie ticket booking app for booking movie tickets, viewing schedules, and selecting seats with ease.",
            longDescription = "The 'Online Movie Ticket Booking System' is designed for multiplex theaters, enabling users to book tickets 24/7 from anywhere. Customers can explore running movies, view schedules, and access service details. The app streamlines the traditional ticket booking process by eliminating the need to visit theaters and stand in queues. It features user registration, login, movie searches, seat selection, and secure payment options. Admins can monitor booked and canceled tickets. With a user-friendly interface, this app simplifies movie ticket booking for both customers and theater owners.",
            features = listOf(
                "User registration and login",
                "View all running movies and their details",
                "Search for movies easily",
                "Theater and seat selection",
                "Secure payment integration with Razorpay",
                "Invoice generation and receipt saving",
                "Firebase integration for database, Firestore, and storage"
            ),
            technologies = listOf("Kotlin", "Android Studio", "XML", "Firebase"),
            libraries = listOf(
                "Material Design",
                "ConstraintLayout",
                "Firebase Firestore",
                "Firebase Storage",
                "Glide",
                "Firebase Realtime Database",
                "Firebase Authentication",
                "Legacy Support",
                "Lifecycle (LiveData, ViewModel)",
                "Navigation Component",
                "Razorpay Checkout"
            ),
            imageUrls = listOf(
                "/projects/meetmyshow/01_hero_showcase.webp",
                "/projects/meetmyshow/02_auth_and_onboarding.webp",
                "/projects/meetmyshow/03_movie_discovery.webp",
                "/projects/meetmyshow/04_cinema_and_showtimes.webp",
                "/projects/meetmyshow/05_seat_and_pricing.webp",
                "/projects/meetmyshow/06_razorpay_payments.webp",
                "/projects/meetmyshow/07_grand_showcase.webp"
            ),
            platform = listOf("Android"),
            topics = listOf("Entertainment", "Booking System", "Movie Ticketing"),
            categories = listOf(ProjectCategory.ANDROID)
        ),
        Project(
            title = "Dual Axis Solar Tracking System",
            shortDescription = "An automated solar tracking system that maximizes solar energy efficiency through light sensors and motor control.",
            longDescription = "The Dual Axis Solar Tracking System is designed to improve solar energy efficiency by automatically aligning solar panels towards the sun. Using light sensors and motor control, the system tracks the sun's position in both horizontal and vertical directions. The system also displays the generated power on an LCD screen, ensuring optimal performance and efficient energy utilization for small appliances.",
            features = listOf(
                "Automatic solar panel rotation in both horizontal and vertical directions",
                "Light sensors for accurate sun tracking",
                "Displays real-time temperature and power generation on an LCD screen",
                "Efficiently manages solar energy for small appliances"
            ),
            technologies = listOf(
                "Arduino",
                "LDR Sensors",
                "Motors",
                "Relay",
                "LCD Display",
                "C++ (Arduino IDE)"
            ),
            libraries = listOf("Wire.h", "LiquidCrystal.h"),
            imageUrls = listOf(
                "/projects/dual-axis-solar-tracker/01_hero_showcase.webp",
                "/projects/dual-axis-solar-tracker/02_sun_tracking_logic.webp",
                "/projects/dual-axis-solar-tracker/03_lcd_power_telemetry.webp",
                "/projects/dual-axis-solar-tracker/04_relay_load_distribution.webp",
                "/projects/dual-axis-solar-tracker/05_grand_showcase.webp"
            ),
            platform = listOf("Arduino"),
            topics = listOf("IoT", "Automation", "Renewable Energy", "Smart Agriculture"),
            categories = listOf(ProjectCategory.IOT)
        ),
        Project(
            title = "Smart Irrigation System",
            shortDescription = "An automated irrigation system for efficient water management using sensors and relay control.",
            longDescription = "The Smart Irrigation System automates the watering process for plants by monitoring soil moisture levels and environmental conditions. It uses a DHT11 sensor to measure temperature and humidity, a soil moisture sensor to detect soil conditions, and a relay to control the water pump. An LCD display shows real-time data to provide instant insights, ensuring efficient water usage and reduced manual effort.",
            features = listOf(
                "Automatic pump control based on soil moisture levels",
                "Real-time display of temperature and humidity",
                "LCD screen for data visualization",
                "Prevents water wastage by activating the pump only when necessary"
            ),
            technologies = listOf(
                "Arduino",
                "DHT11",
                "Soil Moisture Sensor",
                "Relay",
                "LCD Display",
                "C++ (Arduino IDE)"
            ),
            libraries = listOf("Wire.h", "LiquidCrystal_I2C.h", "DHT.h"),
            imageUrls = listOf(
                "/projects/smart-irrigation-system/01_hero_showcase.webp",
                "/projects/smart-irrigation-system/02_soil_moisture_logic.webp",
                "/projects/smart-irrigation-system/03_submersible_pump_reservoir.webp",
                "/projects/smart-irrigation-system/04_circuit_architecture.webp",
                "/projects/smart-irrigation-system/05_grand_showcase.webp"
            ),
            platform = listOf("Arduino"),
            topics = listOf("IoT", "Automation", "Smart Agriculture", "Environmental Monitoring"),
            categories = listOf(ProjectCategory.IOT)
        ),
        Project(
            title = "Android Addict",
            shortDescription = "A React-based website providing Android component code for developers.",
            longDescription = "Android Addict is a React-based website designed to help Android developers by providing ready-to-use Android component code. It serves as a valuable resource for developers seeking efficient solutions and code snippets to improve their Android projects.",
            features = listOf(
                "Collection of Android component code",
                "User-friendly interface for easy navigation",
                "Code snippets for common Android features",
            ),
            technologies = listOf("React", "JavaScript", "CSS", "HTML"),
            libraries = listOf(
                "React",
                "React Router",
                "Material UI"
            ),
            imageUrls = listOf(
                "/projects/android_addict_website/android_addict_website_banner.webp"
            ),
            platform = listOf("Web"),
            topics = listOf("Android Development", "Web Development", "Code Snippets"),
            categories = listOf(ProjectCategory.WEB, ProjectCategory.ANDROID)
        ),
        Project(
            title = "Gamer's Arena",
            shortDescription = "An Android app for hosting and joining gaming tournaments with chat and profile management features.",
            longDescription = "Gamer's Arena is a feature-rich Android application that allows admins to organize gaming tournaments, set schedules, prizes, and declare winners. Users can join tournaments, view participant details, chat with other players, and manage their profiles. The app aims to provide a genuine and transparent platform for gamers to showcase their skills and win rewards.",
            features = listOf(
                "Admin can create and manage tournaments",
                "Users can join tournaments and view details",
                "Chat functionality for player interaction",
                "Profile management for both users and admins",
                "Room ID and password management for secure entry",
                "Tournament result declaration by admins"
            ),
            technologies = listOf("Kotlin", "Android Studio", "XML"),
            libraries = listOf(
                "Firebase Firestore",
                "Firebase Authentication",
                "Firebase Database",
                "Firebase Storage",
                "Glide",
                "Material Design"
            ),
            imageUrls = listOf(
                "/projects/gamers-arena-app/01_hero_showcase.webp",
                "/projects/gamers-arena-app/02_tournament_hub.webp",
                "/projects/gamers-arena-app/03_custom_lobby_credentials.webp",
                "/projects/gamers-arena-app/04_leaderboard_and_wallet.webp",
                "/projects/gamers-arena-app/05_player_chat_community.webp",
                "/projects/gamers-arena-app/06_admin_control_center.webp",
                "/projects/gamers-arena-app/07_grand_showcase.webp"
            ),
            platform = listOf("Android"),
            topics = listOf("Gaming", "Tournament Management", "Chat System"),
            categories = listOf(ProjectCategory.ANDROID)
        ),
        Project(
            title = "TODO / Note App",
            shortDescription = "A complete TODO/Note app built with MVVM and Room, covering all core Android concepts through a step-by-step tutorial series.",
            longDescription = "TODO/Note App is a fully functional Android application built using Kotlin, MVVM architecture, and Room Database. It is designed as a comprehensive learning project supported by a detailed YouTube playlist, covering everything from basic CRUD operations to advanced features like search, sorting, and performance optimization. This project is ideal for beginners and intermediate developers looking to master Android app development with real-world implementation.",
            features = listOf(
                "Create, update, delete, and view tasks (CRUD operations)",
                "MVVM architecture with clean separation of concerns",
                "Local database using Room for persistent storage",
                "Search functionality for quick task lookup",
                "Sort tasks with multiple options",
                "Restore deleted tasks for better UX",
                "Efficient UI with RecyclerView, ListAdapter, and DiffUtil",
                "Optimized performance with coroutines and repository pattern",
                "Modern UI with dialogs, AppBar, and smooth scrolling"
            ),
            technologies = listOf(
                "Kotlin",
                "Android SDK",
                "MVVM Architecture",
                "Room Database"
            ),
            libraries = listOf(
                "Room",
                "Lifecycle",
                "ViewModel",
                "Coroutines",
                "RecyclerView"
            ),
            githubUrl = "https://github.com/Coding-Meet/Todo-App",
            youtubeVideoLink = "https://www.youtube.com/embed/videoseries?list=PLlSuJy9SfzvFqbcWKhs-a3NtYQicyCFo8",
            platform = listOf("Android"),
            topics = listOf(
                "Android Development",
                "MVVM Architecture",
                "Room Database",
                "CRUD App",
                "Beginner Project",
                "Android Tutorials"
            ),
            stargazersCount = 20,
            categories = listOf(ProjectCategory.ANDROID),
            imageUrls = listOf(
                "/projects/todo-app/01_hero_showcase.webp",
                "/projects/todo-app/02_task_crud_dialogs.webp",
                "/projects/todo-app/03_recyclerview_listadapter.webp",
                "/projects/todo-app/04_live_search_filter.webp",
                "/projects/todo-app/05_sorting_and_restore.webp",
                "/projects/todo-app/06_grand_showcase.webp"
            )
        ),
        Project(
            title = "Camera App",
            shortDescription = "A feature-rich Android camera app built with CameraX, covering image capture, video recording, and advanced camera controls.",
            longDescription = "CameraX App is a modern Android application demonstrating how to build a complete camera solution using the CameraX library. It covers essential and advanced features like image capture, video recording, zoom, focus, and real-time UI updates. The project is supported by a detailed YouTube playlist, making it ideal for learning and implementing real-world camera functionalities.",
            features = listOf(
                "Capture high-quality images using CameraX",
                "Video recording with real-time duration display",
                "Zoom control and tap-to-focus with visual feedback",
                "Handle image rotation and aspect ratio adjustments",
                "Fix common CameraX issues (e.g., Android 13 bugs)",
                "Smooth camera preview and lifecycle handling",
                "Step-by-step learning through video tutorials"
            ),
            technologies = listOf(
                "Kotlin",
                "Android SDK",
                "CameraX",
                "Jetpack Libraries"
            ),
            libraries = listOf(
                "CameraX",
                "Lifecycle",
                "ViewBinding"
            ),
            githubUrl = "https://github.com/Coding-Meet/Camera-Using-CameraX",
            youtubeVideoLink = "https://www.youtube.com/embed/videoseries?list=PLlSuJy9SfzvGEeoalzMz-VA5ohI0LzSKH",
            platform = listOf("Android"),
            topics = listOf(
                "CameraX",
                "Android Development",
                "Image Capture",
                "Video Recording",
                "Mobile Camera App",
                "Android Tutorials"
            ),
            stargazersCount = 28,
            websiteUrl = "https://youtube.com/playlist?list=PLlSuJy9SfzvGEeoalzMz-VA5ohI0LzSKH&si=JahooX-lqG2T42OP",
            categories = listOf(ProjectCategory.ANDROID),
            imageUrls = listOf(
                "/projects/camera-app/01_hero_showcase.webp",
                "/projects/camera-app/02_aspect_ratio_16_9_toggle.webp",
                "/projects/camera-app/03_tap_to_focus_metering.webp",
                "/projects/camera-app/04_pinch_to_zoom_slider.webp",
                "/projects/camera-app/05_video_recording_timer.webp",
                "/projects/camera-app/06_grand_showcase.webp"
            )
        ),
        Project(
            title = "Math Quiz App",
            shortDescription = "An interactive quiz app built with Kotlin, covering core Android concepts along with encryption and security techniques.",
            longDescription = "Math Quiz App is an Android application developed using Kotlin, designed as a complete learning project for building interactive quiz-based apps. It covers UI design, data handling, scoring logic, and advanced topics like encryption and API key security. Supported by a structured YouTube playlist, this project helps developers understand both fundamental and advanced Android concepts through hands-on implementation.",
            features = listOf(
                "Interactive quiz system with multiple levels",
                "Score calculation and result display",
                "Countdown timer for each question",
                "JSON-based question loading",
                "Option selection and dynamic scoring",
                "Remove options feature for enhanced gameplay",
                "Modern UI with splash screen, dialogs, and toolbar",
                "File encryption and decryption for secure data handling",
                "API key and sensitive data protection using NDK and libraries"
            ),
            technologies = listOf(
                "Kotlin",
                "Android SDK",
                "JSON Parsing",
                "NDK"
            ),
            libraries = listOf(
                "Gson / JSON",
                "NDK",
                "AndroidX",
                "ViewBinding"
            ),
            githubUrl = "https://github.com/Coding-Meet/Math-Quiz-App",
            youtubeVideoLink = "https://www.youtube.com/embed/videoseries?list=PLlSuJy9SfzvHpc1-IcBTbZnyeBoVCynPE",
            websiteUrl = "https://youtube.com/playlist?list=PLlSuJy9SfzvHpc1-IcBTbZnyeBoVCynPE&si=BAMF8pBR1Aw7l1SQ",
            platform = listOf("Android"),
            topics = listOf(
                "Android Development",
                "Quiz App",
                "Kotlin",
                "JSON",
                "Encryption",
                "NDK Security"
            ),
            stargazersCount = 18,
            categories = listOf(ProjectCategory.ANDROID),
            imageUrls = listOf(
                "/projects/math-quiz-app/01_hero_showcase.webp",
                "/projects/math-quiz-app/02_level_progression.webp",
                "/projects/math-quiz-app/03_countdown_timer.webp",
                "/projects/math-quiz-app/04_lifeline_powerup.webp",
                "/projects/math-quiz-app/05_results_and_security.webp",
                "/projects/math-quiz-app/06_grand_showcase.webp"
            )
        )
    )
}

