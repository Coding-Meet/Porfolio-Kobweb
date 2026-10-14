package com.coding.meet.screens.projects.styles

import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.boxSizing
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.content
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
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
            .boxShadow(0.px, 18.px, 36.px, (-10).px, rgba(16, 185, 129, 0.18))
    }
}

val rotateAnimation = CssStyle {
    val sharedModifier0 = Modifier.boxSizing(BoxSizing.BorderBox)
    base {
        sharedModifier0.display(DisplayStyle.InlineBlock)
    }
    after {
        sharedModifier0
            .content(" ")
            .display(DisplayStyle.Block)
            .margin(30.px)
            .borderRadius(50.percent)
            .border {
                width(4.px)
                style(LineStyle.Solid)
                color(Theme.Primary.color, Color.transparent, colorMode.toPalette().border, Theme.Primary.color)
            }
            .animation(
                LdsDualRing.toAnimation(
                    duration = 1.s,
                    timingFunction = AnimationTimingFunction.Linear,
                    iterationCount = AnimationIterationCount.Infinite
                )
            )
            .size(60.px)
    }
}

val LdsDualRing = Keyframes {
    0.percent {
        Modifier.transform { rotate(0.deg) }
    }
    100.percent {
        Modifier.transform { rotate(360.deg) }
    }
}

val CategoryButtonStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .alignItems(AlignItems.Center)
            .justifyContent(JustifyContent.Center)
            .gap(7.px)
            .backgroundColor(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightCardBackGroundColor,
                    darkColor = Theme.DarkCardBackGroundColor
                )
            )
            .color(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightFontColor,
                    darkColor = Theme.DarkFontColor
                )
            )
            .border(1.px, LineStyle.Solid, colorMode.toPalette().border)
            .boxShadow(0.px, 2.px, 6.px, null, if (colorMode.isLight) rgba(0, 0, 0, 0.04) else rgba(0, 0, 0, 0.2))
            .padding(8.px, 16.px)
            .borderRadius(9999.px)
            .transition(Transition.all(200.ms, AnimationTimingFunction.EaseInOut))
            .fontWeight(500)
            .cursor(Cursor.Pointer)
            .letterSpacing(0.3.px)
            .fontSize(14.px)
    }
    hover {
        Modifier
            .transform { translateY((-2).px) }
            .border(1.px, LineStyle.Solid, Theme.Primary.color)
            .boxShadow(0.px, 4.px, 12.px, null, if (colorMode.isLight) rgba(16, 185, 129, 0.15) else rgba(0, 0, 0, 0.35))
    }
    active {
        Modifier.transform { translateY(0.px) }
    }
}