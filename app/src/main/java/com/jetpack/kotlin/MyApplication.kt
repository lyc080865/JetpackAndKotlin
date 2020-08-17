package com.jetpack.kotlin

import android.app.Application
import android.content.Context
import com.jetpack.kotlin.utils.DataStoreUtils

/**
 * @author  lyc
 * @date    2020/8/4
 * @description:
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        mContext = applicationContext
        DataStoreUtils.init(this)
    }

    companion object {
        private var mInstance: MyApplication? = null
        var mContext: Context? = null
            private set

        @get:Synchronized
        val instance: MyApplication?
            get() {
                if (null == mInstance) {
                    mInstance = MyApplication()
                }
                return mInstance
            }

    }


}