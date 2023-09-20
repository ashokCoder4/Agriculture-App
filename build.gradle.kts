plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.ashokbaniya.connection"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.ashokbaniya.connection"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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
}

dependencies {
    implementation ("com.stripe:stripe-android:20.3.1")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.16.0")
    implementation ("com.stripe:stripe-android:20.30.2")
    implementation ("com.squareup.picasso:picasso:2.71828")
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation ("com.google.firebase:firebase-storage:20.2.1")
    implementation ("com.google.firebase:firebase-auth:22.1.1")
    implementation ("com.google.firebase:firebase-database:20.2.2")
    implementation ("com.google.firebase:firebase-core:21.1.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-database-ktx:20.2.2")
    implementation("com.google.firebase:firebase-database:20.2.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}