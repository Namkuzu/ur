plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

apply(from = rootProject.file("gradle/configure-android.gradle"))
apply(from = rootProject.file("gradle/configure-compose.gradle"))
apply(from = rootProject.file("gradle/jitpack-publish.gradle"))

dependencies {
    implementation(Kotlin.stdLib)
    implementation(Compose.animation)
    implementation(Compose.core)
    implementation(Compose.layout)
    implementation(Compose.foundation)
    implementation(Compose.runtime)
    implementation(Compose.material)
    implementation(Compose.materialIconsExt)
    debugImplementation(Compose.tooling)
}

android {
    namespace = "com.namkuzo.ur"
}
