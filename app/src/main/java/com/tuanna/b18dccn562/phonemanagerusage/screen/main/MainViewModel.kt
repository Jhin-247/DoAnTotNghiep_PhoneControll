package com.tuanna.b18dccn562.phonemanagerusage.screen.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tuanna.b18dccn562.phonemanagerusage.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application
) : BaseViewModel(application) {

    private val hasPermission = MutableLiveData(false)
    private val isInitializedData = MutableLiveData(false)

    fun setHasPermissionStatus(status: Boolean) {
        hasPermission.value = status
    }

    fun getHasPermissionStatus(): LiveData<Boolean> = hasPermission
    fun getInitializedState(): Boolean = isInitializedData.value!!

    fun loadData() {
        isInitializedData.value = true
    }


}