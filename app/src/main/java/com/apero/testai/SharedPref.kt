package com.apero.testai

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.core.content.edit

class SharedPref private constructor(context: Context) {
    private val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.applicationContext)
    
    companion object {
        @Volatile
        private var instance: SharedPref? = null
        
        fun getInstance(context: Context): SharedPref {
            return instance ?: synchronized(this) {
                instance ?: SharedPref(context).also { instance = it }
            }
        }
    }
    
    // String preferences
    fun setString(key: String, value: String) {
        prefs.edit { putString(key, value) }
    }
    
    fun getString(key: String, defaultValue: String = ""): String {
        return prefs.getString(key, defaultValue) ?: defaultValue
    }
    
    // Int preferences
    fun setInt(key: String, value: Int) {
        prefs.edit { putInt(key, value) }
    }
    
    fun getInt(key: String, defaultValue: Int = 0): Int {
        return prefs.getInt(key, defaultValue)
    }
    
    // Boolean preferences
    fun setBoolean(key: String, value: Boolean) {
        prefs.edit { putBoolean(key, value) }
    }
    
    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return prefs.getBoolean(key, defaultValue)
    }
    
    // Long preferences
    fun setLong(key: String, value: Long) {
        prefs.edit { putLong(key, value) }
    }
    
    fun getLong(key: String, defaultValue: Long = 0L): Long {
        return prefs.getLong(key, defaultValue)
    }
    
    // Float preferences
    fun setFloat(key: String, value: Float) {
        prefs.edit { putFloat(key, value) }
    }
    
    fun getFloat(key: String, defaultValue: Float = 0f): Float {
        return prefs.getFloat(key, defaultValue)
    }
    
    // Remove preference
    fun remove(key: String) {
        prefs.edit { remove(key) }
    }
    
    // Clear all preferences
    fun clearAll() {
        prefs.edit { clear() }
    }
    
    // Check if preference exists
    fun contains(key: String): Boolean {
        return prefs.contains(key)
    }
}
