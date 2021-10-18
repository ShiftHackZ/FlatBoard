package com.shifthackz.flatboard.ui.activity.detail

import com.shifthackz.flatboard.keyboard.numeric.base.BaseNumeric
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shifthackz.flatboard.databinding.ItemNumericDetailBinding
import com.shifthackz.flatboard.keyboard.numeric.custom.RandomNumeric

class NumericDetailAdapter(
    var lastSelectedPosition: Int = -1
) : ListAdapter<BaseNumeric, NumericDetailAdapter.NumericDetailViewHolder>(DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NumericDetailViewHolder(ItemNumericDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: NumericDetailViewHolder, position: Int) {
        holder.bind(getItem(position), (position == lastSelectedPosition))
    }

    inner class NumericDetailViewHolder(
        val binding: ItemNumericDetailBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(numeric: BaseNumeric, checked: Boolean) {
            when (numeric) { is RandomNumeric -> numeric.generate() }
            binding.rbSelectedNumericDetail.isChecked = checked
            binding.tvNumericNameDetail.text = numeric.getNumericName()
            binding.tvNumericRenderDetail.text = numeric.getRenderedSample()
            binding.root.setOnClickListener { onItemClick() }
            binding.rbSelectedNumericDetail.setOnClickListener { onItemClick() }
        }

        private fun onItemClick() {
            lastSelectedPosition = adapterPosition
            notifyDataSetChanged()
        }
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<BaseNumeric>() {
            override fun areItemsTheSame(
                oldItem: BaseNumeric,
                newItem: BaseNumeric
            ): Boolean = oldItem.getNumericName() == newItem.getNumericName()

            override fun areContentsTheSame(
                oldItem: BaseNumeric,
                newItem: BaseNumeric
            ): Boolean = oldItem == newItem
        }
    }
}