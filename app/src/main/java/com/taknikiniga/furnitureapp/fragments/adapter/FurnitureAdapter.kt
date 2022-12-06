package com.taknikiniga.furnitureapp.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.taknikiniga.furnitureapp.R
import com.taknikiniga.furnitureapp.databinding.ChipSecBind
import com.taknikiniga.furnitureapp.databinding.ProductImgRcvBind
import com.taknikiniga.furnitureapp.databinding.SelectedLytBind

class FurnitureAdapter : ListAdapter<FurnitureModel, FurnitureViewHolder>(FurnitureDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FurnitureViewHolder {
        return when (viewType) {
            R.layout.chip_chap_sec_lyt -> FurnitureViewHolder.ChipChapVH(ChipSecBind.inflate(
                LayoutInflater.from(parent.context),parent,false))

            R.layout.selected_chip_item_lyt -> FurnitureViewHolder.SelectedChipVH(SelectedLytBind.inflate(
                LayoutInflater.from(parent.context),parent,false))

            R.layout.product_details_image_lyt -> FurnitureViewHolder.ProductImgVH(ProductImgRcvBind.inflate(
                LayoutInflater.from(parent.context),parent,false))
            else -> throw IllegalArgumentException("Invalid ViewType")
        }
    }

    override fun onBindViewHolder(holder: FurnitureViewHolder, position: Int) {
        when (holder) {
            is FurnitureViewHolder.ChipChapVH -> holder.bind(getItem(position) as FurnitureModel.ChipChapSec)
            is FurnitureViewHolder.SelectedChipVH -> holder.bind(getItem(position) as FurnitureModel.SelectedChipSec)
            is FurnitureViewHolder.ProductImgVH -> holder.bind(getItem(position) as FurnitureModel.ProductDetailImgSec)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is FurnitureModel.ChipChapSec -> R.layout.chip_chap_sec_lyt
            is FurnitureModel.SelectedChipSec -> R.layout.selected_chip_item_lyt
            is FurnitureModel.ProductDetailImgSec -> R.layout.product_details_rcv_img_item
        }
    }
}