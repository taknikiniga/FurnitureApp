package com.taknikiniga.furnitureapp.fragments.adapter

sealed class FurnitureModel {

    data class SliderSec(var image:String)
    data class ProductDetailImgSec(var image: String):FurnitureModel()
    data class ChipChapSec(var image:String,var productname:String):FurnitureModel()
    data class SelectedChipSec(var image:String,var productname: String,var productprice:String):FurnitureModel()
}