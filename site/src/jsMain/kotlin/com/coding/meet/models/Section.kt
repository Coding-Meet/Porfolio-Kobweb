package com.coding.meet.models

enum class Section(
    val title: String,
    val path: String
) {
    HOME("Home", homePath),
    PROJECTS("Projects", projectsPath),
    SERVICE("Service", servicePath),
    ARTICLES("Articles", articlesPath),
    CONTACT_ME("Contact Me", contactMePath)
}

const val homePath = "/"
const val projectsPath = "/projects"
const val servicePath = "/service"
const val articlesPath = "/articles"
const val contactMePath = "/contact_me"
