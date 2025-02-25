package com.coding.meet.models

data class Service(
    val title: String,
    val description: String,
    val features: List<String> = arrayListOf(),
    val imageUrls: List<String> = arrayListOf(),
)