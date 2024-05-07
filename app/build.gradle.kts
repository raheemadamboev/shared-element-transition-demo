plugins {
    alias(libs.plugins.android)
    alias(libs.plugins.kotlin)
}

android {
    namespace = "xyz.teamgravity.sharedelementtransitiondemo"
    compileSdk = libs.versions.sdk.compile.get().toInt()

    defaultConfig {
        applicationId = "xyz.teamgravity.sharedelementtransitiondemo"
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = libs.versions.java.target.get()
        freeCompilerArgs += listOf(
            "-opt-in=androidx.compose.animation.ExperimentalSharedTransitionApi",
        )
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // compose
    implementation(platform(libs.compose))
    implementation(libs.compose.ui)
    implementation(libs.compose.graphics)
    implementation(libs.compose.preview)
    implementation(libs.compose.material3)

    // compose animation
    implementation(libs.compose.animation)

    // compose activity
    implementation(libs.compose.activity)

    // compose lifecycle
    implementation(libs.compose.lifecycle)

    // compose navigation
    implementation(libs.compose.navigation)

    // core
    implementation(libs.core)

    // collections
    implementation(libs.collections)
}