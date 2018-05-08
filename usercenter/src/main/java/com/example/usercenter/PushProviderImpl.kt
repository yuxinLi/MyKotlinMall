package com.example.usercenter

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.provider.PushProvider
import com.example.provider.router.RouterPath

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/8
 */
@Route(path = RouterPath.MessageCenter.PATH_MESSAGE_PUSH)
class PushProviderImpl: PushProvider {
    override fun getPushId(): String {
        return ""
    }

    override fun init(context: Context?) {

    }
}