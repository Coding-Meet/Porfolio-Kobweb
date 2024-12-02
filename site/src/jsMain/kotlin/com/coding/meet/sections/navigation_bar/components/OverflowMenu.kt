package com.coding.meet.sections.navigation_bar.components

import androidx.compose.runtime.*
import com.coding.meet.models.Section
import com.coding.meet.sections.navigation_bar.styles.NavigationItemStyle
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.*

@Composable
fun OverflowMenu(onMenuClosed: () -> Unit) {
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
            .zIndex(2)
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
                .padding(all = 25.px)
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
                modifier = Modifier.fillMaxWidth().margin(bottom = 25.px),
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
            Section.entries.forEach { section ->
                Link(
                    modifier = NavigationItemStyle.toModifier()
                        .margin(bottom = 10.px)
                        .fontFamily(Res.Font.FONT_FAMILY_REGULAR)
                        .fontSize(16.px)
                        .fontWeight(FontWeight.Normal)
                        .textDecorationLine(TextDecorationLine.None)
                        .onClick {
                            scope.launch {
                                translateX = (-100).percent
                                opacity = 0.percent
                                delay(500)
                                onMenuClosed()
                            }
                        },
                    path = section.path,
                    text = section.title,
                    openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
                )
            }
        }
    }
}