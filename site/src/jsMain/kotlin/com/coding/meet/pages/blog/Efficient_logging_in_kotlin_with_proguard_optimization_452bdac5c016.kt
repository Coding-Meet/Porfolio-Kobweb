package com.coding.meet.pages.blog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.coding.meet.screens.articles_detail.components.ArticleDetail
import com.coding.meet.util.ArticleData
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/blog/efficient-logging-in-kotlin-with-proguard-optimization-452bdac5c016")
@Composable
fun Efficient_logging_in_kotlin_with_proguard_optimization_452bdac5c016(context: PageContext) {

    val article = remember {
        ArticleData.articles.find { it.id == "efficient-logging-in-kotlin-with-proguard-optimization-452bdac5c016" }
    }
    
    if (article != null) {
        ArticleDetail(article = article, context = context)
    }
}