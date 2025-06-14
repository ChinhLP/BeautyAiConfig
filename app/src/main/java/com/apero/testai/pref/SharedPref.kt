package com.apero.testai.pref

import android.content.Context
import com.apero.testai.pref.PrefConst.IS_FIRST_REQUEST_PERMISSION_CAMERA
import androidx.core.content.edit
import com.apero.testai.App
 class SharedPref {
    private val sharedPrefName = App.getInstance().packageName + ".pickphoto" + "_preferences"

    private val sharedPref =
        App.getInstance().applicationContext.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)

     var languageCode
         get() = sharedPref.getString(PREF_LANGUAGE_CODE, null)
         set(value) = sharedPref.edit { putString(PREF_LANGUAGE_CODE, value) }

    var isFirstRequestPermissionCamera: Boolean
        get() = sharedPref.getBoolean(IS_FIRST_REQUEST_PERMISSION_CAMERA, true)
        set(value) = sharedPref.edit { putBoolean(IS_FIRST_REQUEST_PERMISSION_CAMERA, value) }

     var numberShowDialogServiceError: Int
         get() = sharedPref.getInt(PRE_NUMBER_SHOW_SERVICE_FAILED, 3)
         set(value) = sharedPref.edit { putInt(PRE_NUMBER_SHOW_SERVICE_FAILED, value) }

     companion object {
         private const val IS_FIRST_REQUEST_PERMISSION_CAMERA = "is_first_request_permission_camera"
         private const val PREF_LANGUAGE_CODE = "pref_language_code"
         const val PRE_NUMBER_SHOW_SERVICE_FAILED = "failed_times"


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