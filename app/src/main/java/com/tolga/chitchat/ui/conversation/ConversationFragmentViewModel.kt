package com.tolga.chitchat.ui.conversation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orhanobut.hawk.Hawk
import com.tolga.chitchat.base.BaseViewModel
import com.tolga.chitchat.domain.Status
import com.tolga.chitchat.domain.models.Message
import com.tolga.chitchat.domain.models.MessageResponse
import com.tolga.chitchat.domain.models.User
import com.tolga.chitchat.ui.conversation.service.ConversationUseCase
import com.tolga.chitchat.ui.conversation.service.ConversationViewState
import com.tolga.chitchat.utils.Constants
import com.tolga.chitchat.utils.Storage
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList
import kotlin.random.asKotlinRandom

class ConversationFragmentViewModel @Inject internal constructor(
    private val storage: Storage,
    private var conversationUseCase: ConversationUseCase
) : BaseViewModel() {

    var conversationLiveData: MutableLiveData<ConversationViewState>? = null

    fun getChatdata(): LiveData<ConversationViewState> {
        if (conversationLiveData == null) {
            conversationLiveData = MutableLiveData()
            getChatdataRequest()
        }
        return conversationLiveData as MutableLiveData<ConversationViewState>
    }

    private fun getChatdataRequest() {
        Single.fromObservable(conversationUseCase.getChatdata())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<MessageResponse> {
                override fun onSuccess(response: MessageResponse) {
                    conversationLiveData?.value = ConversationViewState(
                        Status.SUCCESS,
                        null,
                        response
                    )
                }

                override fun onSubscribe(d: Disposable) {}
                override fun onError(e: Throwable) {
                    conversationLiveData?.value = ConversationViewState(
                        Status.ERROR, null, null
                    )
                }
            })
    }

    fun sendMessage(message: String) {
        val message = Message(
            UUID.randomUUID().toString(),
            "${message}",
            Calendar.getInstance(Locale.getDefault()).timeInMillis,
            user = User(
                conversationLiveData?.value?.data!!.messages[0].user.avatarURL,
                Constants.UserID.OWN,
                getUsername()
            )
        )
        conversationLiveData?.value?.data!!.messages.add(message)
        conversationLiveData?.value = ConversationViewState(
            Status.SUCCESS,
            null,
            MessageResponse(conversationLiveData?.value?.data!!.messages))
    }

    fun getUsername(): String {
        return storage.getUsername()
    }

    fun removeUser(){
        storage.removeUser()
    }

}
