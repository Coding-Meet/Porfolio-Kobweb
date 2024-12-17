package com.coding.meet.pages

import androidx.compose.runtime.Composable
import com.coding.meet.layouts.DefaultPageLayout
import com.coding.meet.sections.about_me.AboutMeSection
import com.coding.meet.sections.blog.BlogSection
import com.coding.meet.sections.home.HomeSection
import com.coding.meet.sections.projects.ProjectSection
import com.coding.meet.sections.service.ServiceSection
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    DefaultPageLayout {
        HomeSection()
        AboutMeSection()
        ProjectSection()
        ServiceSection()
        BlogSection()
    }
}
