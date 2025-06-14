package com.apero.testai.utils.all_feature.config

import com.apero.beauty_full.api.config.VslBeautyFullServiceConfig
import com.apero.testai.BuildConfig

class BeautyFullServiceConfig : VslBeautyFullServiceConfig {
    override val appId: String
        get() = "com.apero.testai"
    override val projectName: String
        get() = "PROJECT_MYAPP_ANDROID"
    override val requestHash: String
        get() = "abc123XYZ"
    override val urlIntegrity: String
        get() = "url_integrity_example"
    override val cloudProjectNumber: Long
        get() = 1234567890
} 