import com.michaelflisar.kmpdevtools.BuildFileUtil
import com.michaelflisar.kmpdevtools.Targets
import com.michaelflisar.kmpdevtools.config.LibraryModuleData
import com.michaelflisar.kmpdevtools.config.sub.AndroidLibraryConfig
import com.michaelflisar.kmpdevtools.core.configs.Config
import com.michaelflisar.kmpdevtools.core.configs.LibraryConfig

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.dokka)
    alias(libs.plugins.gradle.maven.publish.plugin)
    alias(libs.plugins.binary.compatibility.validator)
    alias(deps.plugins.kmpdevtools.buildplugin)
}

// ------------------------
// Setup
// ------------------------

val config = Config.read(rootProject)
val libraryConfig = LibraryConfig.read(rootProject)

val buildTargets = Targets(
    // mobile
    android = true,
    iOS = false,
    // desktop
    windows = false,
    macOS = false,
    // web
    wasm = false
)
val androidConfig = AndroidLibraryConfig(
    compileSdk = app.versions.compileSdk,
    minSdk = app.versions.minSdk
)

val libraryModuleData = LibraryModuleData(
    project = project,
    config = config,
    libraryConfig = libraryConfig,
    androidConfig = androidConfig
)

// ------------------------
// Kotlin
// ------------------------

kotlin {

    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }

    //-------------
    // Targets
    //-------------

    buildTargets.setupTargetsLibrary(libraryModuleData)

    // -------
    // Sources
    // -------

    sourceSets {

        // ---------------------
        // custom source sets
        // ---------------------

        // --

        // ---------------------
        // dependencies
        // ---------------------

        commonMain.dependencies {
            implementation(project(":kmpplatformcontext:core"))
        }

        androidMain.dependencies {
            implementation(libs.androidx.core)
            implementation(libs.androidx.startup.runtime)
        }
    }
}

// -------------------
// Publish
// -------------------

// maven publish configuration
if (BuildFileUtil.checkGradleProperty(project, "publishToMaven") != false)
    BuildFileUtil.setupMavenPublish(project, config, libraryConfig)