package com.coding.meet.util

import kotlinx.browser.document
import kotlinx.browser.window
import kotlin.js.json

object Analytics {
    // Initialized to current pathname on page load to prevent duplicate
    // pageviews since the HTML head script already logs the initial landing page.
    private var lastTrackedPath: String? = window.location.pathname

    /**
     * Sends a virtual pageview event to Google Analytics (GA4).
     * Essential for Single Page Applications (SPAs) where client-side navigation
     * occurs without full browser reloads.
     */
    fun trackPageView(
        title: String = document.title,
        path: String = window.location.pathname
    ) {
        // Prevent duplicate pageview logging for identical path
        if (lastTrackedPath == path) return

        lastTrackedPath = path
        try {
            val gtag = window.asDynamic().gtag
            if (gtag != undefined) {
                gtag(
                    "event",
                    "page_view",
                    json(
                        "page_title" to title,
                        "page_location" to window.location.href,
                        "page_path" to path
                    )
                )
            }
        } catch (_: Throwable) {
            // Silently ignore if blocked by ad-blockers or analytics script failed to load
        }
    }

    /**
     * Sends a custom user interaction event to Google Analytics (e.g. project view, contact click).
     */
    fun trackEvent(
        eventName: String,
        params: Map<String, Any> = emptyMap()
    ) {
        try {
            val gtag = window.asDynamic().gtag
            if (gtag != undefined) {
                val jsParams = json()
                params.forEach { (key, value) ->
                    jsParams[key] = value
                }
                gtag("event", eventName, jsParams)
            }
        } catch (_: Throwable) {
            // Silently ignore
        }
    }
}
