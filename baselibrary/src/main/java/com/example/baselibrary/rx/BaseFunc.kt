package com.example.baselibrary.rx

import com.example.baselibrary.common.ResultCode
import com.example.baselibrary.data.protocol.BaseResp
import rx.functions.Func1

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */

class BaseFunc<T>: Func1<BaseResp<T> , rx.Observable<T>>{
    override fun call(t: BaseResp<T>):rx.Observable<T>{
        if (t.status != ResultCode.SUCCESS){
            return rx.Observable.error(BaseException(t.status , t.message))
        }
        return rx.Observable.just(t.data)
    }
}