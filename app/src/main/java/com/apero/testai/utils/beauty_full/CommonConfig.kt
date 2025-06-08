package com.apero.testai.utils.beauty_full

import android.content.Context
import com.apero.testai.pref.SharedPref

class CommonConfig(
    private val sharedPref: SharedPref,
    val applicationContext: Context
) {
    val appName: String = "My App"
    val authority: String = "com.apero.testai.provider"
    val emailReport: String = "support@example.com"
    val emailCCReport: List<String> = listOf(
        "dev1@example.com",
        "dev2@example.com"
    )
    val appLinkWithTag: String = "example.com/myapp #MyApp"
    val nameStyle: String = "MyAppStyle"
    val languageCode: String = "en"
} 