package com.tolga.chitchat.di.module

import com.tolga.chitchat.ui.conversation.ConversationFragment
import com.tolga.chitchat.ui.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeConversationFragment(): ConversationFragment

}
