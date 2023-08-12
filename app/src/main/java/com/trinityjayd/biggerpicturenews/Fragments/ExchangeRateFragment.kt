package com.trinityjayd.biggerpicturenews.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.trinityjayd.biggerpicturenews.ApiClients.CurrencyApiClient
import com.trinityjayd.biggerpicturenews.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ExchangeRateFragment : Fragment() {

    private lateinit var currencySelection: Bundle
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_exchange_rate, container, false)

        currencySelection = Bundle()

        val baseCurrencycmb = view.findViewById<Spinner>(R.id.baseCurrencyCmb)
        val targetCurrencycmb = view.findViewById<Spinner>(R.id.toCurrencyCmb)

        val service = CurrencyApiClient.getClient()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getCurrencies()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    responseBody?.data?.let { currencyData ->
                        val currencySymbols = currencyData.values.map { it.code }

                        if (baseCurrencycmb != null) {
                            val adapter = ArrayAdapter(
                                requireContext(),
                                android.R.layout.simple_spinner_item,
                                currencySymbols
                            )
                            baseCurrencycmb.adapter = adapter
                            baseCurrencycmb.setSelection(adapter.getPosition("USD"))
                        }

                        if (targetCurrencycmb != null) {
                            val adapter = ArrayAdapter(
                                requireContext(),
                                android.R.layout.simple_spinner_item,
                                currencySymbols
                            )
                            targetCurrencycmb.adapter = adapter
                            targetCurrencycmb.setSelection(adapter.getPosition("ZAR"))
                        }

                    }
                } else {
                    Toast.makeText(context, "Error Currency", Toast.LENGTH_SHORT).show()
                }
            }
        }



        baseCurrencycmb.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                currencySelection.putString("baseCurrency", baseCurrencycmb.selectedItem.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //do nothing
            }
        }

        targetCurrencycmb.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                currencySelection.putString("targetCurrency", targetCurrencycmb.selectedItem.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //do nothing
            }
        }

        val saveBtn = view.findViewById<Button>(R.id.saveBtn)
        saveBtn.setOnClickListener {
            val currencyFragment = CurrencyFragment()
            currencyFragment.arguments = currencySelection
            Log.d("ExchangeRateFragment", "currencySelection: $currencySelection")

            val fragmentManager = requireActivity().supportFragmentManager

            fragmentManager.beginTransaction().apply {
                replace(R.id.currencyFragment, currencyFragment)
                commit()
            }
        }

        return view
    }
}