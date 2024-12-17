package com.coding.meet.sections.navigation_bar.styles

import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.saturate
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backdropFilter
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderBottom
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px


val NavHeaderStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(left = 0.5.cssRem, right = 0.5.cssRem, top = 0.5.cssRem, bottom = 0.5.cssRem)
            .fontSize(1.25.cssRem)
            .position(Position.Fixed)
            .top(0.percent)
            .backgroundColor(colorMode.toPalette().background.toRgb().copyf(alpha = 0.65f))
            .backdropFilter(saturate(180.percent), blur(5.px))
            .borderBottom(width = 1.px, style = LineStyle.Solid, color = colorMode.toPalette().border)
    }
}