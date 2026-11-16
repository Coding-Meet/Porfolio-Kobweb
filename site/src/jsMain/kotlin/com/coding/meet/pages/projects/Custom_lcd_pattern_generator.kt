package com.coding.meet.pages.projects

import androidx.compose.runtime.Composable
import com.coding.meet.pages.ProjectPage
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/projects/custom-lcd-pattern-generator")
@Composable
fun Custom_lcd_pattern_generator(context: PageContext) {
    ProjectPage(context = context)
}
