package com.tolga.chitchat.base

import com.tolga.chitchat.domain.Status

open class BaseViewState(val baseStatus: Status?, val baseError: String?) {
    fun isLoading() = baseStatus == Status.LOADING
    fun getErrorMessage() = baseError
    fun shouldShowErrorMessage() = baseError != null
}
