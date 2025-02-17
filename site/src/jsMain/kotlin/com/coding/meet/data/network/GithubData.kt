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
                    val github = json.decodeFromString<ArrayList<Github>>(response)
                    projects.forEachIndexed { index, project ->
                        project.githubUrl?.let { githubUrl ->
                            github.find { githubItem ->
                                githubItem.htmlUrl == githubUrl
                            }?.let {
                                projects[index] = projects[index].copy(
                                    topics = it.topics, stargazersCount = it.stargazersCount
                                )
                            }
                        }
                    }
                    console.log(projects.map { it.stargazersCount })
                }
            }
        } catch (e: Exception) {
            console.error(e)
        }
    }
}