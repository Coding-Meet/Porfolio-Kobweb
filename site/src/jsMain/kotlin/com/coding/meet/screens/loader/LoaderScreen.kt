package com.coding.meet.screens.loader

import androidx.compose.runtime.Composable
import com.coding.meet.util.Constants
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.*

@Composable
fun LoaderScreen(colorMode: ColorMode) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .position(Position.Fixed)
            .top(0.px)
            .left(0.px)
            .zIndex(100)
            .backgroundColor(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.White,
                    darkColor = Theme.DarkCardBackGroundColor
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
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
                        customColor(
                            colorMode = colorMode,
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
                        customColor(
                            colorMode = colorMode,
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
}
