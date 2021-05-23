package com.tolga.chitchat.domain.datasource

import com.tolga.chitchat.domain.MeditopiaApi
import javax.inject.Inject

class ConversationRemoteDataSource @Inject constructor(
    private val meditopiaApi: MeditopiaApi) {

    fun getChatdata() = meditopiaApi.getChatdata()
}

