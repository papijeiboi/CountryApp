package com.papijeiboi.countryapp.model

import com.google.gson.annotations.SerializedName

class Currency{
    @SerializedName("code")
    var code: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("symbol")
    var symbol: String? = null

}