package com.coding.meet.screens.articles.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Hr

@Composable
fun ArticleCard(article: Article) {
    val colorMode by ColorMode.currentState

    Column(
        modifier = ArticleStyle.toModifier().backgroundColor(
            CustomColor(
                lightColor = Theme.LightCardBackGroundColor,
                darkColor = Theme.DarkCardBackGroundColor
            )
        ).borderRadius(20.px).border(
            color = colorMode.toPalette().border, style = LineStyle.Solid, width = 2.px
        ).margin(10.px).padding(10.px).cursor(Cursor.Pointer).onClick {
            window.open(article.link)
        },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (article.thumbnail.isNotEmpty()) {
            RoundedImage(
                src = article.thumbnail
            )
            Hr(
                attrs = Modifier.fillMaxWidth().border(
                    color = colorMode.toPalette().border, style = LineStyle.Solid, width = 2.px
                ).toAttrs()
            )
        }
        SpanText(
            text = article.title,
            modifier = Modifier.fillMaxWidth().color(
                CustomColor(
                    lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                )
            ).fontSize(1.2.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
        )
        SpanText(
            text = article.shortDescription,
            modifier = Modifier.fillMaxWidth().margin(top = 5.px).color(
                CustomColor(
                    lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                )
            ).fontSize(0.95.cssRem).textAlign(TextAlign.Center)
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

    }
}