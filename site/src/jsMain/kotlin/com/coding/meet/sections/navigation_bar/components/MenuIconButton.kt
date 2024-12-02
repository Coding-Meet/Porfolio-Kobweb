package com.coding.meet.sections.navigation_bar.components

import androidx.compose.runtime.Composable
import com.coding.meet.components.PrimaryIconButton
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.icons.HamburgerIcon
import org.jetbrains.compose.web.css.px


@Composable
fun MenuIconButton(onMenuClicked: () -> Unit) {
    PrimaryIconButton(
        modifier = Modifier.size(50.px).backgroundColor(
            CustomColor(
                lightColor = Theme.LightGray,
                darkColor = Theme.DarkGray
            )
        ),
        tooltipText = Res.Strings.Toggle_COLOR_MODE,
        onClick = {
            onMenuClicked()
        },
    ) {
        HamburgerIcon(
            modifier = Modifier.size(30.px)
        )
    }
}