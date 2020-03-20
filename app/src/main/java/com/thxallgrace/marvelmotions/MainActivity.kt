package com.thxallgrace.marvelmotions

import android.os.Bundle
import com.thxallgrace.marvelmotions.base.DatabindingActivity
import com.thxallgrace.marvelmotions.databinding.ActivityMainBinding
import com.thxallgrace.marvelmotions.view.ui.main.MainPagerAdapter

class MainActivity : DatabindingActivity() {

    private val binding : ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            pagerAdapter = MainPagerAdapter(supportFragmentManager)
            navigation = mainBottomNavigation
        }
    }
}
