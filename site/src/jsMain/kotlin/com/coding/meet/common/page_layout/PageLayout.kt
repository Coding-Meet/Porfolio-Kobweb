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
import com.coding.meet.util.AppInfo
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.flexGrow
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.left
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.document
import kotlinx.browser.window
import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.functions.RadialGradient
import com.varabyte.kobweb.compose.css.functions.radialGradient
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Div

@Composable
fun PageLayout(
    title: String,
    content: @Composable () -> Unit,
) {
    var menuOpened by remember { mutableStateOf(false) }
    val colorMode by ColorMode.currentState
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
        document.title = "${AppInfo.WEBSITE_NAME} - $title - My Portfolio"
    }
    Div(
        attrs = Modifier
            .fillMaxWidth()
            .minHeight(100.vh)
            .position(Position.Relative)
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column).toAttrs()
    ) {
        // Full Page Ambient Aurora Background Effect
        Box(
            modifier = Modifier
                .fillMaxSize()
                .position(Position.Fixed)
                .top(0.px)
                .left(0.px)
                .zIndex(0)
                .styleModifier {
                    property(
                        "background",
                        if (colorMode.isDark) {
                            "radial-gradient(ellipse 90% 55% at 50% -10%, rgba(16, 185, 129, 0.20) 0%, transparent 70%), " +
                            "radial-gradient(circle 650px at 12% 85%, rgba(16, 185, 129, 0.12) 0%, transparent 70%), " +
                            "radial-gradient(circle 550px at 88% 45%, rgba(16, 185, 129, 0.09) 0%, transparent 70%)"
                        } else {
                            "radial-gradient(ellipse 95% 65% at 50% -10%, rgba(16, 185, 129, 0.18) 0%, rgba(52, 211, 153, 0.09) 45%, transparent 75%), " +
                            "radial-gradient(circle 700px at 10% 85%, rgba(16, 185, 129, 0.12) 0%, rgba(45, 212, 191, 0.06) 40%, transparent 70%), " +
                            "radial-gradient(circle 600px at 90% 45%, rgba(16, 185, 129, 0.11) 0%, transparent 70%)"
                        }
                    )
                    property("pointer-events", "none")
                }
        )

        // Subtle Faded Micro-Dot Grid Pattern
        Box(
            modifier = Modifier
                .fillMaxSize()
                .position(Position.Fixed)
                .top(0.px)
                .left(0.px)
                .zIndex(0)
                .styleModifier {
                    property(
                        "background-image",
                        if (colorMode.isDark) {
                            "radial-gradient(rgba(255, 255, 255, 0.11) 1px, transparent 1px)"
                        } else {
                            "radial-gradient(rgba(15, 23, 42, 0.11) 1px, transparent 1px)"
                        }
                    )
                    property("background-size", "24px 24px")
                    property(
                        "mask-image",
                        if (colorMode.isDark) {
                            "radial-gradient(ellipse 80% 75% at 50% 30%, black 30%, transparent 85%)"
                        } else {
                            "radial-gradient(ellipse 80% 75% at 50% 30%, black 25%, transparent 85%)"
                        }
                    )
                    property(
                        "-webkit-mask-image",
                        if (colorMode.isDark) {
                            "radial-gradient(ellipse 80% 75% at 50% 30%, black 30%, transparent 85%)"
                        } else {
                            "radial-gradient(ellipse 80% 75% at 50% 30%, black 25%, transparent 85%)"
                        }
                    )
                    property("pointer-events", "none")
                }
        )

        DesktopMenu(
            selectedSectionId = selectedSectionId,
            onMenuClicked = {
                menuOpened = true
            }
        )
        Div(
            attrs = Modifier
                .fillMaxWidth()
                .flexGrow(1)
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Column)
                .toAttrs()
        ) {
            content()
        }
        BackToTopButton()
        if (menuOpened) {
            MobileSideMenu(
                selectedSectionId = selectedSectionId,
                onMenuClosed = { menuOpened = false }
            )
        }
    }
}