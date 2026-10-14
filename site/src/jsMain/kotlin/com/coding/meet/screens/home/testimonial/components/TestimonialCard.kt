package com.coding.meet.screens.home.testimonial.components

import androidx.compose.runtime.Composable
import com.coding.meet.models.Testimonial
import com.coding.meet.screens.home.experience.components.RatingBar
import com.coding.meet.screens.home.testimonial.styles.testimonialCardStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexGrow
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@Composable
fun TestimonialCard(
    testimonial: Testimonial,
    maxLines: Int? = null
) {
    Column(
        modifier = testimonialCardStyle.toModifier()
            .then(
                if (maxLines != null) {
                    Modifier.margin(10.px)
                } else {
                    Modifier.fillMaxWidth()
                }
            ),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        // Top Header: Rating & Quote mark
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 12.px),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RatingBar(
                modifier = Modifier,
                rating = testimonial.rating
            )
            SpanText(
                text = "“",
                modifier = Modifier
                    .color(Theme.Primary.color)
                    .fontSize(2.4.cssRem)
                    .fontWeight(FontWeight.Bold)
                    .lineHeight(1)
            )
        }

        // Review Text container
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .flexGrow(1)
                .overflow(Overflow.Hidden)
                .padding(bottom = 12.px)
        ) {
            SpanText(
                text = testimonial.review,
                modifier = Modifier
                    .fillMaxWidth()
                    .color(
                        CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor)
                    )
                    .fontSize(0.92.cssRem)
                    .textAlign(TextAlign.Start)
                    .lineHeight(1.55)
                    .then(
                        if (maxLines != null) {
                            Modifier.styleModifier {
                                property("display", "-webkit-box")
                                property("-webkit-line-clamp", maxLines.toString())
                                property("-webkit-box-orient", "vertical")
                                property("overflow", "hidden")
                                property("text-overflow", "ellipsis")
                                property("word-break", "break-word")
                            }
                        } else Modifier
                    )
            )
        }

        // Author metadata
        Column(
            modifier = Modifier.fillMaxWidth().margin(top = 8.px),
            horizontalAlignment = Alignment.Start
        ) {
            SpanText(
                text = testimonial.country,
                modifier = Modifier
                    .color(CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor))
                    .fontSize(0.85.cssRem)
                    .fontWeight(FontWeight.SemiBold)
            )
            SpanText(
                text = testimonial.serviceName.replace("_", " "),
                modifier = Modifier
                    .padding(top = 2.px)
                    .color(CustomColor(lightColor = Theme.DarkGray, darkColor = Theme.Muted))
                    .fontSize(0.78.cssRem)
            )
        }
    }
}
