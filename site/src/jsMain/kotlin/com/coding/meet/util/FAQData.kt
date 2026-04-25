package com.coding.meet.util

import com.coding.meet.models.FAQ

object FAQData {
    val faqs = listOf(
        FAQ(
            question = "What technologies do you use for Android app development?",
            answer = "I use Kotlin, Java, Jetpack Compose, and Kotlin Multiplatform, along with MVVM, Clean Architecture, and various Android libraries."
        ),
        FAQ(
            question = "Can you fix bugs in my existing Android app?",
            answer = "Yes, I can debug and fix issues related to UI, crashes, Gradle, SDK updates, and general app performance."
        ),
        FAQ(
            question = "Is source code required to fix bugs in the app?",
            answer = "Yes, source code is required to diagnose and fix bugs in your application."
        ),
        FAQ(
            question = "Can you upgrade my app to the latest Android version?",
            answer = "Yes, I can update your app’s target SDK to Android 14 (API level 35) and make necessary code adjustments for compatibility."
        ),
        FAQ(
            question = "Is source code required to update the app?",
            answer = "Yes, source code is required to update the SDK and fix any compatibility issues in your application."
        ),
        FAQ(
            question = "Do you provide AI chatbot integration?",
            answer = "Yes, I can integrate AI-powered chatbots using Google Gemini API and GPT-3 for intelligent conversations."
        ),
        FAQ(
            question = "Do you provide Play Store upload support?",
            answer = "Yes, I can fix Play Store upload issues, including APK problems and version compatibility errors."
        ),
        FAQ(
            question = "Can you integrate Firebase services into my app?",
            answer = "Yes, I can integrate Firebase services such as Realtime Database, Firestore, Authentication, Push Notifications, and Crashlytics."
        ),
        FAQ(
            question = "Do you work with third-party APIs?",
            answer = "Yes, I can integrate third-party REST APIs to enhance your app’s functionality."
        ),
        FAQ(
            question = "What do you need to get started?",
            answer = "I need access to your app’s source code, preferably through a Git repository, along with the project requirements."
        ),
        FAQ(
            question = "How long does it take to complete a project?",
            answer = "The timeline depends on the complexity of the project. Simple fixes take a few hours, while full app development may take weeks or months."
        )
    )
}
