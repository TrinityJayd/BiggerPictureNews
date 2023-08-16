package com.trinityjayd.biggerpicturenews


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.trinityjayd.biggerpicturenews.Fragments.CurrencyFragment
import com.trinityjayd.biggerpicturenews.Fragments.ExchangeRateFragment
import com.trinityjayd.biggerpicturenews.Fragments.NewsFragment
import com.trinityjayd.biggerpicturenews.Fragments.SettingsFragment
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


        val settings = findViewById<Button>(R.id.settingsButton)
        settings.setOnClickListener() {
            val settingsFragment = SettingsFragment()
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.newsAndRateContainer, settingsFragment)
                commit()
            }
        }

        val newsFragment = NewsFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.newsAndRateContainer, newsFragment)
            commit()
        }


        val newsSource = Bundle()

        val bbcNewsbtn = findViewById<TextView>(R.id.bbcNewsButton)
        bbcNewsbtn.setOnClickListener() {
            newsSource.putString("newsSource", "bbc-news")
            val newsFragment = NewsFragment()
            newsFragment.arguments = newsSource
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.newsAndRateContainer, newsFragment)
                commit()
            }
        }

        val news24btn = findViewById<TextView>(R.id.news24Button)
        news24btn.setOnClickListener() {
            newsSource.putString("newsSource", "news24")
            val newsFragment = NewsFragment()
            newsFragment.arguments = newsSource
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.newsAndRateContainer, newsFragment)
                commit()
            }
        }


    }

}