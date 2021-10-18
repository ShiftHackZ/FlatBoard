package com.shifthackz.flatboard.ui.recyclerview.adapter

import com.shifthackz.flatboard.keyboard.numeric.base.BaseNumeric
import com.shifthackz.flatboard.ui.recyclerview.viewholder.NumericDetailViewHolder
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.shifthackz.flatboard.databinding.ItemNumericDetailBinding
import com.shifthackz.flatboard.ui.base.BaseAdapter

class NumericDetailAdapter (
        private val context: Context,
        private val numerics: List<BaseNumeric>,
        var lastSelectedPosition: Int = -1
) : BaseAdapter<NumericDetailViewHolder, BaseNumeric>(numerics as MutableList<BaseNumeric>) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NumericDetailViewHolder(ItemNumericDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: NumericDetailViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(numerics[position], (position == lastSelectedPosition))
        holder.binding.root.setOnClickListener {
            lastSelectedPosition = position
            notifyDataSetChanged()
        }
        holder.binding.rbSelectedNumericDetail.setOnClickListener {
            lastSelectedPosition = position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = numerics.size
}