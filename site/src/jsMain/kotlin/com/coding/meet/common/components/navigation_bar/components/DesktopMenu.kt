package com.coding.meet.common.components.navigation_bar.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.coding.meet.common.components.IconButton
import com.coding.meet.common.components.navigation_bar.styles.HeaderButtonStyle
import com.coding.meet.common.components.navigation_bar.styles.LogoStyle
import com.coding.meet.common.components.navigation_bar.styles.NavBarStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.coding.meet.util.select
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.HamburgerIcon
import com.varabyte.kobweb.silk.components.icons.MoonIcon
import com.varabyte.kobweb.silk.components.icons.SunIcon
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.localStorage
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import com.varabyte.kobweb.compose.ui.modifiers.display
import org.jetbrains.compose.web.css.DisplayStyle

@Composable
fun DesktopMenu(
    selectedSectionId: String,
    onMenuClicked: () -> Unit
) {
    var colorMode by ColorMode.currentState
    val breakpoint = rememberBreakpoint()

    Div(
        attrs = NavBarStyle.toAttrs(),
    ) {
        Row(
            modifier = Modifier.padding(
                leftRight = if (breakpoint > Breakpoint.SM) 28.px else 14.px,
                topBottom = 10.px
            ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (breakpoint <= Breakpoint.MD) {
                IconButton(
                    modifier = HeaderButtonStyle.toModifier()
                        .size(42.px)
                        .backgroundColor(
                            colorMode.select(Theme.Black.subtle, Theme.White.subtle)
                        ),
                    onClick = {
                        onMenuClicked()
                    },
                ) {
                    HamburgerIcon(
                        modifier = Modifier.size(20.px)
                    )
                }
            }

            Link(
                path = "/",
                openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                modifier = Modifier.display(DisplayStyle.Flex).align(Alignment.CenterVertically)
            ) {
                Image(
                    modifier = LogoStyle.toModifier()
                        .height(if (breakpoint > Breakpoint.MD) 40.px else 36.px)
                        .cursor(Cursor.Pointer),
                    src = when (colorMode) {
                        ColorMode.LIGHT -> Res.Image.LOGO_LIGHT
                        ColorMode.DARK -> Res.Image.LOGO_DARK
                    },
                    alt = "Logo Image"
                )
            }

            if (breakpoint > Breakpoint.MD) {
                Row(
                    modifier = Modifier.gap(6.px),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    NavigationMenu(selectedSectionId)
                }
            }

            IconButton(
                modifier = HeaderButtonStyle.toModifier()
                    .size(42.px)
                    .backgroundColor(
                        colorMode.select(Theme.Black.subtle, Theme.White.subtle)
                    ),
                tooltipText = colorMode.select("Switch to Dark Mode", "Switch to Light Mode"),
                onClick = {
                    colorMode = colorMode.opposite
                    localStorage.setItem(Res.Strings.SAVED_THEME, colorMode.name)
                },
            ) {
                when (colorMode) {
                    ColorMode.LIGHT -> {
                        MoonIcon(
                            modifier = Modifier.size(20.px)
                        )
                    }

                    ColorMode.DARK -> {
                        SunIcon(
                            modifier = Modifier.size(20.px)
                        )
                    }
                }
            }
        }
    }
}