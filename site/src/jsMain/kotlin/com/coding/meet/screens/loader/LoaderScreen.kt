package com.coding.meet.screens.loader

import androidx.compose.runtime.Composable
import com.coding.meet.util.Constants
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.AnimationDirection
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

@Composable
fun LoaderScreen(colorMode: ColorMode) {
    Column(
        modifier = Modifier.fillMaxSize().backgroundColor(
            customColor(
                colorMode = colorMode,
                lightColor = Theme.White,
                darkColor = Theme.DarkCardBackGroundColor
            )
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.animation(
                LogoAnimationStyle.toAnimation(
                    duration = 2.s,
                    iterationCount = AnimationIterationCount.Infinite,
                    timingFunction = AnimationTimingFunction.Linear,
                    direction = AnimationDirection.Alternate
                )
            ),
            src = when (colorMode) {
                ColorMode.LIGHT -> Res.Image.LOGO_LIGHT
                ColorMode.DARK -> Res.Image.LOGO_DARK
            },
            alt = "Logo Image"
        )
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
                .margin(top = 8.px)
                .animation(
                    fadeInUpTextAnimation.toAnimation(
                        duration = 1.s,
                        timingFunction = AnimationTimingFunction.EaseOut
                    )
                )
                .fontWeight(FontWeight.Bold)
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