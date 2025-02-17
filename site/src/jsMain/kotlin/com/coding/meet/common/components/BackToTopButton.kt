package com.coding.meet.common.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.bottom
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.right
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowUp
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.w3c.dom.SMOOTH
import org.w3c.dom.ScrollBehavior
import org.w3c.dom.ScrollToOptions

@Composable
fun BackToTopButton() {
    LaunchedEffect(Unit) {
        window.addEventListener(type = "scroll", callback = {
            val bodyScrollTop = document.documentElement?.scrollTop ?: 0.0
            val documentScrollTop = document.documentElement?.scrollTop ?: 0.0
            val backTopBtn = window.document.getElementById("backTopBtn")?.asDynamic()
            if (bodyScrollTop > 20 || documentScrollTop > 20) {
                backTopBtn.style.display = "block"
            } else {
                backTopBtn.style.display = "none"
            }
        })
    }
    IconButton(
        modifier = Modifier
            .id("backTopBtn")
            .display(DisplayStyle.None)
            .position(Position.Fixed)
            .size(50.px)
            .bottom(20.px)
            .right(20.px)
            .zIndex(99)
            .backgroundColor(Theme.Primary.color)
            .cursor(Cursor.Pointer)
            .borderRadius(20.percent),
        onClick = {
            window.scrollTo(
                ScrollToOptions(
                    top = 0.0,
                    behavior = ScrollBehavior.SMOOTH
                )
            )
        }
    ) {
        FaArrowUp(
            modifier = Modifier.color(Colors.White),
            size = IconSize.LG
        )
    }
}