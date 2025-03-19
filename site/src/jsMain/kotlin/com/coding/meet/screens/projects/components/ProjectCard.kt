package com.coding.meet.screens.projects.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.coding.meet.common.image_slider_with_dot.ImageSliderWithDot
import com.coding.meet.common.image_slider_with_dot.MainButtonStyle
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
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
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
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Hr

@Composable
fun ProjectCard(
    project: Project, onClick: () -> Unit
) {
    val colorMode by ColorMode.currentState

    Column(
        modifier = ProjectStyle.toModifier().margin(10.px).padding(10.px).cursor(Cursor.Pointer)
            .onClick {
                onClick()
            },
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (project.imageUrls.isNotEmpty()) {
            Column {
                ImageSliderWithDot(
                    imageList = project.imageUrls,
                    showIndicators = project.imageUrls.size > 1,
                    showControls = project.imageUrls.size > 1
                )
                Hr(
                    attrs = Modifier.fillMaxWidth().border(
                        color = colorMode.toPalette().border, style = LineStyle.Solid, width = 2.px
                    ).toAttrs()
                )
            }
        }
        Column {
            SpanText(
                text = project.title,
                modifier = Modifier.fillMaxWidth().padding(leftRight = 10.px).color(
                    CustomColor(
                        lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                    )
                ).fontSize(1.5.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
            )
            SpanText(
                text = project.shortDescription,
                modifier = Modifier.fillMaxWidth().padding(top = 5.px, leftRight = 10.px).color(
                    CustomColor(
                        lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                    )
                ).fontSize(1.cssRem).textAlign(TextAlign.Center)
            )
        }

        Div(
            attrs = Modifier.fillMaxWidth().display(value = DisplayStyle.Flex)
                .flexWrap(FlexWrap.Wrap)
                .margin(top = 5.px).justifyContent(JustifyContent.Center).toAttrs()
        ) {
            val platform by remember {
                derivedStateOf {
                    if (project.platform.size <= 3) {
                        project.platform.toMutableList().also {
                            if (project.libraries.size > 2) {
                                it.addAll(project.libraries.take(5))
                            } else {
                                it.addAll(project.libraries)
                                it.addAll(project.technologies.take(3))
                            }
                        }
                    } else {
                        project.platform.toMutableList()
                    }
                }
            }

            platform.forEach {
                SpanText(
                    text = it,
                    modifier = Modifier.color(Theme.LightFontColor.color)
                        .backgroundColor(Theme.LightBackGroundColor.color)
                        .borderRadius(20.percent)
                        .padding(leftRight = 20.px).margin(5.px)
                )
            }
        }

        if (project.appStoreUrl != null || project.githubUrl != null || project.websiteUrl != null) {
            Column(Modifier.fillMaxWidth()) {
                Hr(
                    attrs = Modifier.fillMaxWidth().border(
                        color = colorMode.toPalette().border, style = LineStyle.Solid, width = 2.px
                    ).toAttrs()
                )
                Row(
                    modifier = Modifier.fillMaxWidth().margin(topBottom = 10.px),
                    horizontalArrangement = Arrangement.spacedBy(
                        10.px,
                        Alignment.CenterHorizontally
                    ),
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
                                size = IconSize.XXL,
                                modifier = Modifier
                            )
                            SpanText(
                                modifier = Modifier.fontSize(1.0.cssRem).fontWeight(FontWeight.Bold)
                                    .padding(left = 10.px),
                                text = Res.Strings.PLAY_STORE,
                            )
                        }
                    }
                    if (project.githubUrl != null) {
                        Button(
                            attrs = MainButtonStyle.toAttrs {
                                onClick {
                                    it.stopPropagation()
                                    window.open(project.githubUrl)
                                }
                            }
                        ) {
                            FaGithub(
                                size = IconSize.XXL,
                                modifier = Modifier
                            )
                            if (project.stargazersCount > 0) {
                                SpanText(
                                    modifier = Modifier.fontSize(1.0.cssRem)
                                        .fontWeight(FontWeight.Bold)
                                        .padding(left = 10.px),
                                    text = project.stargazersCount.toString() + " stars",
                                )
                            }
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
                                size = IconSize.XXL,
                                modifier = Modifier
                            )
                            SpanText(
                                modifier = Modifier.fontSize(1.0.cssRem).fontWeight(FontWeight.Bold)
                                    .padding(left = 10.px),
                                text = Res.Strings.LIVE,
                            )
                        }
                    }
                }
            }
        }
    }
}

