package com.example.baselibrary.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.example.baselibrary.R

/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */
object GlideUtils {

    fun loadUrlImage(context: Context, url: String , imageView: ImageView){
        Glide.with(context).load(url)
                .placeholder(R.drawable.icon_back)
                .error(R.drawable.icon_back)
                .centerCrop()
                .into(object : SimpleTarget<GlideDrawable>(){
                    override fun onResourceReady(resource: GlideDrawable?, glideAnimation: GlideAnimation<in GlideDrawable>?) {
                        imageView.setImageDrawable(resource)
                    }
                })
    }

}