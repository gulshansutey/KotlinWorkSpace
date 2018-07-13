package com.example.gulshan.kotlinwithdatabinding.adpaters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.gulshan.kotlinwithdatabinding.BR
import com.example.gulshan.kotlinwithdatabinding.R
import com.example.gulshan.kotlinwithdatabinding.databinding.AdpRecyclerViewBinding


/**
 * Created by Gulshan on 7/6/2018 at 13
 */
class MyRecyclerADP(val data:ArrayList<User>) : RecyclerView.Adapter<MyRecyclerADP.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): VH {

      val adpBinding:AdpRecyclerViewBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
              R.layout.adp_recycler_view, parent,false)
        return VH(adpBinding)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(vh: VH, position: Int) {
        vh.bind(data[position])
    }

    class VH (private val v: AdpRecyclerViewBinding):RecyclerView.ViewHolder(v.root){
        fun bind(data: Any){
            v.setVariable(BR.user,data)
            v.executePendingBindings()
        }
    }
}