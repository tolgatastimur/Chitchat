package com.tolga.chitchat.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * reference : https://github.com/googlesamples/android-architecture-components
 */
open class BaseViewModel : ViewModel() {

    val baseLiveData = MutableLiveData<BaseViewState>()

    val disposable = CompositeDisposable()

    override fun onCleared() {
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
        super.onCleared()
    }
}
