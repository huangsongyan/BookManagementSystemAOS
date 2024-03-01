package com.hubert.bookmanagementsystem.model.http

import android.util.Log
import com.hubert.bookmanagementsystem.model.http.api.BookApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TAG = "RetrofitUtil"

object BookRetrofitClient {
//    private const val BASE_URL = "http://192.168.4.217:8000";
    private const val BASE_URL = "http://192.168.90.62:8000";

    val service by lazy { getService(BookApi::class.java) }

    private var mRetrofit: Retrofit? = null

    private val mOkClient = OkHttpClient.Builder()
        .callTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .followRedirects(false)
        .addInterceptor(HttpLoggingInterceptor { message -> Log.d(TAG, "log: $message") }.setLevel(HttpLoggingInterceptor.Level.BODY)).build()


    fun <T> getService(serviceClass: Class<T>): T {
        if (mRetrofit == null) {
            mRetrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(mOkClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return mRetrofit!!.create(serviceClass)
    }
}