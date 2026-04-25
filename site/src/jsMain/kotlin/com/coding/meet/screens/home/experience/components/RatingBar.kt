package com.coding.meet.screens.home.experience.components

import androidx.compose.runtime.Composable
import com.coding.meet.util.Res
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.px

@Composable
fun RatingBar(modifier: Modifier = Modifier, rating: Double = 5.0) {
    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        repeat(rating.toInt()) {
            Image(
                modifier = Modifier
                    .margin(right = if (it != rating.toInt() - 1) 2.px else 0.px)
                    .size(20.px),
                src = Res.Image.STAR_ICON,
                alt = "Star Icon"
            )
        }
    }
}
