package com.jetpack.kotlin.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.jetpack.kotlin.base.BaseActivity
import com.jetpack.kotlin.R
import com.jetpack.kotlin.vm.MainViewModel

class MainActivity : BaseActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun initView() {
        TODO("Not yet implemented")
    }
}