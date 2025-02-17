package com.coding.meet.data.response.medium


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Feed(
    @SerialName("author")
    val author: String,
    @SerialName("description")
    val description: String,
    @SerialName("image")
    val image: String,
    @SerialName("link")
    val link: String,
    @SerialName("title")
    val title: String,
    @SerialName("url")
    val url: String
)