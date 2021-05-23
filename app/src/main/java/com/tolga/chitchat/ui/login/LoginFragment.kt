package com.tolga.chitchat.ui.login

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.tolga.chitchat.R
import com.tolga.chitchat.base.BaseFragment
import com.tolga.chitchat.databinding.FragmentLoginBinding
import com.tolga.chitchat.utils.setSafeOnClickListener


class LoginFragment : BaseFragment<LoginFragmentViewModel, FragmentLoginBinding>(
    R.layout.fragment_login,
    LoginFragmentViewModel::class.java
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        checkSession()
    }

    private fun initListeners() {
        binding.loginButton.setSafeOnClickListener {
            login(binding.userNameTextInputEditText.text.toString())
        }
    }

    private fun login(username: String) {
        if (username.isNotEmpty() && username.length > 2) {
            binding.userNameTextInputEditText.text?.clear()
            binding.viewModel?.setUsername(username = username)
            navigateToConversationFragment()
        } else {
            showSnackBar(getString(R.string.username_length_error))
        }
    }

    private fun checkSession() {
        if (binding.viewModel?.getUsername()!!.isNotEmpty()) {
            navigateToConversationFragment()
        }
    }

}