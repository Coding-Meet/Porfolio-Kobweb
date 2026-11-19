package com.coding.meet.pages.projects

import androidx.compose.runtime.Composable
import com.coding.meet.pages.ProjectPage
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/projects/store-app-mvi-compose-multiplatform-template")
@Composable
fun Store_app_mvi_compose_multiplatform_template(context: PageContext) {
    ProjectPage(context = context)
}
