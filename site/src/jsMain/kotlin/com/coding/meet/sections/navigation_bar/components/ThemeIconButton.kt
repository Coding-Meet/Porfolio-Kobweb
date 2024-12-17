package com.coding.meet.sections.navigation_bar.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.coding.meet.components.PrimaryIconButton
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.icons.MoonIcon
import com.varabyte.kobweb.silk.components.icons.SunIcon
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.px


@Composable
fun ThemeIconButton(
    onClick: () -> Unit,
) {
    val colorMode by ColorMode.currentState

    PrimaryIconButton(
        modifier = Modifier.size(50.px).backgroundColor(
            CustomColor(
                lightColor = Theme.LightGray,
                darkColor = Theme.DarkGray
            )
        ),
        tooltipText = Res.Strings.TOGGLE_COLOR_MODE,
        onClick = {
            onClick()
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