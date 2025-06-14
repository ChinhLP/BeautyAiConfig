package com.apero.testai

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Matrix
import android.os.Build
import android.util.Log
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.exifinterface.media.ExifInterface
import androidx.lifecycle.lifecycleScope
import com.apero.beauty_full.api.clazz.selectphoto.VslBeautyFullSelectPhoto
import com.apero.beauty_full.api.model.VslBeautyFullCategoryFeature
import com.apero.photopicker.config.PickPhotoNativeAdsConfig
import com.apero.photopicker.config.builder.PhotoPickerUIConfigBuilder
import com.apero.photopicker.model.ImageSample
import com.apero.photopicker.util.PermissionUtil
import com.apero.testai.pref.SharedPref
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject
import java.io.FileOutputStream
import java.util.Locale

class PickPhotoActivity : VslBeautyFullSelectPhoto() {

    companion object {
        private const val KEY_CAN_REQUEST_PERMISSION = "CAN_REQUEST_PERMISSION"

        fun getIntent(
            context: Context,
            isAllFeature: Boolean = false,
            style: VslBeautyFullCategoryFeature,
            reFetchData: Boolean = false
        ): Intent {
            return Intent(context, PickPhotoActivity::class.java).apply {
                putExtras(extras?.apply {
                    putParcelable(KEY_OPEN_FEATURE, style)
                } ?: bundleOf(KEY_OPEN_FEATURE to style))
                putExtra(KEY_OPEN_ALL_FEATURE, isAllFeature)
                putExtra(RE_FETCH_DATA, reFetchData)
            }
        }
    }

    override val enableShowDialogGotoSettingPhoto: Boolean = true
    private val appSharedPref: SharedPref = SharedPref.getInstance()

    override fun onRestart() {
        super.onRestart()
        reFetchImage()
        reFetchCurrentFolder()
        /*permissionUtil.reload(this, reloadImage = {
            reFetchImage()
            reFetchCurrentFolder()
        })*/
    }

    override fun attachBaseContext(newBase: Context?) {
        val language = appSharedPref.languageCode
        if (newBase != null && language != null) {
            super.attachBaseContext(
                updateResources(
                    newBase,
                    language
                )
            )
        } else {
            super.attachBaseContext(newBase)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
//        InterAdsManager.preloadInter(context = this)
    }

    override var onExitListener: VslBeautyFullOnExitListener? = object : VslBeautyFullOnExitListener {
        override fun onExit() {
            startActivity(Intent(this@PickPhotoActivity, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            })
            finish()
        }
    }

    private fun updateResources(
        context: Context, language: String,
    ): Context? {
        val contextFormatted: Context?
        val locale: Locale
        if (language.contains("-")) {
            val splitLanguage = language.split("-")
            locale = Locale(splitLanguage[0], splitLanguage[1])
        } else {
            locale = Locale(language)
        }
        Locale.setDefault(locale)
        val res = context.resources
        val config = Configuration(res?.configuration)
        config.setLocale(locale)
        contextFormatted = context.createConfigurationContext(config)
        return contextFormatted
    }

    override fun setUpUiConfig(builder: PhotoPickerUIConfigBuilder): PhotoPickerUIConfigBuilder {
        return builder
            .setSampleImage(ImageSample.Resource(R.drawable.img_pick_photo_demo))
            .colors {
                setBackground(Color.WHITE)
                /*setBgNegativeDialog(CommonResource.drawable.bg_btn_negative_permission_dialog)
                setTextPrimary(
                    ContextCompat.getColor(
                        this@PickPhotoActivity,
                        CommonResource.color.pick_photo_primary_text_color
                    )
                )
                setPrimary(
                    ContextCompat.getColor(
                        this@PickPhotoActivity,
                        CommonResource.color.primary_color
                    )
                )
                setBackgroundTextDemo(
                    Color.WHITE.withAlpha(0.5f)
                )*/
            }
            .icons {
                /*setButtonNegative(CommonResource.drawable.bg_btn_negative_permission_dialog)
                setSelectedPhoto(CommonResource.drawable.ic_pick_photo_select_button)
                setUnselectedPhoto(CommonResource.drawable.ic_pick_photo_unselect_button)
                setClose(CommonResource.drawable.ic_close)*/
                setButtonMain(R.drawable.perfectme_bg_gradient_button_r50)
            }
            .typography {
                /*setBold(CommonResource.font.gilroy_bold)
                setMedium(CommonResource.font.gilroy_medium)
                setRegular(CommonResource.font.gilroy_regular)
                setSemiBold(CommonResource.font.gilroy_semibold)*/
            }
    }

    override val enableAutoRequestPhotoPermission: Boolean
        get() = true

    override fun setupUI() {
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.white)
        displayCutout()
        hideSystemBar(
            hideStatusBar = false,
            hideNavigationBar = true,
            isLightStatusBar = true
        )
    }

