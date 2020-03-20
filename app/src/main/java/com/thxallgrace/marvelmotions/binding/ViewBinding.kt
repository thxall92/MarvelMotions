package com.thxallgrace.marvelmotions.binding

import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.thxallgrace.marvelmotions.R

@BindingAdapter("bindNavigation")
fun bindNavigation(view: ViewPager, navigationView: BottomNavigationView){
    view.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
        override fun onPageScrollStateChanged(state: Int) = Unit
        override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
        ) = Unit

        override fun onPageSelected(position: Int) {
            navigationView.menu.getItem(position).isChecked = true
        }
    })

    navigationView.setOnNavigationItemSelectedListener {
        when(it.itemId){
            R.id.action_one -> view.currentItem = 0
            R.id.action_two -> view.currentItem = 1
            R.id.action_three -> view.currentItem = 2
        }
        true
    }
}

@BindingAdapter("pagerAdapter")
fun bindPagerAdapter(view: ViewPager, adapter: PagerAdapter){
    view.adapter = adapter
    view.offscreenPageLimit = 3
}