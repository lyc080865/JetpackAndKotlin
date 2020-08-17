package com.jetpack.kotlin.utils

import com.jetpack.kotlin.constant.Constants

/**
 * @author  lyc
 * @date    2020/8/17
 * @description:
 */
class UserUtil {
    companion object {
        fun setUserId(userId: String) {
            DataStoreUtils.put(Constants.USER_ID, userId)
        }

        fun getUserID(): String? {
            return DataStoreUtils.getString(Constants.USER_ID)
        }
    }
}