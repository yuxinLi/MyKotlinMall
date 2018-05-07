package com.example.baselibrary.rx

import com.example.baselibrary.common.ResultCode
import com.example.baselibrary.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */

class BaseFuncBoolean<T>: Func1<BaseResp<T> , Observable<Boolean>>{

    override fun call(t: BaseResp<T>): Observable<Boolean> {

        if (t.status != ResultCode.SUCCESS){
            return Observable.error(BaseException(t.status , t.message))
        }
        return Observable.just(true)
    }

}