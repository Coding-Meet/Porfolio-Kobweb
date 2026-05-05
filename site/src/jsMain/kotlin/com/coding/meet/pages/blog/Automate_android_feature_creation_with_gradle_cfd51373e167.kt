package com.coding.meet.pages.blog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.coding.meet.screens.articles_detail.components.ArticleDetail
import com.coding.meet.util.ArticleData
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/blog/automate-android-feature-creation-with-gradle-cfd51373e167")
@Composable
fun Automate_android_feature_creation_with_gradle_cfd51373e167(context: PageContext) {

    val article = remember {
        ArticleData.articles.find { it.id == "automate-android-feature-creation-with-gradle-cfd51373e167" }
    }
    
    if (article != null) {
        ArticleDetail(article = article, context = context)
    }
}