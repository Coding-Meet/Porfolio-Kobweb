package com.coding.meet.pages.blog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.coding.meet.screens.articles_detail.components.ArticleDetail
import com.coding.meet.util.ArticleData
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext

@Page("/blog/cross-platform-text-to-speech-with-real-time-highlighting-kotlin-multiplatform-swift-9a02fa667f6f")
@Composable
fun Cross_platform_text_to_speech_with_real_time_highlighting_kotlin_multiplatform_swift_9a02fa667f6f(context: PageContext) {

    val article = remember {
        ArticleData.articles.find { it.id == "cross-platform-text-to-speech-with-real-time-highlighting-kotlin-multiplatform-swift-9a02fa667f6f" }
    }
    
    if (article != null) {
        ArticleDetail(article = article, context = context)
    }
}