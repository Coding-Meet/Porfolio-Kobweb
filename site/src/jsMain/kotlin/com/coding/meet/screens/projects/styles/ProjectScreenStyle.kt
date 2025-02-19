package com.coding.meet.screens.projects.styles


import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.BackgroundPosition
import com.varabyte.kobweb.compose.css.BackgroundSize
import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.backgroundPosition
import com.varabyte.kobweb.compose.ui.modifiers.backgroundSize
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.plus
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.s


val ProjectStyle = CssStyle {
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
            .border(
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


val AngledGradientButtonStyle = CssStyle {
    val backgroundColor =  customColor(
        colorMode = colorMode,
        lightColor = Theme.LightFontColor,
        darkColor = Theme.DarkFontColor
    )
    val textColor = customColor(
        colorMode = colorMode,
        lightColor = Theme.DarkFontColor,
        darkColor = Theme.LightFontColor
    )
    base {
        Modifier
            .backgroundSize(BackgroundSize.of(220.percent))
            .boxShadow(0.px, 0.2.em, 0.3.em,null, rgba(0, 0, 0, 0.15f))
            .color( backgroundColor)
            .backgroundColor(Colors.Transparent)
            .backgroundPosition(BackgroundPosition.of(CSSPosition(100.percent)))
            .border(3.px, LineStyle.Solid, backgroundColor)
            .textTransform(TextTransform.Uppercase)
            .padding(8.px, 16.px)
            .borderRadius(3.px)
            .transition(Transition.of("all", 0.2.s, TransitionTimingFunction.EaseOut))
            .fontWeight(900)
            .cursor(Cursor.Pointer)
            .letterSpacing(2.px)
            .backgroundImage(
                linearGradient(110.deg) {
                    add(backgroundColor, 0.percent)
                    add(backgroundColor, 50.percent)
                    add(Colors.Transparent, 50.percent)
                    add(Colors.Transparent, 100.percent)
                }
            )
            .fontSize(14.px)
    }
    hover {
        Modifier
            .transform { translateY((-2).px) }
            .boxShadow(0.px, 0.px, 0.3.em,null, rgba(0, 0, 0, 0.25f))
            .backgroundPosition(BackgroundPosition.of(CSSPosition(0.px)))
            .color(textColor)
    }
    active {
        Modifier
            .transform { translateY((-1).px) }
    }
}
