package com.example.usercenter.service.impl

import com.example.baselibrary.ext.convert
import com.example.usercenter.data.respository.UploadRepository
import com.example.usercenter.service.UploadService
import rx.Observable
import javax.inject.Inject

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/8
 */
class UploadServiceImpl @Inject constructor(): UploadService{

    @Inject
    lateinit var repository: UploadRepository

    override fun getUploadToken(): Observable<String> {
        return repository.getUploadToken().convert()
    }
}