package com.shifthackz.flatboard.ui.viewpager_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.shifthackz.flatboard.R
import com.shifthackz.flatboard.keyboard.numeric.base.BaseNumeric
import com.shifthackz.flatboard.keyboard.numeric.custom.RandomNumeric
import com.shifthackz.flatboard.keyboard.provider.KeyboardContract

class NumericViewPagerAdapter(
    private val context: Context,
    private val list: List<BaseNumeric>,
    private val contract: KeyboardContract,
    private val onFontClick: (Int) -> Unit
) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int) = setupItem(container, position)

    override fun isViewFromObject(view: View, obj: Any) = (view == obj)

    override fun getCount() = list.size

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    private fun setupItem(container: ViewGroup, position: Int): Any {
        val layout = LayoutInflater
                .from(context)
                .inflate(R.layout.item_numeric, container, false)

        val tvName = layout.findViewById<TextView>(R.id.tvNumericName)
        val tvRender = layout.findViewById<TextView>(R.id.tvNumericRender)

        tvName.text = list[position].getNumericName()
        tvRender.text = list[position].getRenderedSample()

        when (list[position]) {
            is RandomNumeric -> {
                (list[position] as RandomNumeric).generate()
                layout.setOnClickListener { handleRandomNumericClick(position) }
            }
            else -> {
                layout.setOnClickListener { handleDefaultNumericClick(position) }
            }
        }
        container.addView(layout)
        return layout
    }

    private fun handleDefaultNumericClick(position: Int) {
        onFontClick.invoke(position)
//        context.startActivityForResult(NumericDetailActivity.newInstance(context, position), Constants.REQUEST_CODE_NUMERIC_DETAIL)
    }

    private fun handleRandomNumericClick(position: Int) {
        (list[position] as RandomNumeric).generate()
        contract.reloadKeyboardNumeric(position)
    }
}

