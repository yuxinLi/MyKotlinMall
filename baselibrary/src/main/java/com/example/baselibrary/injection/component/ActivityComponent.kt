package com.example.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.example.baselibrary.injection.ActivityScope
import com.example.baselibrary.injection.module.ActivityModule
import com.example.baselibrary.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */


@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class) , modules = arrayOf(ActivityModule::class , LifecycleProviderModule::class))
interface ActivityComponent{

    fun activity(): Activity
    fun context(): Context
    fun lifecycleProvider(): LifecycleProvider<*>
}