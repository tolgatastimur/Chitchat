package com.tolga.chitchat.base

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.tolga.chitchat.R
import dagger.android.AndroidInjection


abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding>(
    @LayoutRes val layout: Int,
    viewModelClass: Class<VM>
) : Fragment() {

    open lateinit var binding: DB
    lateinit var dataBindingComponent: DataBindingComponent
    private fun init(inflater: LayoutInflater, container: ViewGroup) {
        binding = DataBindingUtil.inflate(inflater, layout, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.viewModel, viewModel)
    }

    private val viewModel by lazy {
        (activity as? BaseActivity<*, *>)?.viewModelProviderFactory?.let {
            ViewModelProvider(
                this,
                it
            ).get(viewModelClass)
        }
    }

    open fun onInject() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(activity)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init(inflater, container!!)
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    open fun refresh() {}

    open fun navigate(action: Int) {
        view?.let { _view ->
            Navigation.findNavController(_view).navigate(action)
        }
    }

    fun navigateToConversationFragment() {
        findNavController().navigate(R.id.action_loginFragment_to_conversationFragment)
    }

    fun showSnackBar(message: String) {
        val snack: Snackbar = Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT)
        val view = snack.view
        val params = view.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.TOP
        view.layoutParams = params
        snack.show()
    }
}
