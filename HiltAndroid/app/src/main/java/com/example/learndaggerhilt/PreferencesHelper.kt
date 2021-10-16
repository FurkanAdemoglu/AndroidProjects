package com.example.learndaggerhilt

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class PreferencesHelper constructor(context: Context) {

    private val preferences=context.getSharedPreferences("water_tracker_prefs",MODE_PRIVATE)
    private val KEY_WATER_INTAKE="KEY_WATER_INTAKE"
    private var waterIntakePreferencesListener:WaterintakePreferencesListener?=null


    fun incrementWaterIntake(){
        val waterIntake=preferences.getInt(KEY_WATER_INTAKE,0)
        preferences.edit().putInt(KEY_WATER_INTAKE,waterIntake+1).apply()

    }

    fun subscribeToWaterIntakeChanges(listener:WaterintakePreferencesListener){
        this.waterIntakePreferencesListener=listener
        preferences.registerOnSharedPreferenceChangeListener(sharedPreferencesListener)
    }

    fun unsubscribeFromWaterIntakeChanges(){
        this.waterIntakePreferencesListener=null
        preferences.unregisterOnSharedPreferenceChangeListener(sharedPreferencesListener)
    }

    private val sharedPreferencesListener=
        SharedPreferences.OnSharedPreferenceChangeListener{preferences,key->
            if (key==KEY_WATER_INTAKE){
                if (key==KEY_WATER_INTAKE){
                    waterIntakePreferencesListener?.onWaterIntakeChanged(
                        preferences.getInt(key,0)
                    )
                }

            }

        }
}