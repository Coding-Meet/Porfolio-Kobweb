package com.coding.meet.screens.service.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.models.FAQ
import com.coding.meet.screens.articles.styles.ArticleStyle
import com.coding.meet.screens.service.styles.faqCardStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.icons.fa.FaAngleDown
import com.varabyte.kobweb.silk.components.icons.fa.FaAngleUp
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@Composable
fun FAQCard(
    faq: FAQ
) {
    val colorMode by ColorMode.currentState

    var isAnswer by remember { mutableStateOf(false) }

    Column(
        modifier = faqCardStyle.toModifier().margin(10.px).padding(10.px).cursor(Cursor.Pointer)
            .onClick {
                isAnswer = !isAnswer
            },
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(leftRight = 10.px),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SpanText(
                text = "\uD83D\uDE4B "+faq.question,
                modifier = Modifier.fillMaxWidth().padding(right = 20.px).color(
                    CustomColor(
                        lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                    )
                ).fontSize(1.cssRem).fontWeight(FontWeight.Bold)
            )
            if (isAnswer) {
                FaAngleUp(
                    size = IconSize.XL
                )
            } else {
                FaAngleDown(
                    size = IconSize.XL
                )
            }
        }
        if (isAnswer) {
            SpanText(
                text = "\uD83D\uDC49 "+faq.answer,
                modifier = Modifier.fillMaxWidth().padding(top = 5.px, leftRight = 10.px).color(
                    CustomColor(
                        lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                    )
                ).fontSize(1.cssRem)
            )
        }
    }
}

