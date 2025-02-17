package com.coding.meet.common.components.custom_dialog

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.dom.Div

@Composable
fun CustomDialog(
    dialogId: String,
    content: @Composable () -> Unit
) {
    Div(
        attrs = DialogStyle.toModifier().toAttrs {
            id(dialogId)
        }
    ) {
        Box(
            modifier = Modifier
                .then(DialogContentStyle.toModifier())
        ) {
            content()
        }
    }
}