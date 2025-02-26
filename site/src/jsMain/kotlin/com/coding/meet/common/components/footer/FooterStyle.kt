package com.coding.meet.common.components.footer

import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.border
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
            .border(color = colorMode.toPalette().border, style = LineStyle.Solid, width = 1.px)
    }
    Breakpoint.ZERO {
        Modifier.padding(left = 12.px, right = 12.px, top = 10.px, bottom = 10.px)
    }
    Breakpoint.SM {
        Modifier.padding(left = 24.px, right = 24.px, top = 10.px, bottom = 10.px)
    }
    Breakpoint.MD {
        Modifier.padding(left = 34.px, right = 34.px, top = 10.px, bottom = 10.px)
    }
    Breakpoint.LG {
        Modifier.padding(left = 54.px, right = 54.px, top = 10.px, bottom = 10.px)
    }
    Breakpoint.XL {
        Modifier.padding(left = 104.px, right = 104.px, top = 10.px, bottom = 10.px)
    }
}