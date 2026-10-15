package com.coding.meet.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color

import org.jetbrains.compose.web.css.rgba

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

    // Centralized Design Tokens
    Transparent(color = Color.transparent, rgb = rgbColor.rgba(0, 0, 0, 0)),
    DarkBorder(color = Color("#1E293B"), rgb = rgbColor.rgb(30, 41, 59)),
    LightBorder(color = Color("#E2E8F0"), rgb = rgbColor.rgb(226, 232, 240)),
    DarkBackground(color = Color("#0B0F19"), rgb = rgbColor.rgb(11, 15, 25)),
    DarkSurface(color = Color("#0F172A"), rgb = rgbColor.rgb(15, 23, 42)),
    PrimaryLight(color = Color("#34D399"), rgb = rgbColor.rgb(52, 211, 153)),
    PrimaryDark(color = Color("#059669"), rgb = rgbColor.rgb(5, 150, 105)),
    Teal(color = Color("#2DD4BF"), rgb = rgbColor.rgb(45, 212, 191)),

    // Code Syntax Tokens
    CodeBackground(color = Color("#1E1E1E"), rgb = rgbColor.rgb(30, 30, 30)),
    CodeText(color = Color("#D4D4D4"), rgb = rgbColor.rgb(212, 212, 212)),
    CodeAccent(color = Color("#9CDCFE"), rgb = rgbColor.rgb(156, 220, 254)),
    CodeComment(color = Color("#858585"), rgb = rgbColor.rgb(133, 133, 133)),
    CodeMuted(color = Color("#CCCCCC"), rgb = rgbColor.rgb(204, 204, 204));

    fun toRgba(alpha: Number): CSSColorValue {
        val c = rgb.toRgb()
        return rgba(c.red, c.green, c.blue, alpha)
    }

    fun toRgbColor(alpha: Float = 1f): rgbColor {
        return rgb.toRgb().copyf(alpha = alpha)
    }

    // Standardized Design System Opacity Tiers
    val subtle: CSSColorValue get() = toRgba(0.08)
    val soft: CSSColorValue get() = toRgba(0.15)
    val medium: CSSColorValue get() = toRgba(0.30)
    val strong: CSSColorValue get() = toRgba(0.60)

    val subtleRgb: rgbColor get() = toRgbColor(0.08f)
    val softRgb: rgbColor get() = toRgbColor(0.15f)
    val mediumRgb: rgbColor get() = toRgbColor(0.30f)
    val strongRgb: rgbColor get() = toRgbColor(0.60f)
}

fun primaryRgba(alpha: Number): CSSColorValue = Theme.Primary.toRgba(alpha)
fun whiteRgba(alpha: Number): CSSColorValue = Theme.White.toRgba(alpha)
fun blackRgba(alpha: Number): CSSColorValue = Theme.Black.toRgba(alpha)

fun ColorMode.backgroundRgba(alpha: Number): CSSColorValue {
    return if (this.isLight) Theme.LightBackGroundColor.toRgba(alpha)
    else Theme.DarkBackground.toRgba(alpha)
}

fun <T> ColorMode.select(light: T, dark: T): T = if (this.isLight) light else dark

val ColorMode.glassSubtle: CSSColorValue get() = if (this.isLight) Theme.Black.subtle else Theme.White.subtle
val ColorMode.glassSoft: CSSColorValue get() = if (this.isLight) Theme.Black.soft else Theme.White.soft
val ColorMode.glassBorder: CSSColorValue get() = if (this.isLight) Theme.LightBorder.color else Theme.White.soft
val ColorMode.cardBg: CSSColorValue get() = if (this.isLight) Theme.White.color else Theme.DarkCardBackGroundColor.color

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