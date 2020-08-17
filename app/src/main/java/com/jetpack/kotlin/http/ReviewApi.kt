package com.jetpack.kotlin.http

import androidx.lifecycle.LiveData
import com.google.gson.JsonObject
import com.jetpack.kotlin.base.BaseBean
import com.jetpack.kotlin.bean.UserInfoBean
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @author  lyc
 * @date    2020/8/13
 * @description:
 */
open interface ReviewApi {
    @FormUrlEncoded
    @POST("index.php?app=review&mod=ReviewLogin&act=login")
    suspend fun login(@FieldMap map: Map<String, String>): BaseBean<UserInfoBean>
}