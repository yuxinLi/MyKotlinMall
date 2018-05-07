package com.example.baselibrary.injection.module

import android.app.Activity
import com.example.baselibrary.injection.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @ActivityScope
    fun provideActivity():Activity{
        return activity
    }

}