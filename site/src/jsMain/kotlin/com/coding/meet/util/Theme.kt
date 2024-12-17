package com.coding.meet.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color

typealias rgbColor = com.varabyte.kobweb.compose.ui.graphics.Color

enum class Theme(
    val color: CSSColorValue,
    val rgb: rgbColor = rgbColor.rgb(
        210,
        251,
        208
    )
) {
    LightBackGroundColor(color = Color("#D2FBD0")),
    DarkBackGroundColor(color = Color("#000000")),
    LightFontColor(color = Color("#013216")),
    DarkFontColor(color = Color("#03FA6E")),
    Primary(color = Color("#03FA6E")),
    Secondary(color = Color("#121D34")),
    Gray(color = Color("#CFCFCF")),
    LighterGray(color = Color("#F9F9F9")),
    LightGray(color = Color("#EDEDED")),
    DarkGray(color = Color("#5C5C5C")),
    Black(color = Color.black),
    White(color = Color.white),
    Blue(color = Color("#0095F6")),
    Green(color = Color("#00E676"))
}

@Composable
fun CustomColor(
    lightColor: Theme,
    darkColor: Theme
): CSSColorValue {
    val colorMode by ColorMode.currentState
    return when (colorMode) {
        ColorMode.LIGHT -> lightColor.color
        ColorMode.DARK -> darkColor.color
    }
}

fun customColor(
    colorMode: ColorMode,
    lightColor: Theme,
    darkColor: Theme
): CSSColorValue {
    return when (colorMode) {
        ColorMode.LIGHT -> lightColor.color
        ColorMode.DARK -> darkColor.color
    }
}

//#013216
//#03FC6F
//#D2FBD0