package com.coding.meet.pages.projects

import androidx.compose.runtime.Composable
import com.coding.meet.pages.ProjectPage
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/projects/truth-or-dare-app")
@Composable
fun Truth_or_dare_app(context: PageContext) {
    ProjectPage(context = context)
}
