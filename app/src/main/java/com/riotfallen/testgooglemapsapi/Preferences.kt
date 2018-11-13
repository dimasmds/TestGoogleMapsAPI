package com.riotfallen.testgooglemapsapi

import android.content.Context
import android.content.SharedPreferences

class Preferences(val context: Context){

    private lateinit var sharedPreferences: SharedPreferences

    fun writeLat(lat: Double){
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_app), Context.MODE_PRIVATE) ?: return
        with(sharedPreferences.edit()){
            putString(context.getString(R.string.pref_lat), lat.toString())
            apply()
        }
    }

    fun readLat() : Double{
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_app), Context.MODE_PRIVATE)
        val lat = sharedPreferences.getString(context.getString(R.string.pref_lat), (-34.0).toString()) ?: (-34.0).toString()
        return lat.toDouble()
    }

    fun writeLong(long: Double){
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_app), Context.MODE_PRIVATE) ?: return
        with(sharedPreferences.edit()){
            putString(context.getString(R.string.pref_long), long.toString())
            apply()
        }
    }

    fun readLong() : Double{
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_app), Context.MODE_PRIVATE)
        val long = sharedPreferences.getString(context.getString(R.string.pref_long), (151.0).toString()) ?: (151.0).toString()
        return long.toDouble()
    }
}