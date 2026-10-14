package com.coding.meet.screens.home.testimonial.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.coding.meet.util.CustomColor
import com.coding.meet.util.Res
import com.coding.meet.util.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLScriptElement
import kotlin.js.json

data class ClientGeoCountry(
    val country: String,
    val flag: String,
    val lat: Double,
    val lng: Double,
    val reviewCount: Int,
    val sampleSnippet: String
)

val ClientGeoCountriesList = listOf(
    ClientGeoCountry(
        country = "🇺🇸 United States",
        flag = "🇺🇸",
        lat = 38.0,
        lng = -97.0,
        reviewCount = 7,
        sampleSnippet = "Worked on Android robotics programming... couldn't be more impressed! Five stars all the way."
    ),
    ClientGeoCountry(
        country = "🇬🇧 United Kingdom",
        flag = "🇬🇧",
        lat = 54.0,
        lng = -2.5,
        reviewCount = 3,
        sampleSnippet = "Very happy with the end results of the app. Serious guy, no funny business. Highly recommend!"
    ),
    ClientGeoCountry(
        country = "🇪🇸 Spain",
        flag = "🇪🇸",
        lat = 40.2,
        lng = -3.7,
        reviewCount = 22,
        sampleSnippet = "Long-term client partnership with 22 successfully delivered milestones across Android & KMP."
    ),
    ClientGeoCountry(
        country = "🇩🇪 Germany",
        flag = "🇩🇪",
        lat = 51.1,
        lng = 10.4,
        reviewCount = 2,
        sampleSnippet = "Very good and clear communication, delivered edited code very fast. Highly recommend!"
    ),
    ClientGeoCountry(
        country = "🇦🇹 Austria",
        flag = "🇦🇹",
        lat = 47.5,
        lng = 14.5,
        reviewCount = 2,
        sampleSnippet = "Great job, deep understanding, and fast delivery—I’d definitely work with him again."
    ),
    ClientGeoCountry(
        country = "🇮🇳 India",
        flag = "🇮🇳",
        lat = 21.0,
        lng = 78.9,
        reviewCount = 4,
        sampleSnippet = "Best service ever! Delivered high-quality results on time with great attention to detail."
    ),
    ClientGeoCountry(
        country = "🇲🇽 Mexico",
        flag = "🇲🇽",
        lat = 23.6,
        lng = -102.5,
        reviewCount = 3,
        sampleSnippet = "Surprised by the speed and experience that Meet has. Chosen him as my favorite developer."
    ),
    ClientGeoCountry(
        country = "🇰🇷 South Korea",
        flag = "🇰🇷",
        lat = 36.5,
        lng = 127.8,
        reviewCount = 2,
        sampleSnippet = "Code was clean, efficient, and delivered on time. Handled unexpected issues with smart solutions."
    ),
    ClientGeoCountry(
        country = "🇵🇹 Portugal",
        flag = "🇵🇹",
        lat = 39.5,
        lng = -8.0,
        reviewCount = 2,
        sampleSnippet = "Very good and easy to collaborate with. Everything was delivered on point."
    ),
    ClientGeoCountry(
        country = "🇧🇪 Belgium",
        flag = "🇧🇪",
        lat = 50.6,
        lng = 4.6,
        reviewCount = 2,
        sampleSnippet = "A very good and friendly developer, fixes issues rapidly and with high quality."
    ),
    ClientGeoCountry(
        country = "🇦🇪 United Arab Emirates",
        flag = "🇦🇪",
        lat = 24.0,
        lng = 54.0,
        reviewCount = 1,
        sampleSnippet = "Professional communication, fast delivery! Thank you."
    ),
    ClientGeoCountry(
        country = "🇧🇴 Bolivia",
        flag = "🇧🇴",
        lat = -16.5,
        lng = -64.0,
        reviewCount = 2,
        sampleSnippet = "One of the best freelancers! Excellent quality, great communication, and attentive to feedback."
    ),
    ClientGeoCountry(
        country = "🇲🇦 Morocco",
        flag = "🇲🇦",
        lat = 31.8,
        lng = -7.1,
        reviewCount = 2,
        sampleSnippet = "Pinpointed the root cause and quickly identified the best solution. 5 stars are not enough!"
    ),
    ClientGeoCountry(
        country = "🇨🇾 Cyprus",
        flag = "🇨🇾",
        lat = 35.1,
        lng = 33.4,
        reviewCount = 2,
        sampleSnippet = "Very responsive and very good communication. Did the work quickly and fully to scope."
    ),
    ClientGeoCountry(
        country = "🇬🇷 Greece",
        flag = "🇬🇷",
        lat = 39.0,
        lng = 22.0,
        reviewCount = 1,
        sampleSnippet = "Replied fast, delivered changes on time and work was exceptional. Highly recommended!"
    ),
    ClientGeoCountry(
        country = "🇵🇰 Pakistan",
        flag = "🇵🇰",
        lat = 30.3,
        lng = 69.3,
        reviewCount = 2,
        sampleSnippet = "Strong understanding of the work, quickly understood requirements and delivered in minimum time."
    ),
    ClientGeoCountry(
        country = "🇴🇲 Oman",
        flag = "🇴🇲",
        lat = 21.5,
        lng = 57.0,
        reviewCount = 1,
        sampleSnippet = "Amazing service.. very helpful, will for sure ask him again for help."
    ),
    ClientGeoCountry(
        country = "🇳🇬 Nigeria",
        flag = "🇳🇬",
        lat = 9.1,
        lng = 8.7,
        reviewCount = 1,
        sampleSnippet = "Provided a very good service and I really liked it, fast and easy."
    ),
    ClientGeoCountry(
        country = "🇵🇭 Philippines",
        flag = "🇵🇭",
        lat = 13.0,
        lng = 122.0,
        reviewCount = 1,
        sampleSnippet = "Fast delivery and smooth technical implementation."
    ),
    ClientGeoCountry(
        country = "🇲🇲 Myanmar [Burma]",
        flag = "🇲🇲",
        lat = 21.0,
        lng = 96.0,
        reviewCount = 1,
        sampleSnippet = "Quick responsiveness and great technical execution for AI mobile integration."
    )
)

