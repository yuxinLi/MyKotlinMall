package com.example.baselibrary.common

import android.app.Application
import android.content.Context

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */

open class BaseApplication : Application(){


    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()

        initAppInjection()
    }

    private fun initAppInjection() {

    }
}