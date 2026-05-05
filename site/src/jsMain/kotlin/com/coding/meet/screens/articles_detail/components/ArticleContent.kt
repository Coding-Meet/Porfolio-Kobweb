package com.coding.meet.screens.articles_detail.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.models.Article
import com.coding.meet.models.articlesPath
import com.coding.meet.screens.articles.components.StatItem
import com.coding.meet.screens.articles_detail.styles.ArticleContentStyle
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
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaBookOpen
import com.varabyte.kobweb.silk.components.icons.fa.FaCalendarDays
import com.varabyte.kobweb.silk.components.icons.fa.FaChalkboardUser
import com.varabyte.kobweb.silk.components.icons.fa.FaClock
import com.varabyte.kobweb.silk.components.icons.fa.FaEye
import com.varabyte.kobweb.silk.components.icons.fa.FaHandsClapping
import com.varabyte.kobweb.silk.components.icons.fa.FaLink
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLIFrameElement
import org.w3c.dom.HTMLSpanElement
import org.w3c.dom.get

@Composable
fun ArticleContent(
    context: PageContext,
    article: Article?,
) {
    val breakpoint = rememberBreakpoint()
    var isCopied by remember { mutableStateOf(false) }

    LaunchedEffect(isCopied) {
        if (isCopied) {
            delay(2000)
            isCopied = false
        }
    }
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
                        val isInternal =
                            document.referrer.contains(window.location.origin)
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
                .fontSize(2.0.cssRem)
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

            Button(
                modifier = Modifier
                    .backgroundColor(Theme.Primary.color)
                    .padding(leftRight = 14.px, topBottom = 8.px)
                    .borderRadius(12.px)
                    .margin(
                        left = 10.px,
                        top = if (breakpoint == Breakpoint.SM) 10.px else 0.px
                    ),
                onClick = {
                    window.navigator.clipboard.writeText(window.location.href)
                    isCopied = true
                }
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FaLink(
                        modifier = Modifier
                            .margin(right = 8.px)
                            .fontSize(1.cssRem)
                            .color(Theme.LightFontColor.color)
                    )
                    SpanText(
                        text = if (isCopied) "Copied!" else "Copy Link",
                        modifier = Modifier
                            .color(Theme.LightFontColor.color)
                            .fontSize(0.9.cssRem)
                            .fontWeight(FontWeight.Bold)
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 80.percent else 100.percent)
                .padding(bottom = 40.px)
                .color(CustomColor(Theme.LightFontColor, Theme.DarkFontColor))
        ) {
            key(article.content) {
                Div(ArticleContentStyle.toModifier().toAttrs {
                    ref { element ->
                        val htmlElement = element as HTMLElement
                        htmlElement.innerHTML = article.content

                        // Add Copy buttons to pre blocks
                        val preBlocks = htmlElement.querySelectorAll("pre")
                        for (i in 0 until preBlocks.length) {
                            val pre = preBlocks[i] as HTMLElement

                            // Inject simple comment highlighting if not already present
                            val currentHTML = pre.innerHTML
                            if (!currentHTML.contains("class=\"comment\"")) {
                                pre.innerHTML = currentHTML
                                    .replace(
                                        Regex("(^|[^:])(//.*?)(?=<br>|$)"),
                                        "$1<span class=\"comment\">$2</span>"
                                    )
                                    .replace(
                                        Regex("(^|<br>)(#.*?)(?=<br>|$)"),
                                        "$1<span class=\"comment\">$2</span>"
                                    )
                                    .replace(
                                        Regex("(/\\*.*?\\*/)"),
                                        "<span class=\"comment\">$1</span>"
                                    )
                            }

                            // Create a wrapper to keep the copy button fixed during horizontal scroll
                            val wrapper = window.document.createElement("div")
                            wrapper.className = "code-wrapper"
                            pre.parentNode?.replaceChild(wrapper, pre)
                            wrapper.appendChild(pre)

                            val button =
                                window.document.createElement("button") as HTMLButtonElement
                            button.className = "copy-button"
                            button.textContent = "Copy"
                            button.addEventListener("click", {
                                val code = pre.textContent ?: ""
                                window.navigator.clipboard.writeText(code).asDynamic()
                                    .then({
                                        button.textContent = "Copied!"
                                        window.setTimeout(
                                            { button.textContent = "Copy" },
                                            2000
                                        )
                                    })
                            })
                            wrapper.appendChild(button)
                        }

                        // Open all links in new tab and handle previews
                        val links = htmlElement.querySelectorAll("a")
                        for (i in 0 until links.length) {
                            val link = links[i] as HTMLElement
                            val href = link.getAttribute("href") ?: ""

                            link.setAttribute("target", "_blank")
                            link.setAttribute("rel", "noopener noreferrer")

                            // YouTube embedding logic
                            val youtubeRegex =
                                Regex("(?:https?://)?(?:www\\.)?(?:youtube\\.com/(?:watch\\?v=|embed/|shorts/|live/)|youtu\\.be/)([a-zA-Z0-9_-]{11})")
                            val mediumMediaRegex =
                                Regex("https://medium\\.com/media/([a-z0-9]+)/href")

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
                                val iframe =
                                    window.document.createElement("iframe") as HTMLIFrameElement
                                iframe.setAttribute("src", embedUrl)
                                iframe.setAttribute("allowfullscreen", "true")
                                iframe.setAttribute(
                                    "allow",
                                    "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                                )
                                container.appendChild(iframe)

                                // Replace standalone links with video
                                val parent = link.parentElement
                                if (parent?.tagName?.lowercase() == "p" && parent.childNodes.length == 1) {
                                    parent.parentElement?.replaceChild(
                                        container,
                                        parent
                                    )
                                } else {
                                    link.parentElement?.replaceChild(container, link)
                                }

                                // Append a link preview card below the video
                                val previewUrl = if (ytMatch != null) {
                                    "https://www.youtube.com/watch?v=${ytMatch.groupValues[1]}"
                                } else {
                                    href
                                }

                                val previewLink =
                                    window.document.createElement("a") as HTMLAnchorElement
                                previewLink.setAttribute("href", previewUrl)
                                previewLink.setAttribute("target", "_blank")
                                previewLink.className = "link-preview"

                                val previewContent =
                                    window.document.createElement("div")
                                previewContent.className = "link-preview-content"

                                val previewTitle = window.document.createElement("span")
                                previewTitle.className = "link-preview-title"
                                previewTitle.textContent = "Watch on YouTube "
                                val icon =
                                    window.document.createElement("i") as HTMLElement
                                icon.className = "fab fa-youtube"
                                icon.style.fontSize = "0.8rem"
                                previewTitle.appendChild(icon)

                                val url = window.document.createElement("span")
                                url.className = "link-preview-url"
                                url.textContent = ": $previewUrl"

                                previewContent.appendChild(previewTitle)
                                previewContent.appendChild(url)
                                previewLink.appendChild(previewContent)

                                container.parentElement?.insertBefore(
                                    previewLink,
                                    container.nextSibling
                                )
                            } else if (href.startsWith("http") && !href.contains("medium.com") && link.textContent?.trim() == href.trim()) {
                                // Simple link preview for standalone URLs
                                link.className = "link-preview"
                                val content = window.document.createElement("div")
                                content.className = "link-preview-content"

                                val title =
                                    window.document.createElement("span") as HTMLSpanElement
                                title.className = "link-preview-title"
                                title.textContent = "External Link "
                                val icon =
                                    window.document.createElement("i") as HTMLElement
                                icon.className = "fas fa-external-link-alt"
                                icon.style.fontSize = "0.8rem"
                                icon.style.marginLeft = "5px"
                                title.appendChild(icon)

                                val url =
                                    window.document.createElement("span") as HTMLSpanElement
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
}