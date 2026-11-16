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
import com.coding.meet.util.select
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Hr

@Composable
fun ServiceCard(
    service: Service,
    onImageClick: ((Service, Int) -> Unit)? = null
) {
    val colorMode by ColorMode.currentState
    val breakpoint = rememberBreakpoint()
    val isDesktop = breakpoint > Breakpoint.MD

    SimpleGrid(
        numColumns = numColumns(base = 1, sm = 1, md = 1, lg = 2, xl = 2),
        modifier = ServiceCardStyle.toModifier()
            .fillMaxWidth()
            .margin(bottom = 32.px)
            .padding(all = if (isDesktop) 28.px else 18.px)
            .gap(if (isDesktop) 28.px else 18.px)
    ) {
        // Left Column: Large Image Slider + Technology Tags
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (service.imageUrls.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .cursor(Cursor.Pointer)
                        .onClick { onImageClick?.invoke(service, 0) }
                ) {
                    ImageSliderWithDot(
                        imageList = service.imageUrls,
                        showIndicators = service.imageUrls.size > 1,
                        showControls = service.imageUrls.size > 1,
                        autoPlay = false,
                        onImageClick = { index -> onImageClick?.invoke(service, index) }
                    )
                }

                // Tech Tags under the Image
                if (service.tags.isNotEmpty()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.px)
                            .display(DisplayStyle.Flex)
                            .flexWrap(FlexWrap.Wrap)
                            .gap(8.px),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        service.tags.forEach { tag ->
                            Box(
                                modifier = Modifier
                                    .backgroundColor(
                                        colorMode.select(
                                            Theme.Primary.subtle,
                                            Theme.Primary.soft
                                        )
                                    )
                                    .border(
                                        width = 1.px,
                                        style = LineStyle.Solid,
                                        color = colorMode.select(
                                            Theme.Primary.medium,
                                            Theme.Primary.strong
                                        )
                                    )
                                    .borderRadius(9999.px)
                                    .padding(leftRight = 12.px, topBottom = 6.px)
                            ) {
                                SpanText(
                                    text = tag,
                                    modifier = Modifier
                                        .fontSize(0.8.cssRem)
                                        .fontWeight(FontWeight.SemiBold)
                                        .color(
                                            colorMode.select(
                                                Theme.Primary.color,
                                                Theme.White.color
                                            )
                                        )
                                )
                            }
                        }
                    }
                }
            }
        }

        // Right Column: Service Details & Features Checklist
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            // Header: Title & Description
            Column(modifier = Modifier.fillMaxWidth()) {
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
                        .fontSize(if (isDesktop) 1.5.cssRem else 1.3.cssRem)
                        .fontWeight(FontWeight.Bold)
                        .textAlign(if (isDesktop) TextAlign.Start else TextAlign.Center)
                )

                SpanText(
                    text = service.description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.px, bottom = 12.px)
                        .color(CustomColor(lightColor = Theme.DarkGray, darkColor = Theme.Muted))
                        .fontSize(0.94.cssRem)
                        .lineHeight(1.6)
                        .textAlign(if (isDesktop) TextAlign.Start else TextAlign.Center)
                )
            }

            // Features Checklist
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

                SimpleGrid(
                    numColumns = numColumns(base = 1, sm = 1, md = 1, lg = 1, xl = 1),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.px)
                        .gap(8.px)
                ) {
                    service.features.forEach { feature ->
                        Row(
                            modifier = Modifier.fillMaxWidth().gap(6.px),
                            verticalAlignment = Alignment.Top
                        ) {
                            SpanText(
                                text = "✓",
                                modifier = Modifier
                                    .color(Theme.Primary.color)
                                    .fontWeight(FontWeight.Bold)
                                    .fontSize(0.88.cssRem)
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
                                    .fontSize(0.84.cssRem)
                                    .lineHeight(1.4)
                            )
                        }
                    }
                }

                Hr(
                    attrs = Modifier
                        .fillMaxWidth()
                        .margin(bottom = 16.px)
                        .border(
                            color = colorMode.toPalette().border,
                            style = LineStyle.Solid,
                            width = 1.px
                        )
                        .toAttrs()
                )
            }

            // Action Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = if (isDesktop) Arrangement.Start else Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
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
}
