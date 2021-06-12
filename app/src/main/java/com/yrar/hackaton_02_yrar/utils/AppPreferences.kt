package com.yrar.hackaton_02_yrar.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener

class AppPreferences(val context: Context) {


    private val preferences: SharedPreferences = context.getSharedPreferences(context.packageName + "_preferences", Context.MODE_PRIVATE)

    fun writeInt(key : String, value : Int) {
        preferences.edit().putInt(key, value).apply()
    }

    fun readInt(key: String): Int {
        return preferences.getInt(key, 0)
    }

    fun writeString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    fun readString(key : String) : String {
        return preferences.getString(key, "") ?: ""
    }

    fun removeSetting(key: String) {
        preferences.edit().remove(key).apply()
    }

    fun registerOnSharedPreferenceChangeListener(listener: OnSharedPreferenceChangeListener?) {
        preferences.registerOnSharedPreferenceChangeListener(listener)
    }

    fun unregisterOnSharedPreferenceChangeListener(listener: OnSharedPreferenceChangeListener?) {
        preferences.unregisterOnSharedPreferenceChangeListener(listener)
    }

    companion object {

        const val CURRENT_USER_SETTING_KEY = "current_user"
    }
}

