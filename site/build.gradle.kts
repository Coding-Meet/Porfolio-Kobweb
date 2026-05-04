import com.varabyte.kobweb.gradle.application.tasks.KobwebCacheAppFrontendDataTask
import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import com.varabyte.kobweb.project.frontend.AppFrontendData
import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.script
import kotlinx.html.title
import kotlinx.html.unsafe
import kotlinx.serialization.json.Json
import java.net.URL
import java.util.Properties

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kotlinx.serialization)
    // alias(libs.plugins.kobwebx.markdown)
}

group = "com.coding.meet"
version = "1.0-SNAPSHOT"

val localProperties = Properties().apply {
    val file = rootProject.file("local.properties")
    if (file.exists()) {
        load(file.inputStream())
    }
}
val trackingId = localProperties.getProperty("trackingId")

kobweb {
    app {
        index {
            description.set(
                "Android developer portfolio by Meet. Get production-ready Kotlin, Jetpack Compose & KMP apps, premium source code, and expert app development services. 45+ projects delivered."
            )
            head.add {
                script {
                    async = true
                    src = "https://www.googletagmanager.com/gtag/js?id=$trackingId"
                }
                script {
                    unsafe {
                        +"""
            window.dataLayer = window.dataLayer || [];
            function gtag(){dataLayer.push(arguments);}

            gtag('js', new Date());

            gtag('config', '$trackingId', {
                page_title: document.title,
                page_path: window.location.pathname
            });
        """.trimIndent()
                    }
                }

                title("Coding Meet - Android Developer | Kotlin, Compose, KMP Apps & Source Code")
                link(rel = "stylesheet", href = "/fonts/fonts.css")

                // this is link preview
                meta("og:title", "Coding Meet - Android Developer Portfolio & Source Code")
                meta(
                    "og:description",
                    "Production-ready Android apps, Jetpack Compose UI, and Kotlin Multiplatform projects. Buy source code or hire for custom app development."
                )

                meta("og:image", "https://codingmeet.com/preview_image.png")
                meta("og:url", "https://codingmeet.com")
                meta("og:type", "website")

                meta("twitter:card", "summary_large_image")
                meta("twitter:title", "Android Apps, Source Code & Services | Coding Meet")
                meta(
                    "twitter:description",
                    "Explore real-world Android projects, premium source code, and freelance app development services built with Kotlin & Compose."
                )
                meta("twitter:image", "https://codingmeet.com/preview_image.png")

                meta(
                    name = "keywords",
                    content = "Android Developer, Kotlin, Jetpack Compose, KMP, Android apps, source code, freelance developer, mobile apps"
                )
                // this is web icon
                link {
                    rel = "icon"
                    sizes = "16x16 24x24 32x32 64x64"
                    href = "/favicon.icon"
                }
                link {
                    rel = "icon"
                    type = "image/png"
                    sizes = "32x32"
                    href = "/favicon-32x32.png"
                }
                link {
                    rel = "icon"
                    type = "image/png"
                    sizes = "16x16"
                    href = "/favicon-16x16.png"
                }
                link {
                    rel = "icon"
                    type = "image/png"
                    sizes = "48x48"
                    href = "/favicon-48x48.png"
                }
                link {
                    rel = "icon"
                    type = "image/png"
                    sizes = "192x192"
                    href = "/favicon-192x192.png"
                }
                link {
                    rel = "apple-touch-icon"
                    type = "image/png"
                    sizes = "180x180"
                    href = "/favicon-180x180.png"
                }
                link {
                    rel = "apple-touch-icon"
                    type = "image/png"
                    sizes = "167x167"
                    href = "/favicon-167x167.png"
                }
                link {
                    rel = "apple-touch-icon"
                    type = "image/png"
                    sizes = "152x152"
                    href = "/favicon-152x152.png"
                }
            }
        }
    }
}

val Project.kobwebSiteRoutes: Provider<List<String>>
    get() = tasks.named<KobwebCacheAppFrontendDataTask>("kobwebCacheAppFrontendData").map { task ->
        val pageEntries =
            Json.decodeFromString<AppFrontendData>(task.appDataFile.get().asFile.readText()).frontendData.pages
        pageEntries
            .asSequence()
            .map { it.route }
            .sorted()
            .toList()
    }

tasks.register("createSitemap") {
    val routesProvider = kobwebSiteRoutes
    inputs.property("routes", routesProvider)
    val sitemapFile = layout.projectDirectory.file("src/jsMain/resources/public/sitemap.xml")
    outputs.file(sitemapFile)

    doLast {
        val routes = routesProvider.get()
        val sitemapStr = buildString {
            appendLine("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
            appendLine("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">")

            routes.filter { !it.contains('{') }.forEach { route ->
                appendLine("  <url>")
                appendLine("    <loc>https://codingmeet.com$route</loc>")
                appendLine("  </url>")
            }
            appendLine("</urlset>")
        }
        sitemapFile.asFile.writeText(sitemapStr)
        println("Sitemap generated at: ${sitemapFile.asFile.absolutePath}")
    }
}

tasks.register("fetchMediumContent") {
    val outputFile = layout.projectDirectory.file("src/jsMain/kotlin/com/coding/meet/util/MediumContent.kt")

    doLast {
        try {
            val jsonStr = URL("https://api.rss2json.com/v1/api.json?rss_url=https://medium.com/feed/@meet26").readText()
            
            val escapedJson = jsonStr
                .replace("$", "\${'$'}")
                .replace("\"\"\"", "\"\" + \"\"\"")

            val fileContent = buildString {
                appendLine("package com.coding.meet.util")
                appendLine()
                appendLine("object MediumContent {")
                appendLine("    const val jsonStr = \"\"\"$escapedJson\"\"\"")
                appendLine("}")
            }

            outputFile.asFile.writeText(fileContent)
            println("MediumContent.kt generated with raw JSON string.")
        } catch (e: Exception) {
            println("Failed to fetch Medium content: ${e.message}")
            if (!outputFile.asFile.exists()) {
                outputFile.asFile.writeText("package com.coding.meet.util\n\nobject MediumContent {\n    const val jsonStr = \"{}\"\n}")
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("meet")

    sourceSets {
        jsMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.fa)
            // implementation(libs.kobwebx.markdown)
            implementation(libs.kotlinx.serialization.json)
        }
    }
}
