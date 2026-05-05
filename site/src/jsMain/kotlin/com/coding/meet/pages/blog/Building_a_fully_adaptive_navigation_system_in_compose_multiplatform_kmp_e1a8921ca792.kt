package com.coding.meet.pages.blog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.coding.meet.screens.articles_detail.components.ArticleDetail
import com.coding.meet.util.ArticleData
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/blog/building-a-fully-adaptive-navigation-system-in-compose-multiplatform-kmp-e1a8921ca792")
@Composable
fun Building_a_fully_adaptive_navigation_system_in_compose_multiplatform_kmp_e1a8921ca792(context: PageContext) {

    val article = remember {
        ArticleData.articles.find { it.id == "building-a-fully-adaptive-navigation-system-in-compose-multiplatform-kmp-e1a8921ca792" }
    }
    
    if (article != null) {
        ArticleDetail(article = article, context = context)
    }
}