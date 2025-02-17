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
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

@Composable
fun MobileSideMenu(
    selectedSectionId : String,
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
        if(breakpoint > Breakpoint.MD) {
            scope.launch {
                translateX = (-100).percent
                opacity = 0.percent
                delay(500)
                onMenuClosed()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.vh)
            .position(Position.Fixed)
            .zIndex(100)
            .opacity(opacity)
            .backgroundColor(argb(a = 0.5f, r = 0.0f, g = 0.0f, b = 0.0f))
            .transition(
                Transition.of(
                    property = "opacity",
                    duration = 500.ms,
                    timingFunction = null,
                    delay = null
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(if (breakpoint < Breakpoint.MD) 50.percent else 25.percent)
                .overflow(Overflow.Auto)
                .scrollBehavior(ScrollBehavior.Smooth)
                .backgroundColor(CustomColor(
                    lightColor = Theme.White,
                    darkColor = Theme.DarkGray
                ))
                .translateX(tx = translateX)
                .transition(
                    Transition.of(
                        property = "translate",
                        duration = 500.ms,
                        timingFunction = null,
                        delay = null
                    )
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(
                        leftRight = 15.px
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CloseIcon(
                    modifier = Modifier
                        .cursor(Cursor.Pointer)
                        .margin(right = 20.px)
                        .onClick {
                            scope.launch {
                                translateX = (-100).percent
                                opacity = 0.percent
                                delay(500)
                                onMenuClosed()
                            }
                        },
                )
                Image(
                    modifier = Modifier.size(120.px),
                    src = when (colorMode) {
                        ColorMode.LIGHT -> Res.Image.LOGO_LIGHT
                        ColorMode.DARK -> Res.Image.LOGO_DARK
                    },
                    alt = "Logo Image"
                )
            }
            NavigationMenu(selectedSectionId)
        }
    }
}