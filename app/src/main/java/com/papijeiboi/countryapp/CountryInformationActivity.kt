package com.papijeiboi.countryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.papijeiboi.countryapp.model.CountryListModelItem
import kotlinx.android.synthetic.main.activity_country_information.*

const val EXTRA_COUNTRY_INFORMATION = "EXTRA_COUNTRY_INFORMATION"

class CountryInformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_information)

        val listType = object : TypeToken<CountryListModelItem>() {}.type
        val countryInfo: CountryListModelItem =
            Gson().fromJson<CountryListModelItem>(
                intent.getStringExtra(EXTRA_COUNTRY_INFORMATION),
                listType
            )



        setSupportActionBar(toolbar_layout)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        countryInfo.name?.let { setCollapsingToolbarLayoutTitle(it) }



        Glide.with(iv_country_information)
            .load(countryInfo.flags!!.png)
            .into(iv_country_information)

        if (countryInfo.languages!!.size != null) {
            val arraySizeLanguage: Int = countryInfo.languages!!.size
            for (i in 0 until arraySizeLanguage) {
                tv_language.append(countryInfo.languages!![i].name)
                tv_language.append(" ")
            }
        } else {
            tv_language.text = "Not Available"
        }


        if (countryInfo.currencies!!.size != null) {
            val arraySizeCurrency: Int = countryInfo.currencies!!.size
            for (i in 0 until arraySizeCurrency) {
                tv_currency.append(countryInfo.currencies!![i].symbol)
                tv_currency.append(" ")
            }
        } else {
            tv_currency.text = "Not Available"
        }

        tv_capital.text = countryInfo.capital


        toolbar_layout.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setCollapsingToolbarLayoutTitle(title: String) {
        collapsing_toolbar_layout.title = title
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}