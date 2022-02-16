package com.adrian.epicimagery.data.framework.retrofit.client

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NasaClient {
    companion object {

        private val logging =  HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        private val client = OkHttpClient
            .Builder()
            .addInterceptor(logging)
            .build()

        private const val BASE_URL = "https://epic.gsfc.nasa.gov/"

        private var retrofit: Retrofit? = null


        fun getClient(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    // adapter to make retrofit compatible with rxJava
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
            }
            return retrofit!!
        }
    }
}