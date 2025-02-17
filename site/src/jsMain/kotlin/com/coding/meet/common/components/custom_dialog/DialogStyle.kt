package com.coding.meet.common.components.custom_dialog

import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.left
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
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
        .padding(top = 10.px)
}
val DialogContentStyle = CssStyle.base {
    Modifier
        .margin(autoLength)
        .padding(20.px)
        .border(1.px, LineStyle.Solid, Color.black)
        .backgroundColor(Color.white)
        .width(80.percent)
}
