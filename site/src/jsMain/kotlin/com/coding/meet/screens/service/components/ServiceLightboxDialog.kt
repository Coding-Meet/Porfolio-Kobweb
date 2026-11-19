package com.coding.meet.screens.service.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.common.image_slider_with_dot.ControlButtonStyle
import com.coding.meet.common.image_slider_with_dot.IndicatorStyle
import com.coding.meet.common.image_slider_with_dot.IndicatorsStyle
import com.coding.meet.common.image_slider_with_dot.MainButtonStyle
import com.coding.meet.models.Service
import com.coding.meet.models.contactMePath
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.coding.meet.util.select
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.left
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.right
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text

@Composable
fun ServiceLightboxDialog(
    service: Service,
    initialIndex: Int = 0,
    onDismiss: () -> Unit
) {
    val colorMode by ColorMode.currentState
    var currentIndex by remember(service, initialIndex) { mutableStateOf(initialIndex) }
    val lastIndex = (service.imageUrls.size - 1).coerceAtLeast(0)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 4.px),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header: Service Title, Counter, and Close Button
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.px),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                SpanText(
                    text = service.title,
                    modifier = Modifier
                        .color(CustomColor(lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor))
                        .fontFamily(Res.Font.FONT_FAMILY_HEADING)
                        .fontSize(1.35.cssRem)
                        .fontWeight(FontWeight.Bold)
                )
                if (service.imageUrls.size > 1) {
                    SpanText(
                        text = "Slide ${currentIndex + 1} of ${service.imageUrls.size}",
                        modifier = Modifier
                            .padding(top = 4.px)
                            .color(Theme.Primary.color)
                            .fontSize(0.85.cssRem)
                            .fontWeight(FontWeight.SemiBold)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .size(36.px)
                    .borderRadius(50.percent)
                    .backgroundColor(colorMode.select(Theme.White.strong, Theme.Black.soft))
                    .cursor(Cursor.Pointer)
                    .onClick { onDismiss() },
                contentAlignment = Alignment.Center
            ) {
                CloseIcon(modifier = Modifier.size(16.px))
            }
        }

        // Full HD Image View (16:9 Aspect Ratio)
        if (service.imageUrls.isNotEmpty()) {
            val currentImg = service.imageUrls.getOrNull(currentIndex) ?: service.imageUrls[0]
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .borderRadius(14.px)
                    .overflow(Overflow.Hidden)
                    .boxShadow(0.px, 12.px, 32.px, null, Theme.Black.strong)
                    .position(Position.Relative)
                    .styleModifier {
                        property("aspect-ratio", "16 / 9")
                    }
            ) {
                Img(
                    src = currentImg,
                    alt = service.title,
                    attrs = Modifier
                        .fillMaxSize()
                        .toAttrs {
                            style {
                                property("width", "100%")
                                property("height", "100%")
                                property("object-fit", "contain")
                                property("background-color", "#0b0f19")
                            }
                        }
                )

                // Navigation Controls
                if (service.imageUrls.size > 1) {
                    Button(
                        attrs = ControlButtonStyle.toAttrs {
                            style { left(12.px) }
                            onClick {
                                it.stopPropagation()
                                currentIndex = if (currentIndex > 0) currentIndex - 1 else lastIndex
                            }
                        }
                    ) {
                        Text(Res.Strings.PREVIOUS)
                    }

                    Button(
                        attrs = ControlButtonStyle.toAttrs {
                            style { right(12.px) }
                            onClick {
                                it.stopPropagation()
                                currentIndex = (currentIndex + 1) % service.imageUrls.size
                            }
                        }
                    ) {
                        Text(Res.Strings.NEXT)
                    }

                    // Indicators
                    Div(attrs = IndicatorsStyle.toAttrs()) {
                        service.imageUrls.forEachIndexed { index, _ ->
                            Div(
                                attrs = IndicatorStyle.toModifier().onClick {
                                    currentIndex = index
                                }.toAttrs {
                                    if (index == currentIndex) style {
                                        backgroundColor(Theme.Primary.color)
                                        property("width", "24px")
                                        property("border-radius", "6px")
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }

        // Footer CTA
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 18.px),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SpanText(
                text = "💡 Need this custom development for your app? Let's discuss your project.",
                modifier = Modifier
                    .color(CustomColor(lightColor = Theme.DarkGray, darkColor = Theme.Muted))
                    .fontSize(0.9.cssRem)
            )

            Link(
                path = contactMePath,
                modifier = Modifier.textDecorationLine(TextDecorationLine.None)
            ) {
                Button(attrs = MainButtonStyle.toAttrs()) {
                    SpanText(text = "${Res.Strings.CONTACT_ME} →")
                }
            }
        }
    }
}
