package com.jetpack.kotlin.http

import com.jetpack.kotlin.constant.IpConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author  lyc
 * @date    2020/8/13
 * @description:
 */
class HttpManager {
    companion object {
        fun getOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .readTimeout(60000, TimeUnit.MILLISECONDS)
                .connectTimeout(60000, TimeUnit.MILLISECONDS)
                .addInterceptor(HttpHeaderInterceptor())
//                .addInterceptor(LoggingInterceptor())
                .build()
        }

        fun getRetrofitBuilder(): Retrofit.Builder {
            val okHttpClient = getOkHttpClient()
            return Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(IpConstants.IP_URL_DEBUG)
        }

        fun <T> getApiService(cls: Class<T>?): T {
            val retrofit = getRetrofitBuilder().build()
            return retrofit.create(cls)
        }

    }
}