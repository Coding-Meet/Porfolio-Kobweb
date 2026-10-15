package com.coding.meet.common.components.custom_dialog

import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backdropFilter
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.left
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.translateY
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.base
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import com.coding.meet.util.select
import com.coding.meet.util.glassSubtle

val dialogEntranceAnimation = Keyframes {
    from {
        Modifier
            .opacity(0)
            .scale(0.96)
            .translateY(12.px)
    }
    to {
        Modifier
            .opacity(1)
            .scale(1.0)
            .translateY(0.px)
    }
}

val DialogStyle = CssStyle.base {
    Modifier
        .display(DisplayStyle.None)
        .position(Position.Fixed)
        .zIndex(2000)
        .left(0.px)
        .top(0.px)
        .overflow(Overflow.Auto)
        .backgroundColor(Theme.Black.strong)
        .backdropFilter(blur(12.px))
        .fillMaxSize()
        .padding(topBottom = 28.px)
}

val DialogContentStyle = CssStyle.base {
    Modifier
        .margin(autoLength)
        .padding(26.px)
        .borderRadius(22.px)
        .border(
            color = colorMode.glassSubtle,
            style = LineStyle.Solid,
            width = 1.px
        )
        .styleModifier {
            property(
                "box-shadow",
                if (colorMode.isLight) {
                    "0 24px 60px ${Theme.Black.soft}, 0 0 32px ${Theme.Primary.subtle}"
                } else {
                    "0 28px 70px ${Theme.Black.strong}, 0 0 40px ${Theme.Primary.soft}"
                }
            )
            property("backdrop-filter", "blur(20px)")
            property("-webkit-backdrop-filter", "blur(20px)")
        }
        .backgroundColor(
            colorMode.select(Theme.White.strong, Theme.DarkCardBackGroundColor.strong)
        )
}
