package com.example.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.baselibrary.ext.enable
import com.example.baselibrary.ext.onClick
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.example.provider.PushProvider
import com.example.provider.router.RouterPath
import com.example.usercenter.R
import com.example.usercenter.data.protocol.UserInfo
import com.example.usercenter.presenter.LoginPresenter
import com.example.usercenter.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/8
 */

@Route(path = RouterPath.UserCenter.PATH_LOGIN)
class LoginActivity: BaseMvpActivity<LoginPresenter>() , LoginView , View.OnClickListener {

    @Autowired(name = RouterPath.MessageCenter.PATH_MESSAGE_PUSH)
    @JvmField
    var mPushProvider: PushProvider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        initView()

    }

    private fun initView() {
        mLoginBtn.enable(mMobileEt , {isBtnEnable()})
        mLoginBtn.enable(mPwdEt , {isBtnEnable()})

        mLoginBtn.onClick(this)
//        mHeaderBar.rightV

        mForgetPwdTv.onClick(this)

    }

    private fun isBtnEnable(): Boolean{
        return mMobileEt.text.isNotEmpty().not() &&
                mPwdEt.text.isNotEmpty().not()
    }


    override fun injectComponent() {
    }

    override fun onLoginResule(result: UserInfo) {
        toast("登录成功")
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.mLoginBtn -> {
                mPresenter.login(mMobileEt.text.toString() , mPwdEt.text.toString() , mPushProvider?.getPushId()?:"")
            }
        }

    }
}