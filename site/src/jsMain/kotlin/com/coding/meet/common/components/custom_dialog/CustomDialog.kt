package com.coding.meet.common.components.custom_dialog

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.BoxScope
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
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
        ) {
            content()
        }
    }
}