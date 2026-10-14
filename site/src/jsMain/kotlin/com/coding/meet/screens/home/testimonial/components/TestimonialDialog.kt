package com.coding.meet.screens.home.testimonial.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.TestimonialData.testimonials
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.dom.Hr


@Composable
fun ColumnScope.TestimonialDialog(
    selectedCountry: String? = null,
    onDismiss: () -> Unit,
) {
    val colorMode by ColorMode.currentState
    val displayList = if (selectedCountry != null) {
        testimonials.filter { it.country == selectedCountry }
    } else {
        testimonials
    }

    // Dialog Header with balanced spacing and centered title
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 14.px),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Left spacer to perfectly balance the close button and keep title centered
        Box(modifier = Modifier.size(36.px))

        SpanText(
            text = if (selectedCountry != null) "🌟 Reviews from $selectedCountry (${displayList.size})"
            else "🌟 All Testimonials (${displayList.size})",
            modifier = Modifier
                .weight(1f)
                .color(
                    CustomColor(
                        lightColor = Theme.LightFontColor,
                        darkColor = Theme.DarkFontColor
                    )
                )
                .fontFamily(Res.Font.FONT_FAMILY_HEADING)
                .fontSize(1.6.cssRem)
                .fontWeight(FontWeight.Bold)
                .textAlign(TextAlign.Center)
        )

        Box(
            modifier = Modifier
                .size(36.px)
                .borderRadius(50.percent)
                .cursor(Cursor.Pointer)
                .backgroundColor(
                    if (colorMode.isLight) rgba(0, 0, 0, 0.05) else rgba(255, 255, 255, 0.08)
                )
                .onClick { onDismiss() },
            contentAlignment = Alignment.Center
        ) {
            CloseIcon(
                modifier = Modifier.size(16.px)
            )
        }
    }

    Hr(
        attrs = Modifier
            .fillMaxWidth()
            .margin(top = 0.px, bottom = 22.px)
            .border(
                color = colorMode.toPalette().border,
                style = LineStyle.Solid,
                width = 1.px
            )
            .toAttrs()
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .overflow(Overflow.Auto)
            .padding(top = 4.px),
        verticalArrangement = Arrangement.spacedBy(20.px)
    ) {
        displayList.forEach { testimonial ->
            TestimonialCard(testimonial)
        }
    }
}