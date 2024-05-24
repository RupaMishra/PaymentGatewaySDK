plugins {
    alias(libs.plugins.android.library)
    `maven-publish`
}

android {
    namespace = "com.ideaneuron.paymentgateway"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                // Make sure the component name matches your build type
                from(components.findByName("release"))
                groupId = "com.github.RupaMishra"
                artifactId = "PaymentGateway"
                version = "2.0.2"
            }
        }
        repositories {
            mavenLocal()
        }
    }
}
dependencies {

    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}