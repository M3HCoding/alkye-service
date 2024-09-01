package com.alkyeservice.android.bookOpen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
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

        val dotIndicatorLayout = view.findViewById<LinearLayout>(R.id.dotIndicatorLayout)

        // Create dot indicators dynamically
        val dotCount = horizontalItems.size
        val dots = arrayOfNulls<ImageView>(dotCount)

        for (i in 0 until dotCount) {
            dots[i] = ImageView(context).apply {
                setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.non_active_dot))
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(8, 0, 8, 0)
                }
            }
            dotIndicatorLayout.addView(dots[i])
        }

        dots[0]?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.active_dot)) // Set the first dot as active

        horizontalRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val activePosition = layoutManager.findFirstVisibleItemPosition()

                if (activePosition != RecyclerView.NO_POSITION) {
                    for (i in dots.indices) {
                        dots[i]?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.non_active_dot))
                    }
                    dots[activePosition]?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.active_dot))
                }
            }
        })



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
