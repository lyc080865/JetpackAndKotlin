package com.jetpack.kotlin.activity

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jetpack.kotlin.BR
import com.jetpack.kotlin.R
import com.jetpack.kotlin.base.BaseActivity
import com.jetpack.kotlin.databinding.ActivityLoginBinding
import com.jetpack.kotlin.utils.AppCommonUtils
import com.jetpack.kotlin.utils.KeyboardUtils
import com.jetpack.kotlin.utils.ToastUtil
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

        mViewModel!!.userInfo.observe(this, Observer { userInfo ->
            finish()
        })

        mBinding!!.ivClose.setOnClickListener { finish() }
        mBinding!!.tvSubmit.setOnClickListener(View.OnClickListener {
            if (AppCommonUtils.isPhone(mViewModel!!.phone.get()!!)) {
                ToastUtil.show(getString(R.string.input_real_phone))
                return@OnClickListener
            }
            if (mViewModel!!.password.get()!!.length < 6) {
                ToastUtil.show(getString(R.string.input_real_psd))
                return@OnClickListener
            }
            mViewModel!!.login()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        KeyboardUtils.hideSoftInput(this)
    }
}