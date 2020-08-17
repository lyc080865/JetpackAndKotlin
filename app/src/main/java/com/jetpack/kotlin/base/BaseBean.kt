package com.jetpack.kotlin.base

import java.io.Serializable

/**
 * @author 13413
 */
data class BaseBean<T>(
    var status: Int = 0,
    var info: String = "",
    var data: T?
)