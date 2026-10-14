package com.coding.meet.screens.home.testimonial.styles

import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.s

val MapPingAnimation = Keyframes {
    0.percent {
        Modifier
            .transform { scale(0.8) }
            .opacity(0.85)
    }
    60.percent {
        Modifier
            .transform { scale(2.2) }
            .opacity(0.0)
    }
    100.percent {
        Modifier
            .transform { scale(2.2) }
            .opacity(0.0)
    }
}

val MapPinStyle = CssStyle {
    base {
        Modifier
            .cursor(Cursor.Pointer)
            .transition(Transition.all(200.ms))
    }
    hover {
        Modifier.transform { scale(1.3) }
    }
}

val MapPulseRingStyle = CssStyle {
    base {
        Modifier.animation(
            MapPingAnimation.toAnimation(
                duration = 2.4.s,
                iterationCount = AnimationIterationCount.Infinite,
                timingFunction = AnimationTimingFunction.EaseOut
            )
        )
    }
}
