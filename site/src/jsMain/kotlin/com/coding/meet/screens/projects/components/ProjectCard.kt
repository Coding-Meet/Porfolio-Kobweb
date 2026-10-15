package com.coding.meet.screens.projects.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.coding.meet.common.image_slider_with_dot.ImageSliderWithDot
import com.coding.meet.common.image_slider_with_dot.MainButtonStyle
import com.coding.meet.common.image_slider_with_dot.SecondaryButtonStyle
import com.coding.meet.models.Project
import com.coding.meet.screens.projects.styles.ProjectStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaGooglePlay
import com.varabyte.kobweb.silk.components.icons.fa.FaLink
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Hr
import com.coding.meet.util.glassSubtle

@Composable
fun ProjectCard(
    project: Project, onClick: () -> Unit
) {
    val colorMode by ColorMode.currentState

    Column(
        modifier = ProjectStyle.toModifier()
            .margin(10.px)
            .padding(all = 16.px)
            .cursor(Cursor.Pointer)
            .onClick {
                onClick()
            },
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (project.imageUrls.isNotEmpty()) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(bottom = 12.px)
            ) {
                ImageSliderWithDot(
                    imageList = project.imageUrls,
                    showIndicators = project.imageUrls.size > 1,
                    showControls = project.imageUrls.size > 1
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth().padding(bottom = 12.px)
        ) {
            SpanText(
                text = project.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .color(CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor))
                    .fontFamily(Res.Font.FONT_FAMILY_HEADING)
                    .fontSize(1.3.cssRem)
                    .fontWeight(FontWeight.Bold)
                    .textAlign(TextAlign.Center)
            )
            SpanText(
                text = project.shortDescription,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.px, leftRight = 4.px)
                    .color(CustomColor(lightColor = Theme.DarkGray, darkColor = Theme.Muted))
                    .fontSize(0.9.cssRem)
                    .lineHeight(1.5)
                    .textAlign(TextAlign.Center)
            )
        }

        // Tech pills
        Div(
            attrs = Modifier
                .fillMaxWidth()
                .display(DisplayStyle.Flex)
                .flexWrap(FlexWrap.Wrap)
                .gap(6.px)
                .margin(bottom = 12.px)
                .justifyContent(JustifyContent.Center)
                .toAttrs()
        ) {
            val platform by remember(project) {
                derivedStateOf {
                    val list = mutableListOf<String>()
                    list.addAll(project.platform)
                    if (project.platform.size <= 3) {
                        if (project.libraries.size > 2) {
                            list.addAll(project.libraries.take(5))
                        } else {
                            list.addAll(project.libraries)
                            list.addAll(project.technologies.take(3))
                        }
                    }
                    list.distinct()
                }
            }

            platform.forEach {
                SpanText(
                    text = it,
                    modifier = Modifier
                        .color(CustomColor(Theme.DarkGray, Theme.Muted))
                        .backgroundColor(
                            colorMode.glassSubtle
                        )
                        .border(1.px, LineStyle.Solid, colorMode.toPalette().border)
                        .borderRadius(9999.px)
                        .padding(leftRight = 10.px, topBottom = 3.px)
                        .fontSize(0.76.cssRem)
                        .fontWeight(FontWeight.Medium)
                )
            }
        }

        // Action links
        if (project.appStoreUrl != null || project.githubUrl != null || project.websiteUrl != null) {
            Column(Modifier.fillMaxWidth()) {
                Div(
                    attrs = Modifier
                        .fillMaxWidth()
                        .height(1.px)
                        .margin(topBottom = 12.px)
                        .backgroundColor(
                            colorMode.glassSubtle
                        )
                        .toAttrs()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .display(DisplayStyle.Flex)
                        .flexWrap(FlexWrap.Wrap)
                        .gap(8.px)
                        .justifyContent(JustifyContent.Center),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (project.appStoreUrl != null) {
                        Button(
                            attrs = MainButtonStyle.toAttrs {
                                onClick {
                                    it.stopPropagation()
                                    window.open(project.appStoreUrl)
                                }
                            }
                        ) {
                            FaGooglePlay(
                                size = IconSize.LG,
                                modifier = Modifier
                            )
                            SpanText(
                                modifier = Modifier
                                    .fontSize(0.85.cssRem)
                                    .fontWeight(FontWeight.Bold)
                                    .padding(left = 8.px),
                                text = Res.Strings.PLAY_STORE,
                            )
                        }
                    }
                    if (project.githubUrl != null) {
                        Button(
                            attrs = SecondaryButtonStyle.toAttrs {
                                onClick {
                                    it.stopPropagation()
                                    window.open(project.githubUrl)
                                }
                            }
                        ) {
                            FaGithub(
                                size = IconSize.LG,
                                modifier = Modifier
                            )
                            SpanText(
                                modifier = Modifier
                                    .fontSize(0.85.cssRem)
                                    .fontWeight(FontWeight.Bold)
                                    .padding(left = 8.px),
                                text = if (project.stargazersCount > 0) "GitHub (${project.stargazersCount}★)" else "GitHub",
                            )
                        }
                    }
                    if (project.websiteUrl != null) {
                        Button(
                            attrs = MainButtonStyle.toAttrs {
                                onClick {
                                    it.stopPropagation()
                                    window.open(project.websiteUrl)
                                }
                            }
                        ) {
                            FaLink(
                                size = IconSize.LG,
                                modifier = Modifier
                            )
                            SpanText(
                                modifier = Modifier
                                    .fontSize(0.85.cssRem)
                                    .fontWeight(FontWeight.Bold)
                                    .padding(left = 8.px),
                                text = Res.Strings.LIVE,
                            )
                        }
                    }
                }
            }
        }
    }
}
