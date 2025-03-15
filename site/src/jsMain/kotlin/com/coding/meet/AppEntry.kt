package com.coding.meet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.screens.loader.LoaderScreen
import com.coding.meet.util.Res
import com.coding.meet.util.Res.Font.FONT_FAMILY_REGULAR
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.core.init.InitKobweb
import com.varabyte.kobweb.core.init.InitKobwebContext
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.document
import kotlinx.browser.localStorage
import kotlinx.browser.window
import org.jetbrains.compose.web.css.vh
import org.w3c.dom.DocumentReadyState
import org.w3c.dom.INTERACTIVE


@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    var colorMode by ColorMode.currentState

    LaunchedEffect(colorMode) {
        val savedTheme = localStorage.getItem(Res.Strings.SAVED_THEME) ?: ColorMode.LIGHT.name
        colorMode = ColorMode.valueOf(savedTheme)
    }
    SilkApp {
        var isLoaded by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            document.onreadystatechange = {
                if (document.readyState == DocumentReadyState.INTERACTIVE) {
                    isLoaded = false
                }
            }

            window.onload = {
                window.setTimeout({
                    isLoaded = true
                }, 2000)
            }

            window.setTimeout({
                isLoaded = true
            }, 10000)
        }
        Surface(SmoothColorStyle.toModifier().minHeight(100.vh).fontFamily(FONT_FAMILY_REGULAR)) {
            if (!isLoaded) {
                LoaderScreen(colorMode)
            } else {
                content()
            }
        }
    }
}

@InitSilk
fun initColorMode(initSilkContext: InitSilkContext) {
    initSilkContext.apply {
//        theme.palettes.light.background = Theme.LightBackGroundColor.rgb
    }
}

@InitKobweb
fun pageNotFoundHandling(initSilkContext: InitKobwebContext) {
    initSilkContext.router.setErrorHandler {
        if (it != 404) return@setErrorHandler
        initSilkContext.router.navigateTo(
            "/",
            openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
            openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
            updateHistoryMode = UpdateHistoryMode.REPLACE
        )
    }
}