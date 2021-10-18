package com.shifthackz.flatboard.ui.recyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.shifthackz.flatboard.databinding.ItemNumericDetailBinding
import com.shifthackz.flatboard.keyboard.numeric.base.BaseNumeric
import com.shifthackz.flatboard.keyboard.numeric.custom.RandomNumeric

class NumericDetailViewHolder(
    val binding: ItemNumericDetailBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(numeric: BaseNumeric, checked: Boolean) {
        when (numeric) { is RandomNumeric -> numeric.generate() }
        binding.rbSelectedNumericDetail.isChecked = checked
        binding.tvNumericNameDetail.text = numeric.getNumericName()
        binding.tvNumericRenderDetail.text = numeric.getRenderedSample()
    }
}