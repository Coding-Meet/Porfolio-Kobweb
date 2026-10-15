package com.coding.meet.common.components.navigation_bar.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.left
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.vh
import com.coding.meet.util.select
import com.coding.meet.util.glassSubtle

@Composable
fun MobileSideMenu(
    selectedSectionId: String,
    onMenuClosed: () -> Unit
) {

    val scope = rememberCoroutineScope()
    val breakpoint = rememberBreakpoint()
    var translateX by remember { mutableStateOf((-100).percent) }
    var opacity by remember { mutableStateOf(0.percent) }
    val colorMode by ColorMode.currentState

    LaunchedEffect(breakpoint) {
        translateX = 0.percent
        opacity = 100.percent
        if (breakpoint > Breakpoint.MD) {
            scope.launch {
                translateX = (-100).percent
                opacity = 0.percent
                delay(300)
                onMenuClosed()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.vh)
            .position(Position.Fixed)
            .top(0.px)
            .left(0.px)
            .zIndex(2000)
            .opacity(opacity)
            .backgroundColor(Theme.Black.strong)
            .styleModifier {
                property("backdrop-filter", "blur(4px)")
                property("-webkit-backdrop-filter", "blur(4px)")
            }
            .transition(
                Transition.of(
                    property = "opacity",
                    duration = 300.ms,
                    timingFunction = AnimationTimingFunction.EaseInOut,
                    delay = null
                )
            ).onClick {
                scope.launch {
                    translateX = (-100).percent
                    opacity = 0.percent
                    delay(300)
                    onMenuClosed()
                }
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(82.percent)
                .maxWidth(290.px)
                .overflow(Overflow.Auto)
                .scrollBehavior(ScrollBehavior.Smooth)
                .backgroundColor(
                    CustomColor(
                        lightColor = Theme.White,
                        darkColor = Theme.DarkCardBackGroundColor
                    )
                )
                .boxShadow(
                    8.px,
                    0.px,
                    24.px,
                    null,
                    colorMode.select(Theme.Black.soft, Theme.Black.strong)
                )
                .styleModifier {
                    property("border-right", "1px solid ${colorMode.glassSubtle}")
                }
                .borderRadius(topRight = 20.px, bottomRight = 20.px)
                .translateX(tx = translateX)
                .transition(
                    Transition.of(
                        property = "transform",
                        duration = 300.ms,
                        timingFunction = AnimationTimingFunction.cubicBezier(0.16, 1.0, 0.3, 1.0),
                        delay = null
                    )
                )
                .onClick { it.stopPropagation() }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(topBottom = 20.px, leftRight = 18.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CloseIcon(
                    modifier = Modifier
                        .size(16.px)
                        .cursor(Cursor.Pointer)
                        .margin(right = 16.px)
                        .onClick {
                            scope.launch {
                                translateX = (-100).percent
                                opacity = 0.percent
                                delay(300)
                                onMenuClosed()
                            }
                        },
                )
                Image(
                    modifier = Modifier.height(32.px).cursor(Cursor.Pointer),
                    src = when (colorMode) {
                        ColorMode.LIGHT -> Res.Image.LOGO_LIGHT
                        ColorMode.DARK -> Res.Image.LOGO_DARK
                    },
                    alt = "Logo Image"
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(leftRight = 8.px, top = 6.px)
            ) {
                NavigationMenu(selectedSectionId)
            }
        }
    }
}