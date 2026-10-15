package com.coding.meet.common.components.custom_dialog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.window
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.Div

fun resetDialogScroll(dialogId: String) {
    try {
        val element = window.document.getElementById(dialogId) ?: return
        element.scrollTop = 0.0
        element.asDynamic().scrollTo(0.0, 0.0)

        val children = element.querySelectorAll("*")
        for (i in 0 until children.length) {
            val child = children.item(i)?.asDynamic()
            if (child != null && child.scrollTop != undefined && child.scrollTop > 0) {
                child.scrollTop = 0.0
            }
        }

        window.setTimeout({
            element.scrollTop = 0.0
            element.asDynamic().scrollTo(0.0, 0.0)
            val lateChildren = element.querySelectorAll("*")
            for (i in 0 until lateChildren.length) {
                val child = lateChildren.item(i)?.asDynamic()
                if (child != null && child.scrollTop != undefined && child.scrollTop > 0) {
                    child.scrollTop = 0.0
                }
            }
        }, 10)
    } catch (_: Throwable) {
        // Safe fallback
    }
}

@Composable
fun CustomDialog(
    modifier: Modifier,
    dialogId: String,
    resetKey: Any? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    LaunchedEffect(resetKey) {
        resetDialogScroll(dialogId)
    }

    Div(
        attrs = DialogStyle.toModifier().toAttrs {
            id(dialogId)
        }
    ) {
        Column(
            modifier = modifier
                .then(DialogContentStyle.toModifier())
                .animation(
                    dialogEntranceAnimation.toAnimation(
                        duration = 0.28.s,
                        timingFunction = AnimationTimingFunction.cubicBezier(0.16, 1.0, 0.3, 1.0)
                    )
                )
        ) {
            content()
        }
    }
}