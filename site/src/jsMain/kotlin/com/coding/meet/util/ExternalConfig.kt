package com.coding.meet.util

object ExternalConfig {
    private const val GITHUB_USER_NAME = "Coding-Meet"
    private const val TOTAL_PUBLIC_REPOS = 104

    const val TOTAL_PAGE = TOTAL_PUBLIC_REPOS / 100 + 1
    const val GITHUB_BASE_URL = "https://api.github.com/users/$GITHUB_USER_NAME/repos"

    private const val MEDIUM_USER_NAME = "@meet26"
    const val MEDIUM_BASE_URL =
        "https://api.rss2json.com/v1/api.json?rss_url=https://medium.com/feed/$MEDIUM_USER_NAME"
}