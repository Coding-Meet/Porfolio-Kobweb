package com.coding.meet.screens.home.testimonial.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.coding.meet.util.CustomColor
import com.coding.meet.util.TestimonialData.testimonials
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.overflow
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
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Hr


@Composable
fun ColumnScope.TestimonialDialog(
    onDismiss: () -> Unit,
) {
    val colorMode by ColorMode.currentState

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
            SpanText(
                text = "\uD83C\uDF1F All Testimonials",
                modifier = Modifier.color(
                    CustomColor(
                        lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                    )
                ).fontSize(1.8.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
            )
        }
        CloseIcon(
            modifier = Modifier
                .size(20.px)
                .cursor(Cursor.Pointer)
                .onClick {
                    onDismiss()
                },
        )
    }
    Hr(
        attrs = Modifier.fillMaxWidth().margin(bottom = 20.px).border(
            color = colorMode.toPalette().border, style = LineStyle.Solid, width = 2.px
        ).toAttrs()
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .overflow(Overflow.Auto),
        verticalArrangement = Arrangement.spacedBy(20.px)
    ) {
        testimonials.forEach { testimonial ->
            TestimonialCard(testimonial)
        }
    }
}