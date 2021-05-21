package com.tolga.chitchat.di.component

import android.app.Application
import com.tolga.chitchat.ChitchatApp
import com.tolga.vngrs.di.module.ActivityModule
import com.tolga.vngrs.di.module.ApplicationModule
import com.tolga.vngrs.di.module.NetModule
import com.tolga.vngrs.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    NetModule::class,
    ActivityModule::class,
    ViewModelModule::class])


interface AppComponent : AndroidInjector<ChitchatApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ChitchatApp>() {
        @BindsInstance
        abstract fun app(application: Application): Builder
    }
}
