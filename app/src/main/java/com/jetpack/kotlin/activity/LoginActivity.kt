package com.jetpack.kotlin.activity

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.jetpack.kotlin.BR
import com.jetpack.kotlin.R
import com.jetpack.kotlin.base.BaseActivity
import com.jetpack.kotlin.databinding.ActivityLoginBinding
import com.jetpack.kotlin.vm.LoginViewModel

/**
 * @author  lyc
 * @date    2020/8/12
 * @description:
 */
class LoginActivity : BaseActivity() {
    var mViewModel: LoginViewModel? = null
    var mBinding: ActivityLoginBinding? = null

    override fun initView() {
        mBinding =
            DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        mViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        mBinding!!.setVariable(BR.viewModel, mViewModel)
    }
}