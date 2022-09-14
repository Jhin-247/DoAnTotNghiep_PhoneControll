package com.tuanna.b18dccn562.phonemanagerusage.utils

import android.app.Application
import android.content.Context
import android.util.Log
import com.tuanna.b18dccn562.phonemanagerusage.R

class PatternUtil(var application: Application) {

    companion object {
        const val TAG = "PatternUtil"
    }

    fun hasPattern(): Boolean {
        return application.getSharedPreferences(
            application.getString(R.string.app_name),
            Context.MODE_PRIVATE
        ).getString(Constants.pattern, "") != ""
    }

    fun checkPattern(pattern: List<Int>): Boolean {
        var patternAsString = ""
        for (number in pattern) {
            patternAsString = patternAsString.plus(number.toString())
        }
        val savedPattern = getPattern()
        if (savedPattern == patternAsString) {
            return true
        }
        return false
    }

    fun savePattern(pattern: List<Int>) {
        var patternAsString = ""
        for (number in pattern) {
            patternAsString = patternAsString.plus(number.toString())
        }
        Log.i(TAG, "savePattern: $patternAsString")
        return application.getSharedPreferences(
            application.getString(R.string.app_name),
            Context.MODE_PRIVATE
        ).edit().putString(Constants.pattern, patternAsString).apply()
    }

    private fun getPattern(): String? {
        return application.getSharedPreferences(
            application.getString(R.string.app_name),
            Context.MODE_PRIVATE
        ).getString(Constants.pattern, "")
    }
}