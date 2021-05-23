package com.tolga.chitchat.domain.repository

import com.tolga.chitchat.domain.datasource.ConversationRemoteDataSource
import javax.inject.Inject

class ConversationRepository @Inject constructor(private val conversationRemoteDataSource: ConversationRemoteDataSource) {
    fun getChatdata() = conversationRemoteDataSource.getChatdata()

}
