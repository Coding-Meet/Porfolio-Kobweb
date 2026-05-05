package com.coding.meet.pages.blog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.coding.meet.screens.articles_detail.components.ArticleDetail
import com.coding.meet.util.ArticleData
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/blog/how-to-integrate-bottom-navigation-bar-for-compact-screens-and-a-navigation-rail-for-larger-screens-c7dc3baab0e7")
@Composable
fun How_to_integrate_bottom_navigation_bar_for_compact_screens_and_a_navigation_rail_for_larger_screens_c7dc3baab0e7(context: PageContext) {

    val article = remember {
        ArticleData.articles.find { it.id == "how-to-integrate-bottom-navigation-bar-for-compact-screens-and-a-navigation-rail-for-larger-screens-c7dc3baab0e7" }
    }
    
    if (article != null) {
        ArticleDetail(article = article, context = context)
    }
}