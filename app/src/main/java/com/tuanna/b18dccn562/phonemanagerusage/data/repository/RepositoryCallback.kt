package com.tuanna.b18dccn562.phonemanagerusage.data.repository

interface RepositoryCallback<T> {
    fun onLoadSuccess(data: T)
    fun onLoadFail(exception: Exception)
}