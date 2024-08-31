package com.alkyeservice.android.activity

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.alkyeservice.android.R
import com.alkyeservice.android.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        // Set up ViewPager with the TabLayout
        viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.setIcon(R.drawable.book_open)
                1 -> tab.setIcon(R.drawable.bookmark)
                2 -> tab.setIcon(R.drawable.tv)
                3 -> tab.setIcon(R.drawable.bell)
                4 -> tab.setIcon(R.drawable.user)
            }
        }.attach()


        // Set background and icon color for selected tab
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.view.setBackgroundResource(R.drawable.selected_tab_background) // Selected tab background
                tab.icon?.setTint(Color.WHITE) // Selected icon color
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.view.setBackgroundResource(R.drawable.default_tab_background) // Default background for unselected tabs
                tab.icon?.setTint(Color.BLACK) // Default icon color for unselected tabs
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Do nothing for reselection
            }
        })

        tabLayout.selectTab(tabLayout.getTabAt(0))
        tabLayout.getTabAt(0)?.view?.setBackgroundResource(R.drawable.selected_tab_background) // Set selected background for the first tab
        tabLayout.getTabAt(0)?.icon?.setTint(Color.WHITE)
    }
}
