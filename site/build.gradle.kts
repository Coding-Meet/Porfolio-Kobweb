import com.varabyte.kobweb.gradle.application.tasks.KobwebCacheAppFrontendDataTask
import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import com.varabyte.kobweb.project.frontend.AppFrontendData
import kotlinx.html.FlowOrMetaDataOrPhrasingContent
import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.script
import kotlinx.html.title
import kotlinx.html.unsafe
import kotlinx.serialization.json.Json
import java.net.URL
import java.util.Properties
import javax.xml.parsers.DocumentBuilderFactory

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
                "Meet is an Android and Kotlin Multiplatform developer specializing in Kotlin, Java, Jetpack Compose, and Compose Multiplatform. Explore projects, tutorials, and freelance app development services."
            )
            head.add {
                // Anti-flicker theme script: immediately restores saved color mode before DOM paint
                script {
                    unsafe {
                        +"""
                        {
                            const storedColor = localStorage.getItem('theme');
                            const desiredColor = storedColor ? `silk-${'$'}{storedColor.toLowerCase()}` : 'silk-dark';
                            const oppositeColor = desiredColor === 'silk-dark' ? 'silk-light' : 'silk-dark';
                            document.documentElement.classList.replace(oppositeColor, desiredColor);
                        }
                        """.trimIndent()
                    }
                }
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

                title("Meet | Android, Kotlin Multiplatform & Compose Developer")

                link(rel = "stylesheet", href = "/fonts/fonts.css")
                link(rel = "stylesheet", href = "https://unpkg.com/maplibre-gl@4.7.1/dist/maplibre-gl.css")
                script {
                    src = "https://unpkg.com/maplibre-gl@4.7.1/dist/maplibre-gl.js"
                }
                script {
                    src = "/js/cursor.js"
                }

                // Open Graph metadata
                ogMeta("og:title", "Meet | Android & Kotlin Multiplatform Developer")
                ogMeta(
                    "og:description",
                    "Explore Meet's Android and cross-platform projects built with Kotlin, Jetpack Compose, KMP, and CMP. Discover freelance services, tutorials, and open-source work."
                )

                ogMeta("og:image", "https://codingmeet.com/preview_image.png")
                ogMeta("og:url", "https://codingmeet.com")
                ogMeta("og:type", "website")
                ogMeta("og:site_name", "Coding Meet")

                // Twitter / X metadata
                ogMeta("twitter:card", "summary_large_image")
                ogMeta(
                    "twitter:title",
                    "Meet | Android, KMP & Compose Multiplatform Developer"
                )
                ogMeta(
                    "twitter:description",
                    "Building Android and cross-platform apps with Kotlin, Jetpack Compose, KMP, and CMP. Explore projects and freelance services."
                )
                ogMeta("twitter:image", "https://codingmeet.com/preview_image.png")

                // SEO keywords
                ogMeta(
                    "keywords",
                    "Android Developer, Kotlin Developer, Java Developer, Jetpack Compose, Kotlin Multiplatform, KMP, Compose Multiplatform, CMP, Android App Development, Desktop App Development, Freelance Developer, Coding Meet"
                )
                // this is web icon
                link {
                    rel = "icon"
                    sizes = "16x16 24x24 32x32 64x64"
                    href = "/favicon.ico"
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
fun FlowOrMetaDataOrPhrasingContent.ogMeta(
    property: String,
    content: String
) {
    meta {
        attributes["property"] = property
        attributes["content"] = content
    }
}

data class BlogPreview(
    val id: String,
    val title: String,
    val description: String,
    val image: String,
)

fun String.escapeHtmlAttribute(): String = buildString {
    this@escapeHtmlAttribute.forEach { char ->
        when (char) {
            '&' -> append("&amp;")
            '"' -> append("&quot;")
            '<' -> append("&lt;")
            '>' -> append("&gt;")
            else -> append(char)
        }
    }
}

fun String.toAbsoluteSiteUrl(): String =
    if (startsWith("http://") || startsWith("https://")) this else "https://codingmeet.com$this"

fun String.replaceMetaTag(property: String, content: String, attribute: String = "property"): String {
    val escapedContent = content.escapeHtmlAttribute()
    val metaRegex = Regex(
        """<meta\s+[^>]*(?:property|name)=["']${Regex.escape(property)}["'][^>]*>""",
        RegexOption.IGNORE_CASE
    )
    val replacement = """<meta $attribute="$property" content="$escapedContent">"""
    return if (metaRegex.containsMatchIn(this)) {
        replace(metaRegex, replacement)
    } else {
        replace("</head>", "  $replacement\n </head>")
    }
}

fun String.replaceDescriptionMeta(content: String): String {
    val escapedContent = content.escapeHtmlAttribute()
    return replace(
        Regex("""<meta\s+[^>]*name=["']description["'][^>]*>""", RegexOption.IGNORE_CASE),
        """<meta name="description" content="$escapedContent">"""
    )
}

fun String.replaceHtmlTitle(title: String): String {
    val escapedTitle = title.escapeHtmlAttribute()
    return replace(Regex("""<title>.*?</title>"""), "<title>$escapedTitle</title>")
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
    description = "Generates sitemap.xml for all Kobweb site routes."
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
    description = "Fetches Medium articles RSS feed and generates MediumContent.kt."
    val outputFile =
        layout.projectDirectory.file("src/jsMain/kotlin/com/coding/meet/util/MediumContent.kt")

    doLast {
        try {
            val jsonStr =
                URL("https://api.rss2json.com/v1/api.json?rss_url=https://medium.com/feed/@meet26").readText()

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

tasks.register("applyBlogLinkPreviews") {
    description = "Injects Open Graph and Twitter meta tags into exported blog HTML files for link previews."
    notCompatibleWithConfigurationCache("This task patches exported HTML using script-local helpers.")

    val articleDataFile = layout.projectDirectory.file("src/jsMain/kotlin/com/coding/meet/util/ArticleData.kt")
    val exportedSiteDir = layout.projectDirectory.dir(".kobweb/site")

    inputs.file(articleDataFile)
    outputs.dir(exportedSiteDir)
    outputs.upToDateWhen { false }

    doLast {
        val source = articleDataFile.asFile.readText()
        val articleRegex = Regex("""Article\((.*?)(?=\n\s*\),)""", RegexOption.DOT_MATCHES_ALL)
        val fieldRegex = { field: String ->
            Regex("""$field\s*=\s*"((?:\\.|[^"\\])*)"""")
        }
        val previews = articleRegex.findAll(source).mapNotNull { match ->
            val block = match.groupValues[1]
            val title = fieldRegex("title").find(block)?.groupValues?.get(1) ?: return@mapNotNull null
            val description = fieldRegex("shortDescription").find(block)?.groupValues?.get(1) ?: return@mapNotNull null
            val thumbnail = fieldRegex("thumbnail").find(block)?.groupValues?.get(1) ?: return@mapNotNull null
            val link = fieldRegex("link").find(block)?.groupValues?.get(1) ?: return@mapNotNull null

            BlogPreview(
                id = link.substringAfterLast("/"),
                title = title,
                description = description,
                image = thumbnail.toAbsoluteSiteUrl(),
            )
        }.toList()

        check(previews.isNotEmpty()) {
            "No blog previews found in ${articleDataFile.asFile.absolutePath}"
        }

        previews.forEach { preview ->
            val htmlFile = exportedSiteDir.file("blog/${preview.id}.html").asFile
            if (!htmlFile.exists()) {
                logger.warn("No exported HTML found for blog preview: ${preview.id}")
                return@forEach
            }

            val pageUrl = "https://codingmeet.com/blog/${preview.id}"
            val pageTitle = "${preview.title} | Coding Meet"
            val html = htmlFile.readText()
                .replaceHtmlTitle(pageTitle)
                .replaceDescriptionMeta(preview.description)
                .replaceMetaTag("og:title", preview.title)
                .replaceMetaTag("og:description", preview.description)
                .replaceMetaTag("og:image", preview.image)
                .replaceMetaTag("og:url", pageUrl)
                .replaceMetaTag("og:type", "article")
                .replaceMetaTag("twitter:card", "summary_large_image", attribute = "name")
                .replaceMetaTag("twitter:title", preview.title, attribute = "name")
                .replaceMetaTag("twitter:description", preview.description, attribute = "name")
                .replaceMetaTag("twitter:image", preview.image, attribute = "name")

            htmlFile.writeText(html)
        }

        println("Applied blog link previews to ${previews.size} exported pages.")
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


tasks.register("generateBlogKotlinPages") {
    description = "Generates Kotlin @Page files for blog articles based on sitemap.xml routes."

    val sitemapFile = layout.projectDirectory.file("src/jsMain/resources/public/sitemap.xml")
    val outputDir = layout.projectDirectory.dir(
        "src/jsMain/kotlin/com/coding/meet/pages/blog"
    )

    doLast {
        val file = sitemapFile.asFile
        val doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(file)

        val urls = doc.getElementsByTagName("loc")

        val output = outputDir.asFile
        output.mkdirs()

        for (i in 0 until urls.length) {
            val url = urls.item(i).textContent.trim()

            if (!url.contains("/blog/")) continue

            val slug = url.substringAfter("/blog/")

            // Clean class name
            val className = slug
                .replace("-", "_")
                .replace(Regex("[^a-zA-Z0-9_]"), "")
                .replaceFirstChar { it.uppercase() }

            val fileName = "$className.kt"

            val kotlinFile = File(output, fileName)

            val content = """
                package com.coding.meet.pages.blog

                import androidx.compose.runtime.Composable
                import androidx.compose.runtime.remember
                import com.coding.meet.screens.articles_detail.components.ArticleDetail
                import com.coding.meet.util.ArticleData
                import com.varabyte.kobweb.core.Page
                import com.varabyte.kobweb.core.PageContext

                @Page("/blog/$slug")
                @Composable
                fun $className(context: PageContext) {

                    val article = remember {
                        ArticleData.articles.find { it.id == "$slug" }
                    }
                    
                    if (article != null) {
                        ArticleDetail(article = article, context = context)
                    }
                }
            """.trimIndent()

            kotlinFile.writeText(content)
        }

        println("✅ Blog Kotlin pages generated successfully!")
    }
}
