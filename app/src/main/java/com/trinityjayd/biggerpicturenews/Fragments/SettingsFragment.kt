package com.trinityjayd.biggerpicturenews.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.trinityjayd.biggerpicturenews.Login
import com.trinityjayd.biggerpicturenews.R

class SettingsFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        auth = Firebase.auth

        view.findViewById<Button>(R.id.changeCurrencyBtn).setOnClickListener() {
            val exchangeRateFragment = ExchangeRateFragment()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.newsAndRateContainer, exchangeRateFragment)
                commit()
            }
        }


        view.findViewById<Button>(R.id.btnLogout).setOnClickListener() {
            auth.signOut()
            val intent = Intent(requireContext(), Login::class.java)
            startActivity(intent)
        }

        return view
    }


}