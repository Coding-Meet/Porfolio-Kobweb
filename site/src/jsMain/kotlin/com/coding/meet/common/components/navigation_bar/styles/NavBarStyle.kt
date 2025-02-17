package com.coding.meet.common.components.navigation_bar.styles

import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.saturate
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backdropFilter
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderBottom
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.paddingBottom
import org.jetbrains.compose.web.css.paddingLeft
import org.jetbrains.compose.web.css.paddingRight
import org.jetbrains.compose.web.css.paddingTop
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px


val NavBarStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .position(Position.Sticky)
            .top(0.px)
            .zIndex(100)
            .backgroundColor(colorMode.toPalette().background.toRgb().copyf(alpha = 0.85f))
            .backdropFilter(saturate(180.percent), blur(5.px))
            .borderBottom(1.px, LineStyle.Solid, colorMode.toPalette().border)
    }
}

val NavigationItemStyle = CssStyle {
    base {
        Modifier
            .styleModifier {
                paddingLeft(20.px)
                paddingRight(20.px)
                paddingTop(5.px)
                paddingBottom(5.px)
            }
            .fontSize(16.px)
            .textDecorationLine(TextDecorationLine.None)
    }
}

val LogoStyle = CssStyle {
    base {
        Modifier
            .transform { rotate(0.deg) }
            .transition(
                Transition.of(
                    property = "transform",
                    duration = 200.ms,
                    timingFunction = null,
                    delay = null
                )
            )
    }
    hover {
        Modifier
            .transform { rotate((-10).deg) }
    }
}

