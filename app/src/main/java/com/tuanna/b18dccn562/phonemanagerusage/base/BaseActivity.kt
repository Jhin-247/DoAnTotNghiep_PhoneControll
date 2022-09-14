package com.tuanna.b18dccn562.phonemanagerusage.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity() {
    protected lateinit var mBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
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

    fun hideSupportActionBar(){
        supportActionBar?.let {
            supportActionBar!!.hide()
        }
    }

}