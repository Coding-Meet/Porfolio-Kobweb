package com.coding.meet.util

import com.coding.meet.models.Service

object ServiceData {
    val services = listOf(
        Service(
            title = "\uD83D\uDCF1 Build a New Android App",
            description = "Want to create your own Android app? I can build it for you!",
            features = listOf(
                "Develop using Kotlin, Java, Jetpack Compose, and Kotlin Multiplatform",
                "Implement Coroutines, Koin, Dagger Hilt, Retrofit, and Room for efficient architecture",
                "Design UI with XML and Jetpack Compose",
                "Integrate third-party REST APIs seamlessly",
                "Use Navigation Components for smooth app flow",
                "Follow MVVM / Clean Architecture for maintainable code",
                "Optimize image loading with Glide and Coil",
                "Implement Firebase Crashlytics and Google Analytics for monitoring and insights",
                "Utilize Google APIs like Maps and Sign-In",
                "Enable Google Play In-App Updates for seamless user experience",
                "Integrate Firebase Realtime Database, Firestore, and Push Notifications"
            ),
            imageUrls = listOf(
                "services/build_android_app.png"
            ),
        ),
        Service(
            title = "\uD83D\uDD27 Fix Bugs & Improve Your App",
            description = "Is your app crashing or running slow? I will fix it!",
            features = listOf(
                "Resolve UI and layout issues for a better user experience",
                "Optimize app performance to run smoothly",
                "Fix code errors and bugs efficiently",
                "Resolve version update errors and compatibility issues",
                "Debug and fix Android SDK and Gradle problems",
                "Upgrade SDK and API level to meet the latest standards",
                "Identify and fix app crashes for a stable experience",
                "Troubleshoot and resolve specific bugs",
                "Fix importing issues in Android Studio",
                "Debug Jetpack Compose UI issues",
                "Resolve Signup/Login authentication problems",
                "Fix Firebase integration issues (Firestore, Realtime Database, Notifications)",
                "Debug Android Studio SDK-related problems"
            ),
            imageUrls = listOf(
                "services/fix_bug.png"
            ),
        ),
        Service(
            title = "\uD83D\uDE80 Update Your Android App (SDK & Gradle)",
            description = "Need to update your app for the latest Android version?",
            features = listOf(
                "Update target SDK to Android 14 (API level 35) with necessary code adjustments",
                "Fix Gradle and dependency issues",
                "Upgrade SDK and API levels for better performance and security",
                "Debug and resolve Android app bugs",
                "Fix version update errors and compatibility issues",
                "Resolve Android SDK-related errors",
                "Identify and fix app crashes and runtime errors",
                "Fix specific bugs affecting app performance",
                "Troubleshoot APK issues and build problems",
                "Resolve errors when uploading to the Play Store"
            ),
            imageUrls = listOf(
                "services/update_android_app.png"
            ),
        ),
        Service(
            title = "\uD83E\uDD16 Add AI Chatbot to Your App (Google Gemini & GPT-4)",
            description = "Want to add an AI chatbot? I can integrate Google Gemini AI for smart responses!",
            features = listOf(
                "Welcome Screen for a friendly start",
                "Chat Screen with AI-powered conversations using GPT-4 & Gemini API",
                "Internet Connectivity Check to ensure the app stays online",
                "Clipboard Manager for easy message copying",
                "Text Selection for copying and sharing text seamlessly",
                "Popup Menus for enhanced message interaction",
                "Room Database to store chat history locally",
                "Robot Interaction: Insert, view, update, and delete robot characters",
                "Text-to-Speech (TTS) & Voice-to-Text (VTT) support for accessibility",
                "API Key Security with encrypted SharedPreferences"
            ),
            imageUrls = listOf(
                "services/chatbot.png"
            ),
        )
    )
}