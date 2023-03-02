package com.mango.androidrockstars.data.remote

import com.mango.androidrockstars.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Service {
        private var retrofit: ImdbApiService? = null
        fun getRetrofit(): ImdbApiService {
            if (retrofit == null)
                retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ImdbApiService::class.java)
            return retrofit!!
        }
}