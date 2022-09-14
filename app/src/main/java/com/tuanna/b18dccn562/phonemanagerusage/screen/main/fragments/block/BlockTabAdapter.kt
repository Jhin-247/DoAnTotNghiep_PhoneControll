package com.tuanna.b18dccn562.phonemanagerusage.screen.main.fragments.block

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tuanna.b18dccn562.phonemanagerusage.R
import com.tuanna.b18dccn562.phonemanagerusage.screen.main.fragments.home.HomeFragment
import com.tuanna.b18dccn562.phonemanagerusage.screen.main.fragments.timeline.TimeLineFragment
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class BlockTabAdapter @Inject constructor(
    var fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        if (position == 0) {
            return HomeFragment()
        }
        return TimeLineFragment()
    }

    fun getTitle(position: Int): String {
        if (position == 0) {
            return fragment.getString(R.string.all_apps)
        }
        if (position == 1) {
            return fragment.getString(R.string.limited)
        }
        return fragment.getString(R.string.locked)
    }
}