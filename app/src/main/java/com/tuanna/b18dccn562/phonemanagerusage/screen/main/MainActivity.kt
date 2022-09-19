package com.tuanna.b18dccn562.phonemanagerusage.screen.main

import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.tuanna.b18dccn562.phonemanagerusage.MyApplication
import com.tuanna.b18dccn562.phonemanagerusage.R
import com.tuanna.b18dccn562.phonemanagerusage.base.BaseActivity
import com.tuanna.b18dccn562.phonemanagerusage.databinding.ActivityMainBinding
import com.tuanna.b18dccn562.phonemanagerusage.dialog.LoadingDialog
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(), ActivityCallback {
    private val mViewModel by viewModels<MainViewModel>()

    private lateinit var mNavHostFragment: NavHostFragment
    private var mNavController: NavController? = null
    private lateinit var myApplication: MyApplication


    override fun getViewDataBinding(): ActivityMainBinding {
        return DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
    }

    override fun initData() {
        myApplication = application as MyApplication
        if (!checkUsageStatPermission()) {
            mViewModel.setHasPermissionStatus(false)
            requestUsageStatPermission()
        } else {
            mViewModel.setHasPermissionStatus(true)
        }

        mNavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        mNavHostFragment.let {
            mNavController = mNavHostFragment.navController
        }
    }

    override fun initYourView() {
        setStatusBarColor(R.color.status_bar_main_activity_color)
        setupNavigation()
    }

    private fun setupNavigation() {
        hideSupportActionBar()
        mNavHostFragment.let {
            NavigationUI.setupWithNavController(mBinding.bottomNavigation, mNavController!!)
        }
        mBinding.bottomNavigation.itemIconTintList = null
    }

    override fun setupObserver() {
        mViewModel.getHasPermissionStatus().observe(this) {
            if (it) {
                mViewModel.loadData()
            }
        }
    }

    override fun setupListener() {
    }

    override fun onResume() {
        super.onResume()
        if (!mViewModel.getInitializedState()) {
            if (checkUsageStatPermission()) {
                mViewModel.setHasPermissionStatus(true)
            }
        }
    }
}