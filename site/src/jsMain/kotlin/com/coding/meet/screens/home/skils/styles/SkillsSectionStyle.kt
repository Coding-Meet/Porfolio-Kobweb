package com.coding.meet.screens.home.skils.styles

import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.scale
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

val SkillCardStyle = CssStyle {
    base {
        Modifier
            .backgroundColor(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightCardBackGroundColor,
                    darkColor = Theme.DarkCardBackGroundColor
                )
            )
            .borderRadius(14.px)
            .border(1.px, LineStyle.Solid, colorMode.toPalette().border)
            .boxShadow(0.px, 2.px, 8.px, null, rgba(0, 0, 0, 0.03))
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
                1.px,
                LineStyle.Solid,
                if (colorMode.isLight) rgba(16, 185, 129, 0.5) else rgba(16, 185, 129, 0.7)
            )
            .boxShadow(0.px, 10.px, 20.px, (-6).px, rgba(16, 185, 129, 0.14))
    }
}

val SkillsImgStyle = CssStyle {
    base {
        Modifier
            .transition(
                Transition.all(
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }
    hover {
        Modifier.scale(1.1)
    }
}
