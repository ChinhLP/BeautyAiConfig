plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id ("com.google.gms.google-services")
}

android {
    namespace = "com.apero.testai"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.apero.testai"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        
        buildConfigField("String", "REWARD_GEN_ALL_FEATURE_HIGH", "\"ca-app-pub-xxx/reward_high\"")
        buildConfigField("String", "REWARD_GEN_ALL_FEATURE_NORMAL", "\"ca-app-pub-xxx/reward_normal\"")
        buildConfigField("String", "BANNER_ALL_FEATURE_HIGH", "\"ca-app-pub-xxx/banner_all_high\"")
        buildConfigField("String", "BANNER_ALL_FEATURE_NORMAL", "\"ca-app-pub-xxx/banner_all_normal\"")
        buildConfigField("String", "BANNER_SHARE_HIGH", "\"ca-app-pub-xxx/banner_share_high\"")
        buildConfigField("String", "BANNER_SHARE_NORMAL", "\"ca-app-pub-xxx/banner_share_normal\"")
        buildConfigField("String", "BANNER_STYLE_HIGH", "\"ca-app-pub-xxx/banner_style_high\"")
        buildConfigField("String", "BANNER_STYLE_NORMAL", "\"ca-app-pub-xxx/banner_style_normal\"")
        buildConfigField("String", "NATIVE_HIGH_FLOOR", "\"ca-app-pub-xxx/native_high_floor\"")
        buildConfigField("String", "NATIVE_NORMAL_FLOOR", "\"ca-app-pub-xxx/native_normal_floor\"")
        buildConfigField("String", "INTERSTITIAL_HIGH_PRIORITY", "\"ca-app-pub-xxx/interstitial_high\"")
        buildConfigField("String", "INTERSTITIAL_MEDIUM_PRIORITY", "\"ca-app-pub-xxx/interstitial_medium\"")
        buildConfigField("String", "INTERSTITIAL_LOW_PRIORITY", "\"ca-app-pub-xxx/interstitial_low\"")
        buildConfigField("String", "REWARD_GEN_RESTORE_HIGH", "\"ca-app-pub-xxx/reward_restore_high\"")
        buildConfigField("String", "REWARD_GEN_RESTORE_NORMAL", "\"ca-app-pub-xxx/reward_restore_normal\"")
        buildConfigField("String", "BANNER_AD_STYLE_HIGH", "\"ca-app-pub-xxx/banner_ad_style_high\"")
        buildConfigField("String", "BANNER_AD_STYLE_NORMAL", "\"ca-app-pub-xxx/banner_ad_style_normal\"")
        buildConfigField("String", "REWARD_GEN_TEMPLATE_HIGH", "\"ca-app-pub-xxx/reward_template_high\"")
        buildConfigField("String", "REWARD_GEN_TEMPLATE_NORMAL", "\"ca-app-pub-xxx/reward_template_normal\"")
        buildConfigField("String", "BANNER_TEMPLATE_HIGH", "\"ca-app-pub-xxx/banner_template_high\"")
        buildConfigField("String", "BANNER_TEMPLATE_NORMAL", "\"ca-app-pub-xxx/banner_template_normal\"")
        buildConfigField("String", "BANNER_ART_HIGH", "\"ca-app-pub-xxx/banner_art_high\"")
        buildConfigField("String", "BANNER_ART_NORMAL", "\"ca-app-pub-xxx/banner_art_normal\"")
        buildConfigField("String", "REWARD_GEN_ART_HIGH", "\"ca-app-pub-xxx/reward_gen_art_high\"")
        buildConfigField("String", "REWARD_GEN_ART_NORMAL", "\"ca-app-pub-xxx/reward_gen_art_normal\"")
        buildConfigField("String", "REWARD_GEN_ART_PREMIUM_HIGH", "\"ca-app-pub-xxx/reward_gen_art_premium_high\"")
        buildConfigField("String", "REWARD_GEN_ART_PREMIUM_NORMAL", "\"ca-app-pub-xxx/reward_gen_art_premium_normal\"")
        buildConfigField("String", "BANNER_ART_PREMIUM_HIGH", "\"ca-app-pub-xxx/banner_art_premium_high\"")
        buildConfigField("String", "BANNER_ART_PREMIUM_NORMAL", "\"ca-app-pub-xxx/banner_art_premium_normal\"")
        buildConfigField("String", "BANNER_REMOVE_BG_HIGH", "\"ca-app-pub-xxx/banner_remove_bg_high\"")
        buildConfigField("String", "BANNER_REMOVE_BG_NORMAL", "\"ca-app-pub-xxx/banner_remove_bg_normal\"")
        buildConfigField("String", "REWARD_GEN_REMOVE_BG_HIGH", "\"ca-app-pub-xxx/reward_gen_remove_bg_high\"")
        buildConfigField("String", "REWARD_GEN_REMOVE_BG_NORMAL", "\"ca-app-pub-xxx/reward_gen_remove_bg_normal\"")
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
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation("apero:beauty-full:1.3.1-alpha02")
    implementation(libs.play.services.ads)
    implementation(libs.apero.ads)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.pick.photo)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}