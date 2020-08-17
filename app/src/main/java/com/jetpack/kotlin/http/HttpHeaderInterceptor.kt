package com.jetpack.kotlin.http

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * @author: weictor
 * @time: 2019/10/9
 * @remarks: 请求头拦截
 */
class HttpHeaderInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        //  配置请求头
        val request = chain.request().newBuilder()
            .header("Content-Type", "application/json")
            .addHeader("Connection", "close")
            .addHeader("Accept-Encoding", "identity")
            .build()
        return chain.proceed(request)
    }
}