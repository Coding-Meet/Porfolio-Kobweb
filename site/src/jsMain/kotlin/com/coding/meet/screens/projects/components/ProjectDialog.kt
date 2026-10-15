package com.coding.meet.screens.projects.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.coding.meet.common.image_slider_with_dot.ImageSliderWithDot
import com.coding.meet.common.image_slider_with_dot.MainButtonStyle
import com.coding.meet.common.image_slider_with_dot.SecondaryButtonStyle
import com.coding.meet.models.Project
import com.coding.meet.models.ProjectCategory
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.coding.meet.util.glassSubtle
import com.coding.meet.util.select
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
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
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaGooglePlay
import com.varabyte.kobweb.silk.components.icons.fa.FaLink
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
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

    // Top Header: Title + Close Icon
    Row(
        modifier = Modifier.fillMaxWidth().padding(bottom = 10.px),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SpanText(
            text = project.title,
            modifier = Modifier
                .weight(1f)
                .margin(right = 12.px)
                .color(
                    CustomColor(
                        lightColor = Theme.LightFontColor,
                        darkColor = Theme.DarkFontColor
                    )
                )
                .fontFamily(Res.Font.FONT_FAMILY_HEADING)
                .fontSize(1.6.cssRem)
                .fontWeight(FontWeight.Bold)
        )
        Box(
            modifier = Modifier
                .size(36.px)
                .borderRadius(50.percent)
                .cursor(Cursor.Pointer)
                .backgroundColor(
                    colorMode.glassSubtle
                )
                .onClick { onDismiss() },
            contentAlignment = Alignment.Center
        ) {
            CloseIcon(
                modifier = Modifier.size(16.px)
            )
        }
    }

    // Action Buttons (Play Store, GitHub, Live)
    if (project.githubUrl != null || project.appStoreUrl != null || project.websiteUrl != null) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.px)
                .display(DisplayStyle.Flex)
                .flexWrap(FlexWrap.Wrap)
                .gap(8.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (project.appStoreUrl != null) {
                Button(
                    attrs = MainButtonStyle.toAttrs {
                        onClick {
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

    DialogDivider(colorMode)

    // Overview Section
    TitleSpanText(text = "Overview")
    SpanText(
        text = project.longDescription,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.px, bottom = 8.px)
            .color(
                CustomColor(
                    lightColor = Theme.LightFontColor,
                    darkColor = Theme.DarkFontColor
                )
            )
            .lineHeight(1.6)
    )

    // Image Slider Section
    if (project.imageUrls.isNotEmpty()) {
        DialogDivider(colorMode)
        ImageSliderWithDot(
            imageList = project.imageUrls,
            showIndicators = project.imageUrls.size > 1,
            showControls = project.imageUrls.size > 1
        )
    }

    // Features Section
    if (project.features.isNotEmpty()) {
        DialogDivider(colorMode)
        TitleSpanText(text = "Features")
        Ul(
            attrs = Modifier
                .fillMaxWidth()
                .padding(left = 20.px)
                .margin(top = 4.px, bottom = 4.px)
                .toAttrs()
        ) {
            project.features.forEach {
                Li(
                    attrs = Modifier.padding(topBottom = 3.px).toAttrs()
                ) {
                    SpanText(
                        text = it,
                        modifier = Modifier.fillMaxWidth().color(
                            CustomColor(
                                lightColor = Theme.LightFontColor,
                                darkColor = Theme.DarkFontColor
                            )
                        ).lineHeight(1.5)
                    )
                }
            }
        }
        if (project.categories.contains(ProjectCategory.IOT)) {
            Div(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(top = 10.px)
                    .padding(14.px, 18.px)
                    .borderRadius(12.px)
                    .backgroundColor(
                        colorMode.select(Theme.Primary.subtle, Theme.Primary.soft)
                    )
                    .border(
                        1.px,
                        LineStyle.Solid,
                        Theme.Primary.medium
                    )
                    .toAttrs()
            ) {
                SpanText(
                    text = "⚡ Credit: Hardware connections, electrical work, and mentoring by my brother Pranav, an electrical engineer and IoT expert. Software development by me.",
                    modifier = Modifier
                        .fontSize(0.9.cssRem)
                        .fontWeight(FontWeight.Medium)
                        .color(
                            CustomColor(
                                lightColor = Theme.LightFontColor,
                                darkColor = Theme.DarkFontColor
                            )
                        )
                        .lineHeight(1.5)
                )
            }
        }
    }

    // Technologies & Libraries Section
    val allTechnologies = project.technologies.distinct()
    val remainingLibraries = project.libraries.filter { lib ->
        allTechnologies.none { tech -> tech.equals(lib, ignoreCase = true) }
    }.distinct()

    if (allTechnologies.isNotEmpty() || remainingLibraries.isNotEmpty()) {
        DialogDivider(colorMode)
        TitleSpanText(text = "Technologies & Libraries")
        Div(
            attrs = Modifier
                .fillMaxWidth()
                .display(DisplayStyle.Flex)
                .flexWrap(FlexWrap.Wrap)
                .gap(8.px)
                .margin(top = 8.px)
                .toAttrs()
        ) {
            allTechnologies.forEach {
                ProjectChip(text = it, isTechnology = true, colorMode = colorMode)
            }
            remainingLibraries.forEach {
                ProjectChip(text = it, isTechnology = true, colorMode = colorMode)
            }
        }
    }

    // Platforms Section
    val allPlatforms = project.platform.distinct()
    if (allPlatforms.isNotEmpty()) {
        DialogDivider(colorMode)
        TitleSpanText(text = "Platforms")
        Div(
            attrs = Modifier
                .fillMaxWidth()
                .display(DisplayStyle.Flex)
                .flexWrap(FlexWrap.Wrap)
                .gap(8.px)
                .margin(top = 8.px)
                .toAttrs()
        ) {
            allPlatforms.forEach {
                ProjectChip(text = it, isTechnology = false, colorMode = colorMode)
            }
        }
    }

    // Video Section
    if (project.youtubeVideoLink != null) {
        DialogDivider(colorMode)
        TitleSpanText(text = "Demo Video")
        Div(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 8.px)
                .toAttrs()
        ) {
            Iframe(
                attrs = Modifier
                    .borderRadius(12.px)
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
        }
    }

    // Previous / Next Buttons
    if (isNextPreviousBtnShow) {
        DialogDivider(colorMode)
        Row(
            modifier = Modifier.fillMaxWidth().margin(top = 8.px),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                attrs = SecondaryButtonStyle.toAttrs {
                    onClick {
                        onPrevious()
                    }
                }
            ) {
                SpanText(
                    text = "← Previous",
                )
            }
            Button(
                attrs = MainButtonStyle.toAttrs {
                    onClick {
                        onNext()
                    }
                }
            ) {
                SpanText(
                    text = "Next →",
                )
            }
        }
    }
}

@Composable
fun DialogDivider(colorMode: ColorMode) {
    Div(
        attrs = Modifier
            .fillMaxWidth()
            .height(1.px)
            .margin(topBottom = 16.px)
            .backgroundColor(
                colorMode.glassSubtle
            )
            .toAttrs()
    )
}

@Composable
fun ProjectChip(text: String, isTechnology: Boolean = true, colorMode: ColorMode) {
    SpanText(
        text = text,
        modifier = Modifier
            .fontSize(12.px)
            .fontWeight(FontWeight.Medium)
            .padding(topBottom = 6.px, leftRight = 14.px)
            .borderRadius(9999.px)
            .backgroundColor(
                if (isTechnology) {
                    colorMode.select(Theme.Primary.subtle, Theme.Primary.soft)
                } else {
                    colorMode.glassSubtle
                }
            )
            .color(
                if (isTechnology) {
                    colorMode.select(Theme.Primary.color, Theme.PrimaryLight.color)
                } else {
                    CustomColor(Theme.LightFontColor, Theme.DarkFontColor)
                }
            )
            .border(
                1.px,
                LineStyle.Solid,
                if (isTechnology) {
                    Theme.Primary.medium
                } else {
                    colorMode.select(Theme.Black.subtle, Theme.White.soft)
                }
            )
    )
}

@Composable
fun TitleSpanText(text: String, modifier: Modifier = Modifier) {
    SpanText(
        text = text,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 4.px)
            .color(
                CustomColor(
                    lightColor = Theme.LightFontColor,
                    darkColor = Theme.DarkFontColor
                )
            )
            .fontFamily(Res.Font.FONT_FAMILY_HEADING)
            .fontSize(1.2.cssRem)
            .fontWeight(FontWeight.Bold)
    )
}