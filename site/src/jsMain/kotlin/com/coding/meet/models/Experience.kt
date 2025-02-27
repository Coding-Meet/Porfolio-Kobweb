package com.coding.meet.models

data class Experience(
    val title: String,
    val company: String,
    val type: String,
    val startDate: String,
    val endDate: String? = null,
    val duration: String? = null,
    val location: String,
    val description: String
)