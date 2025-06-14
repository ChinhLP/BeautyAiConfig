package com.apero.testai.utils.art

import com.ads.control.ads.wrapper.ApRewardAd
import com.apero.art.api.config.ads.VslArtAdsConfig
import com.apero.testai.BuildConfig

class ArtAdsConfig : VslArtAdsConfig {
    private var rewardAdArtLoaded: ApRewardAd? = null

    override val rewardAdArtReLoaded: ApRewardAd?
        get() = rewardAdArtLoaded

    override val idRewardGenArtHigh: String
        get() = BuildConfig.REWARD_GEN_ART_HIGH

    override val idRewardGenArtNormal: String
        get() = BuildConfig.REWARD_GEN_ART_NORMAL

    override val idBannerArtHigh: String
        get() = BuildConfig.BANNER_ART_HIGH

    override val idBannerArtNormal: String
        get() = BuildConfig.BANNER_ART_NORMAL

    override fun setNewAdsRewardArt(rewardAdArtLoaded: ApRewardAd?) {
        this.rewardAdArtLoaded = rewardAdArtLoaded
    }

    override fun shouldLoadRewardArtAd(
        isShowRewardArtHigh: Boolean,
        isShowRewardArtNormal: Boolean
    ) {
        // Implement your reward ad loading logic here
    }
} 