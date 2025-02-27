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
    LightFontColor(color = Color("#013216")),
    DarkFontColor(color = Color("#FFFFFF")),
    Primary(color = Color("#03FA6E")),
    LightGray(color = Color("#EDEDED")),
    DarkGray(color = Color("#5C5C5C")),
    Black(color = Color.black),
    White(color = Color.white),
    LightCardBackGroundColor(color = Color("#f2f2f280")),
    DarkCardBackGroundColor(color = Color("#161616")),
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