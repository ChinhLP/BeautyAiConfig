package com.apero.testai.utils.setupenhance

import com.apero.beauty_full.common.enhance.api.config.VslEnhanceAdsConfig
import com.apero.testai.BuildConfig

class EnhanceAdsConfig : VslEnhanceAdsConfig {
    override val rewardGenEnhanceHigh: String = BuildConfig.REWARD_GEN_ALL_FEATURE_HIGH
    override val rewardGenEnhanceNormal: String = BuildConfig.REWARD_GEN_ALL_FEATURE_NORMAL
} 