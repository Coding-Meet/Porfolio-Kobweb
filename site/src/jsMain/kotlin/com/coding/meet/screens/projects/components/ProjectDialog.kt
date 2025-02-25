package com.coding.meet.screens.projects.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.coding.meet.common.image_slider_with_dot.ImageSliderWithDot
import com.coding.meet.models.Project
import com.coding.meet.screens.projects.styles.ReadMoreButtonStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.aspectRatio
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
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.visibility
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaGooglePlay
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
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
import org.jetbrains.compose.web.dom.Iframe
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Ul


@Composable
fun ColumnScope.ProjectDialog(
    project: Project,
    isNextPreviousBtnShow: Boolean = false,
    onDismiss: () -> Unit,
    onNext: () -> Unit,
    onPrevious: () -> Unit
) {
    val colorMode by ColorMode.currentState

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            SpanText(
                text = project.title,
                modifier = Modifier.fillMaxWidth().margin(right = 20.px).color(
                    CustomColor(
                        lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                    )
                ).fontSize(1.5.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
            )
            if (project.githubUrl != null || project.appStoreUrl != null) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(topBottom = 5.px),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        5.px,
                        Alignment.CenterHorizontally
                    ),
                ) {
                    if (project.appStoreUrl != null) {
                        FaGooglePlay(
                            size = IconSize.XXL,
                            modifier = Modifier.cursor(Cursor.Pointer).onClick {
                                window.open(project.appStoreUrl!!)
                            })

                    }
                    if (project.githubUrl != null) {
                        FaGithub(
                            size = IconSize.XXL,
                            modifier = Modifier.cursor(Cursor.Pointer).onClick {
                                window.open(project.githubUrl)
                            })
                        if (project.stargazersCount > 0) {
                            SpanText(
                                modifier = Modifier.padding(leftRight = 5.px).color(
                                    CustomColor(
                                        lightColor = Theme.LightFontColor,
                                        darkColor = Theme.DarkFontColor
                                    )
                                ).fontSize(1.0.cssRem).fontWeight(FontWeight.Bold),
                                text = project.stargazersCount.toString() + " stars",
                            )
                        }
                    }
                }
            }
        }
        CloseIcon(
            modifier = Modifier
                .size(20.px)
                .cursor(Cursor.Pointer)
                .onClick {
                    onDismiss()
                },
        )
    }
    Hr(
        attrs = Modifier.fillMaxWidth().border(
            color = colorMode.toPalette().border, style = LineStyle.Solid, width = 2.px
        ).toAttrs()
    )
    TitleSpanText(text = "Overview:")
    SpanText(
        text = project.longDescription,
        modifier = Modifier.fillMaxWidth().padding(topBottom = 5.px).color(
            CustomColor(
                lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
            )
        )
    )
    Hr(
        attrs = Modifier.fillMaxWidth().border(
            color = colorMode.toPalette().border, style = LineStyle.Solid, width = 2.px
        ).toAttrs()
    )
    if (project.imageUrls.isNotEmpty()) {
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
    if (project.features.isNotEmpty()) {
        TitleSpanText(text = "Features & Technologies:")
        Ul(
            attrs = Modifier.fillMaxWidth().padding(leftRight = 10.px).toAttrs()
        ) {
            project.features.forEach {
                Li(
                    attrs = Modifier.toAttrs()
                ) {
                    SpanText(
                        text = it,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
        Hr(
            attrs = Modifier.fillMaxWidth().border(
                color = colorMode.toPalette().border, style = LineStyle.Solid, width = 2.px
            ).toAttrs()
        )
    }

    if (project.libraries.isNotEmpty()) {
        TitleSpanText(text = "Libraries:")
        Div(
            attrs = Modifier.fillMaxWidth().display(value = DisplayStyle.Flex)
                .flexWrap(FlexWrap.Wrap)
                .margin(top = 5.px).justifyContent(JustifyContent.Center).toAttrs()
        ) {
            project.libraries.forEach {
                SpanText(
                    text = it,
                    modifier = Modifier.color(Theme.LightFontColor.color)
                        .backgroundColor(Theme.LightBackGroundColor.color).borderRadius(20.percent)
                        .padding(leftRight = 20.px).margin(5.px)
                )
            }
        }
        Hr(
            attrs = Modifier.fillMaxWidth().border(
                color = colorMode.toPalette().border, style = LineStyle.Solid, width = 2.px
            ).toAttrs()
        )
    }
    if (project.platform.isNotEmpty()) {
        TitleSpanText(text = "Platforms:")
        Div(
            attrs = Modifier.fillMaxWidth().display(value = DisplayStyle.Flex)
                .flexWrap(FlexWrap.Wrap)
                .margin(top = 5.px).justifyContent(JustifyContent.Center).toAttrs()
        ) {
            project.platform.forEach {
                SpanText(
                    text = it,
                    modifier = Modifier.color(Theme.LightFontColor.color)
                        .backgroundColor(Theme.LightBackGroundColor.color).borderRadius(20.percent)
                        .padding(leftRight = 20.px).margin(5.px)
                )
            }
        }
        Hr(
            attrs = Modifier.fillMaxWidth().border(
                color = colorMode.toPalette().border, style = LineStyle.Solid, width = 2.px
            ).toAttrs()
        )
    }
    if (project.youtubeVideoLink != null) {
        TitleSpanText(text = "Video:")
        Iframe(
            attrs = Modifier
                .borderRadius(8.px)
                .overflow(Overflow.Hidden)
                .aspectRatio(16, 9)
                .width(100.percent)
                .toAttrs {
                    attr("allowfullscreen", "")
                    attr("src", project.youtubeVideoLink)
                    attr("title", project.title)
                    attr("frameborder", "0")
                    attr(
                        "allow",
                        "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                    )
                    attr("referrerpolicy", "strict-origin-when-cross-origin")
                }
        )
        Hr(
            attrs = Modifier.fillMaxWidth().border(
                color = colorMode.toPalette().border, style = LineStyle.Solid, width = 2.px
            ).toAttrs()
        )
    }
    if (isNextPreviousBtnShow) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.px, Alignment.CenterHorizontally)
        ) {
            Button(
                attrs = ReadMoreButtonStyle.toAttrs {
                    onClick {
                        onPrevious()
                    }
                }
            ) {
                SpanText(
                    text = "Previous",
                )
            }
            Button(
                attrs = ReadMoreButtonStyle.toAttrs {
                    onClick {
                        onNext()
                    }
                }
            ) {
                SpanText(
                    text = "Next",
                )
            }
        }
    }
}

@Composable
fun TitleSpanText(text: String, modifier: Modifier = Modifier) {
    SpanText(
        text = text,
        modifier = modifier.fillMaxWidth().padding(topBottom = 5.px).color(
            CustomColor(
                lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
            )
        ).fontSize(1.5.cssRem).fontWeight(FontWeight.Bold)
    )
}