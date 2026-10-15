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
import com.coding.meet.util.select
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
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.left
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
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
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div

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
            .fillMaxWidth(if (breakpoint > Breakpoint.LG) 80.percent else if (breakpoint > Breakpoint.SM) 92.percent else 96.percent)
            .maxWidth(1200.px)
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
            val avatarRadius = when {
                breakpoint > Breakpoint.LG -> 160
                breakpoint > Breakpoint.MD -> 132
                breakpoint > Breakpoint.SM -> 118
                else -> 110
            }
            val avatarSize = (avatarRadius * 2).px
            val orbitRadius = when {
                breakpoint > Breakpoint.LG -> 202
                breakpoint > Breakpoint.MD -> 168
                breakpoint > Breakpoint.SM -> 152
                else -> 144
            }
            val iconBoxSize = when {
                breakpoint > Breakpoint.LG -> 46
                breakpoint > Breakpoint.MD -> 40
                breakpoint > Breakpoint.SM -> 38
                else -> 42
            }
            val iconImageSize = when {
                breakpoint > Breakpoint.LG -> 24
                breakpoint > Breakpoint.MD -> 21
                breakpoint > Breakpoint.SM -> 20
                else -> 22
            }
            val containerWidth = (orbitRadius * 2 + iconBoxSize + 6).px
            val containerHeight = (avatarRadius + orbitRadius + iconBoxSize / 2 + 20).px

            Box(
                modifier = Modifier
                    .size(width = containerWidth, height = containerHeight)
                    .position(Position.Relative),
                contentAlignment = Alignment.TopCenter
            ) {
                // Decorative semi-circular dashed orbit track
                Box(
                    modifier = Modifier
                        .position(Position.Absolute)
                        .size((orbitRadius * 2).px)
                        .left(50.percent)
                        .top(avatarRadius.px)
                        .styleModifier {
                            val orbitColor = if (colorMode.isLight) Theme.Primary.strong else Theme.Primary.color
                            property("transform", "translate(-50%, -50%)")
                            property("border", "2px dashed $orbitColor")
                            property("border-top-color", "transparent")
                            property("filter", "drop-shadow(0 0 6px ${Theme.Primary.soft})")
                            property("z-index", "0")
                            property("pointer-events", "none")
                        }
                        .borderRadius(50.percent)
                )

                // Profile Image
                Image(
                    modifier = ProfileImageStyle.toModifier()
                        .size(avatarSize)
                        .display(DisplayStyle.Block)
                        .borderRadius(50.percent)
                        .boxSizing(BoxSizing.BorderBox)
                        .border(
                            3.px,
                            LineStyle.Solid,
                            colorMode.select(Theme.Primary.medium, Theme.Primary.strong)
                        ),
                    src = Res.Image.PROFILE,
                    alt = "Meet - Profile",
                )

                // Social Icons orbiting the bottom half-circle
                SocialBar(
                    avatarRadius = avatarRadius,
                    orbitRadius = orbitRadius,
                    iconBoxSize = iconBoxSize,
                    iconImageSize = iconImageSize
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    leftRight = if (breakpoint > Breakpoint.MD) 20.px else 12.px,
                    topBottom = 10.px
                ),
            verticalArrangement = Arrangement.Center
        ) {
            // Status Pill Badge
            Row(
                modifier = HeroBadgeStyle.toModifier()
                    .padding(leftRight = 14.px, topBottom = 6.px)
                    .margin(bottom = 12.px)
                    .backgroundColor(
                        colorMode.select(Theme.Primary.subtle, Theme.Primary.soft)
                    )
                    .border(
                        1.px,
                        LineStyle.Solid,
                        Theme.Primary.medium
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
                        .boxShadow(0.px, 0.px, 8.px, null, Theme.Primary.strong)
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
                        .color(
                            CustomColor(
                                lightColor = Theme.LightFontColor,
                                darkColor = Theme.DarkFontColor
                            )
                        )
                        .fontFamily(Res.Font.FONT_FAMILY_HEADING)
                        .fontSize(if (breakpoint > Breakpoint.LG) 2.6.cssRem else if (breakpoint > Breakpoint.MD) 2.3.cssRem else if (breakpoint > Breakpoint.SM) 2.1.cssRem else 1.9.cssRem)
                        .fontWeight(FontWeight.Bold)
                        .lineHeight(1.2)
                )
                SpanText(
                    text = "👋",
                    modifier = WavingHandStyle.toModifier()
                        .fontSize(if (breakpoint > Breakpoint.LG) 2.6.cssRem else if (breakpoint > Breakpoint.MD) 2.3.cssRem else if (breakpoint > Breakpoint.SM) 2.1.cssRem else 1.9.cssRem)
                        .lineHeight(1.2)
                )
            }

            // Dynamic typing subhead
            val currentRole = animatedTexts.getOrElse(textIndex) { "" }
            val prefix = when (currentRole) {
                "Open Source Contributor" -> "I'm an "
                else -> "I'm a "
            }

            Div(
                attrs = Modifier
                    .padding(top = 8.px, bottom = 12.px)
                    .lineHeight(1.3)
                    .toAttrs()
            ) {
                SpanText(
                    text = prefix,
                    modifier = Modifier
                        .fontSize(if (breakpoint > Breakpoint.LG) 1.4.cssRem else if (breakpoint > Breakpoint.MD) 1.25.cssRem else 1.15.cssRem)
                        .color(
                            CustomColor(
                                lightColor = Theme.LightFontColor,
                                darkColor = Theme.DarkFontColor
                            )
                        )
                        .fontWeight(FontWeight.SemiBold)
                )
                SpanText(
                    text = currentText,
                    modifier = Modifier
                        .fontSize(if (breakpoint > Breakpoint.LG) 1.4.cssRem else if (breakpoint > Breakpoint.MD) 1.25.cssRem else 1.15.cssRem)
                        .color(Theme.Primary.color)
                        .fontWeight(FontWeight.Bold)
                )
                Box(
                    modifier = Modifier
                        .display(DisplayStyle.InlineBlock)
                        .width(2.px)
                        .height(if (breakpoint > Breakpoint.LG) 22.px else if (breakpoint > Breakpoint.MD) 20.px else if (breakpoint > Breakpoint.SM) 18.px else 17.px)
                        .margin(left = 3.px)
                        .styleModifier {
                            property("vertical-align", "text-bottom")
                        }
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
                modifier = Modifier
                    .padding(bottom = 16.px)
                    .gap(12.px)
                    .display(DisplayStyle.Flex)
                    .flexWrap(FlexWrap.Wrap),
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