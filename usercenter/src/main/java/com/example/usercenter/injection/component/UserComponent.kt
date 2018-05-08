package com.example.usercenter.injection.component

import com.example.baselibrary.injection.PerComponentScope
import com.example.baselibrary.injection.component.ActivityComponent
import com.example.usercenter.injection.module.UploadModule
import com.example.usercenter.injection.module.UserModule
import dagger.Component

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/8
 */

@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class) , modules = arrayOf(UserModule::class , UploadModule::class))
interface UserComponent{

//    fun inject(activity:RegisterActivity)
//    fun inject(activity:LoginActivity)
//    fun inject(activity:ForgetPwdActivity)
//    fun inject(activity:ResetPwdActivity)
//    fun inject(activity:UserInfoActivity)
}