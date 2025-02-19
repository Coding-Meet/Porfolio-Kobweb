package com.coding.meet.screens.articles.styles

import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.plus
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val ArticleStyle = CssStyle {
    base {
        Modifier
            .backgroundColor(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightCardBackGroundColor,
                    darkColor = Theme.DarkCardBackGroundColor
                )
            )
            .borderRadius(10.px)
            .border(
                color = colorMode.toPalette().border, style = LineStyle.Solid, width = 1.px
            )
            .transition(
                Transition.all(
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }

    (Breakpoint.MD + hover) {
        Modifier
            .borderRadius(10.px).border(
                color =
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightFontColor,
                    darkColor = Theme.DarkFontColor
                )
                , style = LineStyle.Solid, width =2.px
            )
            .transform { scale(1.05) }
            .transition(
                Transition.all(
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }
}