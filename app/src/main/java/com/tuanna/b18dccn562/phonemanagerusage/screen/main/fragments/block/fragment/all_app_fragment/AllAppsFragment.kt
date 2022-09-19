package com.tuanna.b18dccn562.phonemanagerusage.screen.main.fragments.block.fragment.all_app_fragment

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuanna.b18dccn562.phonemanagerusage.R
import com.tuanna.b18dccn562.phonemanagerusage.base.BaseFragment
import com.tuanna.b18dccn562.phonemanagerusage.data.model.AppInfo
import com.tuanna.b18dccn562.phonemanagerusage.databinding.FragmentAllAppBinding
import com.tuanna.b18dccn562.phonemanagerusage.utils.AppUtils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AllAppsFragment : BaseFragment<FragmentAllAppBinding>() {

    private val mViewModel by viewModels<AllAppViewModel>()

    @Inject
    lateinit var adapter: AppAdapter

    @Inject
    lateinit var appUtils: AppUtils

    override fun getLayoutId(): Int = R.layout.fragment_all_app

    override fun initData() {
        val data = listOf(
            AppInfo("Camera", "com.camera", null, 123123),
            AppInfo("Camera", "com.camera", null, 123123),
            AppInfo("Camera", "com.camera", null, 123123),
            AppInfo("Camera", "com.camera", null, 123123)
        )
        adapter.submitList(data)
    }

    override fun initYourView() {
        mBinding.rcvItems.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        mBinding.rcvItems.adapter = adapter
    }

    override fun initListener() {
    }

    override fun initObserver() {
        mViewModel.getSearchingStatus().observe(this) {

        }
        mMainViewModel.getHasPermissionStatus().observe(this) {

        }
    }
}