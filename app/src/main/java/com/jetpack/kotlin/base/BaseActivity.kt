package com.jetpack.kotlin.base

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.jetpack.kotlin.utils.BarUtil

/**
 * @author  lyc
 * @date    2020/8/4
 * @description:
 */
open abstract class BaseActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView();

        //设置默认的statue bar 颜色
        BarUtil.subtractMarginTopEqualStatusBarHeight(this.window.decorView)
        BarUtil.setStatusBarAlpha(this, 0, false)
        BarUtil.setStatusBarLightMode(this, true)
    }

    abstract fun initView();
}