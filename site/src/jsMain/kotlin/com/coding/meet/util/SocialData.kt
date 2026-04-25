package com.coding.meet.util

import com.coding.meet.models.Social
import com.coding.meet.util.AppInfo.EMAIL_ID

object SocialData {
    val socials = listOf(
        Social(
            title = "Youtube",
            link = "https://youtube.com/@codingmeet26?si=_2Mu6ozuCdYuqihA",
            lightImage = "social/youtube.svg"
        ),
        Social(
            title = "GitHub",
            link = "https://github.com/Coding-Meet",
            lightImage = "social/github.svg",
            darkImage = "social/github_dark_mode.svg"
        ),
        Social(
            title = "Gmail",
            link = "mailto:$EMAIL_ID",
            lightImage = "social/mail.svg"
        ),
        Social(
            title = "Medium",
            link = "https://www.medium.com/@meet26",
            lightImage = "social/medium.svg",
            darkImage = "social/medium_dark_mode.svg"
        ),
        Social(
            title = "Stack Overflow",
            link = "https://stackoverflow.com/users/13082664/meet",
            lightImage = "social/stack_overflow.svg"
        ),
        Social(
            title = "LinkedIn",
            link = "https://www.linkedin.com/in/coding-meet",
            lightImage = "social/linkedin.svg"
        ),
        Social(
            title = "Instagram",
            link = "https://www.instagram.com/codingmeet26/",
            lightImage = "social/instagram.svg"
        ),
        Social(
            title = "Twitter",
            link = "https://www.twitter.com/CodingMeet",
            lightImage = "social/twitter.svg"
        ),
        Social(
            title = "Telegram",
            link = "https://www.telegram.me/Meetb26",
            lightImage = "social/telegram.svg"
        ),
        Social(
            title = "Buy Me Coffee",
            link = "https://www.buymeacoffee.com/CodingMeet",
            lightImage = "social/buy_me_coffee.svg",
            darkImage = "social/buy_me_coffee_dark_mode.svg"
        ),
    )
}
