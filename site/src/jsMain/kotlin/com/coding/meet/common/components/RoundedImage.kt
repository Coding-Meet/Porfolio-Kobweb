package com.coding.meet.common.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.px

@Composable
fun RoundedImage(
    modifier: Modifier = Modifier,
    src: String,
    navigateTo: String? = null
) {
    val ctx = rememberPageContext()

    Box(
        modifier = Modifier.then(modifier)
            .cursor(Cursor.Pointer)
            .onClick {
                navigateTo?.let {
                    ctx.router.navigateTo(it)
                }
            }
    ) {
        Image(
            modifier = Modifier.fillMaxSize().borderRadius(10.px),
            src = src
        )
    }
}