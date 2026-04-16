package com.coding.meet.data.network

/**
 * Compares online items with local data.
 * Logs if an item is entirely missing locally, or if the local version is "old" (outdated).
 */
fun <L, O> checkLatestData(
    label: String,
    localItems: List<L>,
    onlineItems: List<O>,
    getLocalId: (L) -> String?,
    getOnlineId: (O) -> String?,
    getOnlineTitle: (O) -> String,
    isUpToDate: (L, O) -> Boolean,
    showNewItems: Boolean = true // Added this flag
) {
    val localIds = localItems.mapNotNull { getLocalId(it) }.toSet()

    // Only log new items if requested
    if (showNewItems) {
        onlineItems.forEach { onlineItem ->
            val onlineId = getOnlineId(onlineItem)
            if (onlineId != null && onlineId !in localIds) {
                console.log("NEW $label FOUND: ${getOnlineTitle(onlineItem)} ($onlineId)")
            }
        }
    }

    // Log items that exist locally but have different data online
    localItems.forEach { localItem ->
        val localId = getLocalId(localItem)
        if (localId != null) {
            onlineItems.find { getOnlineId(it) == localId }?.let { onlineItem ->
                if (!isUpToDate(localItem, onlineItem)) {
                    console.log("OLD DATA DETECTED: $label '$localId' needs an update.")
                }
            }
        }
    }
}
