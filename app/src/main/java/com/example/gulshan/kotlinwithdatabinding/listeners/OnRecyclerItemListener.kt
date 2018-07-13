package com.example.gulshan.kotlinwithdatabinding.listeners

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

/**
 * Created by Gulshan on 7/6/2018 at 17
 */
class OnRecyclerItemListener(context: Context, private val listener: OnRvItemListener) : RecyclerView.OnItemTouchListener {


    private var gestureDetector: GestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapUp(e: MotionEvent?) = true
    })

    override fun onTouchEvent(p0: RecyclerView, p1: MotionEvent) {

    }

    override fun onInterceptTouchEvent(rv: RecyclerView, p1: MotionEvent): Boolean {
        val childView = rv.findChildViewUnder(p1.x, p1.y)
        if (childView != null && gestureDetector.onTouchEvent(p1)) {
            listener.onClick(childView, rv.getChildAdapterPosition(childView))
        }
        return false
    }

    override fun onRequestDisallowInterceptTouchEvent(p0: Boolean) {

    }

    interface OnRvItemListener {
        fun onClick(view: View, pos: Int)
    }

}