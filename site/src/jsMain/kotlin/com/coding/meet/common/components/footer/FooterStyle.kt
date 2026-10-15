package com.coding.meet.common.components.footer

import com.coding.meet.util.Theme
import com.coding.meet.util.customColor
import com.coding.meet.util.select
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.borderTop
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val FooterStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .background(
                customColor(
                    colorMode = colorMode,
                    lightColor = Theme.LightCardBackGroundColor,
                    darkColor = Theme.DarkCardBackGroundColor
                )
            )
            .borderTop(1.px, LineStyle.Solid, colorMode.toPalette().border)
    }
    Breakpoint.ZERO {
        Modifier.padding(left = 16.px, right = 16.px, top = 20.px, bottom = 20.px)
    }
    Breakpoint.SM {
        Modifier.padding(left = 24.px, right = 24.px, top = 20.px, bottom = 20.px)
    }
    Breakpoint.MD {
        Modifier.padding(left = 40.px, right = 40.px, top = 24.px, bottom = 24.px)
    }
    Breakpoint.LG {
        Modifier.padding(left = 60.px, right = 60.px, top = 24.px, bottom = 24.px)
    }
    Breakpoint.XL {
        Modifier.padding(left = 100.px, right = 100.px, top = 24.px, bottom = 24.px)
    }
}

val FooterSocialButtonStyle = CssStyle {
    base {
        Modifier
            .size(34.px)
            .borderRadius(50.percent)
            .display(DisplayStyle.Flex)
            .alignItems(AlignItems.Center)
            .justifyContent(JustifyContent.Center)
            .cursor(Cursor.Pointer)
            .border(
                1.px,
                LineStyle.Solid,
                colorMode.select(colorMode.toPalette().border, Theme.White.soft)
            )
            .backgroundColor(
                colorMode.select(Theme.White.color, Theme.White.subtle)
            )
            .boxShadow(
                0.px,
                2.px,
                6.px,
                null,
                colorMode.select(Theme.Black.subtle, Theme.Black.medium)
            )
            .styleModifier {
                property("backdrop-filter", "blur(8px)")
                property("-webkit-backdrop-filter", "blur(8px)")
                property("touch-action", "manipulation")
                property("-webkit-tap-highlight-color", "transparent")
                property("flex-shrink", "0")
            }
            .transition(
                Transition.all(
                    duration = 200.ms,
                    timingFunction = AnimationTimingFunction.cubicBezier(0.16, 1.0, 0.3, 1.0)
                )
            )
    }
    hover {
        Modifier
            .transform {
                scale(1.15)
                translateY((-2).px)
            }
            .backgroundColor(
                Theme.Primary.soft
            )
            .border(
                1.px,
                LineStyle.Solid,
                Theme.Primary.strong
            )
            .boxShadow(0.px, 4.px, 12.px, null, Theme.Primary.medium)
    }
}