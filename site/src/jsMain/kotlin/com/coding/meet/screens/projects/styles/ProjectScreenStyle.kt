package com.coding.meet.screens.projects.styles


import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.plus
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px


val ProjectStyle = CssStyle {
    base {
        Modifier
            .transition(
                Transition.all(
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }

    (Breakpoint.MD + hover) {
        Modifier
            .transform { scale(1.05) }
            .transition(
                Transition.all(
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.EaseInOut
                )
            )
    }
}

val ReadMeBtnStyle = CssStyle {
    base {
        Modifier
            .width(100.px)
            .transition(
                Transition.of(
                    property = "width",
                    duration = 200.ms,
                    timingFunction = null,
                    delay = null
                )
            )
    }
    hover {
        Modifier.width(120.px)
    }
}