package com.example.usercenter.presenter

import com.example.baselibrary.ext.excute
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.example.usercenter.data.protocol.UserInfo
import com.example.usercenter.presenter.view.LoginView
import com.example.usercenter.service.UserService
import javax.inject.Inject

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/8
 */
class LoginPresenter @Inject constructor(): BasePresenter<LoginView>() {

    @Inject
    lateinit var userService: UserService

    fun login(mobile: String , pwd: String , pushId: String){
        if(!checkNetWork()){
            return
        }
        mView.showLoading()
        userService.login(mobile, pwd, pushId)
                .excute(object : BaseSubscriber<UserInfo>(mView){
                    override fun onNext(t: UserInfo) {
                        mView.onLoginResule(t)
                    }
                } , lifecycleProvider)

    }

}