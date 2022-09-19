package com.tuanna.b18dccn562.phonemanagerusage.screen.main.fragments.block.fragment.all_app_fragment

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tuanna.b18dccn562.phonemanagerusage.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AllAppViewModel @Inject constructor(
    application: Application
) : BaseViewModel(application) {
    private val isSearching = MutableLiveData(false)


    fun getSearchingStatus(): LiveData<Boolean> = isSearching
}