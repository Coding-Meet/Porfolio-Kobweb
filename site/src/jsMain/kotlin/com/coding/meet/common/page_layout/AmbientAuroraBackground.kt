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
                        "radial-gradient(ellipse 90% 55% at 50% -10%, rgba(16, 185, 129, 0.20) 0%, transparent 70%), " +
                        "radial-gradient(circle 650px at 12% 85%, rgba(16, 185, 129, 0.12) 0%, transparent 70%), " +
                        "radial-gradient(circle 550px at 88% 45%, rgba(16, 185, 129, 0.09) 0%, transparent 70%)"
                    } else {
                        "radial-gradient(ellipse 95% 65% at 50% -10%, rgba(16, 185, 129, 0.18) 0%, rgba(52, 211, 153, 0.09) 45%, transparent 75%), " +
                        "radial-gradient(circle 700px at 10% 85%, rgba(16, 185, 129, 0.12) 0%, rgba(45, 212, 191, 0.06) 40%, transparent 70%), " +
                        "radial-gradient(circle 600px at 90% 45%, rgba(16, 185, 129, 0.11) 0%, transparent 70%)"
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
                        "radial-gradient(rgba(255, 255, 255, 0.11) 1px, transparent 1px)"
                    } else {
                        "radial-gradient(rgba(15, 23, 42, 0.11) 1px, transparent 1px)"
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
