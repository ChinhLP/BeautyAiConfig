package com.apero.testai.utils.setupfitting

import com.apero.beauty_full.common.fitting.Config
import com.apero.beauty_full.common.fitting.VslFittingConfig
import com.apero.testai.BuildConfig
import com.apero.testai.R

fun fittingProvider(): VslFittingConfig {
    return VslFittingConfig().setBaseConfig(
        Config.IdAdsRewardConfig(
            rewardIdPriorityFittingGenerate = BuildConfig.REWARD_GEN_ALL_FEATURE_HIGH,
            rewardIdDefaultFittingGenerate = BuildConfig.REWARD_GEN_ALL_FEATURE_NORMAL
        ),
        nativeAdsConfig = null,
    ).setUiConfig(
        Config.UiConfig(),
        Config.PhotoPickerUiConfig(
                imageSample = R.drawable.img_pick_photo_demo
        )
    )
} 