import java.util.Properties
import java.io.FileInputStream

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.google.devtools.ksp)
}

android {
    val signingProperties = Properties().apply {
        val signingFile = rootProject.file("signing.properties")
        if (signingFile.exists()) FileInputStream(signingFile).use { load(it) }
    }

    namespace = "com.omarjarid.noasanapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.omarjarid.noasanapp"
        minSdk = 26
        targetSdk = 35
        versionCode = 2
        versionName = "1.0.1-demo"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        signingConfigs {
            create("portfolio") {
                storeFile = file(signingProperties["PORTFOLIO_KEYSTORE"] as String)
                storePassword = signingProperties["PORTFOLIO_STORE_PASSWORD"] as String
                keyAlias = signingProperties["PORTFOLIO_ALIAS"] as String
                keyPassword = signingProperties["PORTFOLIO_KEY_PASSWORD"] as String
            }
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("portfolio")
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.timber)
    implementation(libs.core.splashscreen)

    implementation(project(":data"))

    ksp(libs.hilt.compiler)
}