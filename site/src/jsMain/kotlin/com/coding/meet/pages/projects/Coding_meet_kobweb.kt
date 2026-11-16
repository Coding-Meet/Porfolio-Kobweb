package com.coding.meet.pages.projects

import androidx.compose.runtime.Composable
import com.coding.meet.pages.ProjectPage
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/projects/coding-meet-kobweb")
@Composable
fun Coding_meet_kobweb(context: PageContext) {
    ProjectPage(context = context)
}
