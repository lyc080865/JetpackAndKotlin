package com.jetpack.kotlin.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.jetpack.kotlin.BR
import com.jetpack.kotlin.base.BaseActivity
import com.jetpack.kotlin.R
import com.jetpack.kotlin.databinding.ActivityMainBinding
import com.jetpack.kotlin.vm.MainViewModel

class MainActivity : BaseActivity() {
    lateinit var mViewModel: MainViewModel
    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mBinding.setVariable(BR.viewModel, mViewModel)
    }

    override fun initView() {
        initFragment()
    }

    /**
     * 初始化Fragment
     */
    private fun initFragment() {

    }
}