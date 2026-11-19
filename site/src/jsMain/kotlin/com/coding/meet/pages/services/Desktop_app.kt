package com.coding.meet.pages.services

import androidx.compose.runtime.Composable
import com.coding.meet.pages.ServiceSection
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/service/desktop-app")
@Composable
fun Desktop_app(context: PageContext) {
    ServiceSection(context = context)
}
