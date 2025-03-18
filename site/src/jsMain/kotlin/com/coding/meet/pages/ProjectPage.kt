package com.coding.meet.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.common.components.custom_dialog.CustomDialog
import com.coding.meet.common.components.footer.Footer
import com.coding.meet.common.page_layout.PageLayout
import com.coding.meet.common.page_layout.fadeInUpPageAnimation
import com.coding.meet.models.Project
import com.coding.meet.models.ProjectCategory
import com.coding.meet.models.Section
import com.coding.meet.models.projectsPath
import com.coding.meet.screens.projects.components.ProjectCard
import com.coding.meet.screens.projects.components.ProjectDialog
import com.coding.meet.screens.projects.styles.CategoryButtonStyle
import com.coding.meet.screens.projects.styles.rotateAnimation
import com.coding.meet.util.Constants
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.BackgroundPosition
import com.varabyte.kobweb.compose.css.CSSPosition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.backgroundPosition
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div


@Page(projectsPath)
@Composable
fun ProjectPage() {
    val breakpoint = rememberBreakpoint()
    PageLayout(
        title = Section.PROJECTS.title
    ) {
        var selectedCategory by remember { mutableStateOf(ProjectCategory.ALL) }
        var isLoading by remember { mutableStateOf(false) }
        var filteredProjects by remember { mutableStateOf(Constants.projects) }

        LaunchedEffect(selectedCategory) {
            isLoading = true
            delay(300)
            filteredProjects = if (selectedCategory == ProjectCategory.ALL) {
                Constants.projects
            } else {
                Constants.projects.filter { it.categories.contains(selectedCategory) }
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
                        isShowDialog = !isShowDialog
                        openProject = null
                        currentProjectIndex = null
                    }
                })
            }
            LaunchedEffect(isShowDialog) {
                val model = window.document.getElementById(dialogId)
                val modal = model?.asDynamic()
                val body = window.document.body?.asDynamic()

                if (isShowDialog) {
                    modal?.style?.display = "block"
                    body?.style?.setProperty("overflow", "hidden") // Disable scrolling
                } else {
                    modal?.style?.display = "none"
                    body?.style?.removeProperty("overflow") // Restore default scrolling
                }
            }

            openProject?.let { currentProject ->
                CustomDialog(
                    modifier = Modifier.fillMaxWidth(
                        if (breakpoint > Breakpoint.MD) 60.percent else 90.percent
                    ),
                    dialogId = dialogId,
                ) {
                    ProjectDialog(
                        project = currentProject,
                        selectedCategory= selectedCategory,
                        onDismiss = {
                            isShowDialog = false
                            openProject = null
                        }, onPrevious = {
                            if (currentProjectIndex != null) {
                                if (currentProjectIndex!! > 0) {
                                    currentProjectIndex = currentProjectIndex!! - 1
                                    openProject = filteredProjects[currentProjectIndex!!]
                                }
                            }

                        }, onNext = {
                            if (currentProjectIndex != null) {
                                if (currentProjectIndex!! < filteredProjects.size - 1) {
                                    currentProjectIndex = currentProjectIndex!! + 1
                                    openProject = filteredProjects[currentProjectIndex!!]
                                }
                            }

                        }
                    )
                }
            }
            Div(
                attrs = Modifier.fillMaxWidth().display(value = DisplayStyle.Flex)
                    .flexWrap(FlexWrap.Wrap)
                    .margin(top = 10.px).justifyContent(JustifyContent.Center).toAttrs()
            ) {
                ProjectCategory.entries.forEach { projectCategory ->
                    Button(
                        attrs = CategoryButtonStyle.toModifier().then(
                            if (projectCategory == selectedCategory) Modifier
                                .boxShadow(0.px, 0.px, 0.3.em, null, rgba(0, 0, 0, 0.25f))
                                .backgroundPosition(BackgroundPosition.of(CSSPosition(0.px)))
                                .color(
                                    CustomColor(
                                        lightColor = Theme.DarkFontColor,
                                        darkColor = Theme.LightFontColor
                                    )
                                )
                            else Modifier
                        )
                            .margin(10.px).toAttrs {
                                onClick {
                                    selectedCategory = projectCategory
                                }
                            }
                    ) {
                        SpanText(
                            text = projectCategory.title,
                        )
                    }
                }
            }
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
                        )
                ) {
                    filteredProjects.forEachIndexed { index, project ->
                        ProjectCard(project) {
                            openProject = project
                            currentProjectIndex = index
                            isShowDialog = true
                        }
                    }
                }
            }
            Footer()
        }
    }
}