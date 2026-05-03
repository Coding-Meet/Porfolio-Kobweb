package com.coding.meet.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.coding.meet.common.components.IconButton
import com.coding.meet.common.components.footer.Footer
import com.coding.meet.common.page_layout.PageLayout
import com.coding.meet.common.page_layout.fadeInUpPageAnimation
import com.coding.meet.models.articlesDetailPath
import com.coding.meet.models.articlesPath
import com.coding.meet.screens.articles.components.StatItem
import com.coding.meet.util.ArticleData
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaBookOpen
import com.varabyte.kobweb.silk.components.icons.fa.FaCalendarDays
import com.varabyte.kobweb.silk.components.icons.fa.FaChalkboardUser
import com.varabyte.kobweb.silk.components.icons.fa.FaClock
import com.varabyte.kobweb.silk.components.icons.fa.FaEye
import com.varabyte.kobweb.silk.components.icons.fa.FaHandsClapping
import com.varabyte.kobweb.silk.components.icons.fa.FaShareNodes
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.window
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLElement
import org.w3c.dom.get

@Page(articlesDetailPath)
@Composable
fun ArticleDetailPage(context: PageContext) {
    val articleId = context.route.params["id"]
    val article = remember(articleId) {
        articleId?.let { id ->
            ArticleData.articles.find { it.guid.endsWith(id) }
        }
    }

    LaunchedEffect(articleId, article) {
        if (articleId == null || article == null) {
            context.router.navigateTo(articlesPath)
        }
    }

    val breakpoint = rememberBreakpoint()

    PageLayout(
        title = article?.title ?: "Article Detail"
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 20.px)
                .animation(
                    fadeInUpPageAnimation.toAnimation(
                        duration = 1.s,
                        timingFunction = AnimationTimingFunction.EaseOut
                    )
                ),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 10.px),
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(
                    onClick = {
                        context.router.navigateTo(articlesPath)
                    }
                ) {
                    FaArrowLeft()
                }
            }
            if (article != null) {
                SpanText(
                    text = article.title,
                    modifier = Modifier
                        .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 80.percent else 100.percent)
                        .padding(bottom = 20.px)
                        .color(CustomColor(Theme.LightFontColor, Theme.DarkFontColor))
                        .fontSize(2.5.cssRem)
                        .fontWeight(FontWeight.Bold)
                        .textAlign(TextAlign.Center)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 80.percent else 100.percent)
                        .padding(bottom = 20.px)
                        .flexWrap(FlexWrap.Wrap)
                        .justifyContent(JustifyContent.Center),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    StatItem(article.pubDate) { FaCalendarDays() }
                    StatItem(article.readTime) { FaClock() }
                    article.views?.let { StatItem(it) { FaEye() } }
                    article.reads?.let { StatItem(it) { FaBookOpen() } }
                    article.claps?.let { StatItem(it) { FaHandsClapping() } }
                    article.presentations?.let { StatItem(it) { FaChalkboardUser() } }

                    IconButton(
                        modifier = Modifier.margin(left = 10.px, top = if (breakpoint == Breakpoint.SM)  10.px else 0.px),
                        tooltipText = "Share",
                        onClick = {
                            window.navigator.clipboard.writeText(article.link)
                        }
                    ) {
                        FaShareNodes()
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 80.percent else 100.percent)
                        .padding(bottom = 40.px)
                        .color(CustomColor(Theme.LightFontColor, Theme.DarkFontColor))
                ) {
                    Div(attrs = {
                        classes("article-content")
                        ref { element ->
                            element.innerHTML = article.content
                            
                            // Inject styles for raw HTML content
                            val style = window.document.createElement("style")
                            style.innerHTML = """
                                .article-content {
                                    line-height: 1.8;
                                    font-size: 1.2rem;
                                    text-align: left;
                                    max-width: 100%;
                                    overflow-wrap: break-word;
                                    word-wrap: break-word;
                                }
                                .article-content p {
                                    margin-bottom: 1.5rem;
                                }
                                .article-content figure {
                                    margin: 2.5rem 0;
                                    display: flex;
                                    flex-direction: column;
                                    align-items: center;
                                    justify-content: center;
                                    max-width: 100%;
                                }
                                .article-content img {
                                    max-width: 100%;
                                    height: auto;
                                    border-radius: 12px;
                                    box-shadow: 0 10px 30px rgba(0,0,0,0.15);
                                }
                                .article-content h1, .article-content h2, .article-content h3 {
                                    margin-top: 2rem;
                                    margin-bottom: 1rem;
                                    overflow-wrap: break-word;
                                }
                                .article-content ul, .article-content ol {
                                    margin-bottom: 1.5rem;
                                    padding-left: 1.5rem;
                                    max-width: 100%;
                                    box-sizing: border-box;
                                }
                                .article-content li {
                                    margin-bottom: 0.5rem;
                                    overflow-wrap: break-word;
                                }
                                .article-content blockquote {
                                    border-left: 4px solid #03FA6E;
                                    padding-left: 1rem;
                                    margin: 1.5rem 0;
                                    font-style: italic;
                                    opacity: 0.8;
                                    overflow-wrap: break-word;
                                }
                                .article-content pre {
                                    background: #1e1e1e;
                                    color: #d4d4d4;
                                    padding: 2.5rem 1.5rem 1.5rem 1.5rem;
                                    border-radius: 12px;
                                    overflow-x: auto;
                                    position: relative;
                                    margin: 2.5rem 0;
                                    font-family: 'Fira Code', 'Courier New', monospace;
                                    border: 1px solid #333;
                                    box-shadow: 0 10px 20px rgba(0,0,0,0.2);
                                    max-width: 100%;
                                    box-sizing: border-box;
                                }
                                .article-content code {
                                    font-family: inherit;
                                    color: #ce9178;
                                    background: rgba(0,0,0,0.05);
                                    padding: 2px 6px;
                                    border-radius: 4px;
                                    overflow-wrap: break-word;
                                }
                                .article-content pre code {
                                    background: transparent;
                                    padding: 0;
                                    color: #9cdcfe;
                                    white-space: pre;
                                    overflow-wrap: normal;
                                }
                                .copy-button {
                                    position: absolute;
                                    top: 12px;
                                    right: 12px;
                                    background: rgba(255, 255, 255, 0.05);
                                    color: #888;
                                    border: 1px solid rgba(255, 255, 255, 0.1);
                                    padding: 6px 14px;
                                    border-radius: 8px;
                                    cursor: pointer;
                                    font-size: 0.8rem;
                                    transition: all 0.2s ease;
                                    font-family: 'Inter', sans-serif;
                                    font-weight: 500;
                                }
                                .copy-button:hover {
                                    background: rgba(255, 255, 255, 0.15);
                                    color: #fff;
                                    border-color: rgba(255, 255, 255, 0.3);
                                }
                                .copy-button:active {
                                    transform: scale(0.96);
                                }
                            """.trimIndent()
                            element.appendChild(style)

                            // Add Copy buttons to pre blocks
                            val preBlocks = element.querySelectorAll("pre")
                            for (i in 0 until preBlocks.length) {
                                val pre = preBlocks[i] as HTMLElement
                                val button = window.document.createElement("button")
                                button.className = "copy-button"
                                button.innerHTML = "Copy"
                                button.addEventListener("click", {
                                    val code = pre.innerText.removeSuffix("Copy")
                                    window.navigator.clipboard.writeText(code).asDynamic().then({
                                        button.innerHTML = "Copied!"
                                        window.setTimeout({ button.innerHTML = "Copy" }, 2000)
                                    })
                                })
                                pre.appendChild(button)
                            }

                            onDispose {}
                        }
                    })
                }
            } else {
                SpanText("No article selected.")
            }
            Footer()
        }
    }
}