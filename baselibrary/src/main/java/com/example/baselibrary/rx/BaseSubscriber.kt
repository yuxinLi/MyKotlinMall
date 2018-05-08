package com.example.baselibrary.rx

import com.example.baselibrary.presenter.view.BaseView
import rx.Subscriber

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */
open class BaseSubscriber<T> (val baseView: BaseView): Subscriber<T>() {
    override fun onNext(t: T) {

    }

    override fun onCompleted() {
        baseView.hideLoading()
    }

    override fun onError(e: Throwable?) {
        baseView.hideLoading()
        if (e is BaseException){
            baseView.onError(e.msg)
        }
    }
}