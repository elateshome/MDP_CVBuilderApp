package com.example.mdp_cvbuilderapp

import android.content.Context
import android.content.SharedPreferences

private lateinit var sharedPref: SharedPreferences

class SharedPreferenceUtils{
    companion object {
        @JvmStatic
        fun setPref(activity: LoginActivity): SharedPreferences {
            sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
            return sharedPref
        }

        fun getSharedPref(): SharedPreferences {
            return sharedPref
        }

        fun getPref(key: String): String? {
            return sharedPref.getString(key, "")
        }


    }
}