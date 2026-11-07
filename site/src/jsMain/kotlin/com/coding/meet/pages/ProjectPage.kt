package com.coding.meet.pages

import androidx.compose.runtime.Composable
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
import com.coding.meet.data.network.GithubStargazersCountData
import com.coding.meet.models.Project
import com.coding.meet.models.ProjectCategory
import com.coding.meet.models.Section
import com.coding.meet.models.projectsPath
import com.coding.meet.screens.projects.components.ProjectCard
import com.coding.meet.screens.projects.components.ProjectCategorySection
import com.coding.meet.screens.projects.components.ProjectDialog
import com.coding.meet.screens.projects.styles.rotateAnimation
import com.coding.meet.util.CustomColor
import com.coding.meet.util.ProjectData.projects
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.coding.meet.util.select
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.Div

@Page(projectsPath)
@Composable
fun ProjectPage() {
    val breakpoint = rememberBreakpoint()
    val colorMode by ColorMode.currentState
    PageLayout(
        title = Section.PROJECTS.title
    ) {
        var selectedCategory by remember { mutableStateOf(ProjectCategory.ALL) }
        var isLoading by remember { mutableStateOf(false) }
        val projectsState = remember { mutableStateOf(projects.toMutableList()) }
        GithubStargazersCountData(projectsState)
        var filteredProjects by remember { mutableStateOf(projectsState.value) }

        LaunchedEffect(selectedCategory) {
            isLoading = true
            delay(300)
            filteredProjects = if (selectedCategory == ProjectCategory.ALL) {
                projectsState.value
            } else {
                projectsState.value.filter { it.categories.contains(selectedCategory) }
                    .toMutableList()
            }
            isLoading = false
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
            var isShowDialog by remember { mutableStateOf(false) }
            val dialogId by remember { mutableStateOf("currentProjectDialog") }
            var openProject by remember { mutableStateOf<Project?>(null) }
            var currentProjectIndex by remember { mutableStateOf<Int?>(null) }

            LaunchedEffect(Unit) {
                window.addEventListener("click", {
                    val model = window.document.getElementById(dialogId)
                    val modal = model?.asDynamic()
                    if (it.target == modal) {
                        isShowDialog = false
                    }
                })
                window.addEventListener("keydown", {
                    val keyboardEvent = it.asDynamic()
                    if (keyboardEvent.key == "Escape") {
                        isShowDialog = false
                    }
                })
            }
            LaunchedEffect(isShowDialog, openProject) {
                val model = window.document.getElementById(dialogId)
                val modal = model?.asDynamic()
                val body = window.document.body?.asDynamic()

                if (isShowDialog) {
                    modal?.style?.display = "block"
                    resetDialogScroll(dialogId)
                    body?.style?.setProperty("overflow", "hidden") // Disable scrolling
                } else {
                    modal?.style?.display = "none"
                    resetDialogScroll(dialogId)
                    body?.style?.removeProperty("overflow") // Restore default scrolling
                }
            }

            val activeProject =
                openProject ?: filteredProjects.firstOrNull() ?: projects.firstOrNull()
            if (activeProject != null) {
                CustomDialog(
                    modifier = Modifier.fillMaxWidth(
                        if (breakpoint > Breakpoint.MD) 65.percent else 92.percent
                    ),
                    dialogId = dialogId,
                    resetKey = openProject?.title,
                ) {
                    ProjectDialog(
                        project = activeProject,
                        isNextPreviousBtnShow = filteredProjects.size > 1,
                        onDismiss = {
                            isShowDialog = false
                        },
                        onPrevious = {
                            if (filteredProjects.isNotEmpty()) {
                                val prevIdx =
                                    if (currentProjectIndex == null || currentProjectIndex!! <= 0) {
                                        filteredProjects.size - 1
                                    } else {
                                        currentProjectIndex!! - 1
                                    }
                                currentProjectIndex = prevIdx
                                openProject = filteredProjects[prevIdx]
                                resetDialogScroll(dialogId)
                            }
                        },
                        onNext = {
                            if (filteredProjects.isNotEmpty()) {
                                val nextIdx =
                                    if (currentProjectIndex == null || currentProjectIndex!! >= filteredProjects.size - 1) {
                                        0
                                    } else {
                                        currentProjectIndex!! + 1
                                    }
                                currentProjectIndex = nextIdx
                                openProject = filteredProjects[nextIdx]
                                resetDialogScroll(dialogId)
                            }
                        }
                    )
                }
            }
            SpanText(
                text = "🚀 Featured Projects & Apps",
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
                text = "Production-grade Android, Kotlin Multiplatform, Desktop, Web, and IoT systems built with modern architecture.",
                modifier = Modifier
                    .fillMaxWidth(if (breakpoint > Breakpoint.MD) 65.percent else 90.percent)
                    .padding(bottom = 12.px, leftRight = 20.px)
                    .color(
                        CustomColor(
                            lightColor = Theme.DarkGray,
                            darkColor = Theme.Muted
                        )
                    )
                    .fontSize(if (breakpoint > Breakpoint.SM) 1.cssRem else 0.9.cssRem)
                    .textAlign(TextAlign.Center)
                    .lineHeight(1.5)
            )

            Row(
                modifier = Modifier
                    .margin(top = 4.px, bottom = 8.px)
                    .padding(topBottom = 6.px, leftRight = 16.px)
                    .borderRadius(9999.px)
                    .backgroundColor(colorMode.select(Theme.Primary.subtle, Theme.Primary.soft))
                    .border(1.px, LineStyle.Solid, Theme.Primary.medium),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                SpanText(
                    text = "✨ 100% Authentic Live UI: Presentation mockups are AI-crafted, while all device screenshots display real, working applications.",
                    modifier = Modifier
                        .fontSize(if (breakpoint > Breakpoint.SM) 0.85.cssRem else 0.75.cssRem)
                        .fontWeight(FontWeight.Medium)
                        .color(colorMode.select(Theme.PrimaryDark.color, Theme.PrimaryLight.color))
                        .textAlign(TextAlign.Center)
                )
            }

            ProjectCategorySection(
                selectedCategory = selectedCategory,
                onCategorySelected = {
                    selectedCategory = it
                }
            )
            if (isLoading) {
                // Circular Progress Indicator
                Div(attrs = rotateAnimation.toAttrs())
            } else {
                SimpleGrid(
                    numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 3),
                    modifier = Modifier.fillMaxWidth()
                        .padding(
                            bottom = 10.px,
                            leftRight = if (breakpoint > Breakpoint.SM) 10.px else 0.px
                        ).animation(
                            fadeInUpPageAnimation.toAnimation(
                                duration = 1.s,
                                timingFunction = AnimationTimingFunction.EaseOut
                            )
                        ),
                ) {
                    filteredProjects.forEachIndexed { index, project ->
                        ProjectCard(project) {
                            openProject = project
                            currentProjectIndex = index
                            isShowDialog = true
                            resetDialogScroll(dialogId)
                        }
                    }
                }
            }
            Footer()
        }
    }
}