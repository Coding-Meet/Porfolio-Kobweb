package com.coding.meet.screens.home.skils.components

import androidx.compose.runtime.Composable
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.SkillData.skills
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
fun SkillsSection() {
    val breakpoint = rememberBreakpoint()

    SpanText(
        text = "⚡ Core Technologies & Tools",
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
        text = "Languages, mobile frameworks, and developer tooling I use to craft performant products.",
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
        numColumns = numColumns(base = 2, sm = 2, md = 3, lg = 4),
        modifier = Modifier
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 75.percent else 92.percent)
            .padding(bottom = 20.px)
    ) {
        skills.forEach { skill ->
            SkillCard(skill)
        }
    }
}
