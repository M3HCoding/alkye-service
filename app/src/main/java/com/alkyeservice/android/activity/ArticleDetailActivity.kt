package com.alkyeservice.android.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alkyeservice.android.R
import com.alkyeservice.android.bookOpen.ArticleAdapter
import com.alkyeservice.android.bookOpen.ArticleItem

class ArticleDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_article_delails)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.articleDetail)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<ImageView>(R.id.back).setOnClickListener {
            finish()
        }

        val horizontalItems = listOf(
            ArticleItem(R.drawable.car, "Technology", "Step Into Tomorrow:","Exploring Spatial Computing’s Impact On Industries And The Metaverse!","12 Feb 2024"),
            ArticleItem(R.drawable.car, "Technology", "Step Into Tomorrow:","Exploring Spatial Computing’s Impact On Industries And The Metaverse!","12 Feb 2024"),
            ArticleItem(R.drawable.car, "Technology", "Step Into Tomorrow:","Exploring Spatial Computing’s Impact On Industries And The Metaverse!","12 Feb 2024"),
            ArticleItem(R.drawable.car, "Technology", "Step Into Tomorrow:","Exploring Spatial Computing’s Impact On Industries And The Metaverse!","12 Feb 2024"),
            ArticleItem(R.drawable.car, "Technology", "Step Into Tomorrow:","Exploring Spatial Computing’s Impact On Industries And The Metaverse!","12 Feb 2024"),
            ArticleItem(R.drawable.car, "Technology", "Step Into Tomorrow:","Exploring Spatial Computing’s Impact On Industries And The Metaverse!","12 Feb 2024"),
            // Add more items as needed
        )

        // Initialize Horizontal RecyclerView
        val horizontalRecyclerView = findViewById<RecyclerView>(R.id.rcRecentArticles)
        horizontalRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        horizontalRecyclerView.adapter = ArticleAdapter(this,horizontalItems)
    }
}