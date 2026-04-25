package com.coding.meet.screens.home.testimonial.components

import androidx.compose.runtime.Composable
import com.coding.meet.models.Testimonial
import com.coding.meet.screens.home.experience.components.RatingBar
import com.coding.meet.screens.home.testimonial.styles.testimonialCardStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
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
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Quote Icon at top left
        SpanText(
            text = "“",
            modifier = Modifier.fillMaxWidth().color(Theme.Primary.color)
                .fontSize(3.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Start)
                .margin(top = (-15).px, bottom = (-20).px)
        )

        RatingBar(
            modifier = Modifier.fillMaxWidth().padding(bottom = 10.px),
            rating = testimonial.rating
        )

        SpanText(
            text = testimonial.review,
            modifier = Modifier
                .padding(bottom = 5.px, leftRight = 5.px)
                .color(
                    CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor)
                )
                .fontSize(0.9.cssRem)
                .fontStyle(FontStyle.Italic)
                .textAlign(TextAlign.Center)
                .lineHeight(1.5)
                .then(
                    if (maxLines != null) {
                        Modifier.styleModifier {
                            property("display", "-webkit-box")
                            property("-webkit-line-clamp", maxLines)
                            property("-webkit-box-orient", "vertical")
                            property("overflow", "hidden")
                        }
                    } else Modifier
                )
        )

        Column(
            modifier = Modifier.fillMaxWidth().margin(top = 10.px),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpanText(
                text = "\uD83C\uDF0D ${testimonial.country}",
                modifier = Modifier.color(
                    CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor)
                ).fontSize(0.8.cssRem).fontWeight(FontWeight.Bold)
            )
            SpanText(
                text = testimonial.serviceName.replace("_", " "),
                modifier = Modifier.color(Theme.DarkGray.color).fontSize(0.7.cssRem)
            )
        }
    }
}



