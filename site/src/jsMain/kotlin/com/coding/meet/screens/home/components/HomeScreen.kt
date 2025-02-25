package com.coding.meet.screens.home.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.screens.home.styles.HomeProfileImageStyle
import com.coding.meet.screens.home.styles.SocialImageStyle
import com.coding.meet.util.Constants
import com.coding.meet.util.Constants.animatedTexts
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.boxSizing
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img


@Composable
fun HomeScreen() {
    val breakpoint = rememberBreakpoint()
    val colorMode by ColorMode.currentState


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
                modifier = HomeProfileImageStyle.toModifier()
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
            Div(
                attrs = Modifier.fillMaxWidth().display(value = DisplayStyle.Flex)
                    .flexWrap(FlexWrap.Wrap)
                    .margin(top = 5.px).justifyContent(JustifyContent.Center).backgroundColor(
                        customColor(
                            colorMode = colorMode,
                            lightColor = Theme.LightCardBackGroundColor,
                            darkColor = Theme.DarkCardBackGroundColor
                        )
                    )
                    .borderRadius(10.px)
                    .border(
                        color = colorMode.toPalette().border, style = LineStyle.Solid, width = 1.px
                    )
                    .boxShadow(0.px, 0.px, 0.px, 0.px).toAttrs()
            ) {
                Constants.socials.forEach { social ->
                    Img(
                        src = when (colorMode) {
                            ColorMode.LIGHT -> {
                                social.lightImage
                            }

                            ColorMode.DARK -> {
                                social.darkImage ?: social.lightImage
                            }
                        },
                        alt = social.title,
                        attrs = SocialImageStyle.toModifier().padding(leftRight = 10.px)
                            .margin(5.px).cursor(Cursor.Pointer).onClick {
                            window.open(social.link)
                        }.toAttrs()
                    )
                }
            }
        }
    }
}