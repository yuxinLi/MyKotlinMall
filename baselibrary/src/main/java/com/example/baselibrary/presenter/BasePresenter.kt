package com.example.baselibrary.presenter

import android.content.Context
import com.example.baselibrary.presenter.view.BaseView
import com.example.baselibrary.utils.NetWorkUtils
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */
open class BasePresenter<T: BaseView> {

    lateinit var mView: T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    fun checkNetWork(): Boolean{
        if(NetWorkUtils.isNetWorkAvailable(context)){
            return true
        }
        mView.onError("网络不可用")
        return false
    }

}