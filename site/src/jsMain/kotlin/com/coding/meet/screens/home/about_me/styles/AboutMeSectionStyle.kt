package com.coding.meet.screens.home.about_me.styles

import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translateY
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.s

val WaveHandAnimation = Keyframes {
    0.percent { Modifier.transform { rotate(0.deg) } }
    10.percent { Modifier.transform { rotate(14.deg) } }
    20.percent { Modifier.transform { rotate((-8).deg) } }
    30.percent { Modifier.transform { rotate(14.deg) } }
    40.percent { Modifier.transform { rotate((-4).deg) } }
    50.percent { Modifier.transform { rotate(10.deg) } }
    60.percent { Modifier.transform { rotate(0.deg) } }
    100.percent { Modifier.transform { rotate(0.deg) } }
}

val WavingHandStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.InlineBlock)
            .cursor(Cursor.Pointer)
            .styleModifier {
                property("transform-origin", "70% 70%")
            }
            .animation(
                WaveHandAnimation.toAnimation(
                    duration = 2.5.s,
                    iterationCount = AnimationIterationCount.Infinite,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
            .transition(
                Transition.all(
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }
    hover {
        Modifier.transform { scale(1.2) }
    }
}

val ProfileImageStyle = CssStyle {
    base {
        Modifier
            .boxShadow(0.px, 20.px, 40.px, (-12).px, rgba(16, 185, 129, 0.28))
            .transition(
                Transition.all(
                    duration = 350.ms,
                    timingFunction = AnimationTimingFunction.cubicBezier(0.16, 1.0, 0.3, 1.0)
                )
            )
    }
    hover {
        Modifier
            .transform { scale(1.03) }
            .boxShadow(0.px, 25.px, 50.px, (-10).px, rgba(16, 185, 129, 0.42))
    }
}

val PulseDotAnimation = Keyframes {
    0.percent {
        Modifier.scale(0.95).opacity(0.8)
    }
    50.percent {
        Modifier.scale(1.2).opacity(1.0)
    }
    100.percent {
        Modifier.scale(0.95).opacity(0.8)
    }
}

val BlinkCursorAnimation = Keyframes {
    0.percent { Modifier.opacity(1.0) }
    49.percent { Modifier.opacity(1.0) }
    50.percent { Modifier.opacity(0.0) }
    100.percent { Modifier.opacity(0.0) }
}

val SocialIconButtonStyle = CssStyle {
    base {
        Modifier
            .size(40.px)
            .borderRadius(50.percent)
            .display(DisplayStyle.Flex)
            .alignItems(AlignItems.Center)
            .justifyContent(JustifyContent.Center)
            .cursor(Cursor.Pointer)
            .border(
                1.px,
                LineStyle.Solid,
                colorMode.toPalette().border
            )
            .backgroundColor(
                if (colorMode.isLight) rgba(0, 0, 0, 0.03) else rgba(255, 255, 255, 0.06)
            )
            .boxShadow(0.px, 2.px, 8.px, null, rgba(0, 0, 0, 0.04))
            .transition(
                Transition.all(
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.cubicBezier(0.16, 1.0, 0.3, 1.0)
                )
            )
    }
    hover {
        Modifier
            .transform {
                scale(1.12)
                translateY((-3).px)
            }
            .backgroundColor(
                if (colorMode.isLight) rgba(16, 185, 129, 0.12) else rgba(16, 185, 129, 0.22)
            )
            .border(
                1.px,
                LineStyle.Solid,
                rgba(16, 185, 129, 0.6)
            )
            .boxShadow(0.px, 6.px, 16.px, null, rgba(16, 185, 129, 0.3))
    }
}

val SocialImageStyle = CssStyle {
    base {
        Modifier
            .transition(
                Transition.all(
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.cubicBezier(0.16, 1.0, 0.3, 1.0)
                )
            )
    }
    hover {
        Modifier
            .transform { 
                scale(1.15) 
                translateY((-3).px)
            }
    }
}

val HeroBadgeStyle = CssStyle {
    base {
        Modifier
            .borderRadius(9999.px)
            .transition(
                Transition.all(
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }
    hover {
        Modifier.transform { translateY((-1).px) }
    }
}