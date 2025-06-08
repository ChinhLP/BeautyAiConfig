package com.apero.testai.utils.beauty_full

import com.apero.beauty_full.api.config.VslBeautyFullServiceConfig
import com.apero.beauty_full.api.config.ads.VslBeautyFullAllFeatureAdsIdConfig
import com.apero.beauty_full.api.config.subfeauture.VslBeautyFullBeautyConfigProvider
import com.apero.beauty_full.common.beautify.template2.config.module.ads.builder.AdsBuilderV2
import com.apero.beauty_full.common.beautify.template2.config.module.ui.builder.BeautyUIConfigBuilderV2

class BeautyConfigProvider(
    private val commonConfig: CommonConfig,
    private val adsConfig: VslBeautyFullAllFeatureAdsIdConfig,
    private val serviceConfig: VslBeautyFullServiceConfig
) : VslBeautyFullBeautyConfigProvider(commonConfig.applicationContext) {

    override fun BeautyUIConfigBuilderV2.configureUIConfig() = apply {
        // giữ nguyên defaults hoặc tùy chỉnh nếu cần
    }

    override fun AdsBuilderV2.configureAds(): AdsBuilderV2 = apply {
        setRewardBeauty(
            adsConfig.rewardGenAllFeatureHigh,
            adsConfig.rewardGenAllFeatureNormal
        )
        setRewardGenBeauty(
            adsConfig.idRewardGenArtHigh,
            adsConfig.idRewardGenArtNormal
        )
        setBannerStyle(
            idBannerStyleHigh = adsConfig.idBannerStyleHigh,
            idBannerStyleNormal = adsConfig.idBannerStyleNormal
        )
        setBannerOption(
            idBannerOptionHigh = adsConfig.idBannerAllFeatureHigh,
            idBannerOptionNormal = adsConfig.idBannerAllFeatureNormal
        )
    }

    override fun getAppNameReport(): String =
        commonConfig.applicationContext.getString(commonConfig.appName)

    override fun getLanguage(): String =
        commonConfig.languageCode

    override fun getEmailReport(): String =
        commonConfig.emailReport

    override fun getNameStyle(): String =
        commonConfig.nameStyle

    override fun getPackageNameProvider(): String =
        commonConfig.authority
} 