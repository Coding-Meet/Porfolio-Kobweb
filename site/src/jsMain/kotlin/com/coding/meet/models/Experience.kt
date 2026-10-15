package com.coding.meet.models

import kotlin.js.Date

data class Experience(
    val title: String,
    val company: String,
    val type: String,
    val startDate: String,
    val endDate: String? = null,
    val duration: String? = null,
    val location: String,
    val description: String
) {
    val displayDuration: String
        get() {
            if (!duration.isNullOrBlank() && endDate != "Present") {
                return duration
            }
            return calculateDuration(startDate, endDate)
        }

    companion object {
        private val monthMap = mapOf(
            "Jan" to 0, "Feb" to 1, "Mar" to 2, "Apr" to 3,
            "May" to 4, "Jun" to 5, "Jul" to 6, "Aug" to 7,
            "Sep" to 8, "Oct" to 9, "Nov" to 10, "Dec" to 11
        )

        fun calculateDuration(startDate: String, endDate: String? = null): String {
            val startParts = startDate.trim().split(" ")
            val startMonth = monthMap[startParts.getOrNull(0)] ?: 0
            val startYear = startParts.getOrNull(1)?.toIntOrNull() ?: 2023

            val (endYear, endMonth) = if (endDate == null || endDate.equals(
                    "Present",
                    ignoreCase = true
                )
            ) {
                val now = Date()
                Pair(now.getFullYear(), now.getMonth())
            } else {
                val endParts = endDate.trim().split(" ")
                val m = monthMap[endParts.getOrNull(0)] ?: 0
                val y = endParts.getOrNull(1)?.toIntOrNull() ?: startYear
                Pair(y, m)
            }

            val totalMonths = (endYear - startYear) * 12 + (endMonth - startMonth) + 1
            if (totalMonths <= 0) return "1 mo"

            val years = totalMonths / 12
            val months = totalMonths % 12

            return when {
                years > 0 && months > 0 -> "$years yr${if (years > 1) "s" else ""} $months mo${if (months > 1) "s" else ""}"
                years > 0 -> "$years yr${if (years > 1) "s" else ""}"
                else -> "$months mo${if (months > 1) "s" else ""}"
            }
        }
    }
}