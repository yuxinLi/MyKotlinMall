package com.example.baselibrary.common

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.example.baselibrary.injection.component.AppComponent
import com.example.baselibrary.injection.component.DaggerAppComponent
import com.example.baselibrary.injection.module.AppModule

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */

open class BaseApplication : Application(){


    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initAppInjection()

        context = this

        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    companion object {
        lateinit var context: Context
    }
}