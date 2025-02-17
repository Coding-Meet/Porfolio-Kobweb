package com.coding.meet.common.page_layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.common.components.BackToTopButton
import com.coding.meet.common.components.navigation_bar.components.DesktopMenu
import com.coding.meet.common.components.navigation_bar.components.MobileSideMenu
import com.coding.meet.models.Section
import com.coding.meet.util.Constants
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.toAttrs
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.dom.Div

@Composable
fun PageLayout(
    title: String,
    content: @Composable () -> Unit,
) {
    var menuOpened by remember { mutableStateOf(false) }
    val selectedSectionId by remember(
        window.location
    ) {
        derivedStateOf {
            if (window.location.pathname.trim().isNotEmpty()) {
                window.location.pathname
            } else {
                Section.HOME.path
            }
        }
    }
    LaunchedEffect(title) {
        document.title = "${Constants.WEBSITE_NAME} - $title"
    }
    Div(
        attrs = Modifier
            .fillMaxSize()
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column).toAttrs()
    ) {
        DesktopMenu(
            selectedSectionId = selectedSectionId,
            onMenuClicked = {
                menuOpened = true
            }
        )
        content()
        BackToTopButton()
        if (menuOpened) {
            MobileSideMenu(
                selectedSectionId = selectedSectionId,
                onMenuClosed = { menuOpened = false }
            )
        }
    }
}