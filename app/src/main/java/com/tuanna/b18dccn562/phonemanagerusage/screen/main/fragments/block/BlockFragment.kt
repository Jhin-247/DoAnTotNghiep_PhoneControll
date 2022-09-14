package com.tuanna.b18dccn562.phonemanagerusage.screen.main.fragments.block

import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tuanna.b18dccn562.phonemanagerusage.R
import com.tuanna.b18dccn562.phonemanagerusage.base.BaseFragment
import com.tuanna.b18dccn562.phonemanagerusage.databinding.FragmentBlockBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlockFragment : BaseFragment<FragmentBlockBinding>() {

    private lateinit var tabAdapter: BlockTabAdapter

    override fun getLayoutId(): Int = R.layout.fragment_block

    override fun initData() {
        tabAdapter = BlockTabAdapter(this)
    }

    override fun initYourView() {
        setupTabs()
    }

    private fun setupTabs() {
        mBinding.viewPager.adapter = tabAdapter

        TabLayoutMediator(mBinding.tabLayout, mBinding.viewPager) { tab, position ->
            tab.text = tabAdapter.getTitle(position)
        }.attach()

        mBinding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    mBinding.viewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        mBinding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                mBinding.tabLayout.selectTab(mBinding.tabLayout.getTabAt(position))
            }
        })
        mBinding.viewPager.offscreenPageLimit = 3
    }

    override fun initListener() {

    }

    override fun initObserver() {

    }

}