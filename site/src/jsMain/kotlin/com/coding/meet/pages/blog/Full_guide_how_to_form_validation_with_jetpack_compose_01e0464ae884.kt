package com.coding.meet.pages.blog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.coding.meet.screens.articles_detail.components.ArticleDetail
import com.coding.meet.util.ArticleData
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/blog/full-guide-how-to-form-validation-with-jetpack-compose-01e0464ae884")
@Composable
fun Full_guide_how_to_form_validation_with_jetpack_compose_01e0464ae884(context: PageContext) {

    val article = remember {
        ArticleData.articles.find { it.id == "full-guide-how-to-form-validation-with-jetpack-compose-01e0464ae884" }
    }
    
    if (article != null) {
        ArticleDetail(article = article, context = context)
    }
}