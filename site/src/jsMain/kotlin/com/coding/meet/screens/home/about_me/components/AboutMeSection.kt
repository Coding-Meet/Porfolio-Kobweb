package com.coding.meet.screens.home.about_me.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.common.image_slider_with_dot.MainButtonStyle
import com.coding.meet.common.image_slider_with_dot.SecondaryButtonStyle
import com.coding.meet.models.contactMePath
import com.coding.meet.models.projectsPath
import com.coding.meet.screens.home.about_me.styles.BlinkCursorAnimation
import com.coding.meet.screens.home.about_me.styles.HeroBadgeStyle
import com.coding.meet.screens.home.about_me.styles.ProfileImageStyle
import com.coding.meet.screens.home.about_me.styles.PulseDotAnimation
import com.coding.meet.screens.home.about_me.styles.WavingHandStyle
import com.coding.meet.util.AppInfo.BIO
import com.coding.meet.util.AppInfo.animatedTexts
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.boxSizing
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.Button

@Composable
fun AboutMeSection() {
    val colorMode by ColorMode.currentState
    val breakpoint = rememberBreakpoint()
    var currentText by remember { mutableStateOf("") }
    var textIndex by remember { mutableStateOf(0) }

    // Smooth typing and backspacing animation
    LaunchedEffect(Unit) {
        while (true) {
            val target = animatedTexts.getOrElse(textIndex) { "" }
            for (i in 1..target.length) {
                currentText = target.substring(0, i)
                delay(80)
            }
            delay(1600)
            for (i in target.length downTo 0) {
                currentText = target.substring(0, i)
                delay(35)
            }
            delay(250)
            textIndex = (textIndex + 1) % animatedTexts.size
        }
    }

    SimpleGrid(
        numColumns = numColumns(base = 1, sm = 1, md = 2),
        modifier = Modifier
            .fillMaxWidth(if (breakpoint > Breakpoint.MD) 75.percent else 92.percent)
            .padding(
                top = if (breakpoint > Breakpoint.SM) 32.px else 16.px,
                bottom = if (breakpoint > Breakpoint.SM) 40.px else 20.px
            )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(10.px),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = ProfileImageStyle.toModifier()
                    .size(if (breakpoint > Breakpoint.MD) 310.px else if (breakpoint > Breakpoint.SM) 260.px else 200.px)
                    .display(DisplayStyle.Block)
                    .borderRadius(50.percent)
                    .boxSizing(BoxSizing.BorderBox)
                    .border(
                        3.px,
                        LineStyle.Solid,
                        if (colorMode.isLight) rgba(16, 185, 129, 0.4) else rgba(16, 185, 129, 0.6)
                    ),
                src = Res.Image.PROFILE,
                alt = "Meet - Profile",
            )
            SocialBar(modifier = Modifier.margin(top = 22.px))
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(leftRight = if (breakpoint > Breakpoint.SM) 20.px else 8.px, topBottom = 10.px),
            verticalArrangement = Arrangement.Center
        ) {
            // Status Pill Badge
            Row(
                modifier = HeroBadgeStyle.toModifier()
                    .padding(leftRight = 14.px, topBottom = 6.px)
                    .margin(bottom = 12.px)
                    .backgroundColor(
                        if (colorMode.isLight) rgba(16, 185, 129, 0.08) else rgba(16, 185, 129, 0.15)
                    )
                    .border(
                        1.px,
                        LineStyle.Solid,
                        if (colorMode.isLight) rgba(16, 185, 129, 0.25) else rgba(16, 185, 129, 0.35)
                    )
                    .borderRadius(9999.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(8.px)
                        .borderRadius(50.percent)
                        .backgroundColor(Theme.Primary.color)
                        .animation(
                            PulseDotAnimation.toAnimation(
                                duration = 2.s,
                                iterationCount = AnimationIterationCount.Infinite,
                                timingFunction = AnimationTimingFunction.EaseInOut
                            )
                        )
                        .boxShadow(0.px, 0.px, 8.px, null, rgba(16, 185, 129, 0.8))
                        .margin(right = 8.px)
                )
                SpanText(
                    text = "Available for Freelance & Android Projects",
                    modifier = Modifier
                        .fontSize(0.85.cssRem)
                        .fontWeight(FontWeight.SemiBold)
                        .color(Theme.Primary.color)
                )
            }

            // Headline
            Row(
                modifier = Modifier
                    .display(DisplayStyle.Flex)
                    .flexWrap(FlexWrap.Wrap)
                    .gap(6.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpanText(
                    text = "Hi, I'm Meet",
                    modifier = Modifier
                        .color(CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor))
                        .fontFamily(Res.Font.FONT_FAMILY_HEADING)
                        .fontSize(if (breakpoint > Breakpoint.SM) 2.6.cssRem else 1.9.cssRem)
                        .fontWeight(FontWeight.Bold)
                        .lineHeight(1.2)
                )
                SpanText(
                    text = "👋",
                    modifier = WavingHandStyle.toModifier()
                        .fontSize(if (breakpoint > Breakpoint.SM) 2.6.cssRem else 1.9.cssRem)
                        .lineHeight(1.2)
                )
            }

            // Dynamic typing subhead
            val currentRole = animatedTexts.getOrElse(textIndex) { "" }
            val prefix = if (currentRole.startsWith("A", ignoreCase = true) ||
                currentRole.startsWith("I", ignoreCase = true) ||
                currentRole.startsWith("E", ignoreCase = true) ||
                currentRole.startsWith("O", ignoreCase = true)
            ) {
                "I'm an "
            } else {
                "I'm a "
            }

            Row(
                modifier = Modifier.padding(top = 8.px, bottom = 12.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpanText(
                    text = prefix,
                    modifier = Modifier
                        .fontSize(if (breakpoint > Breakpoint.SM) 1.4.cssRem else 1.15.cssRem)
                        .color(CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor))
                        .fontWeight(FontWeight.SemiBold)
                )
                SpanText(
                    text = currentText,
                    modifier = Modifier
                        .fontSize(if (breakpoint > Breakpoint.SM) 1.4.cssRem else 1.15.cssRem)
                        .color(Theme.Primary.color)
                        .fontWeight(FontWeight.Bold)
                )
                Box(
                    modifier = Modifier
                        .width(2.px)
                        .height(if (breakpoint > Breakpoint.SM) 22.px else 18.px)
                        .margin(left = 2.px)
                        .backgroundColor(Theme.Primary.color)
                        .animation(
                            BlinkCursorAnimation.toAnimation(
                                duration = 0.8.s,
                                iterationCount = AnimationIterationCount.Infinite,
                                timingFunction = AnimationTimingFunction.steps(1)
                            )
                        )
                )
            }

            // Bio
            SpanText(
                text = BIO,
                modifier = Modifier
                    .padding(bottom = 18.px)
                    .color(CustomColor(lightColor = Theme.DarkGray, darkColor = Theme.Muted))
                    .fontSize(1.0.cssRem)
                    .lineHeight(1.65)
            )

            // CTA action buttons
            Row(
                modifier = Modifier.padding(bottom = 16.px).gap(12.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Link(
                    path = projectsPath,
                    modifier = Modifier.textDecorationLine(TextDecorationLine.None),
                    openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
                ) {
                    Button(
                        attrs = MainButtonStyle.toAttrs()
                    ) {
                        SpanText("View Projects →")
                    }
                }
                Link(
                    path = contactMePath,
                    modifier = Modifier.textDecorationLine(TextDecorationLine.None),
                    openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
                ) {
                    Button(
                        attrs = SecondaryButtonStyle.toAttrs()
                    ) {
                        SpanText("Contact Me")
                    }
                }
            }
        }
    }
}