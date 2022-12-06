package com.taknikiniga.furnitureapp.fragments.adapter

sealed class FurnitureNstdModel {

    data class SliderSec(var image:String):FurnitureNstdModel()
    data class FurnitureAdapter(var catname:String,var data:MutableList<FurnitureModel>):FurnitureNstdModel()
}