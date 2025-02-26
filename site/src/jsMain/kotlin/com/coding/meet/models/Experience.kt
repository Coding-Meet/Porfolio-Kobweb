package com.coding.meet.models

data class Experience(
    val title: String,
    val company: String,
    val type: String,
    val startDate: String,
    val endDate: String?,
    val duration: String,
    val location: String,
    val description: String
)