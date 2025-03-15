package com.coding.meet.screens.home.skils.styles

import com.varabyte.kobweb.compose.css.TransformOrigin
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transformOrigin
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.AnimationFillMode
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.s

val SkillsImgStyle = CssStyle {
    base {
        Modifier
            .transition(
                Transition.of("transform", 0.5.s, TransitionTimingFunction.Ease),
                Transition.of("box-shadow", 0.3.s, TransitionTimingFunction.Ease)
            )
            .transformOrigin(TransformOrigin.Center)
            .transform { rotate((-20).deg) }
    }
    hover {
        Modifier
            .animation(
                skillsRoundAnimation
                    .toAnimation(duration = 1.s, timingFunction = AnimationTimingFunction.cubicBezier(0.16, 1.0, 0.3, 1.0), fillMode = AnimationFillMode.Both)
            )
    }
}

val skillsRoundAnimation = Keyframes {
    from {
        Modifier.transform { rotate((-20).deg) }
    }
    to {
        Modifier.transform { rotate((-360).deg) }
    }
}
