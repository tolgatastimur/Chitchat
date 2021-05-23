package com.tolga.chitchat.utils

import android.content.Context
import com.orhanobut.hawk.Hawk
import com.orhanobut.hawk.HawkBuilder
import javax.inject.Inject

class Storage @Inject constructor() {

    fun init(context: Context) {
        Hawk.init(context).build()
    }

    fun setUsername(username: String) {
        Hawk.put(Constants.StorageConstants.USERNAME, username)
    }

    fun getUsername(): String {
        return if (Hawk.get<String>(Constants.StorageConstants.USERNAME).isNotNull()) {
            Hawk.get<String>(Constants.StorageConstants.USERNAME)
        } else {
            ""
        }
    }

    fun removeUser(){
        Hawk.delete(Constants.StorageConstants.USERNAME)
    }
}