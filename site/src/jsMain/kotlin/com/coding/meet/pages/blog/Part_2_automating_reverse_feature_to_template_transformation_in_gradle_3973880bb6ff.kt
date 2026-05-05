package com.coding.meet.pages.blog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.coding.meet.screens.articles_detail.components.ArticleDetail
import com.coding.meet.util.ArticleData
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/blog/part-2-automating-reverse-feature-to-template-transformation-in-gradle-3973880bb6ff")
@Composable
fun Part_2_automating_reverse_feature_to_template_transformation_in_gradle_3973880bb6ff(context: PageContext) {

    val article = remember {
        ArticleData.articles.find { it.id == "part-2-automating-reverse-feature-to-template-transformation-in-gradle-3973880bb6ff" }
    }
    
    if (article != null) {
        ArticleDetail(article = article, context = context)
    }
}