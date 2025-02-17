package com.coding.meet.models

data class Article(
    val title: String,
    val shortDescription: String,
    var thumbnail: String = "",
    val link: String,
    val categories: List<String>,
    val pubDate: String,
)
