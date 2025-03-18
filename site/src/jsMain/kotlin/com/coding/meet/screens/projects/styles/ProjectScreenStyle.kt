package com.coding.meet.screens.projects.styles


import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.css.BackgroundPosition
import com.varabyte.kobweb.compose.css.BackgroundSize
import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.backgroundPosition
import com.varabyte.kobweb.compose.ui.modifiers.backgroundSize
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.boxSizing
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.content
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.plus
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.after
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
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
            .boxShadow(0.px, 0.px, 0.px, 0.px)
            .transition(
                Transition.all(
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }

    (Breakpoint.MD + hover) {
        Modifier
            .border(3.px, LineStyle.Solid, colorMode.toPalette().border)
            .padding(0.25.em, 0.5.em)
            .boxShadow(
                BoxShadow.of(
                    1.px,
                    1.px,
                    0.px,
                    0.px
                ),
                BoxShadow.of(
                    2.px,
                    2.px,
                    0.px,
                    0.px,
                ),
                BoxShadow.of(
                    3.px,
                    3.px,
                    0.px,
                    0.px,
                ),
                BoxShadow.of(
                    4.px,
                    4.px,
                    0.px,
                    0.px,
                ),
                BoxShadow.of(
                    5.px,
                    5.px,
                    0.px,
                    0.px
                )
            )
            .transition(
                Transition.all(
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }
}



val rotateAnimation = CssStyle {
    val sharedModifier0 = Modifier
        .boxSizing(BoxSizing.BorderBox)
    base {
        sharedModifier0
            .display(DisplayStyle.InlineBlock)
    }
    after {
        sharedModifier0
            .content(" ")
            .display(DisplayStyle.Block)
            .margin(30.px)
            .borderRadius(50.percent)
            .border {
                width(5.px)
                style(LineStyle.Solid)
                color(Theme.Primary.color, Color.transparent, colorMode.toPalette().border, Theme.Primary.color)
            }
            .animation(
                LdsDualRing.toAnimation(
                    duration = 1.2.s,
                    timingFunction = AnimationTimingFunction.Linear,
                    iterationCount = AnimationIterationCount.Infinite
                )
            )
            .size(200.px)
    }
}
val LdsDualRing = Keyframes {
    0.percent {
        Modifier
            .transform { rotate(0.deg) }
    }
    100.percent {
        Modifier
            .transform { rotate(360.deg) }
    }
}

val CategoryButtonStyle = CssStyle {
    val backgroundColor = customColor(
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
            .boxShadow(0.px, 0.2.em, 0.3.em, null, rgba(0, 0, 0, 0.15f))
            .color(backgroundColor)
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
            .boxShadow(0.px, 0.px, 0.3.em, null, rgba(0, 0, 0, 0.25f))
            .backgroundPosition(BackgroundPosition.of(CSSPosition(0.px)))
            .color(textColor)
    }
    active {
        Modifier
            .transform { translateY((-1).px) }
    }

}