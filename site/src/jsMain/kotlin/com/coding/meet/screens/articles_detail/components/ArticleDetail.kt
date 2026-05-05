package com.coding.meet.screens.articles_detail.components

import androidx.compose.runtime.Composable
import com.coding.meet.common.components.footer.Footer
import com.coding.meet.common.page_layout.PageLayout
import com.coding.meet.common.page_layout.fadeInUpPageAnimation
import com.coding.meet.models.Article
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.silk.style.animation.toAnimation
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

@Composable
fun ArticleDetail(
    article: Article,
    context: PageContext
) {
    PageLayout(
        title = article.title
    ) {
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 20.px),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ArticleContent(
                    context = context,
                    article = article,
                )
            }
            Footer()
        }
    }
}