package com.example.baselibrary.injection.module

import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */
@Module
class LifecycleProviderModule(private val lifecycleProvider: LifecycleProvider<*>){

    @Provides
    fun provideLifecycleProvider():LifecycleProvider<*>{
        return lifecycleProvider
    }

}