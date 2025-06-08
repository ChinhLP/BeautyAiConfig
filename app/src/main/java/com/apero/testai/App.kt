package com.apero.testai

import android.app.Application
import com.apero.testai.pref.SharedPref
import com.apero.testai.utils.beauty_full.CommonConfig
import com.apero.testai.utils.beauty_full.BeautyFullServiceConfig
import com.apero.testai.utils.beauty_full.VslBeautyFullAdsConfig
import com.apero.testai.utils.beauty_full.BeautyConfigProvider
import com.apero.beauty_full.VslBeautyFullEntry

class App : Application() {

    companion object {
        private lateinit var instance: App

        fun getInstance(): App = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        
        val commonConfig = CommonConfig(SharedPref(this), this)
        val serviceConfig = BeautyFullServiceConfig()
        val adsConfig = VslBeautyFullAdsConfig()
        val beautyProvider = BeautyConfigProvider(commonConfig, adsConfig, serviceConfig)

        VslBeautyFullEntry.initialize(
            context = this,
            commonConfig = commonConfig,
            serviceConfig = serviceConfig,
            allFeatureAdsIdConfig = adsConfig,
            beautyConfigProvider = beautyProvider
        )
    }
}