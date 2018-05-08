package com.example.usercenter.injection.module

import com.example.usercenter.service.UserService
import com.example.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/8
 */

@Module
class UserModule {

    @Provides
    fun provideUserService(userService: UserServiceImpl): UserService{
        return userService
    }

}