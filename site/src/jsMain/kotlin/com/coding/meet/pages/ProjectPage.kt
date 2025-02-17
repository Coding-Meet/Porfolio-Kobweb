package com.coding.meet.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.common.components.custom_dialog.CustomDialog
import com.coding.meet.common.page_layout.PageLayout
import com.coding.meet.models.Project
import com.coding.meet.models.Section
import com.coding.meet.models.projectsPath
import com.coding.meet.screens.projects.components.ProjectCard
import com.coding.meet.util.Constants
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.window
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text


@Page(projectsPath)
@Composable
fun ProjectPage() {
    val breakpoint = rememberBreakpoint()
    PageLayout(
        title = Section.PROJECTS.title
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var isShowDialog by remember { mutableStateOf(false) }
            val dialogId by remember { mutableStateOf("currentProjectDialog") }
            var openProject by remember { mutableStateOf<Project?>(null) }

            LaunchedEffect(Unit) {
                window.addEventListener("click", {
                    val model = window.document.getElementById(dialogId)
                    val modal = model?.asDynamic()
                    if (it.target == modal) {
                        isShowDialog = !isShowDialog
                        openProject = null
                    }
                })
            }
            LaunchedEffect(isShowDialog) {
                if (isShowDialog) {
                    val model = window.document.getElementById(dialogId)
                    val modal = model?.asDynamic()
                    modal?.style?.display = "block"
                } else {
                    val model = window.document.getElementById(dialogId)
                    val modal = model?.asDynamic()
                    modal?.style?.display = "none"
                }
            }

            openProject?.let { currentProject ->
                CustomDialog(
                    dialogId,
                ) {
//                    onDismiss = {
//                        showModal = false
//                        openProject = null
//                    }
                    Text(
                        currentProject.title,
                    )
                }
            }
            SimpleGrid(
                numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 3),
                modifier = Modifier.fillMaxWidth(if (breakpoint > Breakpoint.SM) 90.percent else 100.percent)
                    .padding(top = 10.px)
            ) {
                Constants.projects.forEach { project ->
                    ProjectCard(project) {
                        openProject = project
                        isShowDialog = true
                    }
                }
            }
        }
    }
}