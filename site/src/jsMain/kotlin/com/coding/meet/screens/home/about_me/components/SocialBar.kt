package com.coding.meet.screens.home.about_me.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.coding.meet.screens.home.about_me.styles.SocialIconButtonStyle
import com.coding.meet.util.SocialData.socials
import com.varabyte.kobweb.browser.dom.ElementTarget
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.left
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.overlay.PopupPlacement
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

private val ORBIT_ANGLES = listOf(170.0, 150.0, 130.0, 110.0, 90.0, 70.0, 50.0, 30.0, 10.0)

@Composable
fun SocialBar(
    avatarRadius: Int = 175,
    orbitRadius: Int = 218,
    iconBoxSize: Int = 48,
    iconImageSize: Int = 25,
    modifier: Modifier = Modifier
) {
    val colorMode by ColorMode.currentState

    socials.forEachIndexed { index, social ->
        val angleDeg = ORBIT_ANGLES.getOrElse(index) { 90.0 }
        val angleRad = angleDeg * PI / 180.0
        val x = (orbitRadius * cos(angleRad)).roundToInt()
        val y = (orbitRadius * sin(angleRad)).roundToInt()

        Box(
            modifier = modifier
                .position(Position.Absolute)
                .left(50.percent)
                .top(avatarRadius.px)
                .styleModifier {
                    property("transform", "translate(calc(-50% + ${x}px), calc(-50% + ${y}px))")
                    property("z-index", "20")
                }
        ) {
            Box(
                modifier = SocialIconButtonStyle.toModifier()
                    .size(iconBoxSize.px)
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
                        .size(iconImageSize.px)
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
                placement = PopupPlacement.Bottom
            )
        }
    }
}