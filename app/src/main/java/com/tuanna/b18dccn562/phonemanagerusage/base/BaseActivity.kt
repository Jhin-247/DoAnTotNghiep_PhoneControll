package com.tuanna.b18dccn562.phonemanagerusage.base

import android.app.AppOpsManager
import android.app.AppOpsManager.OPSTR_GET_USAGE_STATS
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.databinding.ViewDataBinding
import com.tuanna.b18dccn562.phonemanagerusage.dialog.LoadingDialog
import javax.inject.Inject


abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity() {
    protected lateinit var mBinding: VB

    @Inject
    lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)

        mBinding = getViewDataBinding()

        initData()
        initYourView()
        setupObserver()
        setupListener()
    }

    override fun onResume() {
        super.onResume()
        observe()
    }

    override fun onPause() {
        super.onPause()
        removeObserve()
    }

    abstract fun getViewDataBinding(): VB
    abstract fun initData()
    abstract fun initYourView()
    abstract fun setupObserver()
    abstract fun setupListener()


    open fun observe() {
    }

    open fun removeObserve() {
    }

    fun hideSupportActionBar() {
        supportActionBar?.let {
            supportActionBar!!.hide()
        }
    }

    fun setStatusBarColor(color: Int) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor =
            ContextCompat.getColor(applicationContext, color)
    }

    @Suppress("DEPRECATION")
    fun checkUsageStatPermission(): Boolean {
        val appOsManager =
            (applicationContext.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager)
        val mode: Int = if (Build.VERSION.SDK_INT >= 29) {
            appOsManager.unsafeCheckOpNoThrow(
                OPSTR_GET_USAGE_STATS,
                android.os.Process.myUid(),
                packageName
            )
        } else {
            appOsManager.checkOpNoThrow(
                OPSTR_GET_USAGE_STATS,
                android.os.Process.myUid(),
                packageName
            )
        }
        return mode == AppOpsManager.MODE_ALLOWED
    }

    fun showLoadingDialog(cancelable: Boolean) {
        if (!loadingDialog.isVisible) {
            loadingDialog.showDialog(supportFragmentManager, cancelable)
        }
    }

    fun hideLoadingDialog() {
        if (loadingDialog.isVisible) {
            loadingDialog.dismiss()
        }
    }

    fun requestUsageStatPermission() {
        startActivity(Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS))
    }

}