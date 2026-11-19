package com.coding.meet.screens.home.achievements.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.coding.meet.models.Achievement
import com.coding.meet.models.contactMePath
import com.coding.meet.screens.home.achievements.styles.achievementCardStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.coding.meet.util.select
import com.varabyte.kobweb.compose.css.Cursor
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
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img

@Composable
fun AchievementCard(achievement: Achievement) {
    val colorMode by ColorMode.currentState

    Column(
        modifier = achievementCardStyle.toModifier()
            .padding(all = 22.px)
            .cursor(Cursor.Pointer)
            .onClick {
                if (achievement.link == contactMePath || achievement.link.startsWith("/")) {
                    window.location.href = achievement.link
                } else {
                    window.open(achievement.link, "_blank")
                }
            } ,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        // Top Row: Platform Icon + Big Metric + Title + External Link Arrow
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 12.px),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f).gap(14.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Styled Icon Box
                Box(
                    modifier = Modifier
                        .size(52.px)
                        .borderRadius(14.px)
                        .backgroundColor(
                            colorMode.select(Theme.White.strong, Theme.Black.soft)
                        )
                        .border(
                            width = 1.px,
                            style = LineStyle.Solid,
                            color = colorMode.toPalette().border
                        )
                        .boxShadow(0.px, 2.px, 8.px, null, Theme.Black.subtle)
                        .padding(10.px),
                    contentAlignment = Alignment.Center
                ) {
                    Img(
                        src = when (colorMode) {
                            ColorMode.LIGHT -> achievement.lightImage
                            ColorMode.DARK -> achievement.darkImage ?: achievement.lightImage
                        },
                        alt = achievement.platform,
                        attrs = Modifier.size(32.px).toAttrs()
                    )
                }

                // Metric Number & Title
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center
                ) {
                    if (achievement.metric.isNotEmpty()) {
                        SpanText(
                            text = achievement.metric,
                            modifier = Modifier
                                .color(Theme.Primary.color)
                                .fontFamily(Res.Font.FONT_FAMILY_HEADING)
                                .fontSize(1.55.cssRem)
                                .fontWeight(FontWeight.Bold)
                                .lineHeight(1.1)
                        )
                    }
                    SpanText(
                        text = achievement.title,
                        modifier = Modifier
                            .color(
                                CustomColor(
                                    lightColor = Theme.LightFontColor,
                                    darkColor = Theme.DarkFontColor
                                )
                            )
                            .fontSize(1.02.cssRem)
                            .fontWeight(FontWeight.SemiBold)
                            .lineHeight(1.2)
                    )
                }
            }

            // External Arrow Pill
//            Box(
//                modifier = Modifier
//                    .size(30.px)
//                    .borderRadius(50.percent)
//                    .backgroundColor(colorMode.select(Theme.Primary.subtle, Theme.Primary.soft))
//                    .padding(4.px),
//                contentAlignment = Alignment.Center
//            ) {
//                SpanText(
//                    text = "↗",
//                    modifier = Modifier
//                        .color(Theme.Primary.color)
//                        .fontSize(0.95.cssRem)
//                        .fontWeight(FontWeight.Bold)
//                )
//            }
        }

        // Subtitle Description
        SpanText(
            text = achievement.subtitle,
            modifier = Modifier
                .fillMaxWidth()
                .color(
                    CustomColor(
                        lightColor = Theme.DarkGray,
                        darkColor = Theme.Muted
                    )
                )
                .fontSize(0.9.cssRem)
                .lineHeight(1.55)
        )

        // Bottom Badges / Tags
//        if (achievement.badges.isNotEmpty()) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .display(DisplayStyle.Flex)
//                    .flexWrap(FlexWrap.Wrap)
//                    .gap(8.px),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                achievement.badges.forEach { badge ->
//                    Box(
//                        modifier = Modifier
//                            .backgroundColor(
//                                CustomColor (
//                                    Theme.LightCardBackGroundColor,
//                                    Theme.Black
//                                )
//                            )
//                            .border(
//                                width = 1.px,
//                                style = LineStyle.Solid,
//                                color = colorMode.toPalette().border
//                            )
//                            .borderRadius(9999.px)
//                            .padding(leftRight = 10.px, topBottom = 4.px)
//                    ) {
//                        SpanText(
//                            text = badge,
//                            modifier = Modifier
//                                .fontSize(0.75.cssRem)
//                                .fontWeight(FontWeight.SemiBold)
//                                .color(
//                                    CustomColor(
//                                        Theme.DarkGray,
//                                        Theme.Muted
//                                    )
//                                )
//                        )
//                    }
//                }
//            }
//        }
    }
}
