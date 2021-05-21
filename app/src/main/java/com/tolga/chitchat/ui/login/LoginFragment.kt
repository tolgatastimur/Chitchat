package com.tolga.chitchat.ui.login

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.tolga.chitchat.R
import com.tolga.chitchat.base.BaseFragment
import com.tolga.chitchat.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<LoginFragmentViewModel, FragmentLoginBinding>(LoginFragmentViewModel::class.java) {
    override fun getLayoutRes() = R.layout.fragment_login


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findNavController().navigate(R.id.action_loginFragment_to_conversationFragment)
    }

}