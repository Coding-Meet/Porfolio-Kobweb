package com.coding.meet.screens.home.testimonial.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.common.components.custom_dialog.CustomDialog
import com.coding.meet.common.image_slider_with_dot.MainButtonStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.TestimonialData.testimonials
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.window
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.dom.Button

@Composable
fun TestimonialSection() {
    val breakpoint = rememberBreakpoint()
    val colorMode by ColorMode.currentState
    var isShowDialog by remember { mutableStateOf(false) }
    val dialogId by remember { mutableStateOf("testimonialDialog") }
    var selectedCountry by remember { mutableStateOf<String?>(null) }

    val filteredTestimonials = remember(selectedCountry) {
        if (selectedCountry != null) {
            testimonials.filter { it.country == selectedCountry }
        } else {
            testimonials
        }
    }

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
        TestimonialDialog(selectedCountry = selectedCountry) {
            isShowDialog = false
        }
    }

    // 100% Real & Verified Reviews Trust Badge
    Row(
        modifier = Modifier
            .margin(top = 36.px, bottom = 12.px)
            .padding(leftRight = 14.px, topBottom = 6.px)
            .backgroundColor(
                if (colorMode.isLight) rgba(16, 185, 129, 0.08) else rgba(16, 185, 129, 0.15)
            )
            .border(
                1.px,
                LineStyle.Solid,
                if (colorMode.isLight) rgba(16, 185, 129, 0.25) else rgba(16, 185, 129, 0.35)
            )
            .borderRadius(9999.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(7.px)
                .borderRadius(50.percent)
                .backgroundColor(Theme.Primary.color)
                .boxShadow(0.px, 0.px, 8.px, null, rgba(16, 185, 129, 0.8))
                .margin(right = 8.px)
        )
        SpanText(
            text = "✓ 100% Real & Verified Client Reviews",
            modifier = Modifier
                .fontSize(0.85.cssRem)
                .fontWeight(FontWeight.SemiBold)
                .color(Theme.Primary.color)
        )
    }

    SpanText(
        text = "💬 Client Testimonials",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 0.px, bottom = 6.px, leftRight = 10.px)
            .color(
                CustomColor(
                    lightColor = Theme.LightFontColor,
                    darkColor = Theme.DarkFontColor
                )
            )
            .fontFamily(Res.Font.FONT_FAMILY_HEADING)
            .fontSize(if (breakpoint > Breakpoint.SM) 2.2.cssRem else 1.7.cssRem)
            .fontWeight(FontWeight.Bold)
            .textAlign(TextAlign.Center)
    )

    SpanText(
        text = "What founders, engineering leads, and clients across the world say about working together.",
        modifier = Modifier
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 65.percent else 90.percent)
            .padding(bottom = 12.px, leftRight = 20.px)
            .color(
                CustomColor(
                    lightColor = Theme.DarkGray,
                    darkColor = Theme.Muted
                )
            )
            .fontSize(1.0.cssRem)
            .lineHeight(1.6)
            .textAlign(TextAlign.Center)
    )

    // Interactive Global Client World Map
    Box(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 75.percent else 92.percent)
            .padding(bottom = 14.px)
    ) {
        ClientWorldMap(
            selectedCountry = selectedCountry,
            onSelectCountry = { country ->
                selectedCountry = country
            }
        )
    }

    // Testimonials Grid (Dynamically filtered by country or full list)
    SimpleGrid(
        numColumns = numColumns(base = 1, sm = 1, md = 3),
        modifier = Modifier
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 75.percent else 92.percent)
            .minHeight(if (breakpoint > Breakpoint.MD) 260.px else 180.px)
            .padding(bottom = 12.px)
    ) {
        filteredTestimonials.take(6).forEach { testimonial ->
            TestimonialCard(
                testimonial = testimonial,
                maxLines = 5
            )
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 75.percent else 92.percent)
            .padding(top = 10.px, bottom = 36.px, leftRight = 20.px),
        horizontalArrangement = Arrangement.Center,
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
                text = if (selectedCountry != null) "View All Reviews for $selectedCountry (${filteredTestimonials.size}) →"
                else "${Res.Strings.SEE_ALL_REVIEW} →",
            )
        }
    }
}
