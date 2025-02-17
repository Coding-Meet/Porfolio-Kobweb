package com.coding.meet.common.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.browser.dom.ElementTarget
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.overlay.PopupPlacement
import com.varabyte.kobweb.silk.components.overlay.Tooltip

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    tooltipText: String? = null,
    onClick: (() -> Unit)? = null,
    icon: @Composable () -> Unit,
) {
    Button(
        onClick = {
            onClick?.invoke()
        },
        modifier = modifier,
    ) {
        icon()
    }
    if (tooltipText != null) {
        Tooltip(
            target = ElementTarget.PreviousSibling,
            text = tooltipText,
            placement = PopupPlacement.BottomRight
        )
    }
}