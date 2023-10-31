plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "uz.gita.contactworkteam"
    compileSdk = 34

    defaultConfig {
        applicationId = "uz.gita.contactworkteam"
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

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
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


    val work_version = "2.8.1"

    // Kotlin + coroutines
    implementation("androidx.work:work-runtime-ktx:$work_version")
    // Room
    val roomVersion = "2.5.2"
    //noinspection GradleDependency
    implementation("androidx.room:room-runtime:$roomVersion")
    //noinspection GradleDependency
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
    //noinspection KaptUsageInsteadOfKsp,GradleDependency
    kapt("androidx.room:room-compiler:$roomVersion")
    //noinspection GradleDependency
    implementation("androidx.room:room-ktx:$roomVersion")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Client
    //noinspection GradleDependency
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    //noinspection GradleDependency
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")

    debugImplementation("com.github.chuckerteam.chucker:library:4.0.0")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:4.0.0")

    // Voyager
    val voyagerVersion = "1.0.0-rc05"
    // Navigator
    //noinspection GradleDependency
    implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
    // BottomSheetNavigator
    //noinspection GradleDependency
    implementation("cafe.adriel.voyager:voyager-bottom-sheet-navigator:$voyagerVersion")
    // TabNavigator
    //noinspection GradleDependency
    implementation("cafe.adriel.voyager:voyager-tab-navigator:$voyagerVersion")
    // Transitions
    //noinspection GradleDependency
    implementation("cafe.adriel.voyager:voyager-transitions:$voyagerVersion")
    // Android
    // Android ViewModel integration
    //noinspection GradleDependency
    implementation("cafe.adriel.voyager:voyager-androidx:$voyagerVersion")
    // Hilt integration
    //noinspection GradleDependency
    implementation("cafe.adriel.voyager:voyager-hilt:$voyagerVersion")

    // Hilt
    val hiltVersion = ("2.44.2")
    //noinspection GradleDependency
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    //noinspection GradleDependency
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")

    // LottieAnim
    implementation("com.airbnb.android:lottie-compose:6.1.0")

    // WorkManager
    implementation("androidx.work:work-runtime:2.8.1")

//    // Better Logging In Android Using Timber
    implementation("com.jakewharton.timber:timber:5.0.1")

    //compose permission
    implementation ("com.google.accompanist:accompanist-permissions:0.31.1-alpha")

    // Hilt worker
    implementation("androidx.hilt:hilt-work:1.0.0")
    // When using Kotlin.
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    // When using Java.
    annotationProcessor("androidx.hilt:hilt-compiler:1.0.0")
}