package com.tolga.chitchat.domain.models

import android.text.format.DateFormat
import com.google.gson.annotations.SerializedName
import java.util.*

data class Message(
    @SerializedName("id")
    val id: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("timestamp")
    val timestamp: Long,
    @SerializedName("user")
    val user: User){

    fun getFormattedTime():String{
        val calendar = Calendar.getInstance(Locale.getDefault())
        calendar.timeInMillis = timestamp
        return DateFormat.format("HH:mm", calendar).toString()    }


}