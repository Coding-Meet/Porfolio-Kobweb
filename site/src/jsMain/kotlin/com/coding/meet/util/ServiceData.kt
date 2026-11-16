package com.coding.meet.util

import com.coding.meet.models.Service

object ServiceData {

    val services = listOf(

        // 1. Custom Android App Development (Gig 03 & 08)
        Service(
            title = "📱 Custom Android App Development",
            description = "Need a custom mobile app for Android? I build high-quality, scalable apps using Kotlin, Java, and modern Clean Architecture.",
            features = listOf(
                "Develop custom native apps using Kotlin, Java, and Jetpack Compose / XML",
                "Clean Architecture + MVVM / MVI for scalable and maintainable codebases",
                "Dependency Injection using Dagger Hilt and Koin",
                "REST API integration using Retrofit, Ktor, and OkHttp",
                "Local database integration with Room and SQLDelight",
                "Firebase integration: Auth, Firestore, Realtime DB, Crashlytics, FCM",
                "Google APIs integration: Maps, Places, Sign-In, Billing, and AdMob",
                "Offline-first architecture with caching and background sync",
                "Play Store production release ready signed AAB"
            ),
            imageUrls = listOf(
                "/services/gig_08_custom_android_app_kotlin_java-xml/varient_02/website-720p/slide_01.webp",
                "/services/gig_08_custom_android_app_kotlin_java-xml/varient_02/website-720p/slide_02.webp",
                "/services/gig_08_custom_android_app_kotlin_java-xml/varient_02/website-720p/slide_03.webp",
            ),
            tags = listOf(
                "Kotlin",
                "Java",
                "Jetpack Compose",
                "XML Layouts",
                "Clean Architecture",
                "MVVM / MVI",
                "Room DB",
                "Firebase",
                "REST APIs",
                "Play Store Ready"
            )
        ),

        // 2. Fix Android Bugs, Crashes & Gradle (Gig 01)
        Service(
            title = "🔧 Fix Bugs & Debug Android Apps",
            description = "Facing crashes, slow performance, or build issues? I debug root causes and fix your Android app professionally.",
            features = listOf(
                "Fix app crashes, NullPointerExceptions, ANRs, and runtime errors",
                "Resolve Jetpack Compose recomposition and UI state bugs",
                "Fix Gradle, SDK, dependency conflicts, and Android Studio errors",
                "Resolve API integration, Retrofit parsing, and network issues",
                "Improve app performance, startup speed, and responsiveness",
                "Fix navigation, deep link, and back stack lifecycle issues",
                "Resolve Firebase Authentication, Firestore, and push notification problems",
                "Fix Play Store publishing, app signing, and ProGuard / R8 issues",
                "Refactor messy code into clean, stable architecture",
                "Resolve compatibility issues across different Android versions"
            ),
            imageUrls = listOf(
                "/services/gig_01_fix_android_bugs_crashes_gradle/varient_02/website-720p/slide_01.webp",
                "/services/gig_01_fix_android_bugs_crashes_gradle/varient_02/website-720p/slide_02.webp",
                "/services/gig_01_fix_android_bugs_crashes_gradle/varient_02/website-720p/slide_03.webp",
            ),
            tags = listOf(
                "Crash Fix",
                "ANR Resolution",
                "NullPointer Fix",
                "Gradle Errors",
                "Compose Bugs",
                "Memory Leaks",
                "API Debugging",
                "Deep Links",
                "R8 / ProGuard",
                "Performance Optimization"
            )
        ),

        // 3. Upgrade Android SDK, Target API & Gradle Migration (Gig 02)
        Service(
            title = "🚀 Upgrade Android SDK, Target API & Gradle",
            description = "Update your Android project for modern devices and Play Store requirements with zero regression.",
            features = listOf(
                "Upgrade Target SDK and Compile SDK to Android 15 (API 35)",
                "Update Gradle, Android Gradle Plugin (AGP), and Gradle Kotlin DSL",
                "Migrate Gradle build scripts to Version Catalogs (libs.versions.toml)",
                "Update Kotlin, Java, and legacy third-party dependencies",
                "Resolve AndroidX and legacy support library conflicts",
                "Implement modern Edge-to-Edge UI and Predictive Back navigation",
                "Resolve Google Play Console policy compliance and 64-bit requirements",
                "Verified stable builds on modern Android devices and emulators"
            ),
            imageUrls = listOf(
                "/services/gig_02_update_android_sdk_gradle_kotlin/varient_01/website-720p/slide_01.webp",
                "/services/gig_02_update_android_sdk_gradle_kotlin/varient_01/website-720p/slide_02.webp",
                "/services/gig_02_update_android_sdk_gradle_kotlin/varient_01/website-720p/slide_03.webp",
            ),
            tags = listOf(
                "Android 15 (API 35)",
                "Target SDK Upgrade",
                "AGP Upgrade",
                "Gradle Kotlin DSL",
                "Version Catalog",
                "libs.versions.toml",
                "Kotlin 2.0+",
                "Edge-to-Edge UI",
                "Predictive Back",
                "Play Policy Compliance"
            )
        ),

        // 4. Kotlin & Jetpack Compose UI (Gig 03 UI)
        Service(
            title = "🎨 Kotlin & Jetpack Compose UI",
            description = "Modernize your UI with Jetpack Compose. Dynamic, reactive, and responsive interfaces built with Material 3.",
            features = listOf(
                "Declarative UI development with Jetpack Compose and Material 3",
                "Migrate legacy XML layouts and custom Views to modern Jetpack Compose",
                "Custom animations, transitions, canvas drawing, and state management",
                "Adaptive layouts for smartphones, tablets, foldables, and large screens",
                "Dynamic color theming (Material You), Dark mode & Light mode",
                "Optimized recomposition performance, StateFlow, and UDF architecture"
            ),
            imageUrls = listOf(
                "/services/gig_03_android_app_kotlin_java_xml_compose/varient_01/website-720p/slide_01.webp",
                "/services/gig_03_android_app_kotlin_java_xml_compose/varient_01/website-720p/slide_02.webp",
                "/services/gig_03_android_app_kotlin_java_xml_compose/varient_01/website-720p/slide_03.webp",
            ),
            tags = listOf(
                "Jetpack Compose",
                "Material 3",
                "Material You",
                "Adaptive Layouts",
                "Custom Animations",
                "XML to Compose",
                "Canvas Drawing",
                "StateFlow",
                "Recomposition Tuning",
                "Dark / Light Mode"
            )
        ),

        // 5. AI Chatbot & Custom AI API Integration (Gig 04)
        Service(
            title = "🤖 AI Chatbot & Custom AI API Integration",
            description = "Integrate smart AI chatbots and assistants into your mobile apps with streaming responses and clean UI.",
            features = listOf(
                "Integrate OpenAI (ChatGPT), Google Gemini, Claude, and DeepSeek APIs",
                "Streaming real-time chat responses with typing effects and markdown support",
                "Custom system prompts, conversation history, and multi-turn context",
                "Document AI with RAG (Retrieval-Augmented Generation) & vector search",
                "Multimodal AI: image analysis, OCR vision, and document understanding",
                "Speech-to-text voice input and text-to-speech audio synthesis",
                "Structured JSON output, function calling, and secure API key management"
            ),
            imageUrls = listOf(
                "/services/gig_04_ai_chatbot_api_mobile_app/varient_01/website-720p/slide_01.webp",
                "/services/gig_04_ai_chatbot_api_mobile_app/varient_01/website-720p/slide_02.webp",
                "/services/gig_04_ai_chatbot_api_mobile_app/varient_01/website-720p/slide_03.webp",
            ),
            tags = listOf(
                "Google Gemini",
                "ChatGPT / OpenAI",
                "Claude AI",
                "DeepSeek",
                "Streaming Responses",
                "RAG & Vector Search",
                "Multimodal Vision",
                "Speech-to-Text",
                "Text-to-Speech",
                "Function Calling"
            )
        ),

        // 6. Kotlin Multiplatform & Compose Multiplatform (Gig 05)
        Service(
            title = "⚡ Kotlin Multiplatform & Compose Multiplatform (KMP & CMP)",
            description = "Target Android, iOS, Desktop, and Web from a single codebase using Kotlin Multiplatform and Compose Multiplatform.",
            features = listOf(
                "Share 100% of business logic across Android, iOS, Desktop, and Web",
                "Shared UI across Android and iOS using Compose Multiplatform (CMP)",
                "Cross-platform state management with Koin, Decompose, and shared ViewModels",
                "Shared networking using Ktor Client with Kotlinx Serialization",
                "Multiplatform reactive database storage with SQLDelight and Room KMP",
                "Faster development and reduced maintenance cost with native performance"
            ),
            imageUrls = listOf(
                "/services/gig_05_kotlin_multiplatform_compose_app/varient_01/website-720p/slide_01.webp",
                "/services/gig_05_kotlin_multiplatform_compose_app/varient_01/website-720p/slide_02.webp",
                "/services/gig_05_kotlin_multiplatform_compose_app/varient_01/website-720p/slide_03.webp",
            ),
            tags = listOf(
                "Kotlin Multiplatform",
                "Compose Multiplatform",
                "Android & iOS",
                "Desktop & Web",
                "Shared Business Logic",
                "Ktor Client",
                "Room KMP",
                "SQLDelight",
                "Koin DI",
                "Single Codebase"
            )
        ),

        // 7. Desktop App Development with CMP (Gig 06)
        Service(
            title = "💻 Desktop App Development (macOS, Windows, Linux)",
            description = "Build fast, native-feeling desktop applications and dashboards using Compose Multiplatform and Kotlin.",
            features = listOf(
                "Cross-platform desktop apps for macOS, Windows, and Linux from one codebase",
                "Modern desktop interfaces: admin dashboards, internal tools, and utilities",
                "Desktop window lifecycle handling, custom titlebars, and native menus",
                "Local database storage with SQLDelight and local file system access",
                "Desktop packaging and installer generation (.dmg, .msi, .deb, .rpm)",
                "Lightweight, high-performance desktop execution powered by JVM"
            ),
            imageUrls = listOf(
                "/services/gig_06_desktop_app_compose_multiplatform/varient_02/website-720p/slide_01.webp",
                "/services/gig_06_desktop_app_compose_multiplatform/varient_02/website-720p/slide_02.webp",
                "/services/gig_06_desktop_app_compose_multiplatform/varient_02/website-720p/slide_03.webp",
            ),
            tags = listOf(
                "Compose Multiplatform",
                "macOS (.dmg)",
                "Windows (.msi)",
                "Linux (.deb)",
                "JVM Desktop",
                "Admin Dashboards",
                "Native Menus",
                "Window Lifecycle",
                "Local SQLite",
                "Internal Dev Tools"
            )
        ),

        // 8. Native iOS App Development (Swift & SwiftUI)
        Service(
            title = "🍎 Native iOS App Development (Swift & SwiftUI)",
            description = "Build high-performance native iOS applications for iPhone and iPad using Swift, SwiftUI, and modern architecture.",
            features = listOf(
                "Native iOS development using Swift, SwiftUI, and UIKit",
                "Clean Architecture + MVVM for scalable, maintainable iOS apps",
                "REST API integration using URLSession and Alamofire networking",
                "Local data persistence with SwiftData, CoreData, and UserDefaults",
                "Integration of Apple features: Sign in with Apple, Biometrics, Push Notifications",
                "iOS App Store release preparation, TestFlight distribution, and app signing"
            ),
            imageUrls = listOf(
                "/services/gig_07_native_ios_app_swift_swiftui/varient_01/website-720p/slide_01.webp",
                "/services/gig_07_native_ios_app_swift_swiftui/varient_01/website-720p/slide_02.webp",
                "/services/gig_07_native_ios_app_swift_swiftui/varient_01/website-720p/slide_03.webp",
            ),
            tags = listOf(
                "Swift",
                "SwiftUI",
                "UIKit",
                "Clean Architecture",
                "MVVM",
                "SwiftData",
                "CoreData",
                "URLSession",
                "Apple Sign-In",
                "App Store Release"
            )
        ),

        // 9. Review, Fix & Refactor AI-Generated App Code (Gig 09)
        Service(
            title = "🛡️ Review, Fix & Refactor AI-Generated App Code",
            description = "Built an app with ChatGPT, Cursor, or Claude? I audit, debug, secure, and refactor AI code into production software.",
            features = listOf(
                "Line-by-line code audit to identify hidden AI traps and memory leaks",
                "Refactor monolithic single-file AI scripts into clean MVVM architecture",
                "Eliminate Jetpack Compose recomposition loops and UI freezes",
                "Fix unmanaged Coroutine leaks and lifecycle state loss on rotation",
                "Security audit: extract hardcoded API secrets into encrypted Keystore storage",
                "Resolve AI-generated Gradle dependency conflicts and build failures",
                "Google Play Store and Desktop production release preparation"
            ),
            imageUrls = listOf(
                "/services/gig_09_review_fix_ai_generated_app_code/varient_01/website-720p/slide_01.webp",
                "/services/gig_09_review_fix_ai_generated_app_code/varient_01/website-720p/slide_02.webp",
                "/services/gig_09_review_fix_ai_generated_app_code/varient_01/website-720p/slide_03.webp",
            ),
            tags = listOf(
                "AI Code Audit",
                "ChatGPT / Claude Code",
                "Cursor AI Code",
                "Monolith to MVVM",
                "Memory Leak Fix",
                "Coroutine Leaks",
                "Compose Loop Fix",
                "Keystore Security",
                "Gradle Conflict Fix",
                "Production Hardening"
            )
        )
    )
}
