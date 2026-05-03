package com.coding.meet.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object DummyArticleState {
    var selectedArticle by mutableStateOf<Article?>(null)
}