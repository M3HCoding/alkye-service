package com.alkyeservice.android.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alkyeservice.android.R

class LoginAndSignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_and_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.loginAndSignUp)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set click listeners
        findViewById<TextView>(R.id.btnSignUp).setOnClickListener {
            // Handle Sign Up button click
            val signUpIntent = Intent(this, SignUpActivity::class.java)
            startActivity(signUpIntent)
        }

        findViewById<TextView>(R.id.btnSignIn).setOnClickListener {
            // Handle Sign In button click
            //val signInIntent = Intent(this, SignInActivity::class.java)
            val signInIntent = Intent(this, HomeActivity::class.java)
            startActivity(signInIntent)
        }

        findViewById<TextView>(R.id.tvTerms).setOnClickListener {
            // Handle Terms and Conditions click
            val termsIntent = Intent(this, TermsActivity::class.java)
            startActivity(termsIntent)
        }
    }
}