package com.apero.testai.utils.setupremoveobject

import com.apero.beauty_full.common.removeobject.api.config.VslRemoveObjectAdsConfig
import com.apero.testai.BuildConfig

class RemoveAdsConfig : VslRemoveObjectAdsConfig {
    override val rewardGenRemoveObjectHigh: String
        get() = BuildConfig.REWARD_GEN_ALL_FEATURE_HIGH
    override val rewardGenRemoveObjectNormal: String
        get() = BuildConfig.REWARD_GEN_ALL_FEATURE_NORMAL
} 