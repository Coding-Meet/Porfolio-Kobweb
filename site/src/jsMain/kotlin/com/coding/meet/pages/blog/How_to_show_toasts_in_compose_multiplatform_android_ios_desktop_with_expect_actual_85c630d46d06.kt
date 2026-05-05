package com.coding.meet.pages.blog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.coding.meet.screens.articles_detail.components.ArticleDetail
import com.coding.meet.util.ArticleData
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/blog/how-to-show-toasts-in-compose-multiplatform-android-ios-desktop-with-expect-actual-85c630d46d06")
@Composable
fun How_to_show_toasts_in_compose_multiplatform_android_ios_desktop_with_expect_actual_85c630d46d06(context: PageContext) {

    val article = remember {
        ArticleData.articles.find { it.id == "how-to-show-toasts-in-compose-multiplatform-android-ios-desktop-with-expect-actual-85c630d46d06" }
    }
    
    if (article != null) {
        ArticleDetail(article = article, context = context)
    }
}