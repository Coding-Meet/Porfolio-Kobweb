package com.coding.meet.screens.home.about_me.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.screens.home.about_me.styles.ProfileImageStyle
import com.coding.meet.util.Constants
import com.coding.meet.util.Constants.animatedTexts
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxSizing
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px


@Composable
fun AboutMeSection() {
    val breakpoint = rememberBreakpoint()


    SimpleGrid(
        numColumns = numColumns(base = 1, sm = 1, md = 2),
        modifier = Modifier.fillMaxWidth(if (breakpoint > Breakpoint.SM) 80.percent else 100.percent)
            .padding(
                topBottom = 10.px,
            )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                modifier = ProfileImageStyle.toModifier()
                    .fillMaxWidth(80.percent)
                    .fillMaxHeight(90.percent)
                    .display(DisplayStyle.Block)
                    .borderRadius(50.percent)
                    .boxSizing(BoxSizing.BorderBox)
                    .border(5.px, LineStyle.Solid, Theme.Primary.color),
                src = Res.Image.profile,
                alt = "Main Image",
            )
        }

        var currentText by remember { mutableStateOf("") }
        var textIndex by remember { mutableStateOf(0) }
        var charIndex by remember { mutableStateOf(0) }

        // Typing animation logic
        LaunchedEffect(textIndex, charIndex) {
            while (true) {
                delay(100) // Adjust speed of typing

                if (charIndex < animatedTexts[textIndex].length) {
                    currentText = animatedTexts[textIndex].substring(0, charIndex + 1)
                    charIndex++
                } else {
                    delay(1000) // Wait before changing text
                    charIndex = 0
                    textIndex = (textIndex + 1) % animatedTexts.size
                    currentText = ""
                }
            }
        }
        Column(
            modifier = Modifier.padding(leftRight = 10.px),
            verticalArrangement = Arrangement.Center
        ) {
            SpanText(
                text = "HI THERE,",
                modifier = Modifier.color(Theme.LightFontColor.color)
                    .backgroundColor(Theme.LightBackGroundColor.color)
                    .borderRadius(20.percent).fontSize(1.cssRem).fontWeight(FontWeight.Bold)
            )
            SpanText(
                text = "I Am $currentText",
                modifier = Modifier.padding(topBottom = 10.px)
                    .color(
                        CustomColor(
                            lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                        )
                    ).fontSize(1.8.cssRem).fontWeight(FontWeight.Bold)
            )
            SpanText(
                text = Constants.BIO,
                modifier = Modifier.padding(topBottom = 10.px)
            )
            SocialBar()
        }
    }
}