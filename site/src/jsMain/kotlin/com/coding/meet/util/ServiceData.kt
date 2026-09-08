package com.coding.meet.util

import com.coding.meet.models.Service

object ServiceData {

    val services = listOf(

        Service(
            title = "\uD83D\uDCF1 Build Android & iOS Apps",
            description = "Need a modern mobile app for Android, iOS, Desktop, or Web? I build scalable apps using the latest technologies.",
            features = listOf(
                "Develop apps using Kotlin, Java, Jetpack Compose, Compose Multiplatform, and Kotlin Multiplatform",
                "Build Android, iOS, Desktop, and Web apps from a shared codebase",
                "Modern UI development using Material 3 and Compose",
                "Clean Architecture + MVVM for scalable and maintainable apps",
                "Dependency Injection using Koin and Dagger Hilt",
                "REST API integration using Retrofit, Ktor, and OkHttp",
                "Local database integration with Room and SQLDelight",
                "Firebase integration: Authentication, Firestore, Realtime Database, Analytics, Crashlytics, Push Notifications",
                "Google APIs integration: Maps, Sign-In, Location, Billing, AdMob",
                "Media apps with ExoPlayer, audio/video support, and file handling",
                "Offline-first architecture with caching and synchronization",
                "Performance optimization and smooth animations",
                "Play Store and App Store ready production apps"
            ),
            imageUrls = listOf(
                "/services/build_android_app.png"
            ),
        ),

        Service(
            title = "\uD83D\uDD27 Fix Bugs & Improve Existing Apps",
            description = "Facing crashes, slow performance, or architecture issues? I can debug and improve your app professionally.",
            features = listOf(
                "Fix app crashes, ANRs, memory leaks, and runtime issues",
                "Resolve Jetpack Compose recomposition and UI state bugs",
                "Debug Kotlin Multiplatform and Compose Multiplatform issues",
                "Fix Gradle, SDK, dependency, and Android Studio problems",
                "Resolve API integration and JSON parsing issues",
                "Improve app performance, startup speed, and responsiveness",
                "Fix navigation, deep link, and back stack issues",
                "Resolve Firebase Authentication and database problems",
                "Fix Play Store publishing and signing issues",
                "Refactor messy code into clean architecture",
                "Optimize network calls and background processing",
                "Debug WebView, media player, notification, and permission issues",
                "Resolve compatibility issues across Android versions and devices"
            ),
            imageUrls = listOf(
                "/services/fix_bug.png"
            ),
        ),

        Service(
            title = "\uD83D\uDE80 Upgrade SDK, Gradle & Modernize App",
            description = "Need to migrate your old project to the latest Android ecosystem? I can modernize your app safely.",
            features = listOf(
                "Upgrade project to latest Android SDK and Gradle versions",
                "Migrate Java/XML projects to Kotlin and Jetpack Compose",
                "Update deprecated APIs and outdated libraries",
                "Migrate from old support libraries to AndroidX",
                "Modernize architecture using MVVM and Clean Architecture",
                "Fix breaking changes after SDK or dependency updates",
                "Resolve AGP, Kotlin, and build configuration issues",
                "Improve app security and Play Store compliance",
                "Add edge-to-edge UI and latest Android features",
                "Prepare apps for latest Play Store requirements",
                "Optimize app size and build performance",
                "Fix release build, ProGuard, and R8 issues",
                "Support latest Android devices and API levels"
            ),
            imageUrls = listOf(
                "/services/update_android_app.png"
            ),
        ),

        Service(
            title = "\uD83E\uDD16 AI Integration & Smart Features",
            description = "Want to add AI-powered experiences to your app? I integrate modern AI tools and automation features.",
            features = listOf(
                "Integrate OpenAI GPT, Google Gemini, and other AI APIs",
                "Build AI chatbots with streaming responses",
                "Voice-to-Text and Text-to-Speech integration",
                "AI image generation and image analysis features",
                "AI-powered content generation and summarization",
                "Secure API handling and token management",
                "Chat history management using Room or SQLDelight",
                "Clipboard actions, message actions, and smart prompts",
                "Modern chat UI with markdown and code highlighting",
                "Realtime AI responses using WebSockets or streaming APIs",
                "Custom AI assistants for business or productivity apps",
                "Offline caching and optimized API usage for lower costs",
                "Integrate AI features into existing Android/iOS apps"
            ),
            imageUrls = listOf(
                "/services/chatbot.png"
            ),
        )
    )
}