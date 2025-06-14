package com.apero.testai.utils.clothes

import com.apero.beauty_full.api.config.subfeauture.VslBeautyFullClothesFeature
import com.apero.beauty_full.common.clothes.config.modelconfig.VslAdsConfigModel
import com.apero.beauty_full.common.clothes.config.modelconfig.VslConfigPickPhotoModel
import com.apero.beauty_full.common.clothes.config.modelconfig.VslFontsConfigModel
import com.apero.beauty_full.common.clothes.config.modelconfig.VslIconsConfigModel
import com.apero.beauty_full.common.clothes.config.modelconfig.VslStringConfigDialogModel
import com.apero.beauty_full.common.clothes.config.modelconfig.VslStringsConfigModel
import com.apero.testai.pref.SharedPref
import com.apero.testai.BuildConfig

object ClothesFeature : VslBeautyFullClothesFeature {
    val sharedPref: SharedPref = SharedPref.getInstance()
    
    override val fonts: VslFontsConfigModel
        get() = VslFontsConfigModel()
        
    override val icons: VslIconsConfigModel
        get() = VslIconsConfigModel()
        
    override val strings: VslStringsConfigModel
        get() = VslStringsConfigModel()
        
    override val stringsDialog: VslStringConfigDialogModel
        get() = VslStringConfigDialogModel()
        
    override val pickPhoto: VslConfigPickPhotoModel
        get() = VslConfigPickPhotoModel()
        
    override val adsConfig: VslAdsConfigModel
        get() = VslAdsConfigModel(
            BuildConfig.REWARD_GEN_ALL_FEATURE_NORMAL,
            BuildConfig.REWARD_GEN_ALL_FEATURE_HIGH,
            BuildConfig.REWARD_GEN_ALL_FEATURE_NORMAL,
            BuildConfig.REWARD_GEN_ALL_FEATURE_HIGH
        )
} 