    override fun getAdConfig(): PickPhotoNativeAdsConfig {
        return /*if (appSharedPref.isGetGift) getAdsConfig(
            isEnableHigh = appSharedPref.isShowBeautySlpNativeHigh,
            isEnableNormal = appSharedPref.isShowBeautySlpNative,
            shouldPreload = true,
            keyPreload = KEY_NATIVE_SELECT_PHOTO
        ) else*/ super.getAdConfig()
    }

    override fun openNextScreen(path: String?, from: String) {
        path?.let { imgPath ->
            super.openNextScreen(path, from)
            /*lifecycleScope.launch {
                rotateImageIfNeeded(imgPath){
                    lifecycleScope.launch(Dispatchers.Main) {
                        InterAdsManager.showInter(
                            activity = this@PickPhotoActivity,
                            enableInter = InterAdsManager.isInterstitialAdNextScreen()
                        ) {
                            super.openNextScreen(path, from)
                        }
                    }
                }
            }*/
        }
    }

    private suspend fun rotateImageIfNeeded(path: String, onDone: (String) -> Unit) = withContext(
        Dispatchers.IO) {
        try {
            val exif = ExifInterface(path)
            val orientation = exif.getAttributeInt(
                ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_UNDEFINED
            )

            // Nếu orientation là ORIENTATION_NORMAL hoặc không cần xoay
            val shouldRotate = when (orientation) {
                ExifInterface.ORIENTATION_ROTATE_90,
                ExifInterface.ORIENTATION_ROTATE_180,
                ExifInterface.ORIENTATION_ROTATE_270 -> true
                else -> false
            }

            if (!shouldRotate) {
                onDone(path)
                return@withContext
            }

            // Load và xoay ảnh
            val bitmap = BitmapFactory.decodeFile(path) ?: run {
                onDone(path)
                return@withContext
            }

            val rotatedBitmap = when (orientation) {
                ExifInterface.ORIENTATION_ROTATE_90 -> rotateBitmap(bitmap, 90f)
                ExifInterface.ORIENTATION_ROTATE_180 -> rotateBitmap(bitmap, 180f)
                ExifInterface.ORIENTATION_ROTATE_270 -> rotateBitmap(bitmap, 270f)
                else -> bitmap
            }

            // Ghi đè lại ảnh đã xoay
            FileOutputStream(path).use { out ->
                rotatedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out)
            }

            // Cập nhật lại orientation là NORMAL để tránh xoay lần nữa
            val newExif = ExifInterface(path)
            newExif.setAttribute(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL.toString())
            newExif.saveAttributes()

            onDone(path)
        } catch (e: Exception) {
            e.printStackTrace()
            onDone(path)
        }
    }

    private fun rotateBitmap(source: Bitmap, angle: Float): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(angle)
        return Bitmap.createBitmap(source, 0, 0, source.width, source.height, matrix, true)
    }


    private fun Activity.hideSystemBar(
        hideStatusBar: Boolean = true,
        hideNavigationBar: Boolean = true,
        isLightStatusBar: Boolean = true,
    ) {
        val windowInsetsController =
            WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        if (hideStatusBar) {
            windowInsetsController.hide(WindowInsetsCompat.Type.statusBars())
        }
        if (hideNavigationBar) {
            windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars())
        }
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars =
            isLightStatusBar
    }

    private fun Activity.displayCutout() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            window.attributes.layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_ALWAYS
        }
    }
}