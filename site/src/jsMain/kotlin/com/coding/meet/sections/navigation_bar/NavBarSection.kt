package com.coding.meet.sections.navigation_bar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.coding.meet.sections.navigation_bar.components.MenuIconButton
import com.coding.meet.sections.navigation_bar.components.MyLogo
import com.coding.meet.sections.navigation_bar.components.NavMenu
import com.coding.meet.sections.navigation_bar.components.ThemeIconButton
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.px

@Composable
fun NavBarSection(onMenuClicked: () -> Unit) {
    var colorMode by ColorMode.currentState

    val breakpoint = rememberBreakpoint()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 15.px),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint <= Breakpoint.MD) {
            MenuIconButton(onMenuClicked)
        }
        MyLogo()
        if (breakpoint > Breakpoint.MD) {
            NavMenu()
        }
        ThemeIconButton(onClick = {
            colorMode = colorMode.opposite
        })
    }
}