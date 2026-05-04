package com.coding.meet.util

import kotlinx.browser.document

fun setPageMeta(
    title: String?,
    description: String?,
    image: String?
) {
    val head = document.head ?: return

    // Title
    title?.let {
        document.title = it
    }

    // Description
    description?.let { desc ->
        val metaDesc = head.querySelector("meta[name='description']")
            ?: document.createElement("meta").apply {
                setAttribute("name", "description")
                head.appendChild(this)
            }
        metaDesc.setAttribute("content", desc)
    }

    // OG Title
    title?.let {
        val ogTitle = head.querySelector("meta[property='og:title']")
            ?: document.createElement("meta").apply {
                setAttribute("property", "og:title")
                head.appendChild(this)
            }
        ogTitle.setAttribute("content", it)
    }

    // OG Description
    description?.let { desc ->
        val ogDesc = head.querySelector("meta[property='og:description']")
            ?: document.createElement("meta").apply {
                setAttribute("property", "og:description")
                head.appendChild(this)
            }
        ogDesc.setAttribute("content", desc)
    }

    // OG Image
    image?.let { img ->
        val ogImage = head.querySelector("meta[property='og:image']")
            ?: document.createElement("meta").apply {
                setAttribute("property", "og:image")
                head.appendChild(this)
            }
        ogImage.setAttribute("content", img)
    }
}