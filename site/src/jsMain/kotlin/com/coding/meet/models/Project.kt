package com.coding.meet.models

data class Project(
    val id: String = "",
    val title: String,
    val shortDescription: String,
    val longDescription: String,
    val categories: List<ProjectCategory>,
    val appStoreUrl: String? = null,
    val githubUrl: String? = null,
    val websiteUrl: String? = null,
    val stargazersCount: Int = 0,
    val youtubeVideoLink: String? = null,
    val features: List<String> = arrayListOf(),
    val technologies: List<String> = arrayListOf(),
    val libraries: List<String> = arrayListOf(),
    val imageUrls: List<String> = arrayListOf(),
    val platform: List<String> = arrayListOf(),
    val topics: List<String> = arrayListOf(),
) {
    val slug: String
        get() = if (id.isNotEmpty()) id else title
            .lowercase()
            .replace(Regex("[^a-z0-9]+"), "-")
            .trim('-')

    fun matchesQuery(query: String): Boolean {
        val clean = query.removePrefix("#").lowercase().trim()
        if (clean.isEmpty()) return false
        val cleanWithoutHyphens = clean.replace("-", "").replace("_", "")
        val slugClean = slug.replace("-", "")
        val titleClean = title.lowercase().replace(Regex("[^a-z0-9]+"), "")
        return slug == clean || (id.isNotEmpty() && id.lowercase() == clean) || cleanWithoutHyphens == slugClean || cleanWithoutHyphens == titleClean
    }
}
