package com.coding.meet.screens.home.achievements.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.coding.meet.models.Achievement
import com.coding.meet.screens.home.achievements.styles.achievementCardStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img

@Composable
fun AchievementCard(achievement: Achievement) {
    val colorMode by ColorMode.currentState

    Row(
        modifier = achievementCardStyle.toModifier().margin(10.px).padding(10.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Img(src = when (colorMode) {
            ColorMode.LIGHT -> {
                achievement.lightImage
            }

            ColorMode.DARK -> {
                achievement.darkImage ?: achievement.lightImage
            }
        })
        Column(
            modifier = Modifier.weight(1f).padding(leftRight = 10.px)
        ) {
            SpanText(
                text = achievement.title,
                modifier = Modifier.fillMaxWidth().color(
                    CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor)
                ).fontSize(1.0.cssRem).fontWeight(FontWeight.Bold)
            )
            SpanText(
                text = achievement.subtitle,
                modifier = Modifier.fillMaxWidth().padding(top = 5.px).color(
                    CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor)
                ).fontSize(0.95.cssRem)
            )
        }
    }
}