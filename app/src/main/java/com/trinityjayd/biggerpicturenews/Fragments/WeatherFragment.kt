package com.trinityjayd.biggerpicturenews.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.trinityjayd.biggerpicturenews.ApiClients.WeatherApiClient
import com.trinityjayd.biggerpicturenews.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class WeatherFragment : Fragment() {

    private var weatherText: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weather, container, false)
        val weather = view.findViewById<TextView>(R.id.weatherTextView)
        val description = view.findViewById<TextView>(R.id.descriptionTextView)

        val service = WeatherApiClient.getClient()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getWeather()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val weatherResponse = response.body()?.get(0)
                    weatherResponse?.let{
                        weather.text = it.Temperature.Metric.Value.toString() + "°C"
                        description.text = it.WeatherText
                    }
                } else {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return view
    }


}