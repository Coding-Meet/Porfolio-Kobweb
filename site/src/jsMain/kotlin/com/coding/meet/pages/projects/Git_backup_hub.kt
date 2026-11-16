package com.coding.meet.pages.projects

import androidx.compose.runtime.Composable
import com.coding.meet.pages.ProjectPage
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/projects/git-backup-hub")
@Composable
fun Git_backup_hub(context: PageContext) {
    ProjectPage(context = context)
}
