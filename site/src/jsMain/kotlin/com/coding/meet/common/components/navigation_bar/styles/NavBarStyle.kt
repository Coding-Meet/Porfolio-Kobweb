package com.coding.meet.common.components.navigation_bar.styles

import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.saturate
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backdropFilter
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderBottom
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

val NavBarStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .position(Position.Sticky)
            .top(0.px)
            .zIndex(1000)
            .backgroundColor(colorMode.toPalette().background.toRgb().copyf(alpha = 0.82f))
            .backdropFilter(saturate(180.percent), blur(16.px))
            .borderBottom(1.px, LineStyle.Solid, colorMode.toPalette().border)
            .boxShadow(0.px, 1.px, 12.px, null, rgba(0, 0, 0, 0.04))
    }
}

val NavigationItemStyle = CssStyle {
    base {
        Modifier
            .padding(leftRight = 16.px, topBottom = 8.px)
            .fontSize(15.px)
            .letterSpacing(0.5.px)
            .borderRadius(9999.px)
            .textDecorationLine(TextDecorationLine.None)
            .transition(
                Transition.all(
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }
    hover {
        Modifier
            .backgroundColor(
                if (colorMode.isLight) rgba(0, 0, 0, 0.04) else rgba(255, 255, 255, 0.08)
            )
    }
}

val LogoStyle = CssStyle {
    base {
        Modifier
            .transform { rotate(0.deg) }
            .transition(
                Transition.of(
                    property = "transform",
                    duration = 250.ms,
                    timingFunction = AnimationTimingFunction.cubicBezier(0.16, 1.0, 0.3, 1.0),
                    delay = null
                )
            )
    }
    hover {
        Modifier
            .transform { 
                scale(1.05)
                rotate((-4).deg) 
            }
    }
}

val HeaderButtonStyle = CssStyle {
    base {
        Modifier
            .borderRadius(9999.px)
            .border(1.px, LineStyle.Solid, colorMode.toPalette().border)
            .transition(
                Transition.all(
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }
    hover {
        Modifier
            .scale(1.08)
            .boxShadow(0.px, 4.px, 12.px, null, rgba(16, 185, 129, 0.2))
    }
}
