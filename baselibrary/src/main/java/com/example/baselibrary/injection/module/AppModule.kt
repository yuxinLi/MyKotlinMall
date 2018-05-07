package com.example.baselibrary.injection.module

import android.content.Context
import com.example.baselibrary.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */

@Module
class AppModule( private val context:BaseApplication){

    @Singleton
    @Provides
    fun provideContext(): Context{
        return context
    }
}