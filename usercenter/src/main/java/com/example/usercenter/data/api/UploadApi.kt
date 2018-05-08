package com.example.usercenter.data.api

import com.example.baselibrary.data.protocol.BaseResp
import retrofit2.http.POST
import rx.Observable

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/8
 */
interface UploadApi{

    @POST("common/getUploadToken")
    fun getUploadToken(): Observable<BaseResp<String>>

}