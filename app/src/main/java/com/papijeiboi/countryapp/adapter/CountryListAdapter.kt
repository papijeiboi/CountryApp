package com.papijeiboi.countryapp.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.papijeiboi.countryapp.CountryInformationActivity
import com.papijeiboi.countryapp.R
import com.papijeiboi.countryapp.model.CountryListModelItem
import kotlinx.android.synthetic.main.country_list_row.view.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.papijeiboi.countryapp.EXTRA_COUNTRY_INFORMATION


class CountryListAdapter(private val activity: Activity) :
    RecyclerView.Adapter<CountryListAdapter.MyViewHolder>() {

    private var countryList: List<CountryListModelItem>? = null

    fun setCountryList(countryList: List<CountryListModelItem>?) {
        this.countryList = countryList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryListAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.country_list_row, parent, false)
        val holder = MyViewHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: CountryListAdapter.MyViewHolder, position: Int) {
        holder.bind(countryList?.get(position)!!)
        holder.itemView.setOnClickListener {

            val mGson = GsonBuilder()
                .setLenient()
                .create()
                mGson.toJson(countryList?.get(position)!!)

            val intent = Intent(activity, CountryInformationActivity::class.java)
            intent.putExtra(EXTRA_COUNTRY_INFORMATION, mGson.toJson(countryList?.get(position)!!))
            activity.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return if (countryList == null) 0 else
            countryList?.size!!
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivFlag = view.iv_country_flag
        val tvCountryName = view.tv_country_name

        fun bind(data: CountryListModelItem) {
            tvCountryName.text = data.name

            val url = data.flags!!.png

            Glide.with(ivFlag)
                .load(url)
                .circleCrop()
                .into(ivFlag)
        }
    }
}