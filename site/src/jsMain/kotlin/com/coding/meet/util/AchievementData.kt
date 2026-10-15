package com.coding.meet.util

import com.coding.meet.models.Achievement
import com.coding.meet.models.contactMePath

object AchievementData {
    val achievements = listOf(
        Achievement(
            title = "📺 4.4K+ YouTube Subscribers",
            subtitle = "Published 450+ video tutorials covering Android, Jetpack Compose, Kotlin Multiplatform, and Compose Multiplatform.",
            platform = "Youtube",
            link = "https://youtube.com/@codingmeet26?si=_2Mu6ozuCdYuqihA",
            lightImage = "/social/youtube.svg"
        ),
        Achievement(
            title = "⭐ 950+ GitHub Stars",
            subtitle = "500+ followers & open-source projects in Android, Jetpack Compose, Kotlin Multiplatform, and Compose Multiplatform.",
            lightImage = "/social/github.svg",
            platform = "Github",
            link = "https://github.com/Coding-Meet",
            darkImage = "/social/github_dark_mode.svg"
        ),
        Achievement(
            title = "📦 70+ Completed Orders",
            subtitle = "Successfully delivered 70+ client projects in Android, Jetpack Compose, Kotlin Multiplatform, and Compose Multiplatform, earning $9K+ with a 4.9⭐ rating.",
            platform = "Fiverr",
            link = contactMePath,
            lightImage = "/social/fiverr.svg"
        ),
        Achievement(
            title = "🤝 200+ Contributions",
            subtitle = "Actively guiding developers on Telegram, LinkedIn, Instagram, X, and Facebook, sharing knowledge about Android, Kotlin, and multiplatform development.",
            lightImage = "/social/contributions.svg",
            platform = "Social Media",
            link = contactMePath,
            darkImage = "/social/contributions_dark.svg"
        ),
        Achievement(
            title = "💬 60+ Answers",
            subtitle = "Guiding developers by providing 60+ highly rated solutions on Stack Overflow, covering Android and Kotlin development.",
            platform = "Stack Overflow",
            link = "https://stackoverflow.com/users/13082664/meet",
            lightImage = "/social/stack_overflow.svg"
        ),
        Achievement(
            title = "✍️ 1.1K+ Claps",
            subtitle = "Writing in-depth technical articles on Android architecture, Jetpack Compose, Kotlin Multiplatform, and Compose Multiplatform.",
            lightImage = "/social/medium.svg",
            platform = "Medium",
            link = "https://www.medium.com/@meet26",
            darkImage = "/social/medium_dark_mode.svg"
        )
    )

}
