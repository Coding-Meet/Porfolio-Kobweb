package com.coding.meet.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.coding.meet.models.articlesDetailPath
import com.coding.meet.models.articlesPath
import com.coding.meet.screens.articles_detail.components.ArticleDetail
import com.coding.meet.util.ArticleData
import com.coding.meet.util.setPageMeta
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext


@Page(articlesDetailPath)
@Composable
fun ArticleDetailPage(context: PageContext) {
    val articleId = context.route.params["id"]
    val article = remember(articleId) {
        articleId?.let { id ->
            ArticleData.articles.find { it.id == id }
        }
    }

    LaunchedEffect(articleId, article) {
        if (articleId == null || article == null) {
            context.router.navigateTo(articlesPath)
        }
        article?.let {
            setPageMeta(
                title = article.title,
                description = article.shortDescription,
                image = "https://codingmeet.com" + article.thumbnail
            )
        }
    }

    article?.let { ArticleDetail(it, context) }
}