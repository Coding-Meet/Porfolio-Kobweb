package com.coding.meet.common.components.custom_dialog

import androidx.compose.runtime.Composable
import com.coding.meet.common.page_layout.fadeInUpPageAnimation
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.Div

@Composable
fun CustomDialog(
    modifier: Modifier,
    dialogId: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Div(
        attrs = DialogStyle.toModifier().toAttrs {
            id(dialogId)
        }
    ) {
        Column(
            modifier = modifier
                .then(DialogContentStyle.toModifier())
                .animation(
                    fadeInUpPageAnimation.toAnimation(
                        duration = 0.8.s,
                        timingFunction = AnimationTimingFunction.EaseOut
                    )
                )
        ) {
            content()
        }
    }
}