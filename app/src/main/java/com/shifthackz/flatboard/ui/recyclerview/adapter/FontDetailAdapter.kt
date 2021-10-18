package com.shifthackz.flatboard.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.shifthackz.flatboard.databinding.ItemFontDetailBinding
import com.shifthackz.flatboard.keyboard.font.base.BaseFont
import com.shifthackz.flatboard.ui.base.BaseAdapter
import com.shifthackz.flatboard.ui.recyclerview.viewholder.FontDetailViewHolder

class FontDetailAdapter (
        private val context: Context,
        private val fonts: List<BaseFont>,
        var lastSelectedPosition: Int = -1
) : BaseAdapter<FontDetailViewHolder, BaseFont>(fonts as MutableList<BaseFont>) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FontDetailViewHolder(
        ItemFontDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: FontDetailViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(fonts[position], (position == lastSelectedPosition))
        setupClickListeners(holder, position)
    }

    override fun getItemCount(): Int {
        return fonts.size
    }

    private fun setupClickListeners(holder: FontDetailViewHolder, position: Int) {
        holder.binding.root.setOnClickListener { handleItemClick(position) }
        holder.binding.rbSelectedFontDetail.setOnClickListener { handleItemClick(position) }
    }

    private fun handleItemClick(position: Int) {
        lastSelectedPosition = position
        notifyDataSetChanged()
    }

}