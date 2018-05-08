package com.example.provider.common

import com.alibaba.android.arouter.launcher.ARouter
import com.example.baselibrary.common.BaseConstant
import com.example.baselibrary.utils.AppPrefsUtils
import com.example.provider.router.RouterPath

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/8
 */


fun isLogin(): Boolean{
    return AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotEmpty()
}

fun afterLogin(method: () -> Unit){
    if (isLogin()){
        method()
    }else{
        ARouter.getInstance().build(RouterPath.UserCenter.PATH_LOGIN).navigation()
    }
}
