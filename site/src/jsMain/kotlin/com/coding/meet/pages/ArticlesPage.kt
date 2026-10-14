package com.coding.meet.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.coding.meet.common.components.footer.Footer
import com.coding.meet.common.page_layout.PageLayout
import com.coding.meet.common.page_layout.fadeInUpPageAnimation
import com.coding.meet.models.Section
import com.coding.meet.models.articlesPath
import com.coding.meet.screens.articles.components.ArticleCard
import com.coding.meet.util.ArticleData.articles
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.window
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s

@Page(articlesPath)
@Composable
fun ArticlesPage(context: PageContext) {
    PageLayout(
        title = Section.ARTICLES.title
    ) {
        val breakpoint = rememberBreakpoint()
        LaunchedEffect(Unit) {
            val saved = window.sessionStorage.getItem("articles_scroll")

            if (saved != null) {
                window.scrollTo(0.0, saved.toDouble())
                window.sessionStorage.removeItem("articles_scroll")
            }
        }
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
            SpanText(
                text = "✍️ Engineering Articles & Tutorials",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.px, bottom = 6.px, leftRight = 10.px)
                    .color(
                        CustomColor(
                            lightColor = Theme.LightFontColor,
                            darkColor = Theme.DarkFontColor
                        )
                    )
                    .fontFamily(Res.Font.FONT_FAMILY_HEADING)
                    .fontSize(if (breakpoint > Breakpoint.SM) 2.2.cssRem else 1.7.cssRem)
                    .fontWeight(FontWeight.Bold)
                    .textAlign(TextAlign.Center)
            )

            SpanText(
                text = "Deep dives into Android architecture, Kotlin Multiplatform, Jetpack Compose, and modern mobile tooling.",
                modifier = Modifier
                    .fillMaxWidth(if (breakpoint > Breakpoint.MD) 65.percent else 90.percent)
                    .padding(bottom = 28.px, leftRight = 20.px)
                    .color(
                        CustomColor(
                            lightColor = Theme.DarkGray,
                            darkColor = Theme.Muted
                        )
                    )
                    .fontSize(1.0.cssRem)
                    .lineHeight(1.6)
                    .textAlign(TextAlign.Center)
            )

            SimpleGrid(
                numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 3),
                modifier = Modifier
                    .fillMaxWidth(if (breakpoint > Breakpoint.MD) 85.percent else 95.percent)
                    .padding(bottom = 36.px)
            ) {
                articles.forEach { article ->
                    ArticleCard(article, onClick = {
                        val scrollY = window.scrollY.toInt()
                        window.sessionStorage.setItem("articles_scroll", scrollY.toString())
                        context.router.navigateTo("$articlesPath/${article.link.split("/").last()}")
                    })
                }
            }
            Footer()
        }
    }
}