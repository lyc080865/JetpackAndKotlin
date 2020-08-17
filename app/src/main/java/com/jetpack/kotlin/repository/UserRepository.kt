package com.jetpack.kotlin.repository

import com.jetpack.kotlin.base.BaseBean
import com.jetpack.kotlin.bean.UserInfoBean
import com.jetpack.kotlin.http.HttpManager
import com.jetpack.kotlin.http.ReviewApi
import retrofit2.await

/**
 * @author  lyc
 * @date    2020/8/17
 * @description:
 */
class UserRepository {
    suspend fun login(phone: String, password: String): BaseBean<UserInfoBean> {
        val map = mutableMapOf<String, String>()
        map["phone"] = phone
        map["password"] = password
        return HttpManager.getApiService(ReviewApi::class.java).login(map)
    }
}