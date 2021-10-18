package com.shifthackz.flatboard.ui.fragment.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.shifthackz.flatboard.R
import com.shifthackz.flatboard.databinding.FragmentMainBinding
import com.shifthackz.flatboard.keyboard.logic.CustomKeyboardView
import com.shifthackz.flatboard.keyboard.provider.KeyboardContract
import com.shifthackz.flatboard.ui.activity.detail.FontDetailActivity
import com.shifthackz.flatboard.ui.activity.detail.NumericDetailActivity
import com.shifthackz.flatboard.ui.base.BaseFragment
import com.shifthackz.flatboard.ui.viewpager_adapter.FontViewPagerAdapter
import com.shifthackz.flatboard.ui.viewpager_adapter.NumericViewPagerAdapter
import com.shifthackz.flatboard.usecases.AvailableFonts
import com.shifthackz.flatboard.utils.Constants.REQUEST_CODE_FONT_DETAIL
import com.shifthackz.flatboard.utils.Constants.REQUEST_CODE_NUMERIC_DETAIL

class MainFragment : BaseFragment<FragmentMainBinding>(), KeyboardContract {

    override val inflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMainBinding
        get() = FragmentMainBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPagers()
        binding.incKeyboard.customKeyboardView.registerEditText(CustomKeyboardView.KeyboardType.QWERTY, binding.testQwertyField)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
                when (requestCode) {
            REQUEST_CODE_FONT_DETAIL -> {
                if (resultCode == Activity.RESULT_OK) {
                    data?.getIntExtra(getString(R.string.EXTRAS_FONT_ID_SEL), binding.incFont.viewPagerFont.currentItem)
                            ?.let { binding.incFont.viewPagerFont.currentItem = it }
                }
            }
            REQUEST_CODE_NUMERIC_DETAIL -> {
                if (resultCode == Activity.RESULT_OK) {
                    data?.getIntExtra(getString(R.string.EXTRAS_NUM_ID_SEL), binding.incNumeric.viewPagerNumeric.currentItem)
                            ?.let { binding.incNumeric.viewPagerNumeric.currentItem = it }
                }
            }
        }
    }

    override fun reloadKeyboardFont(position: Int) = with(binding.incKeyboard.customKeyboardView) {
        updateFont(AvailableFonts.fontList[position], binding.testQwertyField)
    }

    override fun reloadKeyboardNumeric(position: Int) = with(binding.incKeyboard.customKeyboardView) {
        updateNumeric(AvailableFonts.numericList[position], binding.testQwertyField)
    }

    private fun setupViewPagers() {
        binding.incNumeric.viewPagerNumeric.adapter = NumericViewPagerAdapter(
            requireContext(),
            AvailableFonts.numericList,
            this) {
            startActivityForResult(NumericDetailActivity.newInstance(requireContext(), it), REQUEST_CODE_NUMERIC_DETAIL)
        }
        binding.incNumeric.viewPagerNumeric.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) = reloadKeyboardNumeric(position)
        })

        binding.incFont.viewPagerFont.adapter = FontViewPagerAdapter(
            requireContext(),
            AvailableFonts.fontList,
            this) {
            startActivityForResult(FontDetailActivity.newInstance(requireContext(), it), REQUEST_CODE_FONT_DETAIL)
        }
        binding.incFont.viewPagerFont.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageSelected(position: Int) = reloadKeyboardFont(position)
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
