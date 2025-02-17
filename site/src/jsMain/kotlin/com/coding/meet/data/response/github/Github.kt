package com.coding.meet.data.response.github

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Github(
    @SerialName("id")
    val id: Long,

    @SerialName("name")
    val name: String,

    @SerialName("full_name")
    val fullName: String,

    @SerialName("stargazers_count")
    val stargazersCount: Int,

    @SerialName("topics")
    val topics: List<String>,

    @SerialName("html_url")
    val htmlUrl: String
)