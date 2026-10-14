package com.coding.meet.screens.home.about_me.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.coding.meet.screens.home.about_me.styles.SocialIconButtonStyle
import com.coding.meet.util.SocialData.socials
import com.varabyte.kobweb.browser.dom.ElementTarget
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.overlay.PopupPlacement
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img

@Composable
fun SocialBar(modifier: Modifier = Modifier) {
    val colorMode by ColorMode.currentState
    val breakpoint = rememberBreakpoint()

    Div(
        attrs = modifier
            .fillMaxWidth()
            .display(DisplayStyle.Flex)
            .flexWrap(FlexWrap.Wrap)
            .gap(8.px)
            .maxWidth(if (breakpoint > Breakpoint.SM) 480.px else 240.px)
            .justifyContent(JustifyContent.Center)
            .toAttrs()
    ) {
        socials.forEach { social ->
            Box(
                modifier = SocialIconButtonStyle.toModifier()
                    .size(if (breakpoint > Breakpoint.SM) 38.px else 36.px)
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
                        .size(if (breakpoint > Breakpoint.SM) 20.px else 18.px)
                        .toAttrs {
                            style {
                                property("display", "block")
                                property("margin", "auto")
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