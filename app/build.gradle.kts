import kotlin.text.set

// variables
val icons_version = "1.1.1"
val nav_version = "2.8.3"
val apollo_version = "4.0.1"
val viewmodal_version = "2.6.1"



plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.apollographql.apollo").version("4.0.1")
}

android {
    namespace = "com.github.tallestlegacy.rickandmortykt"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.github.tallestlegacy.rickandmortykt"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
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

    implementation("br.com.devsrsouza.compose.icons:feather:$icons_version") // Icons
    implementation ("androidx.navigation:navigation-compose:$nav_version") // Compose navigation
    implementation("com.apollographql.apollo:apollo-runtime:$apollo_version") // GraphQL client
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$viewmodal_version") // Stateflow management
}

apollo {
    service("service") {
        packageName.set("com.github.tallestlegacy.rickandmortykt")
    }
}
