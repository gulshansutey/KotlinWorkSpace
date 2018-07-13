package com.example.gulshan.kotlinwithdatabinding.adpaters

import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.example.gulshan.kotlinwithdatabinding.listeners.OnRecyclerItemListener

/**
 * Created by Gulshan on 7/5/2018 at 13
 */

class LandingViewModel : ViewModel(), OnRecyclerItemListener.OnRvItemListener {


    companion object {
        @JvmStatic
        @BindingAdapter("adp")
        fun listAdapter(view: RecyclerView, data: ArrayList<User>, lvm: LandingViewModel) {
            view.adapter = MyRecyclerADP(data)
            view.addOnItemTouchListener(OnRecyclerItemListener(view.context, lvm))
        }

    }

    fun getRecyclerData(): ArrayList<User> {
        val list: ArrayList<User> = ArrayList()
        for (i in 1..10) {
            list.add(User("User$i@gmail.com", "User$i", "Hi$i"))
        }
        return list
    }

    override fun onClick(view: View, pos: Int) {
        Toast.makeText(view.context, "$pos", Toast.LENGTH_LONG).show()
    }


}
