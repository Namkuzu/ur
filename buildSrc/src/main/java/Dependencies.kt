
object Versions {
    const val kotlin = "1.8.10"
    const val composeCompilerVersion = kotlin
    const val compose = "1.4.2"
    const val targetSdk = 33
    const val buildVersion = "33.0.1"
    const val material = "1.1.0"
    const val navigationCompose = "2.7.0"
}

object Compose {
    const val animation = "androidx.compose.animation:animation:${Versions.compose}"
    const val core = "androidx.compose.ui:ui:${Versions.compose}"
    const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val layout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    const val material = "androidx.compose.material3:material3:${Versions.material}"
    const val materialIcon = "androidx.compose.material.icons:${Versions.material}"
    const val materialIconsExt = "androidx.compose.material:material-icons-extended:${Versions.material}"
    const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
}

object Android {
    const val activityCompose = "androidx.activity:activity-compose:1.6.1"
    const val appcompat = "androidx.appcompat:appcompat:1.5.1"
}

object Kotlin {
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
}