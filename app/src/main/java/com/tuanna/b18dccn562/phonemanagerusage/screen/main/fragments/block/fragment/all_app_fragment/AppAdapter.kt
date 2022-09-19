package com.tuanna.b18dccn562.phonemanagerusage.screen.main.fragments.block.fragment.all_app_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.tuanna.b18dccn562.phonemanagerusage.R
import com.tuanna.b18dccn562.phonemanagerusage.base.BaseAdapter
import com.tuanna.b18dccn562.phonemanagerusage.base.BaseHolder
import com.tuanna.b18dccn562.phonemanagerusage.data.model.AppInfo
import com.tuanna.b18dccn562.phonemanagerusage.databinding.ItemAppBinding
import javax.inject.Inject

class AppAdapter @Inject constructor() : BaseAdapter<AppInfo, ItemAppBinding>() {
    override fun getViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): BaseHolder<ItemAppBinding> {
        return BaseHolder(
            ItemAppBinding.inflate(
                inflater,
                parent,
                false
            )
        )
    }

    override fun bindView(binding: ItemAppBinding, item: AppInfo) {
        Glide.with(binding.ivAppIcon).load(item.mAppIcon).error(R.drawable.ic_default_app_icon)
            .into(binding.ivAppIcon)
        binding.tvIconName.text = item.mAppName
        binding.tvRecommend.text = binding.tvRecommend.context.getString(R.string.recommend_lock)
    }


}