package com.coding.meet.models

data class Project(
    val title: String,
    val shortDescription: String,
    val longDescription:String,
    val categories: List<ProjectCategory>,
    val appStoreUrl: String? = null,
    val githubUrl: String? = null,
    val websiteUrl: String? = null,
    val stargazersCount: Int = 0,
    val youtubeVideoLink : String? = null,
    val features: List<String> = arrayListOf(),
    val technologies: List<String> = arrayListOf(),
    val libraries: List<String> = arrayListOf(),
    val imageUrls: List<String> = arrayListOf(),
    val platform: List<String> = arrayListOf(),
    val topics: List<String> = arrayListOf(),
)
