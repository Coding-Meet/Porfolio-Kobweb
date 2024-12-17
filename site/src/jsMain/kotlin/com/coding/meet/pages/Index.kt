package com.coding.meet.pages

import androidx.compose.runtime.Composable
import com.coding.meet.layouts.DefaultPageLayout
import com.coding.meet.sections.home.components.MainImage
import com.coding.meet.sections.home.components.MainText
import com.coding.meet.util.Res.Dimens.SECTION_WIDTH
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    DefaultPageLayout {
        val breakpoint = rememberBreakpoint()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .maxWidth(SECTION_WIDTH.px)
                .padding(top = 6.cssRem),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SimpleGrid(
                modifier = Modifier.fillMaxWidth(90.percent),
                numColumns = numColumns(base = 1, md = 2)
            ) {
                MainText(breakpoint = breakpoint)
                MainImage()
            }
        }
    }
}
