package com.coding.meet.pages

import androidx.compose.runtime.Composable
import com.coding.meet.common.page_layout.PageLayout
import com.coding.meet.models.Section
import com.coding.meet.screens.home.components.HomeScreen
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    PageLayout(
        title = Section.HOME.title
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeScreen()
        }
    }
}
