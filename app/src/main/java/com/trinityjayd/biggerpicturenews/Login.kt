package com.trinityjayd.biggerpicturenews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        val loginBtn = findViewById<Button>(R.id.loginButton)
        loginBtn.setOnClickListener {
            val email = findViewById<EditText>(R.id.emailEditText)
            val password = findViewById<EditText>(R.id.passwordEditText)

            if (email.text.toString().isEmpty()) {
                email.error = "Please enter email"
                email.requestFocus()
                return@setOnClickListener
            }else if (password.text.toString().isEmpty()) {
                password.error = "Please enter password"
                password.requestFocus()
                return@setOnClickListener
            }else{
                auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = auth.currentUser
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            email.error = "Email or password is incorrect"
                            email.requestFocus()
                        }
                    }
            }
        }

        val registerBtn = findViewById<Button>(R.id.registerButton)
        registerBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}