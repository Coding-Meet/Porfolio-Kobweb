package com.coding.meet.pages.blog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.coding.meet.screens.articles_detail.components.ArticleDetail
import com.coding.meet.util.ArticleData
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/blog/how-to-implement-shaders-in-compose-multiplatform-android-ios-desktop-web-c86a36dd9666")
@Composable
fun How_to_implement_shaders_in_compose_multiplatform_android_ios_desktop_web_c86a36dd9666(context: PageContext) {

    val article = remember {
        ArticleData.articles.find { it.id == "how-to-implement-shaders-in-compose-multiplatform-android-ios-desktop-web-c86a36dd9666" }
    }
    
    if (article != null) {
        ArticleDetail(article = article, context = context)
    }
}