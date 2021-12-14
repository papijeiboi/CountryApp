package com.papijeiboi.countryapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.papijeiboi.countryapp.model.CountryListModelItem
import com.papijeiboi.countryapp.webservice.WebInstance
import com.papijeiboi.countryapp.webservice.WebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel() {

    var liveDataList: MutableLiveData<List<CountryListModelItem>> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<List<CountryListModelItem>>{
        return liveDataList
    }

    fun webService(){
        val webInstance = WebInstance.getWebInstance()
        val webService = webInstance.create(WebService::class.java)
        val call = webService.countryData()

        call.enqueue(object : Callback<List<CountryListModelItem>>{
            override fun onResponse(
                call: Call<List<CountryListModelItem>>,
                response: Response<List<CountryListModelItem>>
            ) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<CountryListModelItem>>, t: Throwable) {
                liveDataList.postValue(null)
                Log.e("webService", t.message.toString())
            }
        })
    }
}