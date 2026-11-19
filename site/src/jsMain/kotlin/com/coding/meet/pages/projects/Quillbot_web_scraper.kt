package com.coding.meet.pages.projects

import androidx.compose.runtime.Composable
import com.coding.meet.pages.ProjectPage
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/projects/quillbot-web-scraper")
@Composable
fun Quillbot_web_scraper(context: PageContext) {
    ProjectPage(context = context)
}
