package com.tolga.chitchat.domain.models

import com.google.gson.annotations.SerializedName

data class MessageResponse(
    @SerializedName("messages")
    var messages: ArrayList<Message>
)