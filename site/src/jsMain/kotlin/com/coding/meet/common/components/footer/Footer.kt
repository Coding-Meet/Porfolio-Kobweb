package com.coding.meet.common.components.footer

import androidx.compose.runtime.Composable
import com.coding.meet.screens.home.about_me.components.SocialBar
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flex
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem

@Composable
fun Footer() {
    Row(
        modifier = FooterStyle.toModifier().displayIfAtLeast(Breakpoint.MD),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier.flex(1), contentAlignment = Alignment.CenterStart) {
            Copyright()
        }
        Box(modifier = Modifier.flex(1), contentAlignment = Alignment.Center) {
            SocialLinks()
        }
        Box(modifier = Modifier.flex(1), contentAlignment = Alignment.CenterEnd) {
            PoweredByKobweb()
        }
    }

    Column(
        modifier = FooterStyle.toModifier().displayUntil(Breakpoint.MD).gap(1.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SocialLinks()
        Copyright()
        PoweredByKobweb()

    }
}

@Composable
private fun SocialLinks() {
    SocialBar()
}

@Composable
private fun Copyright() {
    SpanText(
        modifier =  Modifier
            .color(
                CustomColor(
                    lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                )
            ).fontSize(1.cssRem).fontWeight(FontWeight.Bold),
        text = "Copyright ©\uFE0F 2025, Meet"
    )
}

@Composable
private fun PoweredByKobweb() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        SpanText(
            modifier = Modifier.fillMaxWidth()
                .color(
                    CustomColor(
                        lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                    )
                ).fontSize(1.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center),
            text = "Powered by"
        )
        Link(path = "https://kobweb.varabyte.com/") {
            Image(
                src = "kobweb.png",
                modifier = Modifier
                    .display(DisplayStyle.Flex)
                    .height(1.25.cssRem)
                    .margin(left = 0.375.cssRem)
            )
        }
    }
}