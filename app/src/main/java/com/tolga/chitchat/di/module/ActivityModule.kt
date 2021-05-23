package com.tolga.vngrs.di.module

import com.tolga.chitchat.di.module.FragmentBuildersModule
import com.tolga.chitchat.di.scope.ActivityScope
import com.tolga.chitchat.ui.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    internal abstract fun mainActivity(): MainActivity

}