package com.coding.meet.pages

import androidx.compose.runtime.Composable
import com.coding.meet.common.components.footer.Footer
import com.coding.meet.common.page_layout.PageLayout
import com.coding.meet.common.page_layout.fadeInUpPageAnimation
import com.coding.meet.data.network.MediumArticleData
import com.coding.meet.data.network.MediumDummyArticleData
import com.coding.meet.models.Article
import com.coding.meet.models.DummyArticleState
import com.coding.meet.models.Section
import com.coding.meet.screens.articles.components.ArticleCard
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.Div

@Page("/medium-dummy")
@Composable
fun MediumDummyPage() {
    val context = rememberPageContext()
    PageLayout(
        title = "Medium Dummy Articles"
    ) {
        val breakpoint = rememberBreakpoint()
        val medium = MediumArticleData()

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
            if (medium != null) {
                SimpleGrid(
                    numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 3),
                    modifier = Modifier.fillMaxWidth()
                        .padding(topBottom = 10.px, leftRight = if (breakpoint > Breakpoint.SM) 10.px else 0.px)
                ) {
                    medium.networkArticles.forEach { networkArticle ->
                        val article = Article(
                            title = networkArticle.title,
                            shortDescription = networkArticle.description.substringBefore("</p>").replace(Regex("<[^>]*>"), ""),
                            thumbnail = networkArticle.thumbnail,
                            link = networkArticle.link,
                            categories = networkArticle.categories,
                            pubDate = networkArticle.pubDate,
                            readTime = "5 min read",
                            content = networkArticle.content
                        )
                        ArticleCard(
                            article = article,
                            onClick = {
                                DummyArticleState.selectedArticle = article
                                context.router.navigateTo("/article-detail")
                            }
                        )
                    }
                }
            }
            Footer()
        }
    }
}