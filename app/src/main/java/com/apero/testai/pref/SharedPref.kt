package com.apero.testai.pref

import android.content.Context
import com.apero.testai.pref.PrefConst.IS_FIRST_REQUEST_PERMISSION_CAMERA
import androidx.core.content.edit
import com.apero.testai.App
 class SharedPref {
    private val sharedPrefName = App.getInstance().packageName + ".pickphoto" + "_preferences"

    private val sharedPref =
        App.getInstance().applicationContext.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)

    var isFirstRequestPermissionCamera: Boolean
        get() = sharedPref.getBoolean(IS_FIRST_REQUEST_PERMISSION_CAMERA, true)
        set(value) = sharedPref.edit { putBoolean(IS_FIRST_REQUEST_PERMISSION_CAMERA, value) }

}