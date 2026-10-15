package com.coding.meet.screens.home.experience.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.coding.meet.models.Experience
import com.coding.meet.screens.home.experience.styles.experienceCardStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.coding.meet.util.glassSubtle
import com.coding.meet.util.select
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@Composable
fun ExperienceCard(
    experience: Experience
) {
    val colorMode by ColorMode.currentState
    val isPresent = experience.endDate == "Present"

    Column(
        modifier = experienceCardStyle.toModifier()
            .margin(topBottom = 8.px)
            .padding(all = 20.px),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        // Title and Date Row
        Row(
            modifier = Modifier.fillMaxWidth().flexWrap(FlexWrap.Wrap).gap(8.px)
                .padding(bottom = 6.px),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SpanText(
                text = experience.title,
                modifier = Modifier
                    .color(
                        CustomColor(
                            lightColor = Theme.LightFontColor,
                            darkColor = Theme.DarkFontColor
                        )
                    )
                    .fontSize(1.2.cssRem)
                    .fontWeight(FontWeight.Bold)
            )

            // Duration Pill
            Box(
                modifier = Modifier
                    .backgroundColor(
                        if (isPresent) {
                            colorMode.select(Theme.Primary.subtle, Theme.Primary.soft)
                        } else {
                            colorMode.glassSubtle
                        }
                    )
                    .border(
                        1.px,
                        LineStyle.Solid,
                        if (isPresent) Theme.Primary.medium else Theme.Muted.soft
                    )
                    .borderRadius(9999.px)
                    .padding(leftRight = 12.px, topBottom = 4.px)
            ) {
                SpanText(
                    text = if (isPresent) "🟢 ${experience.displayDuration} (${experience.startDate} - Present)"
                    else "🗓️ ${experience.displayDuration} (${experience.startDate} - ${experience.endDate})",
                    modifier = Modifier
                        .fontSize(0.85.cssRem)
                        .fontWeight(FontWeight.Medium)
                        .color(
                            if (isPresent) Theme.Primary.color else CustomColor(
                                Theme.DarkGray,
                                Theme.Muted
                            )
                        )
                )
            }
        }

        // Company & Type & Location
        Row(
            modifier = Modifier.fillMaxWidth().flexWrap(FlexWrap.Wrap).gap(12.px)
                .padding(bottom = 10.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SpanText(
                text = experience.company,
                modifier = Modifier
                    .color(Theme.Primary.color)
                    .fontSize(0.95.cssRem)
                    .fontWeight(FontWeight.SemiBold)
            )
            SpanText(
                text = "•",
                modifier = Modifier.color(CustomColor(Theme.DarkGray, Theme.Muted))
            )
            SpanText(
                text = experience.type,
                modifier = Modifier
                    .color(CustomColor(Theme.DarkGray, Theme.Muted))
                    .fontSize(0.9.cssRem)
            )
            SpanText(
                text = "•",
                modifier = Modifier.color(CustomColor(Theme.DarkGray, Theme.Muted))
            )
            SpanText(
                text = "📍 ${experience.location}",
                modifier = Modifier
                    .color(CustomColor(Theme.DarkGray, Theme.Muted))
                    .fontSize(0.9.cssRem)
            )
        }

        // Description
        SpanText(
            text = experience.description,
            modifier = Modifier
                .color(CustomColor(lightColor = Theme.DarkGray, darkColor = Theme.Muted))
                .fontSize(0.95.cssRem)
                .lineHeight(1.6)
        )
    }
}
