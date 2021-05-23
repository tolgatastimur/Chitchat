package com.tolga.chitchat.ui.conversation

import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.tolga.chitchat.R
import com.tolga.chitchat.base.BaseFragment
import com.tolga.chitchat.databinding.FragmentConversationBinding
import com.tolga.chitchat.ui.conversation.adapters.MessagesAdapter
import com.tolga.chitchat.ui.conversation.service.ConversationViewState
import com.tolga.chitchat.utils.setSafeOnClickListener


class ConversationFragment :
    BaseFragment<ConversationFragmentViewModel, FragmentConversationBinding>(
        R.layout.fragment_conversation,
        ConversationFragmentViewModel::class.java
    ) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        showSnackBar(getString(R.string.welcome) + " ${binding.viewModel?.getUsername()}")
        getChatdata()
    }

    private fun initListeners() {
        binding.sendMessageButton.setSafeOnClickListener {
            if (!binding.messageEditText.text.isNullOrBlank()) {
                binding.viewModel?.sendMessage(binding.messageEditText.text.toString())
                binding.messageEditText.text!!.clear()
            } else {
                binding.sendMessageButton.isClickable = false
            }
        }
        binding.messageEditText.addTextChangedListener {
            binding.sendMessageButton.isClickable = !it.isNullOrEmpty()
        }

        binding.logoutImageButton.setSafeOnClickListener {
            binding.viewModel?.removeUser()
            findNavController().popBackStack()
        }
    }

    private fun getChatdata() {
        binding.viewModel?.getChatdata()?.observe(viewLifecycleOwner, Observer {
            setNewMessage(it)
        })
    }

    private fun setNewMessage(conversationViewState: ConversationViewState) {
        (binding.messagesRecyclerView.adapter as? MessagesAdapter)?.submitList(conversationViewState.data?.messages)
        (binding.messagesRecyclerView.adapter as? MessagesAdapter)?.notifyItemInserted(
            conversationViewState.data?.messages!!.lastIndex
        )
        binding.messagesRecyclerView.smoothScrollToPosition(conversationViewState.data?.messages!!.lastIndex)
    }
}