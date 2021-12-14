package com.papijeiboi.countryapp.model

import com.google.gson.annotations.SerializedName

class Language {
    @SerializedName("iso639_1")
    var iso639_1: String? = null

    @SerializedName("iso639_2")
    var iso639_2: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("nativeName")
    var nativeName: String? = null
}