package com.coding.meet.models

data class Project(
    val title: String,
    val description: String,
    val technologies: List<String>,
    val githubUrl: String? = null,
    val imageUrls: List<String> = arrayListOf(),
    val platform: String,
    val startDate: String,
    val endDate: String,
    val features: List<String> = arrayListOf(),
    val category: String? = null,
    val topics: List<String> = arrayListOf(),
    val stargazersCount: Int = 0
)
