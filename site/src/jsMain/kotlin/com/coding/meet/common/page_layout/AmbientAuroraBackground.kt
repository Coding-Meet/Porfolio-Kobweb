package com.coding.meet.common.page_layout

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.left
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import com.coding.meet.util.Theme

/**
 * Reusable full-page ambient aurora glow and subtle micro-dot grid pattern background.
 * Used across both PageLayout and LoaderScreen to ensure seamless visual consistency.
 */
@Composable
fun AmbientAuroraBackground(
    colorMode: ColorMode,
    position: Position = Position.Fixed,
    zIndex: Int = 0
) {
    // Full Page Ambient Aurora Background Effect
    Box(
        modifier = Modifier
            .fillMaxSize()
            .position(position)
            .top(0.px)
            .left(0.px)
            .zIndex(zIndex)
            .styleModifier {
                property(
                    "background",
                    if (colorMode.isDark) {
                        "radial-gradient(ellipse 90% 55% at 50% -10%, ${Theme.Primary.soft} 0%, transparent 70%), " +
                        "radial-gradient(circle 650px at 12% 85%, ${Theme.Primary.soft} 0%, transparent 70%), " +
                        "radial-gradient(circle 550px at 88% 45%, ${Theme.Primary.subtle} 0%, transparent 70%)"
                    } else {
                        "radial-gradient(ellipse 95% 65% at 50% -10%, ${Theme.Primary.soft} 0%, ${Theme.PrimaryLight.subtle} 45%, transparent 75%), " +
                        "radial-gradient(circle 700px at 10% 85%, ${Theme.Primary.soft} 0%, ${Theme.Teal.subtle} 40%, transparent 70%), " +
                        "radial-gradient(circle 600px at 90% 45%, ${Theme.Primary.soft} 0%, transparent 70%)"
                    }
                )
                property("pointer-events", "none")
            }
    )

    // Subtle Faded Micro-Dot Grid Pattern
    Box(
        modifier = Modifier
            .fillMaxSize()
            .position(position)
            .top(0.px)
            .left(0.px)
            .zIndex(zIndex)
            .styleModifier {
                property(
                    "background-image",
                    if (colorMode.isDark) {
                        "radial-gradient(${Theme.White.soft} 1px, transparent 1px)"
                    } else {
                        "radial-gradient(${Theme.DarkSurface.soft} 1px, transparent 1px)"
                    }
                )
                property("background-size", "24px 24px")
                property(
                    "mask-image",
                    if (colorMode.isDark) {
                        "radial-gradient(ellipse 80% 75% at 50% 30%, black 30%, transparent 85%)"
                    } else {
                        "radial-gradient(ellipse 80% 75% at 50% 30%, black 25%, transparent 85%)"
                    }
                )
                property(
                    "-webkit-mask-image",
                    if (colorMode.isDark) {
                        "radial-gradient(ellipse 80% 75% at 50% 30%, black 30%, transparent 85%)"
                    } else {
                        "radial-gradient(ellipse 80% 75% at 50% 30%, black 25%, transparent 85%)"
                    }
                )
                property("pointer-events", "none")
            }
    )
}
