package com.coding.meet.data.network

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.coding.meet.data.response.github.Github
import com.coding.meet.util.Constants.GITHUB_BASE_URL
import com.coding.meet.util.Constants.TOTAL_PAGE
import com.coding.meet.util.Constants.projects
import com.varabyte.kobweb.browser.http.http
import kotlinx.browser.window

@Composable
fun GithubStargazersCountData() {
    LaunchedEffect(Unit) {
        try {
            repeat(TOTAL_PAGE) { page ->
                val response = window.http.tryGet(
                    "$GITHUB_BASE_URL?page=${page + 1}&per_page=100"
                )?.decodeToString()
                response?.let {
                    val githubRepos = json.decodeFromString<ArrayList<Github>>(response)

                    checkLatestData(
                        label = "GitHub Project",
                        localItems = projects,
                        onlineItems = githubRepos,
                        getLocalId = { it.githubUrl },
                        getOnlineId = { it.htmlUrl },
                        getOnlineTitle = { it.name },
                        isUpToDate = { local, online ->
                            // Only check stargazersCount as requested
                            local.stargazersCount == online.stargazersCount
                        },
                        showNewItems = false // Don't show new repo logs
                    )

                    projects.forEachIndexed { index, project ->
                        project.githubUrl?.let { githubUrl ->
                            githubRepos.find { it.htmlUrl == githubUrl }?.let {
                                // Only update the stargazersCount
                                projects[index] = projects[index].copy(stargazersCount = it.stargazersCount)
                            }
                        }
                    }
//                    console.log(projects.map { it.stargazersCount })
                }
            }
        } catch (e: Exception) {
            console.error(e)
        }
    }
}