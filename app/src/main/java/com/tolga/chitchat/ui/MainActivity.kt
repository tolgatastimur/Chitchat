package com.tolga.chitchat.ui

import android.os.Bundle
import com.tolga.chitchat.R
import com.tolga.chitchat.base.BaseActivity
import com.tolga.chitchat.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>(MainActivityViewModel::class.java) {

    override fun initViewModel(viewModel: MainActivityViewModel) {
        binding.viewModel = viewModel
    }

    override fun getLayoutRes() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}
