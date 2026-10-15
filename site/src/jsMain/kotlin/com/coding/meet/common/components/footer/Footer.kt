package com.coding.meet.common.components.footer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.coding.meet.screens.home.about_me.styles.SocialImageStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.SocialData.socials
import com.coding.meet.util.Theme
import com.varabyte.kobweb.browser.dom.ElementTarget
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.flex
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.overlay.PopupPlacement
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img
import com.coding.meet.util.select

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
        Box(modifier = Modifier.flex(1).padding(leftRight = 10.px), contentAlignment = Alignment.Center) {
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
    val colorMode by ColorMode.currentState
    Row(
        modifier = Modifier
            .display(DisplayStyle.Flex)
            .flexWrap(FlexWrap.Wrap)
            .gap(8.px)
            .justifyContent(JustifyContent.Center),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        socials.forEach { social ->
            Box(
                modifier = FooterSocialButtonStyle.toModifier()
                    .onClick {
                        window.open(social.link)
                    },
                contentAlignment = Alignment.Center
            ) {
                Img(
                    src = when (colorMode) {
                        ColorMode.LIGHT -> social.lightImage
                        ColorMode.DARK -> social.darkImage ?: social.lightImage
                    },
                    alt = social.title,
                    attrs = Modifier
                        .size(18.px)
                        .toAttrs {
                            style {
                                property("display", "block")
                                property("margin", "auto")
                                property("pointer-events", "none")
                                property("user-select", "none")
                                property("-webkit-user-drag", "none")
                            }
                        }
                )
            }
            Tooltip(
                target = ElementTarget.PreviousSibling,
                text = social.title,
                placement = PopupPlacement.Top
            )
        }
    }
}

@Composable
private fun Copyright() {
    val colorMode by ColorMode.currentState
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        SpanText(
            modifier = Modifier
                .color(
                    CustomColor(
                        lightColor = Theme.DarkGray, darkColor = Theme.Muted
                    )
                ).fontSize(0.9.cssRem).fontWeight(FontWeight.Medium),
            text = Res.Strings.COPYRIGHT_TEXT
        )
        Image(
            src = colorMode.select(Res.Image.COPYRIGHT_LIGHT, Res.Image.COPYRIGHT_DARK),
            alt = "Copyright",
            modifier = Modifier
                .size(14.px)
                .margin(left = 5.px, right = 5.px)
        )
        SpanText(
            modifier = Modifier
                .color(
                    CustomColor(
                        lightColor = Theme.DarkGray, darkColor = Theme.Muted
                    )
                ).fontSize(0.9.cssRem).fontWeight(FontWeight.Medium),
            text = Res.Strings.COPYRIGHT_AUTHOR
        )
    }
}

@Composable
private fun PoweredByKobweb() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        SpanText(
            modifier = Modifier
                .color(
                    CustomColor(
                        lightColor = Theme.DarkGray, darkColor = Theme.Muted
                    )
                    ).fontSize(0.9.cssRem).fontWeight(FontWeight.Medium).textAlign(TextAlign.Center),
            text = Res.Strings.POWERED_BY
        )
        Link(path = "https://kobweb.varabyte.com/") {
            Image(
                src = Res.Image.KOBWEB_LOGO,
                modifier = Modifier
                    .display(DisplayStyle.Flex)
                    .height(1.15.cssRem)
                    .margin(left = 0.375.cssRem)
            )
        }
    }
}