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

     companion object {
         private const val IS_FIRST_REQUEST_PERMISSION_CAMERA = "is_first_request_permission_camera"
         private var instance: SharedPref? = null

         @Synchronized
         fun getInstance(): SharedPref {
             if (instance == null) {
                 instance = SharedPref()
             }
             return instance!!
         }
     }

}