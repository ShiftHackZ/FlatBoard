package com.shifthackz.flatboard.ui.activity.splash

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.shifthackz.flatboard.R

class SplashViewPagerAdapter(private val context: Context) : PagerAdapter() {

    private val splashBoard: List<String> = arrayListOf("F o n t", "F a n c y", "F l a t")

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layout = LayoutInflater
                .from(context)
                .inflate(R.layout.item_splash, container, false)
        val textSplash = layout.findViewById<TextView>(R.id.textSplash)

        textSplash.text = splashBoard[position]

        container.addView(layout)

        return layout
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun getCount(): Int {
        return splashBoard.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

}