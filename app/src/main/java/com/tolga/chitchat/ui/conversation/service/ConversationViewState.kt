package com.tolga.chitchat.ui.conversation.service

import com.tolga.chitchat.base.BaseViewState
import com.tolga.chitchat.domain.Status
import com.tolga.chitchat.domain.models.MessageResponse

class ConversationViewState(
        var status: Status?,
        val error: String? = null,
        var data: MessageResponse? = null
) : BaseViewState(status, error){
}
