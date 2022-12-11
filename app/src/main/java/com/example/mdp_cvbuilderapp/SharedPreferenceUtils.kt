package com.example.mdp_cvbuilderapp

import android.content.Context
import android.content.SharedPreferences

private lateinit var sharedPref: SharedPreferences

class SharedPreferenceUtils{
    companion object {
        @JvmStatic
        fun setSharedPref(activity: LoginActivity): SharedPreferences {
            sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
            return sharedPref
        }


        fun getPrefByKey(key: String): String? {
            return sharedPref.getString(key, "")
        }


    }
}