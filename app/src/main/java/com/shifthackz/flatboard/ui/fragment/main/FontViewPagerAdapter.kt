package com.shifthackz.flatboard.ui.fragment.main

import android.content.Context
import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.shifthackz.flatboard.R
import com.shifthackz.flatboard.keyboard.font.custom.RandomFont
import com.shifthackz.flatboard.keyboard.provider.KeyboardContract

class FontViewPagerAdapter(
    private val context: Context,
    private val list: List<BaseFont>,
    private val contract: KeyboardContract,
    private val onFontClick: (Int) -> Unit
) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int) = setupItem(container, position)

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    private fun setupItem(container: ViewGroup, position: Int): Any {
        val layout = LayoutInflater
                .from(context)
                .inflate(R.layout.item_font, container, false)

        val tvName = layout.findViewById<TextView>(R.id.tvFontName)
        val tvRender = layout.findViewById<TextView>(R.id.tvFontRender)

        tvName.text = list[position].getFontName()
        tvRender.text = list[position].getRenderedSample()

        when (list[position]) {
            is RandomFont -> {
                (list[position] as RandomFont).generate()
                layout.setOnClickListener { handleRandomFontClick(position) }
            }
            else -> {
                layout.setOnClickListener { handleDefaultFontClick(position) }
            }
        }
        container.addView(layout)
        return layout
    }

    private fun handleDefaultFontClick(position: Int) {
        onFontClick.invoke(position)
//        context.startActivityForResult(FontDetailActivity.newInstance(context, position), Constants.REQUEST_CODE_FONT_DETAIL)
    }

    private fun handleRandomFontClick(position: Int) {
        (list[position] as RandomFont).generate()
        contract.reloadKeyboardFont(position)
    }

}

