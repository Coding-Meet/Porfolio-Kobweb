package com.coding.meet.common.image_slider_with_dot

import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.BackgroundPosition
import com.varabyte.kobweb.compose.css.BackgroundSize
import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.bottom
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.left
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.s
import com.coding.meet.util.select


val ImageSliderContainerStyle = CssStyle {
    base {
        Modifier
            .position(Position.Relative)
            .width(100.percent)
            .overflow(Overflow.Hidden)
            .borderRadius(8.px)
            .boxShadow(0.px, 4.px, 8.px, 0.px, Theme.Black.subtle)
    }
}

val ImageSlideContainerStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .transition(Transition.of("transform", 500.ms, AnimationTimingFunction.EaseInOut))
    }
}

val IndicatorsStyle = CssStyle {
    base {
        Modifier
            .position(Position.Absolute)
            .bottom(10.px)
            .left(50.percent)
            .transform { translateX((-50).percent) }
            .display(DisplayStyle.Flex)
            .gap(8.px)
    }
}

val IndicatorStyle = CssStyle {
    base {
        Modifier
            .width(12.px)
            .height(12.px)
            .borderRadius(50.percent)
            .backgroundColor(Theme.LightGray.color)
            .cursor(Cursor.Pointer)
            .transition(Transition.of("background-color", 300.ms))
    }
    hover {
        Modifier.backgroundColor(
            customColor(
                colorMode = colorMode,
                lightColor = Theme.LightFontColor,
                darkColor = Theme.DarkFontColor
            )
        )
    }
}

val ControlButtonStyle = CssStyle {
    base {
        Modifier
            .position(Position.Absolute)
            .top(50.percent)
            .transform { translateY((-50).percent) }
            .backgroundColor(Theme.Black.strong)
            .color(Theme.White.color)
            .padding(8.px, 12.px)
            .borderRadius(4.px)
            .cursor(Cursor.Pointer)
            .border(0.px)
    }
}

val MainButtonStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .alignItems(AlignItems.Center)
            .justifyContent(JustifyContent.Center)
            .backgroundColor(Theme.Primary.color)
            .color(Theme.White.rgb)
            .border(0.px)
            .padding(10.px, 22.px)
            .borderRadius(9999.px)
            .boxShadow(0.px, 4.px, 14.px, null, Theme.Primary.medium)
            .transition(Transition.all(200.ms, AnimationTimingFunction.EaseInOut))
            .fontWeight(600)
            .cursor(Cursor.Pointer)
            .letterSpacing(0.4.px)
            .fontSize(14.px)
    }
    hover {
        Modifier
            .transform { translateY((-2).px) }
            .boxShadow(0.px, 8.px, 20.px, null, Theme.Primary.strong)
    }
    active {
        Modifier
            .transform { translateY(0.px) }
    }
}

val SecondaryButtonStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .alignItems(AlignItems.Center)
            .justifyContent(JustifyContent.Center)
            .backgroundColor(
                colorMode.select(Theme.White.color, Theme.White.subtle)
            )
            .color(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightFontColor,
                    darkColor = Theme.DarkFontColor
                )
            )
            .border(
                1.px,
                LineStyle.Solid,
                if (colorMode.isLight) colorMode.toPalette().border else Theme.White.soft
            )
            .boxShadow(
                0.px,
                2.px,
                6.px,
                null,
                colorMode.select(Theme.Black.subtle, Theme.Black.soft)
            )
            .styleModifier {
                property("backdrop-filter", "blur(8px)")
                property("-webkit-backdrop-filter", "blur(8px)")
            }
            .padding(10.px, 22.px)
            .borderRadius(9999.px)
            .transition(Transition.all(200.ms, AnimationTimingFunction.EaseInOut))
            .fontWeight(600)
            .cursor(Cursor.Pointer)
            .letterSpacing(0.4.px)
            .fontSize(14.px)
    }
    hover {
        Modifier
            .transform { translateY((-2).px) }
            .backgroundColor(
                colorMode.select(Theme.White.color, Theme.White.soft)
            )
            .border(1.px, LineStyle.Solid, Theme.Primary.color)
            .boxShadow(
                0.px,
                4.px,
                14.px,
                null,
                colorMode.select(Theme.Primary.soft, Theme.Primary.medium)
            )
    }
    active {
        Modifier
            .transform { translateY(0.px) }
    }
}