package com.apero.testai.utils.all_feature.config

import com.apero.beauty_full.api.config.ads.VslBeautyFullAllFeatureAdsIdConfig
import com.apero.testai.BuildConfig

class VslBeautyFullAdsConfig : VslBeautyFullAllFeatureAdsIdConfig {
    override val rewardGenAllFeatureHigh: String = BuildConfig.REWARD_GEN_ALL_FEATURE_HIGH
    override val rewardGenAllFeatureNormal: String = BuildConfig.REWARD_GEN_ALL_FEATURE_NORMAL
    override val idBannerAllFeatureHigh: String
        get() = BuildConfig.BANNER_ALL_FEATURE_HIGH
    override val idBannerAllFeatureNormal: String
        get() = BuildConfig.BANNER_ALL_FEATURE_NORMAL
    override val idBannerShareHigh: String
        get() = BuildConfig.BANNER_SHARE_HIGH
    override val idBannerShareNormal: String
        get() = BuildConfig.BANNER_SHARE_NORMAL
    override val idBannerStyleHigh: String
        get() = BuildConfig.BANNER_STYLE_HIGH
    override val idNativeHighFloor: String
        get() = BuildConfig.NATIVE_HIGH_FLOOR
    override val idNativeNormalFloor: String
        get() = BuildConfig.NATIVE_NORMAL_FLOOR
    override val idInterstitialHighPriority: String
        get() = BuildConfig.INTERSTITIAL_HIGH_PRIORITY
    override val idInterstitialMediumPriority: String
        get() = BuildConfig.INTERSTITIAL_MEDIUM_PRIORITY
    override val idInterstitialLowPriority: String
        get() = BuildConfig.INTERSTITIAL_LOW_PRIORITY
    override val idRewardGenRestoreHigh: String
        get() = BuildConfig.REWARD_GEN_RESTORE_HIGH
    override val idRewardGenRestoreNormal: String
        get() = BuildConfig.REWARD_GEN_RESTORE_NORMAL
    override val idBannerAdStyleNormal: String
        get() = BuildConfig.BANNER_AD_STYLE_NORMAL
    override val idBannerAdStyleHigh: String
        get() = BuildConfig.BANNER_AD_STYLE_HIGH
    override val idRewardGenTemplateHigh: String
        get() = BuildConfig.REWARD_GEN_TEMPLATE_HIGH
    override val idRewardGenTemplateNormal: String
        get() = BuildConfig.REWARD_GEN_TEMPLATE_NORMAL
    override val idBannerTemplateHigh: String
        get() = BuildConfig.BANNER_TEMPLATE_HIGH
    override val idBannerTemplateNormal: String
        get() = BuildConfig.BANNER_TEMPLATE_NORMAL
    override val idBannerArtHigh: String
        get() = BuildConfig.BANNER_ART_HIGH
    override val idBannerArtNormal: String
        get() = BuildConfig.BANNER_ART_NORMAL
    override val idRewardGenArtHigh: String
        get() = BuildConfig.REWARD_GEN_ART_HIGH
    override val idRewardGenArtNormal: String
        get() = BuildConfig.REWARD_GEN_ART_NORMAL
    override val idRewardGenArtPremiumHigh: String
        get() = BuildConfig.REWARD_GEN_ART_PREMIUM_HIGH
    override val idRewardGenArtPremiumNormal: String
        get() = BuildConfig.REWARD_GEN_ART_PREMIUM_NORMAL
    override val idBannerArtPremiumHigh: String
        get() = BuildConfig.BANNER_ART_PREMIUM_HIGH
    override val idBannerArtPremiumNormal: String
        get() = BuildConfig.BANNER_ART_PREMIUM_NORMAL
    override val idBannerStyleNormal: String
        get() = BuildConfig.BANNER_STYLE_NORMAL
    override val idBannerRemoveBgHigh: String
        get() = BuildConfig.BANNER_REMOVE_BG_HIGH
    override val idBannerRemoveBgNormal: String
        get() = BuildConfig.BANNER_REMOVE_BG_NORMAL
    override val idRewardGenRemoveBgHigh: String
        get() = BuildConfig.REWARD_GEN_REMOVE_BG_HIGH
    override val idRewardGenRemoveBgNormal: String
        get() = BuildConfig.REWARD_GEN_REMOVE_BG_NORMAL
} 