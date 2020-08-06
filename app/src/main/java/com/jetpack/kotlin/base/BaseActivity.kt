package com.jetpack.kotlin.base

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

/**
 * @author  lyc
 * @date    2020/8/4
 * @description:
 */
open abstract class BaseActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView();
    }

    abstract fun initView();
}