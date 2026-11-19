package com.coding.meet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.screens.loader.LoaderScreen
import com.coding.meet.util.AppInfo
import com.coding.meet.util.Res
import com.coding.meet.util.Res.Font.FONT_FAMILY_REGULAR
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
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
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.color
import kotlinx.browser.document
import kotlinx.browser.localStorage
import kotlinx.browser.window
import org.jetbrains.compose.web.css.vh
import org.w3c.dom.DocumentReadyState
import org.w3c.dom.HTMLScriptElement
import org.w3c.dom.INTERACTIVE
import kotlin.js.json


@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    val colorMode by ColorMode.currentState

    LaunchedEffect(Unit) {
        initWebMCP()
        initCustomCursor()
    }

    LaunchedEffect(colorMode) {
        localStorage.setItem(Res.Strings.SAVED_THEME, colorMode.name)
    }

    // console.log(articleSiteMap.joinToString("\n"))

    SilkApp {
        var isLoaded by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            document.title = "${AppInfo.WEBSITE_NAME} - My Portfolio"

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
        Surface(
            SmoothColorStyle.toModifier().fillMaxWidth().minHeight(100.vh)
                .fontFamily(FONT_FAMILY_REGULAR)
        ) {
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
        val savedTheme = localStorage.getItem(Res.Strings.SAVED_THEME)
        if (savedTheme != null) {
            try {
                config.initialColorMode = ColorMode.valueOf(savedTheme)
            } catch (_: Exception) {
            }
        }

        theme.palettes.light.background = Theme.LightBackGroundColor.rgb
        theme.palettes.light.color = Theme.LightFontColor.rgb
        theme.palettes.light.border = Theme.LightBorder.rgb

        theme.palettes.dark.background = Theme.DarkBackground.rgb
        theme.palettes.dark.color = Theme.DarkFontColor.rgb
        theme.palettes.dark.border = Theme.DarkBorder.rgb
    }
}

@InitKobweb
fun pageNotFoundHandling(initSilkContext: InitKobwebContext) {
    initSilkContext.router.setErrorPage {
        initSilkContext.router.navigateTo(
            "/",
            openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
            openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
            updateHistoryMode = UpdateHistoryMode.REPLACE
        )
    }
}

private fun initWebMCP() {
    val navigator = window.navigator.asDynamic()
    if (navigator.modelContext != null) {
        try {
            navigator.modelContext.provideContext(
                json(
                    "tools" to arrayOf(
                        json(
                            "name" to "get_projects",
                            "description" to "Get a list of portfolio projects with their titles and descriptions",
                            "inputSchema" to json(
                                "type" to "object",
                                "properties" to json()
                            ),
                            "execute" to { _: dynamic ->
                                // This would ideally fetch from ProjectData, but for simplicity in JS:
                                "Fetching projects information from the portfolio site..."
                            }
                        ),
                        json(
                            "name" to "get_articles",
                            "description" to "Get a list of blog articles published on the portfolio",
                            "inputSchema" to json(
                                "type" to "object",
                                "properties" to json()
                            ),
                            "execute" to { _: dynamic ->
                                "Fetching articles information from the portfolio site..."
                            }
                        ),
                        json(
                            "name" to "get_services",
                            "description" to "Get a list of professional services offered (Mobile Apps, AI, Modernization)",
                            "inputSchema" to json(
                                "type" to "object",
                                "properties" to json()
                            ),
                            "execute" to { _: dynamic ->
                                "Fetching services information from the portfolio site..."
                            }
                        )
                    )
                )
            )
            println("WebMCP tools initialized")
        } catch (e: Exception) {
            println("Failed to initialize WebMCP: ${e.message}")
        }
    }
}

private fun initCustomCursor() {
    try {
        val win = window.asDynamic()
        if (win.initCustomCursor != undefined) {
            win.initCustomCursor()
        }
    } catch (_: Exception) {
    }
}

