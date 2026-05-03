package com.coding.meet.data.network

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.data.response.medium.Medium
import com.coding.meet.util.ArticleData.articles
import com.coding.meet.util.ExternalConfig.MEDIUM_BASE_URL
import com.varabyte.kobweb.browser.http.http
import kotlinx.browser.window


import com.coding.meet.data.response.medium.Feed
import com.coding.meet.data.response.medium.NetworkArticle


@Composable
fun MediumDummyArticleData(): Medium? {
    var medium by remember { mutableStateOf<Medium?>(null) }

    LaunchedEffect(Unit) {
        val dummyDescription = """
            <figure><img alt="" src="https://cdn-images-1.medium.com/max/1024/1*zt6f9pwKzMesRCAJcknqlg.png"></figure><p>Shaders are one of the most powerful ways to create modern, high-performance UI effects—ranging from animated backgrounds to complex visual distortions. However, implementing shaders across multiple platforms has traditionally been difficult due to differences in graphics APIs and shader languages.</p>
            <p>In this article, you’ll learn how to build a clean and reusable shader abstraction using Compose Multiplatform that works seamlessly across <strong>Android, iOS, Desktop (Windows/macOS/Linux), and Web (WASM/JS)</strong> from a shared <strong>commonMain</strong> codebase.</p>
            <p>We will use <strong>AGSL (Android Graphics Shading Language)</strong> on Android and <strong>SkSL (Skia Shading Language)</strong> on all other platforms, while writing shader code in a unified way so it runs everywhere with minimal changes.</p>
            <p>By the end of this guide, you’ll have:</p>
            <ul>
            <li>A platform-agnostic shader architecture using <strong>expect/actual</strong>
            </li>
            <li>A consistent way to pass uniforms like time, resolution, and colors</li>
            <li>Support for both background rendering (<strong>drawBehind</strong>) and post-processing effects ...</li>
            </ul>
            <p>Example of shader code:</p>
            <pre><code>
            // Simple Gradient Shader
            vec4 main(vec2 fragCoord) {
                vec2 uv = fragCoord / iResolution.xy;
                return vec4(uv.x, uv.y, 0.5 + 0.5 * sin(iTime), 1.0);
            }
            </code></pre>
        """.trimIndent()

        val myMedium = Medium(
            status = "ok",
            feed = Feed(
                url = "https://medium.com/feed/@meet26",
                title = "Stories by Meet on Medium",
                link = "https://medium.com/@meet26",
                author = "Meet",
                description = "Stories by Meet on Medium",
                image = "https://cdn-images-1.medium.com/fit/c/150/150/1*kyarwWs9afYOsHx9TKScyw.png"
            ),
            networkArticles = listOf(
                NetworkArticle(
                    title = "How to Implement Shaders in Compose Multiplatform (Android, iOS, Desktop & Web)",
                    pubDate = "2026-04-12 10:00:00",
                    link = "https://medium.com/@meet26/how-to-implement-shaders-in-compose-multiplatform-android-ios-desktop-web-c86a36dd9666",
                    guid = "dummy-guid-1",
                    author = "Meet",
                    thumbnail = "",
                    description = dummyDescription,
                    content = dummyDescription,
                    categories = listOf("KMP", "Shaders", "Compose Multiplatform", "Graphics")
                )
            )
        )
        myMedium.networkArticles.forEach { article ->
            val start = article.description.indexOf("src=\"")
            val end = article.description.indexOf("\">")
            if (start != -1 && end != -1) {
                val imageUrl = article.description.substring(start + 5, end)
                article.thumbnail = imageUrl
            }
        }
        medium = myMedium
    }
    return medium
}

@Composable
fun MediumArticleData(): Medium? {
    var medium by remember { mutableStateOf<Medium?>(null) }

    LaunchedEffect(Unit) {
        try {
            val response = window.http.tryGet(MEDIUM_BASE_URL)?.decodeToString()
            response?.let {
                val myMedium = json.decodeFromString<Medium>(response)

                checkLatestData(
                    label = "Medium Article",
                    localItems = articles,
                    onlineItems = myMedium.networkArticles,
                    getLocalId = { it.link },
                    getOnlineId = { it.link },
                    getOnlineTitle = { it.title },
                    isUpToDate = { local, online ->
                        // Check title and pubDate
                        local.title == online.title && local.pubDate == online.pubDate
                    }
                )

                myMedium.networkArticles.forEach { networkArticle ->
                    val start = networkArticle.description.indexOf("src=\"")
                    val end = networkArticle.description.indexOf("\">")
                    if (start != -1 && end != -1) {
                        val imageUrl = networkArticle.description.substring(start + 5, end)
                        networkArticle.thumbnail = imageUrl
                    }
                }
                medium = myMedium
                medium?.networkArticles?.forEach {
                    console.log("Article Title: ${it.title} \n Article Thumbnail Link: ${it.thumbnail} \n Article Link: ${it.link} \n Article Author: ${it.author}\n Article Date: ${it.pubDate}")
                }
            }
            console.log(response)
        } catch (e: Exception) {
            console.error(e)
        }
    }

    return medium
}
