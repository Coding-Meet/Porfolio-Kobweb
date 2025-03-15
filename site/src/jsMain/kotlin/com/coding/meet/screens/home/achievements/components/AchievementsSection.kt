package com.coding.meet.screens.home.achievements.components

import androidx.compose.runtime.Composable
import com.coding.meet.util.Constants
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
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
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun AchievementsSection() {
    val breakpoint = rememberBreakpoint()
    SpanText(
        text = "\uD83C\uDFC6 Achievements",
        modifier = Modifier.fillMaxWidth().padding(topBottom = 10.px, leftRight = 10.px)
            .color(
                CustomColor(
                    lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                )
            ).fontSize(2.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
    )

    SpanText(
        text = "From content creation to community engagement — these achievements showcase my dedication & passion! ✨",
        modifier = Modifier.fillMaxWidth(
            if (breakpoint > Breakpoint.MD) 70.percent else 90.percent

        ).padding(topBottom = 5.px, leftRight = 20.px).color(
            CustomColor(
                lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
            )
        ).fontSize(1.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
    )

    SimpleGrid(
        numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 2, xl = 2),
        modifier = Modifier.fillMaxWidth(
            if (breakpoint > Breakpoint.MD) 70.percent else 90.percent
        ).padding(topBottom = 10.px)
    ) {
        Constants.achievements.forEach { achievement ->
            AchievementCard(achievement)
        }
    }

}


