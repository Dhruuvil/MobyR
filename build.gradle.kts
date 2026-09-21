plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    namespace = "com.mobyrewards.mobyrewards"
    compileSdk = 37

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    publishing {
        singleVariant("release")
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("androidx.core:core-ktx:1.16.0")
    implementation("com.google.android.material:material:1.13.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
    androidTestImplementation("androidx.test.ext:junit:1.3.0")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.Dhruuvil"
            artifactId = "MobyR"
            version = "1.0.1"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}