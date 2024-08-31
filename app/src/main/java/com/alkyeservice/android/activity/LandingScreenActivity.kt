package com.alkyeservice.android.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alkyeservice.android.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

class LandingScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display
        enableEdgeToEdge()
        setContentView(R.layout.activity_landing_screen)

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.landingScreen)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Start a coroutine to handle the delay
        CoroutineScope(Dispatchers.Main).launch {
            delay(3000) // 5-second delay

            // Check if the user is logged in
            val isLoggedIn = checkLoginStatus()

            // Redirect based on login status
            val intent = if (isLoggedIn) {
                Intent(this@LandingScreenActivity, HomeActivity::class.java)
            } else {
                Intent(this@LandingScreenActivity, LoginAndSignUpActivity::class.java)
            }

            startActivity(intent)
            // Finish the current activity so the user can't navigate back to it
            finish()
        }
    }

    // Function to check if the user is logged in
    private fun checkLoginStatus(): Boolean {
        val sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)
        return sharedPreferences.getBoolean("is_logged_in", false)
    }
}
