package com.shifthackz.flatboard.ui.recyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.shifthackz.flatboard.databinding.ItemFontDetailBinding
import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.keyboard.font.custom.RandomFont

class FontDetailViewHolder(
    val binding: ItemFontDetailBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(font: BaseFont, checked: Boolean) {
        when (font) { is RandomFont -> font.generate() }
        binding.rbSelectedFontDetail.isChecked = checked
        binding.tvFontNameDetail.text = font.getFontName()
        binding.tvFontRenderDetail.text = font.getRenderedSample()
    }
}