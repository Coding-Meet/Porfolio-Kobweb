package com.coding.meet.data.response.medium


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Medium(
    @SerialName("feed")
    val feed: Feed,
    @SerialName("items")
    val networkArticles: List<NetworkArticle>,
    @SerialName("status")
    val status: String
)