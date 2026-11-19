package com.coding.meet.pages.projects

import androidx.compose.runtime.Composable
import com.coding.meet.pages.ProjectPage
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/projects/home-automation-system")
@Composable
fun Home_automation_system(context: PageContext) {
    ProjectPage(context = context)
}
