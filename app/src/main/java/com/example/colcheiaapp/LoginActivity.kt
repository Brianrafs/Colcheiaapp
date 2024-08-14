package com.example.colcheiaapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val signInButton = findViewById<Button>(R.id.btn_sign_in)
        val googleButton = findViewById<ImageButton>(R.id.btn_google)
        val facebookButton = findViewById<ImageButton>(R.id.btn_facebook)
        val appleButton = findViewById<ImageButton>(R.id.btn_apple)
        val signUpTextView = findViewById<TextView>(R.id.tv_signup_link)

        signInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Aqui você pode adicionar a lógica de autenticação
                Toast.makeText(this, "Sign in clicked", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
            }
        }

        googleButton.setOnClickListener {
            Toast.makeText(this, "Google sign in clicked", Toast.LENGTH_SHORT).show()
            // Implementar lógica de login com Google
        }

        facebookButton.setOnClickListener {
            Toast.makeText(this, "Facebook sign in clicked", Toast.LENGTH_SHORT).show()
            // Implementar lógica de login com Facebook
        }

        appleButton.setOnClickListener {
            Toast.makeText(this, "Apple sign in clicked", Toast.LENGTH_SHORT).show()
            // Implementar lógica de login com Apple
        }

        signUpTextView.setOnClickListener {
            Toast.makeText(this, "Sign up link clicked", Toast.LENGTH_SHORT).show()
            // Implementar lógica de redirecionamento para tela de cadastro
        }
    }
}
