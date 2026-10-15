package com.coding.meet.screens.service.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.coding.meet.common.image_slider_with_dot.ImageSliderWithDot
import com.coding.meet.common.image_slider_with_dot.MainButtonStyle
import com.coding.meet.models.Service
import com.coding.meet.models.contactMePath
import com.coding.meet.screens.service.styles.ServiceCardStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Hr

@Composable
fun ServiceCard(
    service: Service
) {
    val colorMode by ColorMode.currentState

    Column(
        modifier = ServiceCardStyle.toModifier()
            .margin(10.px)
            .padding(all = 20.px),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (service.imageUrls.isNotEmpty()) {
            Column(modifier = Modifier.fillMaxWidth().padding(bottom = 14.px)) {
                ImageSliderWithDot(
                    imageList = service.imageUrls,
                    showIndicators = service.imageUrls.size > 1,
                    showControls = false
                )
            }
        }

        Column(modifier = Modifier.fillMaxWidth().padding(bottom = 12.px)) {
            SpanText(
                text = service.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .color(
                        CustomColor(
                            lightColor = Theme.LightFontColor,
                            darkColor = Theme.DarkFontColor
                        )
                    )
                    .fontFamily(Res.Font.FONT_FAMILY_HEADING)
                    .fontSize(1.35.cssRem)
                    .fontWeight(FontWeight.Bold)
                    .textAlign(TextAlign.Center)
            )
            SpanText(
                text = service.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.px, leftRight = 4.px)
                    .color(CustomColor(lightColor = Theme.DarkGray, darkColor = Theme.Muted))
                    .fontSize(0.92.cssRem)
                    .lineHeight(1.55)
                    .textAlign(TextAlign.Center)
            )
        }

        if (service.features.isNotEmpty()) {
            Hr(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 10.px)
                    .border(
                        color = colorMode.toPalette().border,
                        style = LineStyle.Solid,
                        width = 1.px
                    )
                    .toAttrs()
            )
            Column(
                modifier = Modifier.fillMaxWidth().padding(leftRight = 4.px, topBottom = 6.px)
                    .gap(8.px)
            ) {
                service.features.forEach { feature ->
                    Row(
                        modifier = Modifier.fillMaxWidth().gap(8.px),
                        verticalAlignment = Alignment.Top
                    ) {
                        SpanText(
                            text = "✓",
                            modifier = Modifier
                                .color(Theme.Primary.color)
                                .fontWeight(FontWeight.Bold)
                                .fontSize(0.9.cssRem)
                        )
                        SpanText(
                            text = feature,
                            modifier = Modifier
                                .color(
                                    CustomColor(
                                        lightColor = Theme.LightFontColor,
                                        darkColor = Theme.DarkFontColor
                                    )
                                )
                                .fontSize(0.88.cssRem)
                                .lineHeight(1.5)
                        )
                    }
                }
            }
            Hr(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 12.px)
                    .border(
                        color = colorMode.toPalette().border,
                        style = LineStyle.Solid,
                        width = 1.px
                    )
                    .toAttrs()
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth().margin(top = 4.px),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Link(
                path = contactMePath,
                modifier = Modifier.textDecorationLine(TextDecorationLine.None)
            ) {
                Button(
                    attrs = MainButtonStyle.toAttrs()
                ) {
                    SpanText(
                        text = "${Res.Strings.CONTACT_ME} →",
                    )
                }
            }
        }
    }
}
