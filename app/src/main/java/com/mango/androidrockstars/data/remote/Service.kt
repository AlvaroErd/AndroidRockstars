package com.mango.androidrockstars.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Service {
    companion object {
        // Instancia de Retrofit
        private var retrofit: ImdbApiService? = null
        fun getInstance(): ImdbApiService {
            if (retrofit == null)
                retrofit = Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ImdbApiService::class.java)

            return retrofit!!
        }
    }


}