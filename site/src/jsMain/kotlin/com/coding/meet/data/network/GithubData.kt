package com.coding.meet.data.network

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import com.coding.meet.data.response.github.Github
import com.coding.meet.models.Project
import com.coding.meet.util.ExternalConfig.GITHUB_BASE_URL
import com.coding.meet.util.ExternalConfig.TOTAL_PAGE
import com.varabyte.kobweb.browser.http.http
import com.varabyte.kobweb.browser.storage.LongStorageKey
import com.varabyte.kobweb.browser.storage.StringStorageKey
import com.varabyte.kobweb.browser.storage.getItem
import com.varabyte.kobweb.browser.storage.setItem
import kotlinx.browser.localStorage
import kotlinx.browser.window
import kotlinx.serialization.Serializable
import kotlin.time.Clock


val GITHUB_STARS_KEY = StringStorageKey("github_stars_cache")
val GITHUB_STARS_TIME_KEY = LongStorageKey("github_stars_cache_time")

@Composable
fun GithubStargazersCountData(projectsState: MutableState<MutableList<Project>>) {
    LaunchedEffect(Unit) {
        try {
            val now = Clock.System.now().toEpochMilliseconds()
            val cacheTime = localStorage.getItem(GITHUB_STARS_TIME_KEY) ?: 0L

            val isCacheValid = (now - cacheTime) < (6 * 60 * 60 * 1000) // 6 hours

            if (isCacheValid) {
                // Load from cache
                localStorage.getItem(GITHUB_STARS_KEY)?.let { jsonString ->
                    val cached = json.decodeFromString<List<RepoStars>>(jsonString)

                    val updated = projectsState.value.toMutableList()

                    updated.forEachIndexed { index, project ->
                        cached.find { it.url == project.githubUrl }?.let {
                            updated[index] = project.copy(stargazersCount = it.stars)
                        }
                    }
                    projectsState.value = updated
                }
                return@LaunchedEffect
            }

            // Cache expired → Call API
            val allRepos = mutableListOf<RepoStars>()

            repeat(TOTAL_PAGE) { page ->
                val response = window.http.tryGet(
                    "$GITHUB_BASE_URL?page=${page + 1}&per_page=100"
                )?.decodeToString()

                response?.let {
                    val githubRepos = json.decodeFromString<ArrayList<Github>>(response)

                    githubRepos.forEach {
                        allRepos.add(RepoStars(it.htmlUrl, it.stargazersCount))
                    }
                }
            }

            // Update UI
            val updated = projectsState.value.toMutableList()
            updated.forEachIndexed { index, project ->
                allRepos.find { it.url == project.githubUrl }?.let {
                    updated[index] = project.copy(stargazersCount = it.stars)
                }
            }
            projectsState.value = updated

            // Save to cache
            localStorage.setItem(GITHUB_STARS_KEY, json.encodeToString(allRepos))
            localStorage.setItem(GITHUB_STARS_TIME_KEY, now)

        } catch (e: Exception) {
            console.error(e)
        }
    }
}

@Serializable
data class RepoStars(val url: String, val stars: Int)
