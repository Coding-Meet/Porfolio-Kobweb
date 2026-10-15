package com.coding.meet.screens.loader

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.common.page_layout.AmbientAuroraBackground
import com.coding.meet.util.AppInfo.GREETINGS
import com.coding.meet.util.AppInfo.WELCOME_TEXT
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.*

@Composable
fun LoaderScreen(colorMode: ColorMode) {
    var greetingIndex by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(220)
            greetingIndex = (greetingIndex + 1) % GREETINGS.size
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .position(Position.Fixed)
            .top(0.px)
            .left(0.px)
            .zIndex(9999)
            .backgroundColor(
                if (colorMode.isDark) {
                    Theme.DarkBackground.rgb
                } else {
                    Theme.LightBackGroundColor.rgb
                }
            )
            .styleModifier {
                property("isolation", "isolate")
            },
        contentAlignment = Alignment.Center
    ) {
        AmbientAuroraBackground(
            colorMode = colorMode,
            zIndex = 0
        )

        Column(
            modifier = Modifier.position(Position.Relative).zIndex(1),
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
                text = "🙏",
                modifier = NamasteEmojiStyle.toModifier()
                    .margin(top = 16.px)
                    .fontSize(36.px)
            )

            SpanText(
                text = GREETINGS[greetingIndex],
                modifier = Modifier
                    .margin(top = 8.px)
                    .fontSize(30.px)
                    .fontFamily(Res.Font.FONT_FAMILY_HEADING)
                    .fontWeight(FontWeight.Bold)
                    .color(
                        customColor(
                            colorMode = colorMode,
                            lightColor = Theme.LightFontColor,
                            darkColor = Theme.DarkFontColor
                        )
                    )
            )

            SpanText(
                text = WELCOME_TEXT,
                modifier = Modifier
                    .fontSize(17.px)
                    .textAlign(TextAlign.Center)
                    .fontFamily(Res.Font.FONT_FAMILY_REGULAR)
                    .color(
                        customColor(
                            colorMode = colorMode,
                            lightColor = Theme.DarkGray,
                            darkColor = Theme.Muted
                        )
                    )
                    .margin(top = 6.px)
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
