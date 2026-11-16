package com.coding.meet.util

import com.coding.meet.models.FAQ

object FAQData {
    val faqs = listOf(
        // 1. Custom Android App Development
        FAQ(
            question = "What architecture and tech stack do you use for custom Android app development?",
            answer = "I build modern native Android apps using Kotlin, Jetpack Compose, and XML following Clean Architecture with MVVM / MVI patterns. I implement Dagger Hilt or Koin for Dependency Injection, Coroutines & Flow for reactive asynchronous data, Room DB for offline caching, and Retrofit or Ktor for network communication."
        ),

        // 2. Fix Bugs & Debugging
        FAQ(
            question = "Can you fix crashes, ANRs, and build errors in my existing Android app?",
            answer = "Yes. I diagnose root causes and resolve runtime crashes, NullPointerExceptions, ANRs (Application Not Responding), memory leaks, infinite Jetpack Compose recompositions, lifecycle state loss, and complex Gradle / Android Studio build failures."
        ),

        // 3. Upgrade Target SDK & Gradle
        FAQ(
            question = "Can you upgrade my app to the latest Android 16 (Target SDK 36) and Gradle version?",
            answer = "Yes. I update apps to Target SDK 36 to comply with mandatory Google Play Console requirements. This includes upgrading Gradle, Android Gradle Plugin (AGP), migrating build scripts to Version Catalogs (libs.versions.toml), adapting to Android 15 behavior changes, and implementing Edge-to-Edge display and Predictive Back navigation."
        ),

        // 4. Jetpack Compose & XML Migration
        FAQ(
            question = "Can you migrate my existing XML-based Android app to Jetpack Compose?",
            answer = "Yes! I can migrate your legacy XML layouts and custom views to Jetpack Compose using Material 3 and Material You dynamic theming. We can modernize screens incrementally without disrupting existing functionality, delivering smooth 60fps animations and responsive UI across phones, tablets, and foldables."
        ),

        // 5. AI Chatbot & LLM Integration
        FAQ(
            question = "Which AI models can you integrate into my mobile or desktop app?",
            answer = "I integrate Google Gemini (Flash & Pro), OpenAI (ChatGPT / GPT-5), Claude, and DeepSeek APIs with real-time streaming responses, conversation history, multi-turn context, voice input/output (STT & TTS), document AI with RAG, and secure server-side or Keystore API key management."
        ),

        // 6. Kotlin Multiplatform & Compose Multiplatform
        FAQ(
            question = "Can you build a single app that runs on both Android and iOS with Kotlin Multiplatform (KMP)?",
            answer = "Yes! Using Kotlin Multiplatform (KMP) and Compose Multiplatform (CMP), we share 100% of business logic, networking (Ktor), and database (Room KMP / SQLDelight), along with shared UI. This gives you 100% native performance on both Android and iOS while cutting development and maintenance costs in half."
        ),

        // 7. Desktop App Development (CMP)
        FAQ(
            question = "Can you develop desktop applications for macOS, Windows, and Linux?",
            answer = "Yes. I build lightweight, high-performance desktop apps, internal utilities, and admin dashboards using Compose Multiplatform for Desktop. I handle native window controls, desktop lifecycle, local SQLite databases, and package production-ready installers (.dmg for macOS, .msi for Windows, and .deb for Linux)."
        ),

        // 8. Native iOS Development
        FAQ(
            question = "Do you develop native iOS apps using Swift and SwiftUI?",
            answer = "Yes. I develop native iOS applications using Swift, SwiftUI, and UIKit with MVVM and Clean Architecture. I handle URLSession/Alamofire networking, SwiftData and CoreData persistence, Sign in with Apple, Push Notifications, and App Store / TestFlight distribution."
        ),

        // 9. Review & Fix AI-Generated Code
        FAQ(
            question = "I built an app using AI tools (ChatGPT, Cursor, Claude) but it has errors. Can you fix and refactor it?",
            answer = "Yes. AI-generated code frequently suffers from unmanaged coroutine leaks, infinite recomposition loops, hardcoded secrets, and bloated single-file code. I audit every line, extract API keys into encrypted storage, refactor code into clean MVVM architecture, and make the app stable and production-ready."
        ),

        // 10. Backend & Firebase Services
        FAQ(
            question = "Can you integrate Firebase or custom REST APIs into my app?",
            answer = "Yes. I integrate Firebase services (Authentication, Cloud Firestore, Realtime Database, Cloud Messaging / FCM, Crashlytics, Remote Config) as well as custom third-party RESTful APIs, GraphQL, and payment gateways like Google Play Billing and Stripe."
        ),

        // 11. App Store & Play Store Support
        FAQ(
            question = "Do you provide Play Store and App Store publishing support?",
            answer = "Yes. I generate release-ready signed App Bundles (.aab) and iOS archives (.ipa), configure R8 / ProGuard rules to optimize app size, and assist with store policy compliance, Data Safety declarations, and resolving app rejection issues."
        ),

        // 12. Getting Started & Timelines
        FAQ(
            question = "What do you need to get started, and how long does a project take?",
            answer = "To get started, I need your project requirements, UI designs (Figma/mockups) if available, and repository access (GitHub/GitLab) or source code zip. Quick bug fixes and SDK upgrades usually take 24–48 hours, while full app developments take 2–6 weeks with milestone testing and post-launch support."
        )
    )
}
