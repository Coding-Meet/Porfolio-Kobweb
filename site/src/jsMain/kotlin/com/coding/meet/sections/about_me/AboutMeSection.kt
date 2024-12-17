package com.coding.meet.sections.about_me

import androidx.compose.runtime.Composable
import com.coding.meet.models.Section
import com.coding.meet.util.Res.Dimens.SECTION_WIDTH
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text


@Composable
fun AboutMeSection() {
    Column(
        modifier = Modifier
            .id(Section.ABOUT_ME.id)
            .fillMaxSize()
            .maxWidth(SECTION_WIDTH.px),

    ) {
        H1 {
            Text("Pierre Roy")

        }

        H2 {
            Text("IT Student")
        }

        H2 {
            Text("France")
        }

        Text("About Me Section")
    }
}