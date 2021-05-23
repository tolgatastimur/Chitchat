package com.tolga.vngrs.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tolga.chitchat.ui.MainActivityViewModel
import com.tolga.chitchat.ui.conversation.ConversationFragmentViewModel
import com.tolga.chitchat.ui.login.LoginFragmentViewModel
import com.tolga.vngrs.di.ViewModelFactory
import com.tolga.vngrs.di.key.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(LoginFragmentViewModel::class)
    abstract fun bindLoginFragmentViewModel(loginFragmentViewModel: LoginFragmentViewModel): ViewModel

  @IntoMap
    @Binds
    @ViewModelKey(ConversationFragmentViewModel::class)
    abstract fun bindConversationFragmentViewModel(conversationFragmentViewModel: ConversationFragmentViewModel): ViewModel

}