package com.shifthackz.flatboard.ui.fragment.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shifthackz.flatboard.R
import com.shifthackz.flatboard.databinding.FragmentMainBinding
import com.shifthackz.flatboard.keyboard.logic.CustomKeyboardView
import com.shifthackz.flatboard.keyboard.provider.KeyboardContract
import com.shifthackz.flatboard.ui.activity.detail.FontDetailActivity
import com.shifthackz.flatboard.ui.activity.detail.NumericDetailActivity
import com.shifthackz.flatboard.base.BaseFragment
import com.shifthackz.flatboard.base.onPageSelected
import com.shifthackz.flatboard.base.provideOnBackPressedCallback
import com.shifthackz.flatboard.usecases.AvailableFonts
import com.shifthackz.flatboard.utils.Constants.REQUEST_CODE_FONT_DETAIL
import com.shifthackz.flatboard.utils.Constants.REQUEST_CODE_NUMERIC_DETAIL

class MainFragment : BaseFragment<FragmentMainBinding>(), KeyboardContract {

    override val inflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMainBinding
        get() = FragmentMainBinding::inflate

    val keyboard: CustomKeyboardView
        get() = binding.incKeyboard.customKeyboardView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackPressed(provideOnBackPressedCallback {
            if (keyboard.isExpanded) keyboard.translateLayout()
            else activity?.finish()
        })
        setupViewPagers()
        keyboard.registerEditText(CustomKeyboardView.KeyboardType.QWERTY, binding.testQwertyField)
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

    override fun reloadKeyboardFont(position: Int) = with(keyboard) {
        updateFont(AvailableFonts.fontList[position], binding.testQwertyField)
    }

    override fun reloadKeyboardNumeric(position: Int) = with(keyboard) {
        updateNumeric(AvailableFonts.numericList[position], binding.testQwertyField)
    }

    private fun setupViewPagers() {
        with(binding.incNumeric.viewPagerNumeric) {
            adapter = NumericViewPagerAdapter(
                requireContext(),
                AvailableFonts.numericList,
                this@MainFragment) {
                startActivityForResult(NumericDetailActivity.newInstance(requireContext(), it), REQUEST_CODE_NUMERIC_DETAIL)
            }
            onPageSelected(::reloadKeyboardNumeric)
        }

        with(binding.incFont.viewPagerFont) {
            adapter = FontViewPagerAdapter(
                requireContext(),
                AvailableFonts.fontList,
                this@MainFragment) {
                startActivityForResult(FontDetailActivity.newInstance(requireContext(), it), REQUEST_CODE_FONT_DETAIL)
            }
            onPageSelected(::reloadKeyboardFont)
        }

    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
