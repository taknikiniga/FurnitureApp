package com.taknikiniga.furnitureapp.fragments.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.taknikiniga.furnitureapp.databinding.NstdRcvBind
import com.taknikiniga.furnitureapp.databinding.SliderBind

sealed class FurnitureNstdViewHolder (binding:View):RecyclerView.ViewHolder(binding){

    class SliderSecVH(private val binding:SliderBind) : FurnitureNstdViewHolder(binding.root){
        fun bind(item:FurnitureNstdModel.SliderSec){

        }
    }

    class NstdRcvVH(private val binding:NstdRcvBind):FurnitureNstdViewHolder(binding.root){
        fun bind(item:FurnitureNstdModel.FurnitureAdapter){
            binding.data = item
        }
    }
}