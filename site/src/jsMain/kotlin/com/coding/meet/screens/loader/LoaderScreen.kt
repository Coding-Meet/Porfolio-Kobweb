package com.coding.meet.screens.loader

import androidx.compose.runtime.Composable
import com.coding.meet.util.Constants
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.alignItems
import com.varabyte.kobweb.compose.css.justifyContent
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div

@Composable
fun LoaderScreen(colorMode: ColorMode) {
    Div(attrs = {
        style {
            position(Position.Fixed)
            width(100.percent)
            height(100.vh)
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            justifyContent(JustifyContent.Center)
            alignItems(AlignItems.Center)
            backgroundColor(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.White,
                    darkColor = Theme.DarkCardBackGroundColor
                )
            )
        }
    }) {
        SpanText(
            text = Constants.NAMASTE_TEXT,
            modifier = Modifier
                .fontSize(30.px)
                .textAlign(TextAlign.Center)
                .color(
                    CustomColor(
                        lightColor = Theme.LightFontColor,
                        darkColor = Theme.DarkFontColor
                    )
                )
                .animation(
                    fadeInUpTextAnimation.toAnimation(
                        duration = 1.s,
                        timingFunction = AnimationTimingFunction.EaseOut
                    )
                )
        )

        SpanText(
            text = Constants.WELCOME_TEXT,
            modifier = Modifier
                .fontSize(20.px)
                .textAlign(TextAlign.Center)
                .color(
                    CustomColor(
                        lightColor = Theme.LightFontColor,
                        darkColor = Theme.DarkFontColor
                    )
                )
                .margin(top = 8.px)
                .animation(
                    fadeInUpTextAnimation.toAnimation(
                        duration = 1.s,
                        timingFunction = AnimationTimingFunction.EaseOut,
                    )
                )
        )
    }
}