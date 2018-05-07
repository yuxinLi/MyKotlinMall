package com.example.baselibrary.ext

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.baselibrary.data.protocol.BaseResp
import com.example.baselibrary.rx.BaseFunc
import com.example.baselibrary.rx.BaseFuncBoolean
import com.example.baselibrary.rx.BaseSubscriber
import com.example.baselibrary.utils.GlideUtils
import com.example.baselibrary.widget.DefaultTextWatcher
import com.trello.rxlifecycle.LifecycleProvider
import rx.Observable
import rx.android.schedulers.AndroidSchedulers

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */

fun <T> Observable<T>.excute(subscriber: BaseSubscriber<T> , lifecycleProvider: LifecycleProvider<*>){
    this.subscribeOn(rx.schedulers.Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(lifecycleProvider.bindToLifecycle())
            .subscribe(subscriber)
}

fun <T> Observable<BaseResp<T>>.convert():Observable<T>{
    return this.flatMap(BaseFunc())
}

fun <T> Observable<BaseResp<T>>.convertBoolean(): Observable<Boolean>{
    return this.flatMap(BaseFuncBoolean())
}

fun View.onClick(listener: View.OnClickListener): View{
    setOnClickListener(listener)
    return this
}


fun View.onClick(method: () -> Unit): View{
    setOnClickListener {
        method()
    }
    return this
}

fun Button.enable(et: EditText , method: ()->Boolean){
    val btn = this
    et.addTextChangedListener(object : DefaultTextWatcher(){
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}

fun ImageView.loadUrl(url:String){
    GlideUtils.loadUrlImage(context , url , this)
}


fun View.setVisible(visible: Boolean){
    this.visibility = if (visible) View.VISIBLE else View.GONE
}






