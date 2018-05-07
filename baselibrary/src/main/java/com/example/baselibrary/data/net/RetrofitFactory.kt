package com.example.baselibrary.data.net

import com.example.baselibrary.common.BaseConstant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */
class RetrofitFactory private constructor(){

    companion object {
        val instance: RetrofitFactory by lazy {
            RetrofitFactory()
        }
    }

    private val inteceptor: Interceptor
    private val retrofit: Retrofit

    init {
        inteceptor = Interceptor {
            chain ->
            val request = chain.request()
                    .newBuilder()
                    .addHeader("Content_Type" , "application/json")
                    .addHeader("charset" , "UTF-8")
                    .addHeader("token" , "")
                    .build()

            chain.proceed(request)
        }

        retrofit = Retrofit.Builder()
                .baseUrl(BaseConstant.SERVER_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(initClient())
                .build()
    }

    private fun initClient(): OkHttpClient? {
        return OkHttpClient.Builder()
                .addInterceptor(initLogInterceptor())
                .addInterceptor(inteceptor)
                .connectTimeout(10 , TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .build()
    }

    private fun initLogInterceptor(): Interceptor? {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return inteceptor
    }

    fun <T> create(service:Class<T>):T{
        return retrofit.create(service)
    }


}