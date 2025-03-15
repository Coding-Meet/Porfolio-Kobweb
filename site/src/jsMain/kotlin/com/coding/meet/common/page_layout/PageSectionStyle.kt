package com.coding.meet.common.page_layout

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.translateY
import com.varabyte.kobweb.silk.style.animation.Keyframes
import org.jetbrains.compose.web.css.px

val fadeInUpPageAnimation = Keyframes {
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