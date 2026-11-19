package com.coding.meet.pages.projects

import androidx.compose.runtime.Composable
import com.coding.meet.pages.ProjectPage
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/projects/shader-compose-multiplatform-app")
@Composable
fun Shader_compose_multiplatform_app(context: PageContext) {
    ProjectPage(context = context)
}
