package com.tolga.chitchat

import com.tolga.chitchat.di.component.DaggerAppComponent
import com.tolga.chitchat.utils.Storage
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class ChitchatApp :DaggerApplication(){

    @Inject
    lateinit var storage: Storage

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().app(this).create(this)
    }

    override fun onCreate() {
        super.onCreate()
        storage.init(this)
    }

}