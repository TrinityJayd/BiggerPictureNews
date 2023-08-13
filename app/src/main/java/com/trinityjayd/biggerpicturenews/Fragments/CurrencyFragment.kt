package com.trinityjayd.biggerpicturenews.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.trinityjayd.biggerpicturenews.ApiClients.CurrencyApiClient
import com.trinityjayd.biggerpicturenews.BuildConfig
import com.trinityjayd.biggerpicturenews.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CurrencyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_currency, container, false)
        val service = CurrencyApiClient.getClient()
        CoroutineScope(Dispatchers.IO).launch{
            var base = arguments?.getString("baseCurrency")
            var target = arguments?.getString("targetCurrency")

            var response = service.getExchangeRates(BuildConfig.CURRENCY_API_KEY,"USD","ZAR")
            if (base != null && target != null) {
                response = service.getExchangeRates(BuildConfig.CURRENCY_API_KEY,base, target)
            }else{
                base = "USD"
                target = "ZAR"
            }

            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    val responseBody = response.body()
                    responseBody?.data?.let { exchangeRateData ->
                        val exchangeRate = exchangeRateData.values.first()
                        val roundedExchangeRate = String.format("%.1f", exchangeRate)

                        val comparison = view.findViewById<TextView>(R.id.currencyComparisonTextView)
                        comparison.text = "1 $base = $roundedExchangeRate $target"
                    }
                }else{
                    Toast.makeText(context, "Error Currency", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return view
    }




}