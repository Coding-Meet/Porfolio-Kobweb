package com.coding.meet.sections.navigation_bar.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.coding.meet.sections.navigation_bar.styles.LogoStyle
import com.coding.meet.util.Res
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode

@Composable
fun MyLogo() {
    val colorMode by ColorMode.currentState
    Image(
        modifier = LogoStyle.toModifier(),
        src = when (colorMode) {
            ColorMode.LIGHT -> Res.Image.LOGO_LIGHT
            ColorMode.DARK -> Res.Image.LOGO_DARK
        },
        alt = "Logo Image"
    )
}