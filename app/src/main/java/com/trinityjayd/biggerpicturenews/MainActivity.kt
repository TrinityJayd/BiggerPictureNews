package com.trinityjayd.biggerpicturenews

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.trinityjayd.biggerpicturenews.Fragments.CurrencyFragment
import com.trinityjayd.biggerpicturenews.Fragments.ExchangeRateFragment
import com.trinityjayd.biggerpicturenews.Fragments.WeatherFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherFragment = WeatherFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.weatherFragment, weatherFragment)
            commit()
        }

        val currencyFragment = CurrencyFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.currencyFragment, currencyFragment)
            commit()
        }

        val changeCurrency = findViewById<TextView>(R.id.changeCurrencyTextView)
        changeCurrency.setOnClickListener(){
            val exchangeRateFragment = ExchangeRateFragment()
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.exchangeRateFragment, exchangeRateFragment)
                commit()
            }
        }





    }

}