package com.coding.meet.util

import com.coding.meet.models.Achievement
import com.coding.meet.models.contactMePath

object AchievementData {
    val achievements = listOf(
        Achievement(
            title = "📺 4.4K+ YouTube Subscribers",
            subtitle = "Created 450+ Android development tutorials",
            platform = "Youtube",
            link = "https://youtube.com/@codingmeet26?si=_2Mu6ozuCdYuqihA",
            lightImage = "social/youtube.svg"
        ),
        Achievement(
            title = "⭐ 850+ GitHub Stars",
            subtitle = "500+ followers and growing open-source community",
            lightImage = "social/github.svg",
            platform = "Github",
            link = "https://github.com/Coding-Meet",
            darkImage = "social/github_dark_mode.svg"
        ),
        Achievement(
            title = "📦 45+ Completed Orders",
            subtitle = "Completed 45+ client projects with $4,000+ earnings and 4.9⭐ rating",
            platform = "Fiverr",
            link = contactMePath,
            lightImage = "social/fiverr.svg"
        ),
        Achievement(
            title = "🤝 200+ Contributions",
            subtitle = "Actively supporting developers on Telegram, Instagram, LinkedIn, Facebook & Twitter",
            lightImage = "social/contributions.svg",
            platform = "Social Media",
            link = contactMePath,
            darkImage = "social/contributions_dark.svg"
        ),
        Achievement(
            title = "💬 60+ Answers",
            subtitle = "Guiding developers with 60+ solutions on Stack Overflow",
            platform = "Stack Overflow",
            link = "https://stackoverflow.com/users/13082664/meet",
            lightImage = "social/stack_overflow.svg"
        ),
        Achievement(
            title = "✍️ 1K+ Claps",
            subtitle = "Published 10+ technical articles on Medium",
            lightImage = "social/medium.svg",
            platform = "Medium",
            link = "https://www.medium.com/@meet26",
            darkImage = "social/medium_dark_mode.svg"
        )
    )

}
