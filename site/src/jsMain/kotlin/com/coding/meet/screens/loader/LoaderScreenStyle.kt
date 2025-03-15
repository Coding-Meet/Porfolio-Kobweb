package com.coding.meet.screens.loader

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.translateY
import com.varabyte.kobweb.silk.style.animation.Keyframes
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val fadeInUpTextAnimation = Keyframes {
    from {
        Modifier
            .opacity(0)
            .translateY(20.px)
    }
    to {
        Modifier
            .opacity(1)
            .translateY(0.px)
    }
}

val LogoAnimationStyle = Keyframes {
    from {
        Modifier
            .transform { rotate(0.deg) }

    }
    50.percent {
        Modifier
            .transform { rotate((-10).deg) }

    }
    to {
        Modifier
            .transform { rotate(10.deg) }
    }
}