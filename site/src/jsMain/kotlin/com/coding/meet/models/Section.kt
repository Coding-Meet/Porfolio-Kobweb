package com.coding.meet.models

enum class Section(
    val id: String,
    val title: String,
    val path: String
) {
    HOME("home", "Home", "#home"),
    ABOUT_ME("about-me", "About Me", "#about-me"),
//    SKILLS("skills", "Skills", "#skills"),
    PROJECTS("projects", "Projects", "#projects"),
    EXPERIENCES("experiences", "Experiences", "#experiences"),
    SERVICE("service", "Service", "#service"),
    BLOG("blog", "Blog", "#blog"),
}