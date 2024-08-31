package com.alkyeservice.android.activity

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alkyeservice.android.R

class TermsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_terms)

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.landingScreen)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the WebView and load the URL
        val webView = findViewById<WebView>(R.id.webViewTerms)
        val url = "https://alkye.com/terms-conditions/"
        webView.loadUrl(url)
    }
}
