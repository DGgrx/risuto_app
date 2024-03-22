import java.io.FileInputStream
import java.util.Properties

// Load keystore properties from keystore.properties file
val keystoreProperties = Properties().apply {
    load(FileInputStream(rootProject.file("keystore.properties")))
}

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")

}

android {
    namespace = "com.example.jumping_minds_assignment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.jumping_minds_assignment"
        minSdk = 24
        targetSdk = 34
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    signingConfigs {
        create("release") {
            storeFile = rootProject.file(keystoreProperties["storeFile"])
            storePassword = keystoreProperties["storePassword"] as String
            keyAlias = keystoreProperties["keyAlias"] as String
            keyPassword = keystoreProperties["keyPassword"] as String
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

    // Splash Screen API
    implementation("androidx.core:core-splashscreen:1.0.0")

    // Preferences DataStore
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // Dagger Hilt
    val hilt_version = "2.51"
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-android-compiler:$hilt_version")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // NavGraph - Jetpack Compose Integration
    val nav_version = "2.7.7"
    implementation("androidx.navigation:navigation-compose:$nav_version")

    // Accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.35.0-alpha")


    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.10.0")
    implementation("com.squareup.retrofit2:converter-gson:2.10.0")

    // Paging 3
    val paging_version = "3.2.1"
    implementation("androidx.paging:paging-runtime:$paging_version")
    implementation("androidx.paging:paging-compose:3.3.0-alpha04")

    // Coil for Loading images using coroutines
    implementation("io.coil-kt:coil-compose:2.6.0")


    // Room Database
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")


    // Jetpack Compose
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // JUnit for Unit Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}

