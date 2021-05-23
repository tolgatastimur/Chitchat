package com.tolga.chitchat.utils

import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.util.*

object TextViewAdapter {

    @JvmStatic
    @BindingAdapter("bind:textColor")
    fun setTextColor(textView: TextView?,id:String?) {
        val rnd = Random()
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        textView?.setTextColor(color)
    }

}
