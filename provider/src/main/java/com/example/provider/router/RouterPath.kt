package com.example.provider.router

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/8
 */

object RouterPath{

    class UserCenter{
        companion object {
            const val PATH_LOGIN = "/userCenter/login"
        }
    }

    class OrderCenter{
        companion object {
            const val PATH_ORDER_CONFIRM = "/orderCenter/confirm"
        }
    }

    class PaySDK{
        companion object {
            const val PATH_PAY = "/paySDK/pay"
        }
    }


}