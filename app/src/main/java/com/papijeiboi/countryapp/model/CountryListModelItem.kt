package com.papijeiboi.countryapp.model

import com.google.gson.annotations.SerializedName

class CountryListModelItem {
    @SerializedName("flags")
    var flags: Flags? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("languages")
    var languages: List<Language>? = null

    @SerializedName("capital")
    var capital: String? = null

    @SerializedName("currencies")
    var currencies: List<Currency>? = null
}