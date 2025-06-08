package com.apero.testai.utils.beauty_full

import com.apero.beauty_full.api.config.VslBeautyFullServiceConfig

class BeautyFullServiceConfig : VslBeautyFullServiceConfig {
    override val appId: String = "com.apero.testai"
    override val projectName: String = "PROJECT_MYAPP_ANDROID"
    override val requestHash: String = "abc123XYZ"
    override val urlIntegrity: String = "url_integrity_example"
    override val cloudProjectNumber: Long = 1234567890
} 