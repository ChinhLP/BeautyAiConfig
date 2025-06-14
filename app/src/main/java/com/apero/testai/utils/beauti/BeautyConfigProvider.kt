package com.apero.testai.utils.beauti

import com.apero.beauty_full.api.config.subfeauture.VslBeautyFullBeautyConfigProvider
import com.apero.beauty_full.common.beautify.template2.config.module.ads.builder.AdsBuilderV2
import com.apero.beauty_full.common.beautify.template2.config.module.ui.builder.BeautyUIConfigBuilderV2
import com.apero.testai.R
import com.apero.testai.pref.SharedPref
import com.apero.testai.App
import com.apero.testai.BuildConfig

class BeautyConfigProvider : VslBeautyFullBeautyConfigProvider(App.getInstance()) {
    val sharedPref: SharedPref by lazy { SharedPref.getInstance() }

    override fun BeautyUIConfigBuilderV2.configureUIConfig() = apply {
        colors {
            setTextPrimaryColor(R.color.beauty_color_text_primary)
            setTextSecondaryColor(R.color.beauty_color_text_secondary)
            setTextMainColor(R.color.beauty_color_text_main)
        }
        strings {
            setLoading(R.string.vsl_beautify_loading)
            setTag(R.string.app_name)
        }
        icons {
            iconClose(R.drawable.beautify_ic_back)
            bgButtonMain(R.drawable.beautify_bg_gradient_button_r6)
            bgButtonOval(R.drawable.perfectme_bg_gradient_button_r50)
            iconBadgeEdit(R.drawable.beautify_bg_gradient_button_r999)
            setIconBackToHome(R.drawable.beautify_ic_share_home)
        }
        textFont {
            regular(R.font.svn_gilroy_regular)
            medium(R.font.svn_gilroy_medium)
            bold(R.font.svn_gilroy_bold)
            semiBold(R.font.svn_gilroy_semibold)
        }
        animations {
            setLoadingAnimation(R.raw.beautify_anim_loading)
        }
    }

    override fun AdsBuilderV2.configureAds(): AdsBuilderV2 = apply {
        setRewardBeauty(
            BuildConfig.REWARD_GEN_ALL_FEATURE_HIGH,
            BuildConfig.REWARD_GEN_ALL_FEATURE_NORMAL
        )
        setRewardGenBeauty(
            BuildConfig.REWARD_GEN_ALL_FEATURE_HIGH,
            BuildConfig.REWARD_GEN_ALL_FEATURE_NORMAL
        )
        setBannerStyle(
            idBannerStyleHigh = BuildConfig.BANNER_STYLE_HIGH,
            idBannerStyleNormal = BuildConfig.BANNER_STYLE_NORMAL
        )
        setBannerOption(
            idBannerOptionHigh = BuildConfig.BANNER_ALL_FEATURE_HIGH,
            idBannerOptionNormal = BuildConfig.BANNER_ALL_FEATURE_NORMAL
        )
    }

    override fun getAppNameReport(): String {
        return App.getInstance().getString(R.string.app_name)
    }

    override fun getLanguage(): String {
        return sharedPref.languageCode ?: "en"
    }

    override fun getEmailReport(): String {
        return "support@example.com"
    }

    override fun getNameStyle(): String {
        return "MyApp - Beautify"
    }

    override fun getPackageNameProvider(): String {
        return "${BuildConfig.APPLICATION_ID}.provider"
    }
} 