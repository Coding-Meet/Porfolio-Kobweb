package com.coding.meet.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import com.coding.meet.common.components.footer.Footer
import com.coding.meet.common.page_layout.PageLayout
import com.coding.meet.common.page_layout.fadeInUpPageAnimation
import com.coding.meet.models.Section
import com.coding.meet.screens.home.about_me.components.AboutMeSection
import com.coding.meet.screens.home.achievements.components.AchievementsSection
import com.coding.meet.screens.home.experience.components.ExperiencesSection
import com.coding.meet.screens.home.testimonial.components.TestimonialSection
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.style.animation.toAnimation
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.events.Event

@Page
@Composable
fun HomePage() {
    DisposableEffect(Unit) {
        val initialHash = window.location.hash
        var isAutoScrolling = initialHash.isNotEmpty()
        var currentSection = ""
        val sections = listOf("aboutme", "achievement", "experience", "testimonial")

        fun scrollToTarget(hash: String, retryCount: Int = 0) {
            val clean = hash.removePrefix("#").trim().lowercase()
            if (clean.isEmpty()) {
                isAutoScrolling = false
                return
            }

            val targetId = when (clean) {
                "aboutme", "about-me", "about" -> "aboutme"
                "achievement", "achievements" -> "achievement"
                "experience", "experiences" -> "experience"
                "testimonial", "testimonials", "review", "reviews" -> "testimonial"
                "footer", "contact" -> "footer"
                else -> clean
            }

            val element = document.getElementById(targetId)
            val offsetTop = (element.asDynamic()?.offsetTop as? Number)?.toDouble() ?: 0.0

            // If element is not yet attached or laid out in DOM, retry up to 12 times (1.2s max)
            if ((element == null || (targetId != "aboutme" && offsetTop == 0.0)) && retryCount < 12) {
                window.setTimeout({ scrollToTarget(hash, retryCount + 1) }, 100)
                return
            }

            if (element != null) {
                isAutoScrolling = true
                currentSection = targetId

                val targetHash = "#$targetId"
                if (window.location.hash != targetHash) {
                    window.history.replaceState(null, "", targetHash)
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

        // Handle initial load if hash is present
        if (initialHash.isNotEmpty()) {
            window.setTimeout({ scrollToTarget(initialHash) }, 80)
        }

        // Handle dynamic hash changes in the URL (anchor clicks, back/forward)
        val onHashChange: (Event) -> Unit = {
            if (window.location.hash.isNotEmpty()) {
                isAutoScrolling = true
                scrollToTarget(window.location.hash)
            }
        }
        window.addEventListener("hashchange", onHashChange)

        // Scroll Spy: Update URL hash as the user scrolls past sections
        val onScroll: (Event) -> Unit = {
            if (!isAutoScrolling) {
                val scrollY = (window.asDynamic().pageYOffset as? Number)?.toDouble()
                    ?: (document.documentElement?.scrollTop ?: 0.0)
                val windowHeight = (window.asDynamic().innerHeight as? Number)?.toDouble() ?: 800.0
                val docHeight = (document.documentElement?.scrollHeight ?: 0).toDouble()

                val isBottom = (scrollY + windowHeight) >= (docHeight - 120.0)

                val activeSection = if (isBottom) {
                    "testimonial"
                } else if (scrollY < 80.0) {
                    "aboutme"
                } else {
                    var found = ""
                    val triggerLine = windowHeight * 0.35
                    for (id in sections) {
                        val el = document.getElementById(id) ?: continue
                        val rect = el.getBoundingClientRect()
                        if (rect.top <= triggerLine && rect.bottom > triggerLine) {
                            found = id
                            break
                        }
                    }
                    found
                }

                if (activeSection.isNotEmpty() && activeSection != currentSection) {
                    currentSection = activeSection
                    val newHash = "#$activeSection"
                    if (window.location.hash != newHash) {
                        window.history.replaceState(null, "", newHash)
                    }
                }
            }
        }
        window.addEventListener("scroll", onScroll)

        onDispose {
            window.removeEventListener("hashchange", onHashChange)
            window.removeEventListener("scroll", onScroll)
        }
    }

    PageLayout(
        title = Section.HOME.title
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .animation(
                    fadeInUpPageAnimation.toAnimation(
                        duration = 0.8.s,
                        timingFunction = AnimationTimingFunction.EaseOut
                    )
                ),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // About Me Section (#aboutme, #about)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .id("aboutme")
                    .styleModifier { property("scroll-margin-top", "80px") },
                contentAlignment = Alignment.Center
            ) {
                Div(attrs = Modifier.id("about").styleModifier { property("scroll-margin-top", "80px") }.toAttrs())
                AboutMeSection()
            }

            // Achievements Section (#achievement, #achievements)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .id("achievement")
                    .styleModifier { property("scroll-margin-top", "80px") },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Div(attrs = Modifier.id("achievements").styleModifier { property("scroll-margin-top", "80px") }.toAttrs())
                AchievementsSection()
            }

            // Experiences Section (#experience, #experiences)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .id("experience")
                    .styleModifier { property("scroll-margin-top", "80px") },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Div(attrs = Modifier.id("experiences").styleModifier { property("scroll-margin-top", "80px") }.toAttrs())
                ExperiencesSection()
            }

            // Testimonials Section (#testimonial, #testimonials)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .id("testimonial")
                    .styleModifier { property("scroll-margin-top", "80px") },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Div(attrs = Modifier.id("testimonials").styleModifier { property("scroll-margin-top", "80px") }.toAttrs())
                TestimonialSection()
            }

            // Footer (#footer)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .id("footer")
                    .styleModifier { property("scroll-margin-top", "80px") },
                contentAlignment = Alignment.Center
            ) {
                Footer()
            }
        }
    }
}

