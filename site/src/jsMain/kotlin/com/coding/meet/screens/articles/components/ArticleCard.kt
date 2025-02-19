package com.coding.meet.screens.articles.components

import androidx.compose.runtime.Composable
import com.coding.meet.common.components.RoundedImage
import com.coding.meet.models.Article
import com.coding.meet.screens.articles.styles.ArticleStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
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
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div

@Composable
fun ArticleCard(article: Article) {
    Column(
        modifier = ArticleStyle.toModifier()
            .margin(10.px)
            .cursor(Cursor.Pointer)
            .onClick {
                window.open(article.link)
            },
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (article.thumbnail.isNotEmpty()) {
            RoundedImage(
                src = article.thumbnail
            )
        }
        SpanText(
            text = article.title,
            modifier = Modifier.fillMaxWidth().padding(top = 5.px, leftRight = 10.px).color(
                CustomColor(
                    lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                )
            ).fontSize(1.2.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
        )
        SpanText(
            text = article.shortDescription,
            modifier = Modifier.fillMaxWidth().padding(topBottom = 5.px, leftRight = 10.px).color(
                CustomColor(
                    lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                )
            ).fontSize(1.cssRem).textAlign(TextAlign.Center)
        )
        Div(
            attrs = Modifier.fillMaxWidth().display(DisplayStyle.Flex).flexWrap(FlexWrap.Wrap)
                .margin(top = 5.px).justifyContent(JustifyContent.Center).toAttrs()
        ) {
            article.categories.forEach {
                SpanText(
                    text = it.trim(),
                    modifier = Modifier.color(Theme.LightFontColor.color)
                        .backgroundColor(Theme.LightBackGroundColor.color).borderRadius(20.percent)
                        .padding(leftRight = 20.px).margin(5.px)
                )
            }
        }
        SpanText(
            text = article.pubDate + " | " + article.readTime,
            modifier = Modifier.fillMaxWidth().padding(topBottom = 5.px, leftRight = 10.px).color(
                CustomColor(
                    lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                )
            ).fontSize(1.cssRem).textAlign(TextAlign.Center)
        )
    }
}