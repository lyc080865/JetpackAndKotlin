package com.jetpack.kotlin.utils

/**
 * @author  lyc
 * @date    2020/8/17
 * @description:
 */
class AppCommonUtils {
    companion object{
        fun isPhone(phone: String): Boolean {
            return !phone.startsWith("1") || phone.length < 11
        }
    }
}