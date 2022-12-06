package com.taknikiniga.furnitureapp.fragments.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

import com.taknikiniga.furnitureapp.databinding.ChipSecBind
import com.taknikiniga.furnitureapp.databinding.ProductImgRcvBind
import com.taknikiniga.furnitureapp.databinding.SelectedLytBind

sealed class FurnitureViewHolder(binding: View) : RecyclerView.ViewHolder(binding) {

    class ChipChapVH(private val binding: ChipSecBind) : FurnitureViewHolder(binding.root) {
        fun bind(item: FurnitureModel.ChipChapSec) {
            binding.bind = item
        }
    }

    class SelectedChipVH(private val binding: SelectedLytBind) : FurnitureViewHolder(binding.root) {
        fun bind(item: FurnitureModel.SelectedChipSec) {
            binding.bind = item
        }
    }

    class ProductImgVH(private val binding: ProductImgRcvBind) :
        FurnitureViewHolder(binding.root) {
        fun bind(item: FurnitureModel.ProductDetailImgSec) {
            binding.bind = item
        }
    }


}