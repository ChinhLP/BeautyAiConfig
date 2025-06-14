package com.apero.testai.utils.all_feature.config

import android.content.Context
import com.apero.beauty_full.api.config.VslBeautyFullCommonConfig
import com.apero.testai.MainActivity
import com.apero.testai.PickPhotoActivity
import com.apero.testai.R
import com.apero.testai.pref.SharedPref

class CommonConfig(private val sharedPref: SharedPref, private val applicationContext: Context) :
    VslBeautyFullCommonConfig {
    override val languageCode: String
        get() = sharedPref.languageCode ?: "en"

    override val nameStyle: String
        get() = "MyAppStyle"

    override val pickPhotoClass: Class<*>
        get() = PickPhotoActivity::class.java

    override val homeClass: Class<*>
        get() = MainActivity::class.java

    override val nativeLayout: Int
        get() = R.layout.layout_native_lfo_and_onb_top_bt

    override val loadingNativeLayout: Int
        get() = R.layout.layout_loading_native_large

    override val emailReport: String = "support@example.com"

    override val emailCCReport: List<String> = listOf("dev1@example.com", "dev2@example.com")

    override val language: String
        get() = sharedPref.languageCode ?: "en"

    override val appName: Int = R.string.app_name

    override val appLinkWithTag: String = "example.com/myapp #MyApp"

    override val authority: String = "${applicationContext.packageName}.provider"
} 