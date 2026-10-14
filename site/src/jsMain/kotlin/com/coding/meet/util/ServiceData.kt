package com.coding.meet.util

import com.coding.meet.models.Service

object ServiceData {

    val services = listOf(

        Service(
            title = "\uD83D\uDCF1 Custom Android App Development",
            description = "Need a custom mobile app for Android? I build high-quality, scalable apps using Kotlin and modern architecture.",
            features = listOf(
                "Develop custom apps using Kotlin, Java, and Jetpack Compose",
                "Clean Architecture + MVVM for scalable and maintainable apps",
                "Dependency Injection using Koin and Dagger Hilt",
                "REST API integration using Retrofit, Ktor, and OkHttp",
                "Local database integration with Room and SQLDelight",
                "Firebase integration: Auth, Firestore, Realtime DB, Crashlytics, Push Notifications",
                "Google APIs integration: Maps, Sign-In, Location, Billing, AdMob",
                "Offline-first architecture with caching and synchronization",
                "Performance optimization and smooth animations",
                "Play Store production release ready"
            ),
            imageUrls = listOf(
                "/services/custom-android-app/[14-52-39_28-06-26]-variant_2_custom_android_app.png",
                "/services/custom-android-app/[14-52-43_28-06-26]-variant_3_custom_android_app.png",
                "/services/custom-android-app/[15-01-37_28-06-26]-variant_2_custom_android_app.png"
            ),
        ),

        Service(
            title = "\uD83D\uDD27 Fix Bugs & Debug Android Apps",
            description = "Facing crashes, slow performance, or architecture issues? I can debug and fix your app professionally.",
            features = listOf(
                "Fix app crashes, ANRs, memory leaks, and runtime issues",
                "Resolve Jetpack Compose recomposition and UI state bugs",
                "Fix Gradle, SDK, dependency, and Android Studio problems",
                "Resolve API integration and JSON parsing issues",
                "Improve app performance, startup speed, and responsiveness",
                "Fix navigation, deep link, and back stack issues",
                "Resolve Firebase Authentication and database problems",
                "Fix Play Store publishing and signing issues",
                "Refactor messy code into clean architecture",
                "Resolve compatibility issues across Android versions"
            ),
            imageUrls = listOf(
                "/services/fix_android_bugs/[18-24-42_28-06-26]-variant_1_fix_android_bugs.png",
                "/services/fix_android_bugs/[18-24-44_28-06-26]-variant_2_fix_android_bugs.png",
                "/services/fix_android_bugs/[18-24-48_28-06-26]-variant_3_fix_android_bugs.png"
            ),
        ),

        Service(
            title = "🎨 Kotlin & Jetpack Compose UI",
            description = "Modernize your UI with Jetpack Compose. Dynamic, reactive, and responsive interfaces built with Material 3.",
            features = listOf(
                "Declarative UI development with Jetpack Compose & Material 3",
                "Custom animations, transitions, and state management",
                "Adaptive layouts for phones, tablets, and foldables",
                "Dark mode & light mode theme switching",
                "Migrate legacy XML layouts to modern Jetpack Compose",
                "Custom UI components, design systems, and canvas drawing"
            ),
            imageUrls = listOf(
                "/services/kotlin_jetpack_compose/[15-44-20_28-06-26]-variant_1_kotlin_jetpack_compose.png",
                "/services/kotlin_jetpack_compose/[15-44-23_28-06-26]-variant_2_kotlin_jetpack_compose.png",
                "/services/kotlin_jetpack_compose/[15-50-56_28-06-26]-variant_3_kotlin_jetpack_compose.png"
            ),
        ),

        Service(
            title = "⚡ Kotlin Multiplatform & Compose Multiplatform",
            description = "Target Android, iOS, Desktop, and Web from a single codebase using Kotlin Multiplatform & Compose Multiplatform.",
            features = listOf(
                "Share business logic across Android, iOS, Desktop, and Web",
                "Shared UI using Compose Multiplatform (CMP)",
                "Cross-platform state management with Koin & Decompose / ViewModel",
                "Shared networking with Ktor & multiplatform serialization",
                "Multiplatform database storage using SQLDelight or Room KMP",
                "Cost-effective & faster time to market for cross-platform apps"
            ),
            imageUrls = listOf(
                "/services/kotlin_multiplatform_cmp/[15-41-03_30-06-26]-variant_1_kotlin_multiplatform_cmp.png",
                "/services/kotlin_multiplatform_cmp/[15-41-06_30-06-26]-variant_2_kotlin_multiplatform_cmp.png",
                "/services/kotlin_multiplatform_cmp/[15-41-10_30-06-26]-variant_3_kotlin_multiplatform_cmp.png"
            ),
        ),

        Service(
            title = "🍎 Native iOS App Development (Swift)",
            description = "Build high-performance native iOS applications using Swift and SwiftUI with clean architecture.",
            features = listOf(
                "Native iOS development using Swift and SwiftUI / UIKit",
                "Clean Architecture + MVVM for scalable iOS codebases",
                "REST API integration & URLSession / Alamofire networking",
                "Local data storage with SwiftData or CoreData",
                "iOS App Store release preparation & TestFlight deployment"
            ),
            imageUrls = listOf(
                "/services/native_ios_swift/[16-54-40_30-06-26]-variant_1_native_ios_swift.png",
                "/services/native_ios_swift/[16-54-43_30-06-26]-variant_2_native_ios_swift.png",
                "/services/native_ios_swift/[16-54-46_30-06-26]-variant_3_native_ios_swift.png"
            ),
        )
    )
}