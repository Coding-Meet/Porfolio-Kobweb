package com.coding.meet.pages

import androidx.compose.runtime.Composable
import com.coding.meet.common.components.footer.Footer
import com.coding.meet.common.page_layout.PageLayout
import com.coding.meet.models.Section
import com.coding.meet.models.servicePath
import com.coding.meet.screens.service.components.FAQCard
import com.coding.meet.screens.service.components.ServiceCard
import com.coding.meet.util.Constants
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Page(servicePath)
@Composable
fun ServiceSection() {
    val breakpoint = rememberBreakpoint()
    PageLayout(
        title = Section.SERVICE.title
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            SpanText(
                text = "\uD83D\uDE80 Get Your Android App Built & Fixed!",
                modifier = Modifier.fillMaxWidth().padding(topBottom = 10.px, leftRight = 10.px)
                    .color(
                        CustomColor(
                            lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                        )
                    ).fontSize(2.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
            )

            SpanText(
                text = "I help businesses and individuals build Android apps, fix problems, and improve performance. Whether you need a new app, a chatbot, or a small fix, I’m here to help!",
                modifier = Modifier.fillMaxWidth(
                    if (breakpoint > Breakpoint.MD) 70.percent else 90.percent

                ).padding(topBottom = 5.px, leftRight = 20.px).color(
                    CustomColor(
                        lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                    )
                ).fontSize(1.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
            )
            SimpleGrid(
                numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 2, xl = 2),
                modifier = Modifier.fillMaxWidth(
                    if (breakpoint > Breakpoint.MD) 70.percent else 90.percent
                ).padding(topBottom = 10.px)
            ) {
                Constants.services.forEach { service ->
                    ServiceCard(service)
                }
            }
            SpanText(
                text = "\uD83D\uDE4B FAQ",
                modifier = Modifier.fillMaxWidth().padding(topBottom = 10.px, leftRight = 10.px)
                    .color(
                        CustomColor(
                            lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                        )
                    ).fontSize(2.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
            )

            SpanText(
                text = "Here are the most common questions to help you with your decision.",
                modifier = Modifier.fillMaxWidth(
                    if (breakpoint > Breakpoint.MD) 70.percent else 90.percent

                ).padding(topBottom = 5.px, leftRight = 20.px).color(
                    CustomColor(
                        lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                    )
                ).fontSize(1.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
            )
            SimpleGrid(
                numColumns = numColumns(base = 1, sm = 1, md = 1, lg = 1, xl = 1),
                modifier = Modifier.fillMaxWidth(
                    if (breakpoint > Breakpoint.MD) 70.percent else 90.percent
                ).padding(topBottom = 10.px)
            ) {
                Constants.faqs.forEach { faq ->
                    FAQCard(faq)
                }
            }
            Footer()
        }
    }
}