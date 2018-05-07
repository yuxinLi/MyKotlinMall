package com.example.baselibrary.data.protocol

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */
class BaseResp<out T>(val status:Int , val message: String , val data: T)