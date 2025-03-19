package com.coding.meet.models

data class Achievement(
    val title: String,
    val subtitle: String,
    val platform: String,
    val link : String,
    val lightImage: String,
    val darkImage: String? = null
)