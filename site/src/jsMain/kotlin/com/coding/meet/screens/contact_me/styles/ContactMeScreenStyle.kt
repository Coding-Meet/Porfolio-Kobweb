package com.coding.meet.screens.contact_me.styles

import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.s


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
        .border(1.px, LineStyle.Solid, rgba(255, 255, 255, 0.5))
        .borderRadius(20.px)
        .color(
            customColor(
                colorMode = colorMode,
                lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
            )
        )
        .margin(topBottom = 8.px)
        .padding(18.px,26.px)
        .fontWeight(500)
        .fontSize(18.px)
        .letterSpacing(0.8.px)
        .transition(Transition.of("ease-in-out", 0.3.s, null, null))

    cssRule(" input"){
        commonFormInputFormTextAreaModifier
    }
    cssRule(" textarea"){
        commonFormInputFormTextAreaModifier
    }
    cssRule(" input:focus"){
        Modifier
            .color(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                )
            )
    }
    cssRule(" textarea:focus"){
        Modifier
            .color(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                )
            )
    }
    cssRule(" input::placeholder"){
        Modifier.fontSize(16.px)
            .fontWeight(400)
            .color(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                )
            )
    }
    cssRule(" textarea::placeholder"){
        Modifier.fontSize(16.px)
            .fontWeight(400)
            .color(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                )
            )
    }
    cssRule(" input:focus::placeholder"){
        Modifier
            .color(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                )
            )
            .opacity(0.8)
    }
    cssRule(" textarea:focus::placeholder"){
        Modifier
            .color(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightFontColor, darkColor = Theme.DarkFontColor
                )
            )
            .opacity(0.8)
    }

}