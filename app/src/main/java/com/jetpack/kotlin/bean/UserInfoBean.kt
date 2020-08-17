package com.jetpack.kotlin.bean

import com.google.gson.annotations.SerializedName

/**
 * @author  lyc
 * @date    2020/8/17
 * @description:
 */
data class UserInfoBean(
    @SerializedName("oauth_token")
    var toke: String = ""
)