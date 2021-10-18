package com.shifthackz.flatboard.ui.activity.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import com.shifthackz.flatboard.databinding.ActivitySplashBinding
import com.shifthackz.flatboard.ui.activity.main.MainActivity
import com.shifthackz.flatboard.ui.base.BaseActivity
import com.shifthackz.flatboard.ui.viewpager_adapter.SplashViewPagerAdapter

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override val inflater: (LayoutInflater) -> ActivitySplashBinding
        get() = ActivitySplashBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        binding.viewPagerSplash.adapter = SplashViewPagerAdapter(this)
        Handler(Looper.getMainLooper()).postDelayed({
            binding.viewPagerSplash.arrowScroll(View.FOCUS_RIGHT)
        }, 700L)
        Handler(Looper.getMainLooper()).postDelayed({
            binding.viewPagerSplash.arrowScroll(View.FOCUS_RIGHT)
        }, 1400L)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 2100L)
    }
}
