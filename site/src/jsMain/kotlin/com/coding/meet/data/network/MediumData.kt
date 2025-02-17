package com.coding.meet.data.network

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.data.response.medium.Medium
import com.coding.meet.util.Constants.MEDIUM_BASE_URL
import com.coding.meet.util.Constants.mediumArticleDummyData
import com.varabyte.kobweb.browser.http.http
import kotlinx.browser.window


@Composable
fun MediumDummyArticleData(): Medium? {
    var medium by remember { mutableStateOf<Medium?>(null) }

    LaunchedEffect(Unit) {
        val myMedium = json.decodeFromString<Medium>(
            mediumArticleDummyData
        )
        myMedium.networkArticles.forEach { article ->
            val start = article.description.indexOf("src=\"")
            val end = article.description.indexOf("\">")
            val imageUrl = article.description.substring(start + 5, end)
            article.thumbnail = imageUrl
        }
        medium = myMedium
        medium?.networkArticles?.forEach {
            console.log("Article Title: ${it.title} \n Article Thumbnail Link: ${it.thumbnail} \n Article Link: ${it.link} \n Article Author: ${it.author}\n Article Date: ${it.pubDate}")
        }
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
                myMedium.networkArticles.forEach { article ->
                    val start = article.description.indexOf("src=\"")
                    val end = article.description.indexOf("\">")
                    val imageUrl = article.description.substring(start + 5, end)
                    article.thumbnail = imageUrl
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
