package com.apero.testai

import android.app.Application
import com.ads.control.admob.Admob
import com.ads.control.admob.AppOpenManager
import com.ads.control.ads.AperoAd
import com.ads.control.application.AdsMultiDexApplication
import com.ads.control.config.AperoAdConfig
import com.ads.control.config.AppsflyerConfig
import com.apero.testai.pref.SharedPref
import com.apero.testai.di.BeautyFullConfigProvider
import com.apero.testai.utils.beauti.BeautyConfigProvider
import com.apero.testai.utils.setupfitting.fittingProvider
import com.apero.beauty_full.VslBeautyFullEntry
import com.google.firebase.FirebaseApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class App : AdsMultiDexApplication() {

    companion object {
        private lateinit var instance: App

        fun getInstance(): App = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        FirebaseApp.initializeApp(this)
        initKoin()
        VslBeautyFullEntry.initialize(
            context = this,
            config = BeautyFullConfigProvider.beautyFullConfig,
            beautyPlusConfig = BeautyConfigProvider(),
            fittingConfig = fittingProvider(),
            singleFeatureAction = null
        )
    }

    private fun configAdsSdk() {
        val env = AperoAdConfig.ENVIRONMENT_DEVELOP
        aperoAdConfig =
            AperoAdConfig(
                this,
                "fsvwLvCwqI6CibDA218nv3Tftn3O9EibhAJckrMxHhWBMYIJiZNjo5EFOTbm2hTohIWeeyWImpR7aXuHLN1K2nGpj9SMa8MJaQ0LfCGmF01MMrbD8lkjIZopMB/b5FIFs8fp4nBvnfYvSCmjSCMKwKHJ641FEN44W2/do5DaYTM=",
                AperoAdConfig.PROVIDER_ADMOB,
                env
            )
        Admob.getInstance().setOpenActivityAfterShowInterAds(true)

        aperoAdConfig.appsflyerConfig = AppsflyerConfig(true, "2PUNpdyDTkedZTgeKkWCyB")
        Admob.getInstance().setFan(true)
        Admob.getInstance().setAppLovin(true)
        Admob.getInstance().setColony(true)

        /*
                aperoAdConfig.idAdResume = BuildConfig.open_resume
                aperoAdConfig?.facebookClientToken = getString(R.string.facebook_token_id)
        */
        aperoAdConfig?.isEnableTrackingPaidAdValueAsFBPurchase = true
        AperoAd.getInstance().init(this, aperoAdConfig, false)

        // Auto disable ad resume after user click ads and back to app
        Admob.getInstance().setDisableAdResumeWhenClickAds(true)
//        AppOpenManager.getInstance().disableAppResumeWithActivity(SplashActivity::class.java)
    }

    @OptIn(KoinExperimentalAPI::class)
    private fun initKoin() {
        startKoin {
            androidLogger(
                if (BuildConfig.DEBUG)
                    Level.INFO
                else
                    Level.NONE
            )
            androidContext(this@App)
        }
    }
}