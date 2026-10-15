package com.coding.meet.pages

import androidx.compose.runtime.Composable
import com.coding.meet.common.components.footer.Footer
import com.coding.meet.common.page_layout.PageLayout
import com.coding.meet.common.page_layout.fadeInUpPageAnimation
import com.coding.meet.models.Section
import com.coding.meet.models.servicePath
import com.coding.meet.screens.service.components.FAQCard
import com.coding.meet.screens.service.components.ServiceCard
import com.coding.meet.util.CustomColor
import com.coding.meet.util.FAQData.faqs
import com.coding.meet.util.Res
import com.coding.meet.util.ServiceData.services
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

@Page(servicePath)
@Composable
fun ServiceSection() {
    val breakpoint = rememberBreakpoint()
    PageLayout(
        title = Section.SERVICE.title
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .animation(
                    fadeInUpPageAnimation.toAnimation(
                        duration = 1.s,
                        timingFunction = AnimationTimingFunction.EaseOut
                    )
                ),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpanText(
                text = "⚡ Professional Engineering Services",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.px, bottom = 6.px, leftRight = 10.px)
                    .color(
                        CustomColor(
                            lightColor = Theme.LightFontColor,
                            darkColor = Theme.DarkFontColor
                        )
                    )
                    .fontFamily(Res.Font.FONT_FAMILY_HEADING)
                    .fontSize(if (breakpoint > Breakpoint.SM) 2.2.cssRem else 1.7.cssRem)
                    .fontWeight(FontWeight.Bold)
                    .textAlign(TextAlign.Center)
            )

            SpanText(
                text = "From greenfield mobile apps and KMP cross-platform systems to performance audit & bug triage.",
                modifier = Modifier
                    .fillMaxWidth(if (breakpoint > Breakpoint.MD) 65.percent else 90.percent)
                    .padding(bottom = 28.px, leftRight = 20.px)
                    .color(
                        CustomColor(
                            lightColor = Theme.DarkGray,
                            darkColor = Theme.Muted
                        )
                    )
                    .fontSize(1.0.cssRem)
                    .lineHeight(1.6)
                    .textAlign(TextAlign.Center)
            )

            SimpleGrid(
                numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 2, xl = 2),
                modifier = Modifier
                    .fillMaxWidth(if (breakpoint > Breakpoint.MD) 75.percent else 92.percent)
                    .padding(bottom = 36.px)
            ) {
                services.forEach { service ->
                    ServiceCard(service)
                }
            }

            SpanText(
                text = "🙋 Frequently Asked Questions",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.px, bottom = 6.px, leftRight = 10.px)
                    .color(
                        CustomColor(
                            lightColor = Theme.LightFontColor,
                            darkColor = Theme.DarkFontColor
                        )
                    )
                    .fontFamily(Res.Font.FONT_FAMILY_HEADING)
                    .fontSize(if (breakpoint > Breakpoint.SM) 2.0.cssRem else 1.6.cssRem)
                    .fontWeight(FontWeight.Bold)
                    .textAlign(TextAlign.Center)
            )

            SpanText(
                text = "Everything you need to know about working together, timelines, and deliverables.",
                modifier = Modifier
                    .fillMaxWidth(if (breakpoint > Breakpoint.MD) 65.percent else 90.percent)
                    .padding(bottom = 24.px, leftRight = 20.px)
                    .color(
                        CustomColor(
                            lightColor = Theme.DarkGray,
                            darkColor = Theme.Muted
                        )
                    )
                    .fontSize(1.0.cssRem)
                    .lineHeight(1.6)
                    .textAlign(TextAlign.Center)
            )

            SimpleGrid(
                numColumns = numColumns(base = 1, sm = 1, md = 1, lg = 1, xl = 1),
                modifier = Modifier
                    .fillMaxWidth(if (breakpoint > Breakpoint.MD) 75.percent else 92.percent)
                    .padding(bottom = 36.px)
            ) {
                faqs.forEach { faq ->
                    FAQCard(faq)
                }
            }

            Footer()
        }
    }
}