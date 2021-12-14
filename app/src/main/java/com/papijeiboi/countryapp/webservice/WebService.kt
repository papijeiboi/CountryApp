package com.papijeiboi.countryapp.webservice

import com.papijeiboi.countryapp.model.CountryListModelItem
import retrofit2.Call
import retrofit2.http.GET

interface WebService {

    @GET("/v2/all")
    fun countryData(): Call<List<CountryListModelItem>>
}