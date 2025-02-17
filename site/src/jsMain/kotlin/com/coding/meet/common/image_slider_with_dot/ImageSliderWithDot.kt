package com.coding.meet.common.image_slider_with_dot

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.left
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.right
import org.jetbrains.compose.web.css.transform
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text


@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun ImageSliderWithDot(
    imageList: List<String>,
    showControls: Boolean = true,
    showIndicators: Boolean = true,
    autoPlay: Boolean = true,
    interval: Int = 3000
) {
    var currentIndex by remember { mutableStateOf(0) }
    val lastIndex = imageList.size - 1
    val colorMode by ColorMode.currentState

    // Auto-Play Logic
    LaunchedEffect(autoPlay, currentIndex) {
        if (autoPlay) {
            delay(interval.toLong())
            currentIndex = (currentIndex + 1) % imageList.size
        }
    }

    Div(attrs = ImageSliderContainerStyle.toAttrs()) {
        // Slides
        Div(
            attrs = ImageSlideContainerStyle.toAttrs {
                style {
                    transform { translateX((-currentIndex * 100).percent) }
                }
            }
        ) {
            imageList.forEach { image ->

                Img(
                    src = image,
                    alt = "Project Image",
                    attrs = Modifier.fillMaxSize().borderRadius(10.px).toAttrs()
                )

            }
        }
        // Indicators
        if (showIndicators) {
            Div(attrs = IndicatorsStyle.toAttrs()) {
                imageList.forEachIndexed { index, _ ->
                    Div(
                        attrs = IndicatorStyle.toModifier().onClick {
                            currentIndex = index
                        }.toAttrs {
                            if (index == currentIndex) style {
                                backgroundColor(
                                    customColor(
                                        colorMode = colorMode,
                                        lightColor = Theme.LightFontColor,
                                        darkColor = Theme.DarkFontColor
                                    )
                                )
                            }
                        }
                    )
                }
            }
        }
        // Controls
        if (showControls) {
            Button(
                attrs = ControlButtonStyle.toAttrs {
                    style { left(10.px) }
                    onClick {
                        currentIndex = if (currentIndex > 0) currentIndex - 1 else lastIndex
                    }
                }
            ) {
                Text("<")
            }

            Button(
                attrs = ControlButtonStyle.toAttrs {
                    style { right(10.px) }
                    onClick {
                        currentIndex = (currentIndex + 1) % imageList.size
                    }
                }
            ) {
                Text(">")
            }
        }
    }
}

