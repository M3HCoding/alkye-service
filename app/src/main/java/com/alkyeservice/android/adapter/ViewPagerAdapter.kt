package com.alkyeservice.android.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alkyeservice.android.fragment.BellFragment
import com.alkyeservice.android.bookOpen.BookOpenFragment
import com.alkyeservice.android.fragment.BookmarkFragment
import com.alkyeservice.android.fragment.TVFragment
import com.alkyeservice.android.fragment.UserFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 5 // Number of tabs
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BookOpenFragment()
            1 -> BookmarkFragment()
            2 -> TVFragment()
            3 -> BellFragment()
            4 -> UserFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}
