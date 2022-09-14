package com.tuanna.b18dccn562.phonemanagerusage.screen.main

import android.app.Application
import com.tuanna.b18dccn562.phonemanagerusage.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application
) : BaseViewModel(application) {
}