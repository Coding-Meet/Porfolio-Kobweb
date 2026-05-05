package com.coding.meet.pages.blog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.coding.meet.screens.articles_detail.components.ArticleDetail
import com.coding.meet.util.ArticleData
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/blog/how-to-integrate-viewmodel-in-kotlin-multiplatform-with-koin-1a1134530215")
@Composable
fun How_to_integrate_viewmodel_in_kotlin_multiplatform_with_koin_1a1134530215(context: PageContext) {

    val article = remember {
        ArticleData.articles.find { it.id == "how-to-integrate-viewmodel-in-kotlin-multiplatform-with-koin-1a1134530215" }
    }
    
    if (article != null) {
        ArticleDetail(article = article, context = context)
    }
}