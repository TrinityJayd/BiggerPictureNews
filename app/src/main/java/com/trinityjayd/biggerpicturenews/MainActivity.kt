package com.trinityjayd.biggerpicturenews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.trinityjayd.biggerpicturenews.ApiClients.WeatherApiClient
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
    }
}