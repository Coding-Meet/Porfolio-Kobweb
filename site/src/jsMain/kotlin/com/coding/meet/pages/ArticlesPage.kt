package com.coding.meet.pages

import androidx.compose.runtime.Composable
import com.coding.meet.common.components.footer.Footer
import com.coding.meet.common.page_layout.PageLayout
import com.coding.meet.models.Section
import com.coding.meet.models.articlesPath
import com.coding.meet.screens.articles.components.ArticleCard
import com.coding.meet.common.page_layout.fadeInUpPageAnimation
import com.coding.meet.util.Constants.articles
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

@Page(articlesPath)
@Composable
fun ArticlesPage() {
    PageLayout(
        title = Section.ARTICLES.title
    ) {

        val breakpoint = rememberBreakpoint()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .animation(
                    fadeInUpPageAnimation.toAnimation(
                        duration = 1.s,
                        timingFunction = AnimationTimingFunction.EaseOut
                    )
                ),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            SimpleGrid(
                numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 3),
                modifier = Modifier.fillMaxWidth()
                    .padding(topBottom = 10.px, leftRight = if (breakpoint > Breakpoint.SM) 10.px else 0.px)
            ) {
                articles.forEach { article ->
                    ArticleCard(article)
                }
            }
            Footer()
        }
    }
}