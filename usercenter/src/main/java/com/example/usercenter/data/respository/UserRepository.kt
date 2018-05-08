package com.example.usercenter.data.respository

import com.example.baselibrary.data.net.RetrofitFactory
import com.example.baselibrary.data.protocol.BaseResp
import com.example.usercenter.data.api.UserApi
import com.example.usercenter.data.protocol.*
import rx.Observable
import javax.inject.Inject

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/8
 */
class UserRepository @Inject constructor() {

    private var mUserApi:UserApi = RetrofitFactory.instance.create(UserApi::class.java)


    fun register(mobile: String , pwd: String , verifyCode: String): Observable<BaseResp<String>>{
        return mUserApi.register(RegisterReq(mobile, pwd, verifyCode))
    }

    fun login(mobile:String,pwd:String,pushId:String): Observable<BaseResp<UserInfo>>{
        return mUserApi.login(LoginReq(mobile,pwd,pushId))
    }

    /*
        忘记密码
     */
    fun forgetPwd(mobile:String,verifyCode:String): Observable<BaseResp<String>>{
        return mUserApi.forgetPwd(ForgetPwdReq(mobile,verifyCode))
    }

    /*
        重置密码
     */
    fun resetPwd(mobile:String,pwd:String): Observable<BaseResp<String>>{
        return mUserApi.resetPwd(ResetPwdReq(mobile,pwd))
    }

    /*
        编辑用户资料
     */
    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String):Observable<BaseResp<UserInfo>>{
        return mUserApi.editUser(EditUserReq(userIcon,userName,userGender,userSign))
    }

}