package com.shifthackz.flatboard.base

import androidx.viewpager.widget.ViewPager

fun ViewPager.onPageSelected(action: (Int) -> Unit) = this.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
    override fun onPageScrollStateChanged(state: Int) = Unit
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) = Unit
    override fun onPageSelected(position: Int) = action.invoke(position)
})