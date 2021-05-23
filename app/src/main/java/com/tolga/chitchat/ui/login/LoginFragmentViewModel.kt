package com.tolga.chitchat.ui.login

import com.tolga.chitchat.base.BaseViewModel
import com.tolga.chitchat.utils.Storage
import javax.inject.Inject

class LoginFragmentViewModel @Inject internal constructor(private val storage: Storage) :
    BaseViewModel() {

    fun setUsername(username: String) {
        storage.setUsername(username)
    }

    fun getUsername(): String {
        return storage.getUsername()

    }
}
