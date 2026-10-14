package com.coding.meet.common.components.footer

import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.borderTop
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px

val FooterStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .background(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightCardBackGroundColor,
                    darkColor = Theme.DarkCardBackGroundColor
                )
            )
            .borderTop(1.px, LineStyle.Solid, colorMode.toPalette().border)
    }
    Breakpoint.ZERO {
        Modifier.padding(left = 16.px, right = 16.px, top = 20.px, bottom = 20.px)
    }
    Breakpoint.SM {
        Modifier.padding(left = 24.px, right = 24.px, top = 20.px, bottom = 20.px)
    }
    Breakpoint.MD {
        Modifier.padding(left = 40.px, right = 40.px, top = 24.px, bottom = 24.px)
    }
    Breakpoint.LG {
        Modifier.padding(left = 60.px, right = 60.px, top = 24.px, bottom = 24.px)
    }
    Breakpoint.XL {
        Modifier.padding(left = 100.px, right = 100.px, top = 24.px, bottom = 24.px)
    }
}