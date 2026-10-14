package com.coding.meet.screens.contact_me.styles

import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.outline
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

val formStyle = CssStyle {
    val commonFormInputFormTextAreaModifier = Modifier
        .fillMaxWidth()
        .background(
            customColor(
                colorMode = colorMode,
                lightColor = Theme.LightCardBackGroundColor,
                darkColor = Theme.DarkCardBackGroundColor
            )
        )
        .border(color = colorMode.toPalette().border, style = LineStyle.Solid, width = 1.px)
        .borderRadius(14.px)
        .color(
            customColor(
                colorMode = colorMode,
                lightColor = Theme.LightFontColor,
                darkColor = Theme.DarkFontColor
            )
        )
        .margin(topBottom = 8.px)
        .padding(14.px, 20.px)
        .fontWeight(500)
        .fontSize(16.px)
        .letterSpacing(0.4.px)
        .outline(0.px)
        .transition(Transition.all(200.ms))

    cssRule(" input") {
        commonFormInputFormTextAreaModifier
    }
    cssRule(" textarea") {
        commonFormInputFormTextAreaModifier
    }
    cssRule(" input:focus") {
        Modifier
            .outline(0.px)
            .border(1.px, LineStyle.Solid, Theme.Primary.color)
            .boxShadow(0.px, 0.px, 0.px, 3.px, rgba(16, 185, 129, 0.2))
    }
    cssRule(" textarea:focus") {
        Modifier
            .outline(0.px)
            .border(1.px, LineStyle.Solid, Theme.Primary.color)
            .boxShadow(0.px, 0.px, 0.px, 3.px, rgba(16, 185, 129, 0.2))
    }
    cssRule(" input::placeholder") {
        Modifier
            .fontSize(15.px)
            .fontWeight(400)
            .color(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.DarkGray,
                    darkColor = Theme.Muted
                )
            )
            .opacity(0.7)
    }
    cssRule(" textarea::placeholder") {
        Modifier
            .fontSize(15.px)
            .fontWeight(400)
            .color(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.DarkGray,
                    darkColor = Theme.Muted
                )
            )
            .opacity(0.7)
    }
}