package com.coding.meet.screens.service.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.models.FAQ
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
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.icons.fa.FaAngleDown
import com.varabyte.kobweb.silk.components.icons.fa.FaAngleUp
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@Composable
fun FAQCard(
    faq: FAQ
) {
    var isAnswer by remember { mutableStateOf(false) }

    Column(
        modifier = faqCardStyle.toModifier()
            .margin(topBottom = 8.px)
            .padding(all = 18.px)
            .cursor(Cursor.Pointer)
            .onClick {
                isAnswer = !isAnswer
            },
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(leftRight = 4.px),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SpanText(
                text = faq.question,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(right = 16.px)
                    .color(
                        if (isAnswer) Theme.Primary.color
                        else CustomColor(
                            lightColor = Theme.LightFontColor,
                            darkColor = Theme.DarkFontColor
                        )
                    )
                    .fontSize(1.05.cssRem)
                    .fontWeight(FontWeight.SemiBold)
            )
            if (isAnswer) {
                FaAngleUp(
                    size = IconSize.LG,
                    modifier = Modifier.color(Theme.Primary.color)
                )
            } else {
                FaAngleDown(
                    size = IconSize.LG,
                    modifier = Modifier.color(CustomColor(Theme.DarkGray, Theme.Muted))
                )
            }
        }
        if (isAnswer) {
            SpanText(
                text = faq.answer,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.px, leftRight = 4.px)
                    .color(
                        CustomColor(
                            lightColor = Theme.DarkGray,
                            darkColor = Theme.Muted
                        )
                    )
                    .fontSize(0.95.cssRem)
                    .lineHeight(1.6)
            )
        }
    }
}
