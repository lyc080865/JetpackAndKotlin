package com.jetpack.kotlin.http

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author  lyc
 * @date    2020/8/13
 * @description:
 */
class LoggingInterceptor() :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        return response
    }

}