package com.coding.meet.pages.services

import androidx.compose.runtime.Composable
import com.coding.meet.pages.ServiceSection
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/service/custom-android-app")
@Composable
fun Custom_android_app(context: PageContext) {
    ServiceSection(context = context)
}
