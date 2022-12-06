package com.taknikiniga.furnitureapp.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taknikiniga.furnitureapp.R
import com.taknikiniga.furnitureapp.databinding.NstdRcvBind
import com.taknikiniga.furnitureapp.databinding.SliderBind

class FurnitureNstdAdapter(var model: MutableList<FurnitureNstdModel>) : RecyclerView.Adapter<FurnitureNstdViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FurnitureNstdViewHolder {
      return  when(viewType){
          R.layout.slider_sec_lyt -> FurnitureNstdViewHolder.SliderSecVH(SliderBind.inflate(
              LayoutInflater.from(parent.context),parent,false))

          R.layout.nstd_rcv_lyt -> FurnitureNstdViewHolder.NstdRcvVH(NstdRcvBind.inflate(
              LayoutInflater.from(parent.context),parent,false))

          else -> throw java.lang.IllegalArgumentException("Invalid Viewtype")
      }
    }

    override fun onBindViewHolder(holder: FurnitureNstdViewHolder, position: Int) {
        when(holder){
            is FurnitureNstdViewHolder.NstdRcvVH -> holder.bind(model[position] as FurnitureNstdModel.FurnitureAdapter)
            is FurnitureNstdViewHolder.SliderSecVH -> holder.bind(model[position] as FurnitureNstdModel.SliderSec)
        }
    }

    override fun getItemCount(): Int  = model.size

    override fun getItemViewType(position: Int): Int {
        return when(model[position]){
            is FurnitureNstdModel.FurnitureAdapter -> R.layout.nstd_rcv_lyt
            is FurnitureNstdModel.SliderSec -> R.layout.slider_sec_lyt
        }
    }
}