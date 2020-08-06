package com.jetpack.kotlin

import android.app.Application
import android.content.Context

/**
 * @author  lyc
 * @date    2020/8/4
 * @description:
 */
class MyApplication : Application() {

    lateinit var mInstance: MyApplication
    lateinit var mContext: Context

    override fun onCreate() {
        super.onCreate()
        mContext = this
    }


}