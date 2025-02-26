package com.coding.meet.screens.home.experience.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.px

@Composable
fun RatingBar(modifier: Modifier = Modifier) {
    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        repeat(5) {
            Image(
                modifier = Modifier
                    .margin(right = if (it != 4) 2.px else 0.px)
                    .size(30.px),
                src = "star_icon.svg",
                alt = "Star Icon"
            )
        }
    }
}