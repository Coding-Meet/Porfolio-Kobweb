package com.coding.meet.screens.articles.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.coding.meet.common.components.RoundedImage
import com.coding.meet.models.Article
import com.coding.meet.screens.articles.styles.ArticleStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.coding.meet.util.glassSubtle
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
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
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaBookOpen
import com.varabyte.kobweb.silk.components.icons.fa.FaChalkboardUser
import com.varabyte.kobweb.silk.components.icons.fa.FaEye
import com.varabyte.kobweb.silk.components.icons.fa.FaHandsClapping
import com.varabyte.kobweb.silk.components.text.SpanText
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
import org.jetbrains.compose.web.dom.Div

@Composable
fun ArticleCard(article: Article, onClick: (() -> Unit)? = null) {
    val colorMode by ColorMode.currentState

    Column(
        modifier = ArticleStyle.toModifier()
            .margin(10.px)
            .padding(16.px)
            .cursor(Cursor.Pointer)
            .onClick {
                if (onClick != null) {
                    onClick()
                } else {
                    window.open(article.link)
                }
            },
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (article.thumbnail.isNotEmpty()) {
            Column(modifier = Modifier.fillMaxWidth().padding(bottom = 12.px)) {
                RoundedImage(
                    src = article.thumbnail
                )
            }
        }

        Column(modifier = Modifier.fillMaxWidth().padding(bottom = 8.px)) {
            SpanText(
                text = article.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(leftRight = 4.px)
                    .color(
                        CustomColor(
                            lightColor = Theme.LightFontColor,
                            darkColor = Theme.DarkFontColor
                        )
                    )
                    .fontFamily(Res.Font.FONT_FAMILY_HEADING)
                    .fontSize(1.2.cssRem)
                    .fontWeight(FontWeight.Bold)
                    .lineHeight(1.35)
                    .textAlign(TextAlign.Start)
            )
            SpanText(
                text = article.shortDescription,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.px, leftRight = 4.px)
                    .color(CustomColor(lightColor = Theme.DarkGray, darkColor = Theme.Muted))
                    .fontSize(0.9.cssRem)
                    .lineHeight(1.5)
                    .textAlign(TextAlign.Start)
            )
        }

        // Tags
        Div(
            attrs = Modifier
                .fillMaxWidth()
                .display(DisplayStyle.Flex)
                .flexWrap(FlexWrap.Wrap)
                .gap(6.px)
                .margin(topBottom = 8.px)
                .justifyContent(JustifyContent.Start)
                .toAttrs()
        ) {
            article.categories.take(3).forEach {
                SpanText(
                    text = it.trim(),
                    modifier = Modifier
                        .color(CustomColor(Theme.DarkGray, Theme.Muted))
                        .backgroundColor(
                            colorMode.glassSubtle
                        )
                        .border(1.px, LineStyle.Solid, colorMode.toPalette().border)
                        .borderRadius(9999.px)
                        .fontSize(0.75.cssRem)
                        .fontWeight(FontWeight.Medium)
                        .padding(leftRight = 10.px, topBottom = 3.px)
                )
            }
        }

        // Stats
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .margin(top = 8.px, bottom = 4.px)
                .padding(leftRight = 4.px),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            article.views?.let { StatItem(it) { FaEye() } }
            article.reads?.let { StatItem(it) { FaBookOpen() } }
            article.claps?.let { StatItem(it) { FaHandsClapping() } }
            article.presentations?.let { StatItem(it) { FaChalkboardUser() } }
        }

        // Date and Read Time
        SpanText(
            text = "${article.pubDate} • ${article.readTime}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.px, leftRight = 4.px)
                .color(CustomColor(lightColor = Theme.DarkGray, darkColor = Theme.Muted))
                .fontSize(0.82.cssRem)
                .textAlign(TextAlign.Start)
        )
    }
}

@Composable
fun StatItem(value: String, icon: @Composable () -> Unit) {
    Row(
        modifier = Modifier.margin(right = 14.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.margin(right = 5.px).fontSize(0.8.cssRem).color(Theme.Primary.color)
        ) {
            icon()
        }
        SpanText(
            text = value,
            modifier = Modifier
                .fontSize(0.8.cssRem)
                .fontWeight(FontWeight.Medium)
                .color(CustomColor(Theme.DarkGray, Theme.Muted))
        )
    }
}