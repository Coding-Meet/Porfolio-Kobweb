package com.coding.meet.screens.home.experience.components

import androidx.compose.runtime.Composable
import com.coding.meet.models.Experience
import com.coding.meet.screens.home.experience.styles.experienceCardStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@Composable
fun ExperienceCard(
    experience: Experience
) {
    Column(
        modifier = experienceCardStyle.toModifier().margin(10.px).padding(10.px),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        // Title and Company
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.px),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SpanText(
                text = experience.title,
                modifier = Modifier.fillMaxWidth().padding(right = 10.px).color(
                    CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor)
                ).fontSize(1.2.cssRem).fontWeight(FontWeight.Bold)
            )
        }

        // Company and Type
        SpanText(
            text = "${experience.company} • ${experience.type}",
            modifier = Modifier.color(
                CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor)
            ).fontSize(1.cssRem)
        )

        // Duration
        SpanText(
            text =if (experience.endDate == "Present")
                "⏳ ${experience.startDate} - ${experience.endDate}"
            else
                "⏳ ${experience.duration} (${experience.startDate} - ${experience.endDate})",
            modifier = Modifier.color(
                CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor)
            ).fontSize(0.9.cssRem)
        )

        // Location
        SpanText(
            text = experience.location,
            modifier = Modifier.color(
                CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor)
            ).fontSize(0.9.cssRem)
        )

        // Description
        SpanText(
            text = experience.description,
            modifier = Modifier.margin(top = 10.px).color(
                CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor)
            ).fontSize(0.95.cssRem)
        )
    }
}

