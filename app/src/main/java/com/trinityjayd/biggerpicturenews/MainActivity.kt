package com.trinityjayd.biggerpicturenews

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.trinityjayd.biggerpicturenews.ApiClients.CurrencyApiClient
import com.trinityjayd.biggerpicturenews.Fragments.WeatherFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherFragment = WeatherFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.weatherFragment, weatherFragment)
            commit()
        }


        //create an array that will store the currency symbols returned from the API
        val currencySymbols = ArrayList<String>()
        val currencyCmb = findViewById<Spinner>(R.id.currencyCmb)

        val service = CurrencyApiClient.getClient()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getCurrencies()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    responseBody?.data?.let { currencyData ->
                        val currencySymbols = currencyData.values.map { it.code }

                        if (currencyCmb != null) {
                            val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, currencySymbols)
                            currencyCmb.adapter = adapter
                        }
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Error Currency", Toast.LENGTH_SHORT).show()
                }
            }
        }



        currencyCmb.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val currency = parent?.getItemAtPosition(position).toString()
                Toast.makeText(parent?.context, currency, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //do nothing
            }
        }


    }
}