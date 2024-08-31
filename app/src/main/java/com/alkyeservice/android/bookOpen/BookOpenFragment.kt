package com.alkyeservice.android.bookOpen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alkyeservice.android.R

class BookOpenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_book_open, container, false)

        // Dummy data
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
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewLatestArticles)
        horizontalRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        horizontalRecyclerView.adapter = ArticleAdapter(requireContext(),horizontalItems)

        val recentArticles = listOf(
            ArticleItem(R.drawable.car, "Technology", "Step Into Tomorrow:","Exploring Spatial Computing’s Impact On Industries And The Metaverse!","12 Feb 2024"),
            ArticleItem(R.drawable.car, "Technology", "Step Into Tomorrow:","Exploring Spatial Computing’s Impact On Industries And The Metaverse!","12 Feb 2024"),
            ArticleItem(R.drawable.car, "Technology", "Step Into Tomorrow:","Exploring Spatial Computing’s Impact On Industries And The Metaverse!","12 Feb 2024"),
            ArticleItem(R.drawable.car, "Technology", "Step Into Tomorrow:","Exploring Spatial Computing’s Impact On Industries And The Metaverse!","12 Feb 2024"),
            ArticleItem(R.drawable.car, "Technology", "Step Into Tomorrow:","Exploring Spatial Computing’s Impact On Industries And The Metaverse!","12 Feb 2024"),
            ArticleItem(R.drawable.car, "Technology", "Step Into Tomorrow:","Exploring Spatial Computing’s Impact On Industries And The Metaverse!","12 Feb 2024"),
            // Add more items as needed
        )

        // Initialize Recent RecyclerView
        val recentRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewRecentArticles)
        recentRecyclerView.layoutManager = LinearLayoutManager(context)
        recentRecyclerView.adapter = RecentArticlesAdapter(requireContext(),recentArticles)

        return view
    }
}
