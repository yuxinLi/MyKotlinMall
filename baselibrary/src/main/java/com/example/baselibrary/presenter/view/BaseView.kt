package com.example.baselibrary.presenter.view

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */

interface BaseView{
    fun showLoading()
    fun hideLoading()
    fun onError(text:String)
}