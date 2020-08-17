package com.jetpack.kotlin.utils

import android.content.Context
import android.content.SharedPreferences
import com.jetpack.kotlin.MyApplication
import com.jetpack.kotlin.R

/**
 * @author  lyc
 * @date    2020/8/17
 * @description:
 */
class DataStoreUtils {
    companion object {
        private var context: Context? = null

        fun init(context: Context) {
            DataStoreUtils.context = context
        }

        private fun getSharedPreference(): SharedPreferences? {
            return context!!.getSharedPreferences(
                MyApplication.mContext!!.getString(R.string.app_name),
                Context.MODE_PRIVATE
            )
        }

        fun put(key: String, value: String) {
            getSharedPreference()!!.edit().putString(key, value).apply()
        }

        fun getString(key: String?): String? {
            return getSharedPreference()!!.getString(key, "")
        }

    }

}