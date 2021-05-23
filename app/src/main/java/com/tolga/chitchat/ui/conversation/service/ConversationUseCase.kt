package com.tolga.chitchat.ui.conversation.service

import com.tolga.chitchat.domain.models.MessageResponse
import com.tolga.chitchat.domain.repository.ConversationRepository
import io.reactivex.Observable
import javax.inject.Inject

class ConversationUseCase @Inject constructor(
        private val conversationRepository: ConversationRepository
) {

    fun getChatdata(): Observable<MessageResponse> {
        return conversationRepository.getChatdata()
    }
}