package com.coding.meet.screens.home.testimonial.styles

import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.boxSizing
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
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

val testimonialCardStyle = CssStyle {
    base {
        Modifier
            .boxSizing(BoxSizing.BorderBox)
            .minHeight(230.px)
            .backgroundColor(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightCardBackGroundColor,
                    darkColor = Theme.DarkCardBackGroundColor
                )
            )
            .borderRadius(16.px)
            .padding(22.px)
            .border(
                color = colorMode.toPalette().border,
                style = LineStyle.Solid,
                width = 1.px
            )
            .boxShadow(0.px, 2.px, 12.px, null, Theme.Black.subtle)
            .transition(
                Transition.all(
                    duration = 250.ms,
                    timingFunction = AnimationTimingFunction.cubicBezier(0.16, 1.0, 0.3, 1.0)
                )
            )
    }

    hover {
        Modifier
            .transform { translateY((-4).px) }
            .border(
                color = Theme.Primary.strong,
                style = LineStyle.Solid,
                width = 1.px
            )
            .boxShadow(0.px, 14.px, 32.px, (-8).px, Theme.Primary.soft)
    }
}