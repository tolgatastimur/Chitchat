package com.tolga.chitchat.ui.conversation

import com.tolga.chitchat.R
import com.tolga.chitchat.base.BaseFragment
import com.tolga.chitchat.databinding.FragmentConversationBinding
import com.tolga.chitchat.databinding.FragmentLoginBinding
import com.tolga.chitchat.ui.login.LoginFragmentViewModel

class ConversationFragment : BaseFragment<ConversationFragmentViewModel, FragmentConversationBinding>(ConversationFragmentViewModel::class.java) {
    override fun getLayoutRes() = R.layout.fragment_conversation
}