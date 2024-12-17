package com.coding.meet.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.models.Section
import com.coding.meet.sections.navigation_bar.NavBarSection
import com.coding.meet.sections.navigation_bar.components.BackToTopButton
import com.coding.meet.sections.navigation_bar.components.OverflowMenu
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import kotlinx.browser.window

@Composable
fun DefaultPageLayout(
    content: @Composable ColumnScope.() -> Unit,
) {
    var menuOpened by remember { mutableStateOf(false) }
    var selectedSectionId by remember { mutableStateOf(Section.HOME.path) }
    LaunchedEffect(window.location) {
        if (window.location.pathname.trim().isNotEmpty()) {
            selectedSectionId = window.location.pathname
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            NavBarSection(
                selectedSectionId = selectedSectionId,
                onSelectSectionId = {
                    selectedSectionId = it
                },
                onMenuClicked = {
                    menuOpened = true
                }
            )
            content()
        }
        BackToTopButton()
        if (menuOpened) {
            OverflowMenu(
                selectedSectionId = selectedSectionId,
                onSelectSectionId = {
                    selectedSectionId = it
                },
                onMenuClosed = { menuOpened = false }
            )
        }
    }
}