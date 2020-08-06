package com.jetpack.kotlin.activity

import android.os.Bundle
import com.jetpack.kotlin.base.BaseActivity
import com.jetpack.kotlin.R

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}