package com.tuanna.b18dccn562.phonemanagerusage.di.module

import android.app.Application
import com.tuanna.b18dccn562.phonemanagerusage.utils.PatternUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providePatternUtil(application: Application): PatternUtil {
        return PatternUtil(application)
    }
}