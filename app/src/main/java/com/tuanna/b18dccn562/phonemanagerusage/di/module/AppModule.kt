package com.tuanna.b18dccn562.phonemanagerusage.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideExecutors(): Executor {
        return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
    }

}