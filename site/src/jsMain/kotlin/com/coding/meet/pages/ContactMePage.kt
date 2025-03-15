package com.coding.meet.pages

import androidx.compose.runtime.Composable
import com.coding.meet.common.components.footer.Footer
import com.coding.meet.common.page_layout.PageLayout
import com.coding.meet.models.Section
import com.coding.meet.models.contactMePath
import com.coding.meet.screens.contact_me.components.FormInput
import com.coding.meet.common.page_layout.fadeInUpPageAnimation
import com.coding.meet.util.CustomColor
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
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s


@Page(contactMePath)
@Composable
fun ContactMePage() {
    val breakpoint = rememberBreakpoint()

    PageLayout(
        title = Section.CONTACT_ME.title
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
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SpanText(
                    text = "\uD83D\uDE80 Let’s Build Something Amazing Together!",
                    modifier = Modifier.fillMaxWidth().padding(topBottom = 10.px, leftRight = 10.px)
                        .color(
                            CustomColor(
                                lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                            )
                        ).fontSize(2.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
                )
                SpanText(
                    text = "📩 Feel free to reach out – let’s collaborate and create something extraordinary!",
                    modifier = Modifier.fillMaxWidth(
                        if (breakpoint > Breakpoint.MD) 70.percent else 90.percent

                    ).padding(topBottom = 5.px, leftRight = 20.px).color(
                        CustomColor(
                            lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                        )
                    ).fontSize(1.2.cssRem).fontWeight(FontWeight.Bold).textAlign(TextAlign.Center)
                )
                FormInput()
            }
            Footer()
        }
    }
}