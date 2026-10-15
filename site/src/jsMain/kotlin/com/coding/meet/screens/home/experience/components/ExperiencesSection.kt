package com.coding.meet.screens.home.experience.components

import androidx.compose.runtime.Composable
import com.coding.meet.util.CustomColor
import com.coding.meet.util.ExperienceData.experiences
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ExperiencesSection() {
    val breakpoint = rememberBreakpoint()

    SpanText(
        text = "🚀 Work Experience",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 36.px, bottom = 6.px, leftRight = 10.px)
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
        text = "Every chapter brings unique challenges, architecture paradigms, and scalable engineering solutions.",
        modifier = Modifier
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 65.percent else 90.percent)
            .padding(bottom = 24.px, leftRight = 20.px)
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

    SimpleGrid(
        numColumns = numColumns(base = 1, sm = 1, md = 1, lg = 1, xl = 1),
        modifier = Modifier
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 75.percent else 92.percent)
            .padding(bottom = 20.px)
    ) {
        experiences.forEach { experience ->
            ExperienceCard(experience)
        }
    }
}