package com.coding.meet.util

import com.coding.meet.data.network.json
import com.coding.meet.data.response.medium.Medium
import com.coding.meet.models.Article

object ArticleData {
    private val rawArticles = listOf(

        Article(
            title = "How to Implement Shaders in Compose Multiplatform (Android, iOS, Desktop & Web)",
            shortDescription = "Learn how to build and run shader animations across Android, iOS, Desktop, and Web using Compose Multiplatform.",
            thumbnail = "/articles/shader-cmp.png",
            link = "https://medium.com/@meet26/how-to-implement-shaders-in-compose-multiplatform-android-ios-desktop-web-c86a36dd9666",
            categories = listOf("KMP", "Shaders", "Compose Multiplatform", "Graphics"),
            pubDate = "Apr 12, 2026",
            readTime = "13 min read",
            guid = "https://medium.com/p/c86a36dd9666",
            presentations = "1.3K",
            views = "208",
            reads = "109",
            claps = "133",
            isFeatured = false,
            replaceUrlList = mapOf(
                "https://medium.com/media/17e14b58c22d2a700f92305581567830" to "https://www.youtube.com/watch?v=zIDrScVQjhg"
            )
        ),

        Article(
            title = "Building a Fully Adaptive Navigation System in Compose Multiplatform (KMP)",
            shortDescription = "Create a responsive navigation system that adapts across screen sizes in Compose Multiplatform.",
            thumbnail = "/articles/adaptive_navigation.png",
            link = "https://medium.com/@meet26/building-a-fully-adaptive-navigation-system-in-compose-multiplatform-kmp-e1a8921ca792",
            categories = listOf("KMP", "Navigation", "UI Design"),
            pubDate = "Jan 24, 2026",
            readTime = "15 min read",
            guid = "https://medium.com/p/e1a8921ca792",
            presentations = "3.3K",
            views = "1.1K",
            reads = "640",
            claps = "58",
            isFeatured = true
        ),

        Article(
            title = "Cross-Platform Text-to-Speech with Real-time Highlighting",
            shortDescription = "Implement text-to-speech with synchronized highlighting using Kotlin Multiplatform and Swift.",
            thumbnail = "/articles/tts_highlighting.png",
            link = "https://medium.com/@meet26/cross-platform-text-to-speech-with-real-time-highlighting-kotlin-multiplatform-swift-9a02fa667f6f",
            categories = listOf("KMP", "TTS", "Accessibility"),
            pubDate = "Aug 19, 2025",
            readTime = "21 min read",
            guid = "https://medium.com/p/9a02fa667f6f",
            presentations = "2.9K",
            views = "1.3K",
            reads = "647",
            claps = "74",
            isFeatured = true,
            replaceUrlList = mapOf(
                "https://medium.com/media/ebc60e432aadd97971fd61cdd30c7476" to "https://www.youtube.com/watch?v=SzuDWWdEkqE"
            )
        ),

        Article(
            title = "How to Show Toasts in Compose Multiplatform (Android, iOS, Desktop)",
            shortDescription = "Implement cross-platform toast messages using expect/actual in Compose Multiplatform.",
            thumbnail = "/articles/toast_cmp.png",
            link = "https://medium.com/@meet26/how-to-show-toasts-in-compose-multiplatform-android-ios-desktop-with-expect-actual-85c630d46d06",
            categories = listOf("KMP", "UI", "Compose"),
            pubDate = "Jun 19, 2025",
            readTime = "7 min read",
            guid = "https://medium.com/p/85c630d46d06",
            presentations = "1.94K",
            views = "2.9K",
            reads = "1.2K",
            claps = "140",
            isFeatured = true
        ),

        Article(
            title = "Efficient Logging in Kotlin with ProGuard Optimization",
            shortDescription = "Implement an optimized logging system that removes logs in release builds using ProGuard.",
            thumbnail = "/articles/logging_proguard.png",
            link = "https://medium.com/@meet26/efficient-logging-in-kotlin-with-proguard-optimization-452bdac5c016",
            categories = listOf("Android", "Kotlin", "Logging", "ProGuard"),
            pubDate = "Mar 24, 2025",
            readTime = "4 min read",
            guid = "https://medium.com/p/452bdac5c016",
            presentations = "6.3K",
            views = "2.2K",
            reads = "900",
            claps = "139",
            isFeatured = true
        ),

        Article(
            title = "Part 2: Automating Reverse Feature to Template Transformation in Gradle",
            shortDescription = "Automate Android template creation using Gradle scripting.",
            thumbnail = "/articles/feature-to-template.png",
            link = "https://medium.com/@meet26/part-2-automating-reverse-feature-to-template-transformation-in-gradle-3973880bb6ff",
            categories = listOf("Android", "Gradle", "Automation"),
            pubDate = "Feb 18, 2025",
            readTime = "7 min read",
            guid = "https://medium.com/p/3973880bb6ff",
            presentations = "1.8K",
            views = "375",
            reads = "124",
            claps = "91",
            isFeatured = false
        ),

        Article(
            title = "Automate Android Feature Creation with Gradle",
            shortDescription = "Speed up Android development by automating feature creation with Gradle.",
            thumbnail = "/articles/template-to-feature.png",
            link = "https://medium.com/@meet26/automate-android-feature-creation-with-gradle-cfd51373e167",
            categories = listOf("Android", "Gradle", "Automation"),
            pubDate = "Dec 10, 2024",
            readTime = "7 min read",
            guid = "https://medium.com/p/cfd51373e167",
            presentations = null,
            views = "2.5K",
            reads = "1.1K",
            claps = "212",
            isFeatured = true
        ),

        Article(
            title = "Full Guide: How to Form Validation With Jetpack Compose in Kotlin",
            shortDescription = "Complete guide to implementing form validation in Jetpack Compose.",
            thumbnail = "/articles/form-validation-jetpack-compose.png",
            link = "https://medium.com/@meet26/full-guide-how-to-form-validation-with-jetpack-compose-01e0464ae884",
            categories = listOf("Jetpack Compose", "Validation", "Kotlin"),
            pubDate = "Oct 1, 2024",
            readTime = "16 min read",
            guid = "https://medium.com/p/01e0464ae884",
            presentations = null,
            views = "4K",
            reads = "2.3K",
            claps = "109",
            isFeatured = true,
            replaceUrlList = mapOf(
                "https://medium.com/media/03ea2be5ab777b90e0a030ce0c9330cb" to "https://www.youtube.com/watch?v=8M_CNcVWHx0"
            )
        ),

        Article(
            title = "Bottom Navigation Bar & Navigation Rail in Compose Multiplatform",
            shortDescription = "Implement adaptive navigation for compact and large screens in Compose Multiplatform.",
            thumbnail = "/articles/bottom-navigation-bar-cmp.png",
            link = "https://medium.com/@meet26/how-to-integrate-bottom-navigation-bar-for-compact-screens-and-a-navigation-rail-for-larger-screens-c7dc3baab0e7",
            categories = listOf("Android", "Navigation", "UI Design"),
            pubDate = "Sep 20, 2024",
            readTime = "10 min read",
            guid = "https://medium.com/p/c7dc3baab0e7",
            presentations = null,
            views = "4.3K",
            reads = "2.1K",
            claps = "76",
            isFeatured = true,
            replaceUrlList = mapOf(
                "https://medium.com/media/0978046c7e7b122964874b23b4aa1223" to "https://www.youtube.com/watch?v=ThDlqCwCN28"
            )
        ),
        Article(
            title = "How to Integrate ViewModel in Kotlin Multiplatform with Koin",
            shortDescription = "Use ViewModel in Kotlin Multiplatform projects with Koin dependency injection.",
            thumbnail = "/articles/viewmodel-kmp.png",
            link = "https://medium.com/@meet26/how-to-integrate-viewmodel-in-kotlin-multiplatform-with-koin-1a1134530215",
            categories = listOf(
                "Kotlin Multiplatform",
                "ViewModel",
                "Dependency Injection",
                "Koin"
            ),
            pubDate = "Sep 11, 2024",
            readTime = "5 min read",
            guid = "https://medium.com/p/1a1134530215",
            presentations = null,
            views = "6.7K",
            reads = "4K",
            claps = "63",
            isFeatured = true
        )
    )

    val articles = try {
        val mediumData = json.decodeFromString<Medium>(MediumContent.jsonStr)
        rawArticles.map { article ->
            val onlineItem = mediumData.networkArticles.find { it.guid == article.guid }
            var content = onlineItem?.content ?: article.content
            article.replaceUrlList.forEach { (old, new) ->
                content = content.replace(old, new)
            }
            article.copy(content = content)
        }
    } catch (e: Exception) {
        rawArticles
    }
    val articleSiteMap = articles.map { article ->
        """
    <url>
        <loc>
            https://codingmeet.com/blog/${article.id}
        </loc>
    </url>"""
    }
}