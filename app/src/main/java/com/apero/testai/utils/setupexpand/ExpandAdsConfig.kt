package com.apero.testai.utils.setupexpand

import com.apero.beauty_full.common.expand.api.config.VslExpandAdsConfig
import com.apero.testai.BuildConfig

class ExpandAdsConfig : VslExpandAdsConfig {
    override val rewardGenExpandHigh: String = BuildConfig.REWARD_GEN_ALL_FEATURE_HIGH
    override val rewardGenExpandNormal: String = BuildConfig.REWARD_GEN_ALL_FEATURE_NORMAL
} 