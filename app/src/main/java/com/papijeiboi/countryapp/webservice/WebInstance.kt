package com.papijeiboi.countryapp.webservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebInstance {
    companion object {
        const val BASE_URL = "https://restcountries.com/"

        fun getWebInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}