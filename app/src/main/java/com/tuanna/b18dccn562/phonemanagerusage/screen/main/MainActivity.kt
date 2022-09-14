package com.tuanna.b18dccn562.phonemanagerusage.screen.main

import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.tuanna.b18dccn562.phonemanagerusage.R
import com.tuanna.b18dccn562.phonemanagerusage.base.BaseActivity
import com.tuanna.b18dccn562.phonemanagerusage.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(), ActivityCallback {
    private val mViewModel by viewModels<MainViewModel>()

    private lateinit var mNavHostFragment: NavHostFragment
    private var mNavController: NavController? = null


    override fun getViewDataBinding(): ActivityMainBinding {
        return DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
    }

    override fun initYourView() {
        setStatusBarColor(R.color.status_bar_main_activity_color)
        setupNavigation()
    }

    override fun setupObserver() {
    }

    override fun initData() {
        mNavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        mNavHostFragment.let {
            mNavController = mNavHostFragment.navController
        }
    }

    override fun setupListener() {
    }

    private fun setupNavigation() {
        hideSupportActionBar()
        mNavHostFragment.let {
            NavigationUI.setupWithNavController(mBinding.bottomNavigation, mNavController!!)
        }
        mBinding.bottomNavigation.itemIconTintList = null
    }
}