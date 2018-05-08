package com.example.usercenter.data.respository

import com.example.baselibrary.data.net.RetrofitFactory
import com.example.baselibrary.data.protocol.BaseResp
import com.example.usercenter.data.api.UploadApi
import rx.Observable
import javax.inject.Inject

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/8
 */
class UploadRepository @Inject constructor() {

    fun getUploadToken(): Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UploadApi::class.java).getUploadToken()
    }

}