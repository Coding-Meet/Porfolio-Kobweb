package com.coding.meet.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color

typealias rgbColor = com.varabyte.kobweb.compose.ui.graphics.Color

enum class Theme(
    val color: CSSColorValue,
    val rgb: rgbColor = rgbColor.rgb(16, 185, 129)
) {
    LightBackGroundColor(color = Color("#FAFBFC"), rgb = rgbColor.rgb(250, 251, 252)),
    LightFontColor(color = Color("#0F172A"), rgb = rgbColor.rgb(15, 23, 42)),
    DarkFontColor(color = Color("#F8FAFC"), rgb = rgbColor.rgb(248, 250, 252)),
    Primary(color = Color("#10B981"), rgb = rgbColor.rgb(16, 185, 129)),
    LightGray(color = Color("#F1F5F9"), rgb = rgbColor.rgb(241, 245, 249)),
    DarkGray(color = Color("#64748B"), rgb = rgbColor.rgb(100, 116, 139)),
    Black(color = Color.black, rgb = rgbColor.rgb(0, 0, 0)),
    White(color = Color.white, rgb = rgbColor.rgb(255, 255, 255)),
    LightCardBackGroundColor(color = Color("#FFFFFF"), rgb = rgbColor.rgb(255, 255, 255)),
    DarkCardBackGroundColor(color = Color("#111827"), rgb = rgbColor.rgb(17, 24, 39)),
    Muted(color = Color("#94A3B8"), rgb = rgbColor.rgb(148, 163, 184)),
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