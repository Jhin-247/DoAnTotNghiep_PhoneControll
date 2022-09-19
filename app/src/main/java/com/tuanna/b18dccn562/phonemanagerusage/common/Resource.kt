package com.tuanna.b18dccn562.phonemanagerusage.common

open class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Fail<T>(message: String, data: T?) : Resource<T>(data, message)
}