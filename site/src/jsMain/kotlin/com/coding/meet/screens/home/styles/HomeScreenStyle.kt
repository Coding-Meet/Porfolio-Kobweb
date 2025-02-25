package com.coding.meet.screens.home.styles


import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translateY
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.filter
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px


val MainButtonStyle = CssStyle {
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

@OptIn(ExperimentalComposeWebApi::class)
val HomeProfileImageStyle = CssStyle {
    base {
        Modifier
            .styleModifier {
                filter { grayscale(100.percent) }
            }
            .transition(
                Transition.of(
                    property = "filter",
                    duration = 200.ms,
                    timingFunction = null,
                    delay = null
                )
            )
    }
    hover {
        Modifier.styleModifier {
            filter { grayscale(0.percent) }
        }
    }
}

val zoomIn = Keyframes {
    from { Modifier.scale(0) }
    to { Modifier.scale(1) }
}

val upDownAnim = Keyframes {
    each(0.percent, 100.percent) {
        Modifier.translateY((-20).px)
    }
    50.percent {
        Modifier.translateY(20.px)
    }
}
val SocialImageStyle = CssStyle {
    hover {
        Modifier.scale(1.2)
    }
}