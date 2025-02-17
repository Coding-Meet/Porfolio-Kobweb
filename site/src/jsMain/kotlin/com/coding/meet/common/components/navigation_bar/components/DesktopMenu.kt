package com.coding.meet.common.components.navigation_bar.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.coding.meet.common.components.IconButton
import com.coding.meet.common.components.navigation_bar.styles.LogoStyle
import com.coding.meet.common.components.navigation_bar.styles.NavBarStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.HamburgerIcon
import com.varabyte.kobweb.silk.components.icons.MoonIcon
import com.varabyte.kobweb.silk.components.icons.SunIcon
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div

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
            modifier = Modifier.padding(all = 0.5.cssRem),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (breakpoint <= Breakpoint.MD) {
                IconButton(
                    modifier = Modifier.size(50.px).backgroundColor(
                        CustomColor(
                            lightColor = Theme.LightGray,
                            darkColor = Theme.DarkGray
                        )
                    ),
                    onClick = {
                        onMenuClicked()
                    },
                ) {
                    HamburgerIcon(
                        modifier = Modifier.size(30.px)
                    )
                }
            }
            Image(
                modifier = LogoStyle.toModifier(),
                src = when (colorMode) {
                    ColorMode.LIGHT -> Res.Image.LOGO_LIGHT
                    ColorMode.DARK -> Res.Image.LOGO_DARK
                },
                alt = "Logo Image"
            )
            if (breakpoint > Breakpoint.MD) {
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    NavigationMenu(selectedSectionId)
                }
            }
            IconButton(
                modifier = Modifier.size(50.px).backgroundColor(
                    CustomColor(
                        lightColor = Theme.LightGray,
                        darkColor = Theme.DarkGray
                    )
                ),
                tooltipText = Res.Strings.TOGGLE_COLOR_MODE,
                onClick = {
                    colorMode = colorMode.opposite
                },
            ) {
                when (colorMode) {
                    ColorMode.LIGHT -> {
                        MoonIcon(
                            modifier = Modifier.size(30.px)
                        )
                    }

                    ColorMode.DARK -> {
                        SunIcon(
                            modifier = Modifier.size(30.px)
                        )
                    }
                }
            }
        }
    }
}