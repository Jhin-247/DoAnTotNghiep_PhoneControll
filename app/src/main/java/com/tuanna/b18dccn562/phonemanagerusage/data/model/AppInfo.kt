package com.tuanna.b18dccn562.phonemanagerusage.data.model

import android.graphics.drawable.Drawable
import com.tuanna.b18dccn562.phonemanagerusage.base.Equatable

data class AppInfo(
    var mAppName: String,
    var mPackageName: String,
    var mAppIcon: Drawable?,
    var mUsedDuration: Long
): Equatable