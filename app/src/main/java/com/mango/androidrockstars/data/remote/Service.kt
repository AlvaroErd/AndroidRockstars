package com.mango.androidrockstars.data.remote

import com.mango.androidrockstars.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Service {
    companion object {
        private var retrofit: ImdbApiService? = null
        fun getInstance(): ImdbApiService {
            if (retrofit == null)
                retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ImdbApiService::class.java)
            return retrofit!!
        }
    }


}