package com.coding.meet.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.key
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
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
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
import kotlinx.browser.document
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
            ArticleData.articles.find { it.link.endsWith(id) }
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
            if (article != null) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 80.percent else 100.percent)
                        .padding(topBottom = 15.px),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Row(
                        modifier = Modifier
                            .cursor(Cursor.Pointer)
                            .onClick {
                                val isInternal = document.referrer.contains(window.location.origin)
                                if (isInternal && window.history.length > 1) {
                                    window.history.back()
                                } else {
                                    context.router.navigateTo(articlesPath)
                                }
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        FaArrowLeft(modifier = Modifier.margin(right = 8.px))
                        SpanText(
                            text = "Back to Blog",
                            modifier = Modifier
                                .color(CustomColor(Theme.LightFontColor, Theme.DarkFontColor))
                                .fontSize(1.cssRem)
                                .fontWeight(FontWeight.Medium)
                        )
                    }
                }

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
                        modifier = Modifier.backgroundColor(
                            CustomColor(
                                lightColor = Theme.LightGray,
                                darkColor = Theme.DarkGray
                            )
                        ).margin(left = 10.px, top = if (breakpoint == Breakpoint.SM)  10.px else 0.px),
                        tooltipText = "Share",
                        onClick = {
                            window.navigator.clipboard.writeText(window.location.href)
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
                    key(article.content) {
                        Div(attrs = {
                            classes("article-content")
                            ref { element ->
                                element.innerHTML =  article.content

                                // Inject styles for raw HTML content
                                if (window.document.getElementById("article-styles") == null) {
                                    val style = window.document.createElement("style")
                                    style.id = "article-styles"
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
                                            margin: 1.0rem 0;
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
                                        .video-container {
                                            position: relative;
                                            padding-bottom: 56.25%;
                                            height: 0;
                                            overflow: hidden;
                                            max-width: 100%;
                                            border-radius: 12px;
                                            margin: 2rem 0;
                                            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
                                        }
                                        .video-container iframe {
                                            position: absolute;
                                            top: 0;
                                            left: 0;
                                            width: 100%;
                                            height: 100%;
                                            border: 0;
                                        }
                                        .link-preview {
                                            display: flex;
                                            flex-direction: column;
                                            background: rgba(0,0,0,0.05);
                                            border: 1px solid rgba(0,0,0,0.1);
                                            border-radius: 12px;
                                            margin: 1.5rem 0;
                                            overflow: hidden;
                                            text-decoration: none !important;
                                            transition: all 0.2s ease;
                                            cursor: pointer;
                                        }
                                        .link-preview:hover {
                                            background: rgba(0,0,0,0.08);
                                            transform: translateY(-2px);
                                            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
                                        }
                                        .link-preview-content {
                                            padding: 1.2rem;
                                        }
                                        .link-preview-title {
                                            font-weight: bold;
                                            font-size: 1.1rem;
                                            margin-bottom: 0.5rem;
                                            display: block;
                                            color: #03FA6E;
                                        }
                                        .link-preview-url {
                                            font-size: 0.9rem;
                                            opacity: 0.7;
                                            word-break: break-all;
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
                                        .article-content .comment,
                                        .article-content .token.comment,
                                        .article-content .hljs-comment {
                                            color: #858585 !important;
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
                                    window.document.head?.appendChild(style)
                                }

                                // Add Copy buttons to pre blocks
                                val preBlocks = element.querySelectorAll("pre")
                                for (i in 0 until preBlocks.length) {
                                    val pre = preBlocks[i] as HTMLElement

                                    // Inject simple comment highlighting if not already present
                                    val currentHTML = pre.innerHTML
                                    if (!currentHTML.contains("class=\"comment\"")) {
                                        pre.innerHTML = currentHTML
                                            .replace(Regex("(^|[^:])(//.*?)(?=<br>|$)"), "$1<span class=\"comment\">$2</span>")
                                            .replace(Regex("(^|<br>)(#.*?)(?=<br>|$)"), "$1<span class=\"comment\">$2</span>")
                                            .replace(Regex("(/\\*.*?\\*/)"), "<span class=\"comment\">$1</span>")
                                    }

                                    val button = window.document.createElement("button")
                                    button.className = "copy-button"
                                    button.textContent = "Copy"
                                    button.addEventListener("click", {
                                        val code = pre.textContent?.removeSuffix("Copy") ?: ""
                                        window.navigator.clipboard.writeText(code).asDynamic().then({
                                            button.textContent = "Copied!"
                                            window.setTimeout({ button.textContent = "Copy" }, 2000)
                                        })
                                    })
                                    pre.appendChild(button)
                                }

                                // Open all links in new tab and handle previews
                                val links = element.querySelectorAll("a")
                                for (i in 0 until links.length) {
                                    val link = links[i] as HTMLElement
                                    val href = link.getAttribute("href") ?: ""

                                    link.setAttribute("target", "_blank")
                                    link.setAttribute("rel", "noopener noreferrer")

                                    // YouTube embedding logic
                                    val youtubeRegex = Regex("(?:https?://)?(?:www\\.)?(?:youtube\\.com/watch\\?v=|youtu\\.be/)([a-zA-Z0-9_-]{11})")
                                    val mediumMediaRegex = Regex("https://medium\\.com/media/([a-z0-9]+)/href")

                                    val ytMatch = youtubeRegex.find(href)
                                    val mediumMatch = mediumMediaRegex.find(href)

                                    if (ytMatch != null || mediumMatch != null) {
                                        val embedUrl = if (ytMatch != null) {
                                            "https://www.youtube.com/embed/${ytMatch.groupValues[1]}"
                                        } else {
                                            href // Direct embed for Medium media links
                                        }

                                        val container = window.document.createElement("div")
                                        container.className = "video-container"
                                        val iframe = window.document.createElement("iframe")
                                        iframe.setAttribute("src", embedUrl)
                                        iframe.setAttribute("allowfullscreen", "true")
                                        iframe.setAttribute("allow", "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture")
                                        container.appendChild(iframe)

                                        // Replace standalone links with video
                                        val parent = link.parentElement
                                        if (parent?.tagName?.lowercase() == "p" && parent.childNodes.length == 1) {
                                            parent.parentElement?.replaceChild(container, parent)
                                        } else {
                                            link.parentElement?.replaceChild(container, link)
                                        }
                                    } else if (href.startsWith("http") && !href.contains("medium.com") && link.textContent?.trim() == href.trim()) {
                                        // Simple link preview for standalone URLs
                                        link.className = "link-preview"
                                        val content = window.document.createElement("div")
                                        content.className = "link-preview-content"

                                        val title = window.document.createElement("span")
                                        title.className = "link-preview-title"
                                        title.innerHTML = "External Link <i class='fas fa-external-link-alt' style='font-size: 0.8rem; margin-left: 5px;'></i>"

                                        val url = window.document.createElement("span")
                                        url.className = "link-preview-url"
                                        url.textContent = href

                                        content.appendChild(title)
                                        content.appendChild(url)
                                        link.textContent = ""
                                        link.appendChild(content)
                                    }
                                }

                                onDispose {}
                            }
                        })
                    }
                }
            } else {
                SpanText("No article selected.")
            }
            Footer()
        }
    }
}