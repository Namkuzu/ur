// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.android.library") version "8.1.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.10" apply false
}

buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
    }

    repositories {
        google()
        gradlePluginPortal()
    }
}

subprojects {
    repositories {
        google()
        gradlePluginPortal()
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            // Allow warnings when running from IDE, makes it easier to experiment.
            allWarningsAsErrors = true

            jvmTarget = "1.8"
        }
    }
}
