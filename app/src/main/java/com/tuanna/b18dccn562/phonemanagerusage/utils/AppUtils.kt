package com.tuanna.b18dccn562.phonemanagerusage.utils

import android.app.Application
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import com.tuanna.b18dccn562.phonemanagerusage.R
import com.tuanna.b18dccn562.phonemanagerusage.data.model.AppInfo
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppUtils @Inject constructor(
    var application: Application
) {

    fun getAppIconByAppName(packageName: String): Drawable? {
        try {
            val packageManager: PackageManager = application.packageManager
            return packageManager.getApplicationIcon(packageName)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return AppCompatResources.getDrawable(
            application,
            R.drawable.ic_launcher_foreground
        )
    }

    fun getAppName(packageName: String): String {
        val packageManager: PackageManager = application.packageManager
        var applicationInfo: ApplicationInfo? = null
        try {
            applicationInfo = packageManager.getApplicationInfo(packageName, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return (
                (if (applicationInfo != null)
                    packageManager.getApplicationLabel(applicationInfo) else "Unknown") as String
                )
    }

}