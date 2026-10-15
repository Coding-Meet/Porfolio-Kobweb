package com.coding.meet.screens.loader

import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.translateY
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

val fadeInUpTextAnimation = Keyframes {
    from {
        Modifier
            .opacity(0)
            .translateY(16.px)
    }
    to {
        Modifier
            .opacity(1)
            .translateY(0.px)
    }
}

val LogoAnimationStyle = Keyframes {
    0.percent {
        Modifier.transform { scale(0.94) }.opacity(0.8)
    }
    50.percent {
        Modifier.transform { scale(1.04) }.opacity(1.0)
    }
    100.percent {
        Modifier.transform { scale(0.94) }.opacity(0.8)
    }
}

val NamasteAnimation = Keyframes {
    0.percent {
        Modifier.transform {
            translateY(0.px)
            scale(1.0)
            rotate(0.deg)
        }
    }
    18.percent {
        // Hands lift up gracefully in warm greeting
        Modifier.transform {
            translateY((-6).px)
            scale(1.16)
            rotate(0.deg)
        }
    }
    38.percent {
        // Respectful bow forward from the wrists
        Modifier.transform {
            translateY(4.px)
            scale(1.24)
            rotate((-8).deg)
        }
    }
    56.percent {
        // Gentle secondary nod
        Modifier.transform {
            translateY(2.px)
            scale(1.16)
            rotate((-4).deg)
        }
    }
    74.percent {
        // Rising back to center
        Modifier.transform {
            translateY((-2).px)
            scale(1.06)
            rotate(0.deg)
        }
    }
    90.percent {
        // Settling into rest
        Modifier.transform {
            translateY(0.px)
            scale(1.0)
            rotate(0.deg)
        }
    }
    100.percent {
        Modifier.transform {
            translateY(0.px)
            scale(1.0)
            rotate(0.deg)
        }
    }
}

val NamasteEmojiStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.InlineBlock)
            .styleModifier {
                property("transform-origin", "50% 90%")
            }
            .animation(
                NamasteAnimation.toAnimation(
                    duration = 2.2.s,
                    iterationCount = AnimationIterationCount.Infinite,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }
}

val GreetingTextStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.InlineBlock)
            .margin(top = 8.px)
            .fontSize(32.px)
            .fontWeight(FontWeight.Bold)
            .letterSpacing(0.5.px)
            .styleModifier {
                property("background", "linear-gradient(135deg, #10B981 0%, #2DD4BF 100%)")
                property("-webkit-background-clip", "text")
                property("background-clip", "text")
                property("-webkit-text-fill-color", "transparent")
                property("color", "transparent")
                property("filter", "drop-shadow(0 2px 14px rgba(16, 185, 129, 0.25))")
            }
    }
}