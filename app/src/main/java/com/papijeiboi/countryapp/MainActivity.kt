package com.papijeiboi.countryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.papijeiboi.countryapp.adapter.CountryListAdapter
import com.papijeiboi.countryapp.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var countryListAdapter: CountryListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        initRv()
    }

    private fun initRv() {
        rv_country.layoutManager = LinearLayoutManager(this)
        countryListAdapter = CountryListAdapter(this)
        rv_country.adapter = countryListAdapter
    }

    private fun initViewModel() {
        val viewModel:MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if(it != null){
                countryListAdapter.setCountryList(it)
                countryListAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                Log.e("initViewModel", "Error")
            }
        })
        viewModel.webService()
    }
}