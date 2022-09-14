package com.tuanna.b18dccn562.phonemanagerusage.data.repository_imp

import android.app.Application
import com.tuanna.b18dccn562.phonemanagerusage.data.repository.ApplicationRepository
import javax.inject.Inject

class ApplicationRepositoryImp @Inject constructor(
    private val appContext: Application
) : ApplicationRepository {

}