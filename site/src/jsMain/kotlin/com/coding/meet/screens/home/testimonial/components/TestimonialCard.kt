package com.coding.meet.screens.home.testimonial.components

import androidx.compose.runtime.Composable
import com.coding.meet.models.Testimonial
import com.coding.meet.screens.home.experience.components.RatingBar
import com.coding.meet.screens.home.testimonial.styles.testimonialCardStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@Composable
fun TestimonialCard(
    testimonial: Testimonial
) {
    Column  (
        modifier =  testimonialCardStyle.toModifier()
            .margin(10.px),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RatingBar(modifier = Modifier.fillMaxWidth().padding(topBottom = 10.px))
        SpanText(
            text = testimonial.review,
            modifier = Modifier.padding(topBottom = 5.px,leftRight = 10.px).color(
                CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor)
            ).fontSize(0.8.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
        )
        SpanText(
            text = "\uD83C\uDF0D ${testimonial.country}",
            modifier = Modifier.padding(bottom = 5.px).color(
                CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor)
            ).fontSize(0.9.cssRem)
        )
    }
}