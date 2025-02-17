package com.coding.meet

import androidx.compose.runtime.Composable
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
import org.jetbrains.compose.web.css.vh


@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    SilkApp {
        Surface(SmoothColorStyle.toModifier().minHeight(100.vh).fontFamily(FONT_FAMILY_REGULAR)) {
            content()
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