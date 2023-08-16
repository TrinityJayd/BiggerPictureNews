package com.trinityjayd.biggerpicturenews.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.trinityjayd.biggerpicturenews.ApiClients.CurrencyApiClient
import com.trinityjayd.biggerpicturenews.BuildConfig
import com.trinityjayd.biggerpicturenews.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CurrencyFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_currency, container, false)

        auth = Firebase.auth

        val uid = auth.currentUser?.uid
        val database = Firebase.database.reference

        uid?.let { userId ->
            database.child(userId).child("currencyPreferences").get()
                .addOnSuccessListener { preferencesSnapshot ->
                    var baseCurrency =
                        preferencesSnapshot.child("baseCurrency").getValue(String::class.java)
                    var targetCurrency =
                        preferencesSnapshot.child("targetCurrency").getValue(String::class.java)

                    val service = CurrencyApiClient.getClient()
                    CoroutineScope(Dispatchers.IO).launch {
                        val response = if (baseCurrency != null && targetCurrency != null) {
                            service.getExchangeRates(
                                BuildConfig.CURRENCY_API_KEY,
                                baseCurrency!!, targetCurrency!!
                            )
                        } else {
                            baseCurrency = "USD"
                            targetCurrency = "ZAR"
                            service.getExchangeRates(BuildConfig.CURRENCY_API_KEY, baseCurrency!!, targetCurrency!!)
                        }

                        withContext(Dispatchers.Main) {
                            if (response.isSuccessful) {
                                val responseBody = response.body()
                                responseBody?.data?.let { exchangeRateData ->
                                    val exchangeRate = exchangeRateData.values.first()
                                    val roundedExchangeRate = String.format("%.1f", exchangeRate)

                                    val comparison =
                                        view.findViewById<TextView>(R.id.currencyComparisonTextView)
                                    comparison.text =
                                        "1 $baseCurrency\n$roundedExchangeRate $targetCurrency"
                                }
                            } else {
                                Toast.makeText(context, "Error Currency", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
        }

        return view
    }
}
