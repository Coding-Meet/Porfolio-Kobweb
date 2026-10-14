package com.coding.meet.screens.service.styles

import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

val ServiceCardStyle = CssStyle {
    base {
        Modifier
            .backgroundColor(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightCardBackGroundColor,
                    darkColor = Theme.DarkCardBackGroundColor
                )
            )
            .borderRadius(18.px)
            .border(
                color = colorMode.toPalette().border,
                style = LineStyle.Solid,
                width = 1.px
            )
            .boxShadow(0.px, 2.px, 14.px, null, rgba(0, 0, 0, 0.04))
            .transition(
                Transition.all(
                    duration = 250.ms,
                    timingFunction = AnimationTimingFunction.cubicBezier(0.16, 1.0, 0.3, 1.0)
                )
            )
    }

    hover {
        Modifier
            .transform { translateY((-6).px) }
            .border(
                color = if (colorMode.isLight) rgba(16, 185, 129, 0.5) else rgba(16, 185, 129, 0.7),
                style = LineStyle.Solid,
                width = 1.px
            )
            .boxShadow(0.px, 18.px, 36.px, (-10).px, rgba(16, 185, 129, 0.16))
    }
}

val faqCardStyle = CssStyle {
    base {
        Modifier
            .backgroundColor(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightCardBackGroundColor,
                    darkColor = Theme.DarkCardBackGroundColor
                )
            )
            .borderRadius(16.px)
            .border(
                color = colorMode.toPalette().border,
                style = LineStyle.Solid,
                width = 1.px
            )
            .boxShadow(0.px, 2.px, 10.px, null, rgba(0, 0, 0, 0.03))
            .transition(
                Transition.all(
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.cubicBezier(0.16, 1.0, 0.3, 1.0)
                )
            )
    }

    hover {
        Modifier
            .transform { translateY((-3).px) }
            .border(
                color = if (colorMode.isLight) rgba(16, 185, 129, 0.5) else rgba(16, 185, 129, 0.7),
                style = LineStyle.Solid,
                width = 1.px
            )
            .boxShadow(0.px, 8.px, 20.px, (-4).px, rgba(16, 185, 129, 0.12))
    }
}