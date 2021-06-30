package com.indialone.viewpager2andfragmentswithtablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.indialone.viewpager2andfragmentswithtablayout.fragments.*
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val words = arrayListOf("one", "two", "three", "four", "five")

        val fragments = arrayListOf<Fragment>(
            TopHeadlinesFragment(),
            TechCrunchFragment(),
            AppleNewsFragment(),
            TeslaNewsFragment(),
            WsjComNewsFragment()
        )

        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.viewpager)
        viewPager.adapter = ViewPagerAdapter(fragments, this)

        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val tabTitles =
            arrayListOf("TopHeadlines", "TechCrunch", "Apple", "Tesla", "Wsj.com")

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

    }


}