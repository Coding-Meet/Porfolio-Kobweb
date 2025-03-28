package com.coding.meet.screens.home.testimonial.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.common.components.custom_dialog.CustomDialog
import com.coding.meet.common.image_slider_with_dot.MainButtonStyle
import com.coding.meet.util.Constants
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.window
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button

@Composable
fun TestimonialSection() {
    val breakpoint = rememberBreakpoint()
    var isShowDialog by remember { mutableStateOf(false) }
    val dialogId by remember { mutableStateOf("testimonialDialog") }

    LaunchedEffect(Unit) {
        window.addEventListener("click", {
            val model = window.document.getElementById(dialogId)
            val modal = model?.asDynamic()
            if (it.target == modal) {
                isShowDialog = !isShowDialog
            }
        })
    }
    LaunchedEffect(isShowDialog) {
        val model = window.document.getElementById(dialogId)
        val modal = model?.asDynamic()
        val body = window.document.body?.asDynamic()

        if (isShowDialog) {
            modal?.style?.display = "block"
            body?.style?.setProperty("overflow", "hidden") // Disable scrolling
        } else {
            modal?.style?.display = "none"
            body?.style?.removeProperty("overflow") // Restore default scrolling
        }
    }

    CustomDialog(
        modifier = Modifier.fillMaxWidth(
            if (breakpoint > Breakpoint.MD) 60.percent else 90.percent
        ),
        dialogId = dialogId,
    ) {
        TestimonialDialog {
            isShowDialog = false
        }
    }

    SpanText(
        text = "\uD83C\uDF1F Testimonial",
        modifier = Modifier.fillMaxWidth().padding(topBottom = 10.px, leftRight = 10.px)
            .color(
                CustomColor(
                    lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                )
            ).fontSize(2.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
    )
    SpanText(
        text = "What my clients & collaborators say about my work! 🚀",
        modifier = Modifier.fillMaxWidth(
            if (breakpoint > Breakpoint.MD) 70.percent else 90.percent

        ).padding(topBottom = 5.px, leftRight = 20.px).color(
            CustomColor(
                lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
            )
        ).fontSize(1.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
    )
    SimpleGrid(
        numColumns = numColumns(base = 1, sm = 1, md = 3),
        modifier = Modifier.fillMaxWidth(
            if (breakpoint > Breakpoint.MD) 70.percent else 90.percent
        ).padding(top = 10.px)
    ) {
        Constants.testimonials.take(6).forEach { testimonial ->
            TestimonialCard(testimonial)
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth(
            if (breakpoint > Breakpoint.MD) 70.percent else 90.percent
        ).padding(topBottom = 20.px, leftRight = 20.px),
        horizontalArrangement = Arrangement.spacedBy(10.px, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            attrs = MainButtonStyle.toAttrs {
                onClick {
                    isShowDialog = true
                }
            }
        ) {
            SpanText(
                text = Res.Strings.SEE_ALL_REVIEW,
            )
        }
    }
}
