package com.jetpack.kotlin.base

import android.app.Activity
import android.os.Bundle

/**
 * @author  lyc
 * @date    2020/8/4
 * @description:
 */
open class BaseActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}