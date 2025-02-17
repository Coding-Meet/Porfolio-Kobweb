package com.coding.meet.data.response.medium


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkArticle(
    @SerialName("author")
    val author: String,
    @SerialName("categories")
    val categories: List<String>,
    @SerialName("content")
    val content: String,
    @SerialName("description")
    val description: String,
    @SerialName("guid")
    val guid: String,
    @SerialName("link")
    val link: String,
    @SerialName("pubDate")
    val pubDate: String,
    @SerialName("thumbnail")
    var thumbnail: String = "",
    @SerialName("title")
    val title: String,
)