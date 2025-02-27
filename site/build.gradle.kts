import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.meta

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kotlinx.serialization)
    // alias(libs.plugins.kobwebx.markdown)
}

group = "com.coding.meet"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Explore my Android development portfolio featuring Kotlin, Jetpack Compose, and KMP projects. Get premium source codes, expert services, and valuable tutorials!")
            head.add {
                link(rel = "stylesheet", href = "/fonts/fonts.css")

                // this is link preview
                meta("og:title", "Coding Meet - My Portfolio")
                meta("og:description", "Explore my Android development portfolio featuring Kotlin, Jetpack Compose, and KMP projects. Get premium source codes, expert services, and valuable tutorials!")
                meta("og:image", "https://codingmeet.com/preview_image.png")
                meta("og:url", "https://codingmeet.com")
                meta("og:type", "website")

                meta("twitter:card", "summary_large_image")
                meta("twitter:title", "Coding Meet - My Portfolio")
                meta("twitter:description", "Explore my Android development portfolio featuring Kotlin, Jetpack Compose, and KMP projects. Get premium source codes, expert services, and valuable tutorials!")
                meta("twitter:image", "https://codingmeet.com/preview_image.png")

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



kotlin {
    configAsKobwebApplication("meet")

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
        }

        jsMain.dependencies {
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.fa)
            // implementation(libs.kobwebx.markdown)
            implementation(libs.kotlinx.serialization.json)
        }
    }
}
