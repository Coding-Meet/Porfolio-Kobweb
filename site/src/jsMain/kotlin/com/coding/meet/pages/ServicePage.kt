package com.coding.meet.pages

import androidx.compose.runtime.Composable
import com.coding.meet.layouts.DefaultPageLayout
import com.coding.meet.models.servicePath
import com.coding.meet.util.Res.Dimens.SECTION_WIDTH
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

@Page(servicePath)
@Composable
fun ServiceSection() {
    DefaultPageLayout {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .maxWidth(SECTION_WIDTH.px),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Text("Service Section")
        }
    }
}