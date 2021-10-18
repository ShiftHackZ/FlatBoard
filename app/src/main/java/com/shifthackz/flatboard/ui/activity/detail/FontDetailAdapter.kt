package com.shifthackz.flatboard.ui.activity.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shifthackz.flatboard.databinding.ItemFontDetailBinding
import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.keyboard.font.custom.RandomFont

class FontDetailAdapter(
    var lastSelectedPosition: Int = -1
) : ListAdapter<BaseFont, FontDetailAdapter.FontDetailViewHolder>(DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FontDetailViewHolder(
        ItemFontDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: FontDetailViewHolder, position: Int) {
        holder.bind(getItem(position), (position == lastSelectedPosition))
    }

    inner class FontDetailViewHolder(
        private val binding: ItemFontDetailBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(font: BaseFont, checked: Boolean) {
            when (font) { is RandomFont -> font.generate() }
            binding.rbSelectedFontDetail.isChecked = checked
            binding.tvFontNameDetail.text = font.getFontName()
            binding.tvFontRenderDetail.text = font.getRenderedSample()
            binding.root.setOnClickListener { onClicked() }
            binding.rbSelectedFontDetail.setOnClickListener { onClicked() }
        }

        private fun onClicked() {
            lastSelectedPosition = adapterPosition
            notifyDataSetChanged()
        }
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<BaseFont>() {
            override fun areItemsTheSame(
                oldItem: BaseFont,
                newItem: BaseFont
            ): Boolean = oldItem.getFontName() == newItem.getFontName()

            override fun areContentsTheSame(
                oldItem: BaseFont,
                newItem: BaseFont
            ): Boolean = oldItem == newItem
        }
    }
}