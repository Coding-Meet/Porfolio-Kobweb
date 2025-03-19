package com.coding.meet.common.image_slider_with_dot

import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.BackgroundPosition
import com.varabyte.kobweb.compose.css.BackgroundSize
import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
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
import com.varabyte.kobweb.compose.ui.modifiers.bottom
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
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
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.active
import com.varabyte.kobweb.silk.style.selectors.hover
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


val ImageSliderContainerStyle = CssStyle {
    base {
        Modifier
            .position(Position.Relative)
            .width(100.percent)
            .overflow(Overflow.Hidden)
            .borderRadius(8.px)
            .boxShadow(0.px, 4.px, 8.px, 0.px, rgba(0, 0, 0, 0.1))
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
            .backgroundColor(Color.lightgray)
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
            .backgroundColor(rgba(0, 0, 0, 0.5))
            .color(Theme.White.color)
            .padding(8.px, 12.px)
            .borderRadius(4.px)
            .cursor(Cursor.Pointer)
            .border(0.px)
    }
}

val MainButtonStyle = CssStyle {
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