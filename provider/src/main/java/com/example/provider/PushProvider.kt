package com.example.provider

import com.alibaba.android.arouter.facade.template.IProvider

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/8
 */

interface PushProvider: IProvider{
    fun getPushId(): String
}