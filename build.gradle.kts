plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlinx.serialization) apply false
}

subprojects {
    repositories {
        mavenCentral()
        google()
        maven("https://us-central1-maven.pkg.dev/varabyte-repos/public")
    }
}
