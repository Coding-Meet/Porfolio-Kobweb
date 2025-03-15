package com.coding.meet.models

data class Achievement(
    val title: String,
    val subtitle: String,
    val lightImage: String,
    val darkImage: String? = null
)