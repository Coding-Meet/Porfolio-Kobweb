package com.coding.meet.util

import com.coding.meet.models.Achievement
import com.coding.meet.models.contactMePath

object AchievementData {
    val achievements = listOf(
        Achievement(
            metric = "4.4K+",
            title = "YouTube Subscribers",
            subtitle = "Published 450+ high-quality video tutorials helping developers worldwide master modern Android, Jetpack Compose, and Kotlin Multiplatform.",
            platform = "YouTube",
            link = "https://youtube.com/@codingmeet26?si=_2Mu6ozuCdYuqihA",
            lightImage = "/social/youtube.svg",
            badges = listOf("🎬 450+ Videos", "🔴 Tech Tutorials", "👥 4.4K+ Community")
        ),
        Achievement(
            metric = "950+",
            title = "GitHub Stars",
            subtitle = "Active open-source author building architecture templates and production-grade libraries trusted by 500+ followers across the globe.",
            lightImage = "/social/github.svg",
            platform = "GitHub",
            link = "https://github.com/Coding-Meet",
            darkImage = "/social/github_dark_mode.svg",
            badges = listOf("⭐ 950+ Stars", "📦 Open Source", "👥 500+ Followers")
        ),
        Achievement(
            metric = "70+",
            title = "Completed Client Projects",
            subtitle = "Successfully delivered 70+ client apps, SDK upgrades, and architecture refactors with a stellar 4.9★ rating and over $9K+ earned.",
            platform = "Fiverr",
            link = contactMePath,
            lightImage = "/social/fiverr.svg",
            badges = listOf("⭐ 4.9 Rating", "💼 $9K+ Earned", "✅ 100% On-Time")
        ),
        Achievement(
            metric = "200+",
            title = "Community Contributions",
            subtitle = "Actively mentoring developers across Telegram, LinkedIn, X, and Instagram through architectural discussions and daily code reviews.",
            lightImage = "/social/contributions.svg",
            platform = "Community",
            link = contactMePath,
            darkImage = "/social/contributions_dark.svg",
            badges = listOf("💬 Mentorship", "🌐 5 Communities", "🤝 Daily Guidance")
        ),
        Achievement(
            metric = "60+",
            title = "Stack Overflow Solutions",
            subtitle = "Guiding developers by providing 60+ verified, highly-rated solutions covering complex Android lifecycle, Jetpack Compose, and KMP bugs.",
            platform = "Stack Overflow",
            link = "https://stackoverflow.com/users/13082664/meet",
            lightImage = "/social/stack_overflow.svg",
            badges = listOf("💡 Verified Answers", "🏆 Top 10% Solver", "🛠️ Bug Resolver")
        ),
        Achievement(
            metric = "1.1K+",
            title = "Medium Article Claps",
            subtitle = "Authoring in-depth technical blogs breaking down Clean Architecture, MVI design patterns, and Compose performance optimizations.",
            lightImage = "/social/medium.svg",
            platform = "Medium",
            link = "https://www.medium.com/@meet26",
            darkImage = "/social/medium_dark_mode.svg",
            badges = listOf("👏 1.1K+ Claps", "✍️ Technical Writer", "📚 Deep Dives")
        )
    )
}
