package com.coding.meet.pages

import androidx.compose.runtime.Composable
import com.coding.meet.common.components.footer.Footer
import com.coding.meet.common.page_layout.PageLayout
import com.coding.meet.models.Section
import com.coding.meet.screens.home.about_me.components.AboutMeSection
import com.coding.meet.screens.home.experience.components.ExperiencesSection
import com.coding.meet.screens.home.testimonial.components.TestimonialSection
import com.coding.meet.common.page_layout.fadeInUpPageAnimation
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.style.animation.toAnimation
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.s

@Page
@Composable
fun HomePage() {
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
            AboutMeSection()
            ExperiencesSection()
            TestimonialSection()
            Footer()
        }
    }
}
