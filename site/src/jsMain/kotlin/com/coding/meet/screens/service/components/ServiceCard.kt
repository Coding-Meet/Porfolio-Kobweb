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
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
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
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Ul

@Composable
fun ServiceCard(
    service: Service
) {
    val colorMode by ColorMode.currentState

    Column(
        modifier = ServiceCardStyle.toModifier().margin(10.px).padding(10.px),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (service.imageUrls.isNotEmpty()) {
            ImageSliderWithDot(
                imageList = service.imageUrls,
                showIndicators = service.imageUrls.size > 1,
                showControls = false
            )
            Hr(
                attrs = Modifier.fillMaxWidth().border(
                    color = colorMode.toPalette().border, style = LineStyle.Solid, width = 2.px
                ).toAttrs()
            )
        }
        SpanText(
            text = service.title,
            modifier = Modifier.fillMaxWidth().padding(leftRight = 10.px).color(
                CustomColor(
                    lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                )
            ).fontSize(1.5.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
        )
        SpanText(
            text = service.description,
            modifier = Modifier.fillMaxWidth().padding(top = 5.px, leftRight = 10.px).color(
                CustomColor(
                    lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                )
            ).fontSize(1.cssRem).textAlign(TextAlign.Center)
        )
        Hr(
            attrs = Modifier.fillMaxWidth().border(
                color = colorMode.toPalette().border, style = LineStyle.Solid, width = 2.px
            ).toAttrs()
        )
        if (service.features.isNotEmpty()) {
            Ul {
                service.features.forEach {
                    Li(
                        attrs  = Modifier.fillMaxWidth().padding(leftRight = 10.px).toAttrs()
                    ) {
                        SpanText(
                            text = it,

                        )
                    }
                }
            }
            Hr(
                attrs = Modifier.fillMaxWidth().border(
                    color = colorMode.toPalette().border, style = LineStyle.Solid, width = 2.px
                ).toAttrs()
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.px, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Link(path = contactMePath) {
                Button(
                    attrs = MainButtonStyle.toAttrs()
                ) {
                    SpanText(
                        text = Res.Strings.CONTACT_ME,
                    )
                }
            }
        }
    }
}

