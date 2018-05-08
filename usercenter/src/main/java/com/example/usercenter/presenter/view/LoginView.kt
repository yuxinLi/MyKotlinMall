package com.example.usercenter.presenter.view

import com.example.baselibrary.presenter.view.BaseView
import com.example.usercenter.data.protocol.UserInfo

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/8
 */
interface LoginView: BaseView {
    fun onLoginResule(result: UserInfo)
}