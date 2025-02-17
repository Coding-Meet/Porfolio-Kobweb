package com.coding.meet.models

enum class Section(
    val title: String,
    val path: String
) {
    HOME("Home", homePath),
//    ABOUT_ME("About Me", aboutMePath),

    //    SKILLS("Skills",skillsPath),
    PROJECTS("Projects", projectsPath),
//    EXPERIENCES("Experiences", experiencesPath),
    SERVICE("Service", servicePath),
    Articles("Articles", articlesPath),
}

const val homePath = "/"
//const val aboutMePath = "/about-me"

//const val skillsPath = "/skills"
const val projectsPath = "/projects"
//const val experiencesPath = "/experiences"
const val servicePath = "/service"
const val articlesPath = "/articles"
