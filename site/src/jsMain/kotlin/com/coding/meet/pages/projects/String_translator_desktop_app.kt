package com.coding.meet.pages.projects

import androidx.compose.runtime.Composable
import com.coding.meet.pages.ProjectPage
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/projects/string-translator-desktop-app")
@Composable
fun String_translator_desktop_app(context: PageContext) {
    ProjectPage(context = context)
}
