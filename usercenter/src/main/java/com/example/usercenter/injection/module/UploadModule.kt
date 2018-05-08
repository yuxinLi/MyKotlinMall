package com.example.usercenter.injection.module

import com.example.usercenter.service.UploadService
import com.example.usercenter.service.impl.UploadServiceImpl
import dagger.Module
import dagger.Provides

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/8
 */

@Module
class UploadModule{

    @Provides
    fun provideUploadService(uploadService: UploadServiceImpl): UploadService{
        return uploadService
    }
}