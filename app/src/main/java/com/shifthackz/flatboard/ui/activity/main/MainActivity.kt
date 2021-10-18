package com.shifthackz.flatboard.ui.activity.main

import android.os.Bundle
import android.view.LayoutInflater
import com.shifthackz.flatboard.ui.fragment.main.MainFragment
import com.shifthackz.flatboard.databinding.ActivityMainBinding
import com.shifthackz.flatboard.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val inflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "\uD835\uDC6D\uD835\uDC90\uD835\uDC8F\uD835\uDC95\uD835\uDC83\uD835\uDC90\uD835\uDC82\uD835\uDC93\uD835\uDC85"
        supportFragmentManager.beginTransaction().replace(
            binding.mainContainer.id,
            MainFragment.newInstance()
        ).commit()
    }
//
//    override fun onBackPressed() {
//        if (keyboard.isExpanded) {
//            keyboard.translateLayout()
//        } else {
//            super.onBackPressed()
//        }
//    }
}