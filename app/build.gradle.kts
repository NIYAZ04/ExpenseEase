import org.jetbrains.kotlin.kapt3.base.Kapt.kapt
import shadow.bundletool.com.android.tools.r8.internal.id

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id("com.google.devtools.ksp")
    id ("io.realm.kotlin")
    id ("io.sentry.android.gradle") version "4.0.0"
}


android {
    namespace = "com.example.expensetracker"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.expensetracker"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables{
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles (
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

buildscript{
    repositories{
        mavenCentral()
    }
}



dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation ("androidx.compose.material3:material3:1.0.1")



    // Dependencies added by Mir_Niyazul_Haque

    //Faker instanse
    implementation ("io.github.serpro69:kotlin-faker:1.13.0")
    // for Swipable
    implementation ("me.saket.swipe:swipe:1.0.0")
    // For Navigation
    implementation("androidx.navigation:navigation-compose:2.6.0")
    // marsseleng ->For Calender
    implementation("com.marosseleng.android:compose-material3-datetime-pickers:0.6.0")
    // skydoves ->For Color Picker
    implementation ("com.github.skydoves:colorpicker-compose:1.0.0")

    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

//room


    implementation("androidx.room:room-runtime:2.5.0")
    annotationProcessor("androidx.room:room-compiler:2.5.0")

    implementation("androidx.room:room-ktx:2.5.0")
    kapt("androidx.room:room-compiler:2.5.0")
    ksp("androidx.room:room-compiler:2.5.0")

// chart Dependency
implementation("com.github.tehras:charts:0.2.4-alpha")

    // lets check
    implementation ("com.github.skydoves:colorpicker-compose:1.0.0")
    implementation ("me.saket.swipe:swipe:1.0.0")
    implementation ("io.github.serpro69:kotlin-faker:1.13.0")

    implementation ("com.google.accompanist:accompanist-pager:0.29.1-alpha")

    //Adding Sentry implementation for performance Checking
    implementation ("io.sentry:sentry-android:6.13.1")
    implementation ("io.sentry:sentry-compose-android:6.13.1")
// Realm Database Integration
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation ("io.realm.kotlin:library-base:1.6.0")
}




