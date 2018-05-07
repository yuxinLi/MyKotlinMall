package com.example.baselibrary.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baselibrary.common.BaseApplication
import com.example.baselibrary.injection.component.ActivityComponent
import com.example.baselibrary.injection.component.DaggerActivityComponent
import com.example.baselibrary.injection.module.ActivityModule
import com.example.baselibrary.injection.module.LifecycleProviderModule
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.presenter.view.BaseView
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */
abstract class BaseMvpFragment<T: BasePresenter<*>> : BaseFragment() , BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent: ActivityComponent

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        initActivityInjection()
        injectComponent()

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    protected abstract fun injectComponent()

    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent((activity.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(activity))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()
    }

    /*
       显示加载框，默认实现
    */
    override fun showLoading() {
    }

    /*
        隐藏加载框，默认实现
     */
    override fun hideLoading() {
    }

    /*
        错误信息提示，默认实现
     */
    override fun onError(text:String) {
        toast(text)
    }
}