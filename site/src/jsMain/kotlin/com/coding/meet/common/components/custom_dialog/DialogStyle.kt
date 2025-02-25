package com.coding.meet.common.components.custom_dialog

import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.left
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

val DialogStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.None)
        .position(Position.Fixed)
        .zIndex(1000)
        .left(0.px)
        .top(0.px)
        .overflow(Overflow.Auto)
        .backgroundColor(rgba(0, 0, 0, 0.4f))
        .fillMaxSize()
        .padding(topBottom = 10.px)
}
val DialogContentStyle = CssStyle.base {
    Modifier
        .margin(autoLength)
        .padding(20.px)
        .borderRadius(10.px)
        .border(
            color = colorMode.toPalette().border, style = LineStyle.Solid, width = 1.px
        )
        .backgroundColor(
            customColor(
                colorMode = colorMode,
                lightColor = Theme.White,
                darkColor = Theme.DarkCardBackGroundColor
            )
        )
}
