plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.google.devtools.ksp)
    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.kotlin.serialization)
}

// Import the config file
apply(from = "config.gradle.kts")

// Add an extension function for DefaultConfig
fun com.android.build.api.dsl.DefaultConfig.addBuildConfigFields(fields: Any?) {
    fields ?: return
    val buildConfigFields = fields as Map<String, String>
    buildConfigFields.forEach { (key, value) -> buildConfigField("String", key, "\"$value\"") }
}

android {
    namespace = "com.omarjarid.data"
    compileSdk = 36

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        val buildConfigFields = project.ext["buildConfigFields"]
        addBuildConfigFields(buildConfigFields)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
    buildFeatures { buildConfig = true }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit2.kotlinx.serialization.converter)

    implementation(libs.hilt.android)
    implementation(libs.logging.interceptor)
    implementation(libs.javax.inject)
    implementation(libs.retrofit)

    ksp(libs.hilt.compiler)

    api(project(":domain"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}