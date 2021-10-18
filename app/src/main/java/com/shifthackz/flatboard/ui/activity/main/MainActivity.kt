package com.shifthackz.flatboard.ui.activity.main

import android.os.Bundle
import android.view.LayoutInflater
import com.shifthackz.flatboard.ui.fragment.main.MainFragment
import com.shifthackz.flatboard.databinding.ActivityMainBinding
import com.shifthackz.flatboard.ui.base.BaseActivity
import com.shifthackz.flatboard.utils.Constants.MAIN_SCREEN_TITLE

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val inflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = MAIN_SCREEN_TITLE
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