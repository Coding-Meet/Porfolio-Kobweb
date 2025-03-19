package com.coding.meet.screens.home.about_me.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.coding.meet.screens.home.about_me.styles.SocialImageStyle
import com.coding.meet.util.Constants
import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.browser.dom.ElementTarget
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.overlay.PopupPlacement
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img

@Composable
fun SocialBar() {
    val colorMode by ColorMode.currentState

    Div(
        attrs = Modifier.fillMaxWidth().display(value = DisplayStyle.Flex)
            .flexWrap(FlexWrap.Wrap)
            .margin(top = 5.px).justifyContent(JustifyContent.Center).backgroundColor(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightCardBackGroundColor,
                    darkColor = Theme.DarkCardBackGroundColor
                )
            )
            .borderRadius(10.px)
            .border(
                color = colorMode.toPalette().border, style = LineStyle.Solid, width = 1.px
            )
            .boxShadow(0.px, 0.px, 0.px, 0.px).toAttrs()
    ) {
        Constants.socials.forEach { social ->
            Img(
                src = when (colorMode) {
                    ColorMode.LIGHT -> {
                        social.lightImage
                    }

                    ColorMode.DARK -> {
                        social.darkImage ?: social.lightImage
                    }
                },
                alt = social.title,
                attrs = SocialImageStyle.toModifier().padding(leftRight = 10.px)
                    .margin(5.px).cursor(Cursor.Pointer).onClick {
                        window.open(social.link)
                    }.toAttrs()
            )
            Tooltip(
                target = ElementTarget.PreviousSibling,
                text =  social.title,
                placement = PopupPlacement.Top
            )
        }
    }
}