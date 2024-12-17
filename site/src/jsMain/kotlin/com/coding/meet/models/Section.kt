package com.coding.meet.models

enum class Section(
    val id: String,
    val title: String,
    val path: String
) {
    HOME("home", "Home", homePath),
    ABOUT_ME("about-me", "About Me", aboutMePath),
//    SKILLS("skills", "Skills",skillsPath),
    PROJECTS("projects", "Projects", projectsPath),
    EXPERIENCES("experiences", "Experiences", experiencesPath),
    SERVICE("service", "Service", servicePath),
    BLOG("blog", "Blog", blogPath),
}

const val homePath = "/"
const val aboutMePath = "/about-me"
const val skillsPath = "/skills"
const val projectsPath = "/projects"
const val experiencesPath = "/experiences"
const val servicePath = "/service"
const val blogPath = "/blog"
