package com.taknikiniga.furnitureapp.fragments.onboarding.custombind

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.library.baseAdapters.BR
import com.bumptech.glide.Glide
import com.taknikiniga.furnitureapp.R
import javax.inject.Inject

class OnboardBinding @Inject constructor() : BaseObservable() {
    @get:Bindable
    var slogstitle: String? = null
        set(value) {
            field = value
            notifyPropertyChanged( BR.slogstitle)
        }

    @get:Bindable
    var slogsdesc: String? = null
        set(value) {
            field = value
            notifyPropertyChanged( BR.slogsdesc)
        }

    @get:Bindable
    var image: String? = null
        set(value) {
            field = value
            notifyPropertyChanged( BR.image)
        }

//     companion object{
//         @JvmStatic
//         @BindingAdapter("imagebind","placeholder")
//         fun bind(view:ImageView,url: String="",placeholder:Drawable) {
//
//             try {
//                 if (url.isNullOrEmpty()){
//                     view.setImageDrawable(placeholder)
//                 }else{
//                     Glide.with(view).load(url)
//                         .placeholder(R.drawable.ic_baseline_favorite_24)
//                         .into(view)
//                 }
//             }catch (e:Exception){
//                 e.printStackTrace()
//             }
//
//
//
//         }
//     }


}