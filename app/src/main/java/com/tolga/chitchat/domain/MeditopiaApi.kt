package com.tolga.chitchat.domain

import com.tolga.chitchat.domain.models.MessageResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface MeditopiaApi {
    @GET("files/chatdata-example.json")
    fun getChatdata(): Observable<MessageResponse>
}