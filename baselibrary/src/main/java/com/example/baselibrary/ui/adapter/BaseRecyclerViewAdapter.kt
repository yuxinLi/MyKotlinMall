package com.example.baselibrary.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView


/**
 * 描    述：
 * 作    者：liyx@13322.com
 * 时    间：2018/5/7
 */
abstract class BaseRecyclerViewAdapter<T , VH: RecyclerView.ViewHolder>(var mContext: Context): RecyclerView.Adapter<VH>() {

    var mItemClickListener: OnItemClickListener<T>? = null
    var dataList: MutableList<T> = mutableListOf()

    fun setData(source: MutableList<T>){
        dataList = source
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            mItemClickListener?.onItemClick(dataList[position] , position)
        }
    }

    interface OnItemClickListener<in T>{
        fun onItemClick(item: T , position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener<T>){
        this.mItemClickListener = listener
    }
}