private fun ensureMapLibreLoaded(onReady: () -> Unit) {
    if (window.asDynamic().maplibregl != null) {
        onReady()
        return
    }
    val existingScript = document.querySelector("script[src*='maplibre-gl']")
    if (existingScript != null) {
        existingScript.addEventListener("load", { onReady() })
        return
    }
    val script = document.createElement("script") as HTMLScriptElement
    script.src = "https://unpkg.com/maplibre-gl@4.7.1/dist/maplibre-gl.js"
    script.onload = { onReady() }
    document.head?.appendChild(script)
}

@Composable
fun ClientWorldMap(
    selectedCountry: String?,
    onSelectCountry: (String?) -> Unit
) {
    val colorMode by ColorMode.currentState
    val activeCountry = ClientGeoCountriesList.find { it.country == selectedCountry }
    var mapInstance by remember { mutableStateOf<dynamic>(null) }
    val markersMap = remember { js("({})") }

    LaunchedEffect(colorMode) {
        ensureMapLibreLoaded {
            val maplibregl = window.asDynamic().maplibregl ?: return@ensureMapLibreLoaded
            val mapElement = document.getElementById("client-openfreemap") ?: return@ensureMapLibreLoaded

            // OpenFreeMap styles: dark for dark mode, positron for light mode
            val styleUrl = if (colorMode.isDark) {
                "https://tiles.openfreemap.org/styles/dark"
            } else {
                "https://tiles.openfreemap.org/styles/positron"
            }

            // Sync data-theme attribute on container for instant CSS theme switching
            mapElement.setAttribute("data-theme", if (colorMode.isDark) "dark" else "light")

            // If map already exists, smoothly switch tiles style without recreating markers or resetting camera
            val existingMap = mapInstance
            if (existingMap != null) {
                try {
                    existingMap.setStyle(styleUrl)
                } catch (_: Throwable) {}
                return@ensureMapLibreLoaded
            }

            val map = js(
                """
                new maplibregl.Map({
                    container: 'client-openfreemap',
                    style: styleUrl,
                    center: [12.0, 24.0],
                    zoom: 1.6,
                    minZoom: 1.2,
                    maxZoom: 8,
                    scrollZoom: false,
                    attributionControl: false
                })
                """
            )
            mapElement.asDynamic()._maplibre = map
            mapInstance = map

            // Add navigation control (zoom buttons)
            val navControl = js("new maplibregl.NavigationControl({ showCompass: false })")
            map.addControl(navControl, "top-right")

            // Add attribution
            val attrControl = js("new maplibregl.AttributionControl({ compact: true, customAttribution: '<a href=\"https://openfreemap.org\" target=\"_blank\">OpenFreeMap</a> &copy; <a href=\"https://www.openstreetmap.org/copyright\" target=\"_blank\">OpenStreetMap</a>' })")
            map.addControl(attrControl, "bottom-right")

            map.on("load", {
                // Add interactive markers for all client countries
                ClientGeoCountriesList.forEach { client ->
                    val el = document.createElement("div") as HTMLElement
                    el.className = "client-marker-container"
                    el.title = client.country
                    el.innerHTML = """
                        <div class="client-marker-pin">
                            <span class="client-marker-pulse"></span>
                            <span class="client-marker-flag">${client.flag}</span>
                        </div>
                    """.trimIndent()

                    val popupHtml = """
                        <div class="client-map-popup-inner">
                            <div class="client-popup-title">
                                <span>${client.country}</span>
                            </div>
                            <div class="client-popup-stats">
                                ⭐ 5.0 Rating • ${client.reviewCount} ${if (client.reviewCount > 1) "Projects" else "Project"}
                            </div>
                            <div class="client-popup-quote">
                                “${client.sampleSnippet}”
                            </div>
                        </div>
                    """.trimIndent()

                    // focusAfterOpen: false and autoPan: false prevent the browser from scrolling/jumping
                    val popup = js("""
                        new maplibregl.Popup({
                            offset: 20,
                            closeButton: true,
                            focusAfterOpen: false,
                            autoPan: false
                        })
                    """).setHTML(popupHtml)

                    val marker = js("new maplibregl.Marker({ element: el })")
                        .setLngLat(arrayOf(client.lng, client.lat))
                        .setPopup(popup)
                        .addTo(map)

                    el.onclick = { e ->
                        e.stopPropagation()
                        onSelectCountry(client.country)
                    }

                    markersMap[client.country] = marker
                }
            })

            window.setTimeout({
                map.resize()
            }, 300)
        }
    }

    // Fly to selected country when clicked without causing page scroll
    LaunchedEffect(selectedCountry, mapInstance) {
        val map = mapInstance
        if (map != null) {
            // Update marker styles: highlight selected hero pin and set distinct unselected neutral color on others
            js("""
                for (var key in markersMap) {
                    var m = markersMap[key];
                    if (m) {
                        var p = m.getPopup();
                        if (p && p.isOpen()) {
                            p.remove();
                        }
                        var el = m.getElement();
                        if (el) {
                            var pin = el.querySelector(".client-marker-pin") || el;
                            if (selectedCountry) {
                                if (key === selectedCountry) {
                                    pin.classList.add("is-selected");
                                    pin.classList.remove("is-unselected");
                                    el.style.zIndex = "10";
                                } else {
                                    pin.classList.remove("is-selected");
                                    pin.classList.add("is-unselected");
                                    el.style.zIndex = "2";
                                }
                            } else {
                                pin.classList.remove("is-selected");
                                pin.classList.remove("is-unselected");
                                el.style.zIndex = "5";
                            }
                        }
                    }
                }
            """)

            if (selectedCountry != null) {
                val target = ClientGeoCountriesList.find { it.country == selectedCountry }
                if (target != null) {
                    map.flyTo(json(
                        "center" to arrayOf(target.lng, target.lat),
                        "zoom" to 4.2,
                        "speed" to 1.4,
                        "essential" to true
                    ))
                    val marker = markersMap[selectedCountry]
                    js("""
                        if (marker) {
                            var p = marker.getPopup();
                            if (p && !p.isOpen()) {
                                marker.togglePopup();
                            }
                        }
                    """)
                }
            } else {
                map.flyTo(json(
                    "center" to arrayOf(12.0, 24.0),
                    "zoom" to 1.6,
                    "speed" to 1.2,
                    "essential" to true
                ))
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            try {
                mapInstance?.remove()
            } catch (_: Throwable) {}
            mapInstance = null
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .margin(top = 10.px, bottom = 24.px)
            .backgroundColor(
                if (colorMode.isLight) rgba(255, 255, 255, 0.7) else rgba(15, 23, 42, 0.6)
            )
            .border(
                1.px,
                LineStyle.Solid,
                if (colorMode.isLight) rgba(0, 0, 0, 0.08) else rgba(255, 255, 255, 0.08)
            )
            .borderRadius(20.px)
            .padding(all = 20.px)
            .boxShadow(
                0.px, 10.px, 30.px, 0.px,
                if (colorMode.isLight) rgba(0, 0, 0, 0.04) else rgba(0, 0, 0, 0.25)
            )
    ) {
        // Map Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 14.px)
                .flexWrap(FlexWrap.Wrap)
                .gap(12.px),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.gap(8.px)
            ) {
                Box(
                    modifier = Modifier
                        .size(10.px)
                        .borderRadius(9999.px)
                        .backgroundColor(Theme.Primary.color)
                        .boxShadow(0.px, 0.px, 10.px, 2.px, Theme.Primary.color)
                )
                SpanText(
                    text = "Global Client Presence (OpenFreeMap)",
                    modifier = Modifier
                        .fontFamily(Res.Font.FONT_FAMILY_HEADING)
                        .fontSize(1.15.cssRem)
                        .fontWeight(FontWeight.Bold)
                        .color(CustomColor(Theme.LightFontColor, Theme.DarkFontColor))
                )
            }

            // Stats Badges
            Row(
                modifier = Modifier.flexWrap(FlexWrap.Wrap).gap(8.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                listOf(
                    "🌍 20+ Countries",
                    "🚀 70+ Projects",
                    "⭐ 4.9★ Rating"
                ).forEach { badge ->
                    Box(
                        modifier = Modifier
                            .backgroundColor(
                                if (colorMode.isLight) rgba(0, 0, 0, 0.04) else rgba(255, 255, 255, 0.06)
                            )
                            .border(
                                1.px,
                                LineStyle.Solid,
                                if (colorMode.isLight) rgba(0, 0, 0, 0.08) else rgba(255, 255, 255, 0.1)
                            )
                            .borderRadius(9999.px)
                            .padding(leftRight = 10.px, topBottom = 4.px)
                    ) {
                        SpanText(
                            text = badge,
                            modifier = Modifier
                                .fontSize(0.78.cssRem)
                                .fontWeight(FontWeight.Medium)
                                .color(CustomColor(Theme.DarkGray, Theme.Muted))
                        )
                    }
                }
            }
        }

        // OpenFreeMap Map Container
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(390.px)
                .minHeight(360.px)
                .borderRadius(14.px)
                .overflow(Overflow.Hidden)
                .position(Position.Relative)
                .zIndex(1)
                .border(
                    1.px,
                    LineStyle.Solid,
                    if (colorMode.isLight) rgba(226, 232, 240, 0.8) else rgba(30, 41, 59, 0.6)
                )
        ) {
            Div(
                attrs = {
                    id("client-openfreemap")
                    style {
                        property("width", "100%")
                        property("height", "100%")
                        property("min-height", "390px")
                    }
                }
            )
        }

        // Country Pill Quick-Filter Bar (Placed directly below map so buttons stay in place)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .margin(top = 12.px)
                .flexWrap(FlexWrap.Wrap)
                .gap(6.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // "All Countries" Pill
            val isAll = selectedCountry == null
            Box(
                modifier = Modifier
                    .cursor(Cursor.Pointer)
                    .backgroundColor(
                        if (isAll) Theme.Primary.color
                        else (if (colorMode.isLight) rgba(0, 0, 0, 0.04) else rgba(255, 255, 255, 0.06))
                    )
                    .border(
                        1.px,
                        LineStyle.Solid,
                        if (isAll) Theme.Primary.color
                        else (if (colorMode.isLight) rgba(0, 0, 0, 0.08) else rgba(255, 255, 255, 0.08))
                    )
                    .borderRadius(9999.px)
                    .padding(leftRight = 10.px, topBottom = 4.px)
                    .onClick { onSelectCountry(null) }
            ) {
                SpanText(
                    text = "🌐 All (70+)",
                    modifier = Modifier
                        .fontSize(0.76.cssRem)
                        .fontWeight(if (isAll) FontWeight.Bold else FontWeight.Medium)
                        .color(
                            if (isAll) Colors.White else CustomColor(Theme.LightFontColor, Theme.DarkFontColor)
                        )
                )
            }

            // Top Countries Pills
            ClientGeoCountriesList.forEach { client ->
                val isSelected = selectedCountry == client.country
                Box(
                    modifier = Modifier
                        .cursor(Cursor.Pointer)
                        .backgroundColor(
                            if (isSelected) Theme.Primary.color
                            else (if (colorMode.isLight) rgba(0, 0, 0, 0.03) else rgba(255, 255, 255, 0.04))
                        )
                        .border(
                            1.px,
                            LineStyle.Solid,
                            if (isSelected) Theme.Primary.color
                            else (if (colorMode.isLight) rgba(0, 0, 0, 0.06) else rgba(255, 255, 255, 0.06))
                        )
                        .borderRadius(9999.px)
                        .padding(leftRight = 9.px, topBottom = 4.px)
                        .onClick {
                            if (isSelected) onSelectCountry(null) else onSelectCountry(client.country)
                        }
                ) {
                    SpanText(
                        text = "${client.country} (${client.reviewCount})",
                        modifier = Modifier
                            .fontSize(0.75.cssRem)
                            .fontWeight(if (isSelected) FontWeight.Bold else FontWeight.Normal)
                            .color(
                                if (isSelected) Colors.White
                                else CustomColor(Theme.LightFontColor, Theme.DarkFontColor)
                            )
                    )
                }
            }
        }

        // Active Country Detail Card (Spotlight) - displayed cleanly below the pills
        if (activeCountry != null) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(top = 10.px)
                    .backgroundColor(
                        if (colorMode.isLight) rgba(16, 185, 129, 0.08) else rgba(16, 185, 129, 0.12)
                    )
                    .border(
                        1.px,
                        LineStyle.Solid,
                        rgba(16, 185, 129, 0.25)
                    )
                    .borderRadius(12.px)
                    .padding(all = 12.px)
                    .flexWrap(FlexWrap.Wrap)
                    .gap(10.px),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.gap(8.px)
                    ) {
                        SpanText(
                            text = activeCountry.country,
                            modifier = Modifier
                                .fontFamily(Res.Font.FONT_FAMILY_HEADING)
                                .fontSize(0.95.cssRem)
                                .fontWeight(FontWeight.Bold)
                                .color(CustomColor(Theme.LightFontColor, Theme.DarkFontColor))
                        )
                        SpanText(
                            text = "• ${activeCountry.reviewCount} ${if (activeCountry.reviewCount > 1) "Projects" else "Project"} (5.0 ★)",
                            modifier = Modifier
                                .fontSize(0.82.cssRem)
                                .fontWeight(FontWeight.SemiBold)
                                .color(Theme.Primary.color)
                        )
                    }
                    SpanText(
                        text = "“${activeCountry.sampleSnippet}”",
                        modifier = Modifier
                            .padding(top = 2.px)
                            .fontSize(0.82.cssRem)
                            .color(CustomColor(Theme.DarkGray, Theme.Muted))
                            .lineHeight(1.4)
                    )
                }

                if (selectedCountry != null) {
                    Box(
                        modifier = Modifier
                            .cursor(Cursor.Pointer)
                            .backgroundColor(rgba(16, 185, 129, 0.15))
                            .borderRadius(8.px)
                            .padding(leftRight = 10.px, topBottom = 4.px)
                            .onClick { onSelectCountry(null) }
                    ) {
                        SpanText(
                            text = "✕ Reset Filter",
                            modifier = Modifier
                                .fontSize(0.8.cssRem)
                                .fontWeight(FontWeight.SemiBold)
                                .color(Theme.Primary.color)
                        )
                    }
                }
            }
        }
    }
}
