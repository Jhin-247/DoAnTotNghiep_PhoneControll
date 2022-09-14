package com.tuanna.b18dccn562.phonemanagerusage.base

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity() {
    protected lateinit var mBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
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


    private fun observe() {
    }

    private fun removeObserve() {
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

}