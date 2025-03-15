package com.coding.meet.screens.home.skils.components


import androidx.compose.runtime.Composable
import com.coding.meet.models.Skill
import com.coding.meet.screens.home.skils.styles.SkillsImgStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img

@Composable
fun SkillCard(
    skill: Skill
) {
    Row(
        modifier = Modifier.margin(10.px).padding(10.px),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Img(
            src = skill.logo,
            attrs = SkillsImgStyle.toModifier().fillMaxSize().toAttrs()
        )
        SpanText(
            text = skill.name,
            modifier = Modifier.fillMaxWidth().weight(1f).padding(leftRight = 10.px).color(
                CustomColor(
                    lightColor = Theme.LightFontColor,
                    darkColor = Theme.DarkFontColor
                )
            ).fontSize(1.0.cssRem).fontWeight(FontWeight.Bold)
        )

    }
}

