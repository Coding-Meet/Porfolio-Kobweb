package com.coding.meet.sections.blog

import androidx.compose.runtime.Composable
import com.coding.meet.models.Section
import com.coding.meet.util.Res.Dimens.SECTION_WIDTH
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text


@Composable
fun BlogSection() {
    Box(
        modifier = Modifier
            .id(Section.BLOG.id)
            .fillMaxSize()
            .maxWidth(SECTION_WIDTH.px),
        contentAlignment = Alignment.Center
    ) {
        Text("Blog Section")
    }
}