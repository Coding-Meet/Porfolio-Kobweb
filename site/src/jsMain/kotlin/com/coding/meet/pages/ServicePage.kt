package com.coding.meet.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.common.components.custom_dialog.CustomDialog
import com.coding.meet.common.components.custom_dialog.resetDialogScroll
import com.coding.meet.common.components.footer.Footer
import com.coding.meet.common.page_layout.PageLayout
import com.coding.meet.common.page_layout.fadeInUpPageAnimation
import com.coding.meet.models.Section
import com.coding.meet.models.Service
import com.coding.meet.models.servicePath
import com.coding.meet.screens.service.components.FAQCard
import com.coding.meet.screens.service.components.ServiceCard
import com.coding.meet.screens.service.components.ServiceLightboxDialog
import com.coding.meet.util.CustomColor
import com.coding.meet.util.FAQData.faqs
import com.coding.meet.util.Res
import com.coding.meet.util.ServiceData.services
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
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s
import org.w3c.dom.events.Event

@Page(servicePath)
@Composable
fun ServiceSection(context: PageContext = rememberPageContext()) {
    val breakpoint = rememberBreakpoint()
    val isDesktop = breakpoint > Breakpoint.MD

    var isShowLightbox by remember { mutableStateOf(false) }
    val lightboxDialogId by remember { mutableStateOf("serviceLightboxDialog") }
    var activeService by remember { mutableStateOf<Service?>(null) }
    var activeImageIndex by remember { mutableStateOf(0) }

    DisposableEffect(Unit) {
        val routeSlug = context.route.params.get("service")?.trim() ?: ""
        val pathSlug = window.location.pathname.removePrefix("/service").removePrefix("/").substringBefore("/").substringBefore("?").substringBefore("#").trim()
        val initialHash = window.location.hash.removePrefix("#").trim()
        val initialTarget = if (routeSlug.isNotEmpty()) routeSlug else if (pathSlug.isNotEmpty()) pathSlug else initialHash

        var isAutoScrolling = initialTarget.isNotEmpty()
        var currentSection = ""
        val serviceIds = listOf(
            "custom-android-app",
            "fix-bugs",
            "upgrade-sdk",
            "compose-ui",
            "ai-chatbot",
            "kmp-cmp",
            "desktop-app",
            "ios-app",
            "ai-code-review",
            "faq"
        )

        fun resolveTargetId(raw: String): String {
            val clean = raw.removePrefix("#").trim().lowercase()
            if (clean.isEmpty()) return ""

            return when (clean) {
                "custom-android-app", "android-app", "android", "custom-app" -> "custom-android-app"
                "fix-bugs", "debug", "bug-fix", "fix-android-bugs", "bugs" -> "fix-bugs"
                "upgrade-sdk", "target-sdk", "sdk-upgrade", "android-15", "gradle-upgrade" -> "upgrade-sdk"
                "compose-ui", "jetpack-compose", "compose", "compose-ui-design" -> "compose-ui"
                "ai-chatbot", "chatbot", "ai-integration", "gemini-api", "ai" -> "ai-chatbot"
                "kmp-cmp", "kmp", "cmp", "kotlin-multiplatform", "multiplatform" -> "kmp-cmp"
                "desktop-app", "desktop", "compose-desktop", "macos", "windows" -> "desktop-app"
                "ios-app", "ios", "swift", "swiftui", "native-ios" -> "ios-app"
                "ai-code-review", "ai-code", "code-review", "refactor-ai-code", "ai-review" -> "ai-code-review"
                "faq", "faqs", "questions", "question" -> "faq"
                else -> clean
            }
        }

        fun scrollToTarget(target: String, retryCount: Int = 0) {
            val targetId = resolveTargetId(target)
            if (targetId.isEmpty()) {
                isAutoScrolling = false
                return
            }

            val element = document.getElementById(targetId)
            val offsetTop = (element.asDynamic()?.offsetTop as? Number)?.toDouble() ?: 0.0

            if ((element == null || (targetId != serviceIds.first() && offsetTop == 0.0)) && retryCount < 12) {
                window.setTimeout({ scrollToTarget(target, retryCount + 1) }, 100)
                return
            }

            if (element != null) {
                isAutoScrolling = true
                currentSection = targetId

                val targetUrl = "/service/$targetId"
                if (window.location.pathname != targetUrl) {
                    window.history.replaceState(null, "", targetUrl)
                }

                val options = js("({ behavior: 'smooth', block: 'start' })")
                element.asDynamic().scrollIntoView(options)

                window.setTimeout({
                    isAutoScrolling = false
                }, 900)
            } else {
                isAutoScrolling = false
            }
        }

        // Handle initial load if target is present
        if (initialTarget.isNotEmpty()) {
            window.setTimeout({ scrollToTarget(initialTarget) }, 80)
        }

        // Handle dynamic hash changes in the URL
        val onHashChange: (Event) -> Unit = {
            if (window.location.hash.isNotEmpty()) {
                isAutoScrolling = true
                scrollToTarget(window.location.hash)
            }
        }
        window.addEventListener("hashchange", onHashChange)

        // Handle popstate for back/forward navigation
        val onPopState: (Event) -> Unit = {
            val popSlug = window.location.pathname.removePrefix("/service").removePrefix("/").substringBefore("/").substringBefore("?").substringBefore("#").trim()
            if (popSlug.isNotEmpty()) {
                isAutoScrolling = true
                scrollToTarget(popSlug)
            }
        }
        window.addEventListener("popstate", onPopState)

        // Scroll Spy: Update URL path as user scrolls past each service card
        val onScroll: (Event) -> Unit = {
            if (!isAutoScrolling) {
                val scrollY = (window.asDynamic().pageYOffset as? Number)?.toDouble()
                    ?: (document.documentElement?.scrollTop ?: 0.0)
                val windowHeight = (window.asDynamic().innerHeight as? Number)?.toDouble() ?: 800.0
                val docHeight = (document.documentElement?.scrollHeight ?: 0).toDouble()

                val isBottom = (scrollY + windowHeight) >= (docHeight - 120.0)

                val activeSection = if (isBottom) {
                    "faq"
                } else if (scrollY < 80.0) {
                    ""
                } else {
                    var found = ""
                    val triggerLine = windowHeight * 0.35
                    for (id in serviceIds) {
                        val el = document.getElementById(id) ?: continue
                        val rect = el.getBoundingClientRect()
                        if (rect.top <= triggerLine && rect.bottom > triggerLine) {
                            found = id
                            break
                        }
                    }
                    found
                }

                if (activeSection != currentSection) {
                    currentSection = activeSection
                    val targetUrl = if (activeSection.isNotEmpty()) "/service/$activeSection" else "/service"
                    if (window.location.pathname != targetUrl) {
                        window.history.replaceState(null, "", targetUrl)
                    }
                }
            }
        }
        window.addEventListener("scroll", onScroll)

        onDispose {
            window.removeEventListener("hashchange", onHashChange)
            window.removeEventListener("popstate", onPopState)
            window.removeEventListener("scroll", onScroll)
        }
    }

    LaunchedEffect(Unit) {
        window.addEventListener("click", { event: Event ->
            val model = window.document.getElementById(lightboxDialogId)
            if (event.target == model) {
                isShowLightbox = false
            }
        })
        window.addEventListener("keydown", { event: Event ->
            val keyboardEvent = event.asDynamic()
            if (keyboardEvent.key == "Escape") {
                isShowLightbox = false
            }
        })
    }

    LaunchedEffect(isShowLightbox, activeService) {
        val model = window.document.getElementById(lightboxDialogId)
        val modal = model?.asDynamic()
        val body = window.document.body?.asDynamic()

        if (isShowLightbox && activeService != null) {
            modal?.style?.display = "block"
            resetDialogScroll(lightboxDialogId)
            body?.style?.setProperty("overflow", "hidden")
        } else {
            modal?.style?.display = "none"
            resetDialogScroll(lightboxDialogId)
            body?.style?.removeProperty("overflow")
        }
    }

    PageLayout(
        title = Section.SERVICE.title
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
            SpanText(
                text = "⚡ Professional Engineering Services",
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
                text = "From greenfield mobile apps and KMP cross-platform systems to performance audit & bug triage.",
                modifier = Modifier
                    .fillMaxWidth(if (isDesktop) 65.percent else 90.percent)
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

            // Horizontal Agency-Style Split Cards
            Column(
                modifier = Modifier
                    .fillMaxWidth(if (breakpoint > Breakpoint.LG) 85.percent else if (isDesktop) 88.percent else 94.percent)
                    .padding(bottom = 36.px)
                    .gap(12.px),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                services.forEach { service ->
                    ServiceCard(
                        service = service,
                        onImageClick = { s, index ->
                            activeService = s
                            activeImageIndex = index
                            isShowLightbox = true
                        }
                    )
                }
            }

            SpanText(
                text = "🙋 Frequently Asked Questions",
                modifier = Modifier
                    .id("faq")
                    .styleModifier { property("scroll-margin-top", "80px") }
                    .fillMaxWidth()
                    .padding(top = 20.px, bottom = 6.px, leftRight = 10.px)
                    .color(
                        CustomColor(
                            lightColor = Theme.LightFontColor,
                            darkColor = Theme.DarkFontColor
                        )
                    )
                    .fontFamily(Res.Font.FONT_FAMILY_HEADING)
                    .fontSize(if (breakpoint > Breakpoint.SM) 2.0.cssRem else 1.6.cssRem)
                    .fontWeight(FontWeight.Bold)
                    .textAlign(TextAlign.Center)
            )

            SpanText(
                text = "Everything you need to know about working together, timelines, and deliverables.",
                modifier = Modifier
                    .fillMaxWidth(if (isDesktop) 65.percent else 90.percent)
                    .padding(bottom = 24.px, leftRight = 20.px)
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
                numColumns = numColumns(base = 1, sm = 1, md = 1, lg = 1, xl = 1),
                modifier = Modifier
                    .fillMaxWidth(if (isDesktop) 82.percent else 92.percent)
                    .padding(bottom = 36.px)
            ) {
                faqs.forEach { faq ->
                    FAQCard(faq)
                }
            }

            Footer()
        }
    }

    // High-Resolution Lightbox Dialog
    val currentActiveService = activeService ?: services.firstOrNull()
    if (currentActiveService != null) {
        CustomDialog(
            modifier = Modifier.fillMaxWidth(
                if (isDesktop) 72.percent else 95.percent
            ),
            dialogId = lightboxDialogId,
            resetKey = activeService?.title
        ) {
            ServiceLightboxDialog(
                service = currentActiveService,
                initialIndex = activeImageIndex,
                onDismiss = {
                    isShowLightbox = false
                }
            )
        }
    }
}
