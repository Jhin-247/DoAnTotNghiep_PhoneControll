package com.tuanna.b18dccn562.phonemanagerusage.screen.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.tuanna.b18dccn562.phonemanagerusage.R
import com.tuanna.b18dccn562.phonemanagerusage.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ActivityCallback {
    private lateinit var mBinding: ActivityMainBinding
    private val mViewModel by viewModels<MainViewModel>()

    private lateinit var mNavHostFragment: NavHostFragment
    private var mNavController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initData()
        setupNavigation()
        setupListener()
    }

    private fun setupListener() {
    }

    private fun setupNavigation() {
        mNavHostFragment.let {
            NavigationUI.setupWithNavController(mBinding.bottomNavigation, mNavController!!)
            mBinding.bottomNavigation.selectedItemId = R.id.homeFragment
        }
    }

    private fun initData() {
        mNavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        mNavHostFragment.let {
            mNavController = mNavHostFragment.navController
        }
    }
}