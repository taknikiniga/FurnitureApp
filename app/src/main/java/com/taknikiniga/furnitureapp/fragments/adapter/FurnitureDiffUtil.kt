package com.taknikiniga.furnitureapp.fragments.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.DiffResult

class FurnitureDiffUtil : DiffUtil.ItemCallback<FurnitureModel>() {
    override fun areItemsTheSame(oldItem: FurnitureModel, newItem: FurnitureModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: FurnitureModel, newItem: FurnitureModel): Boolean {
        return oldItem == newItem
    }
}