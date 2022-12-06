package com.taknikiniga.furnitureapp.fragments.utils

import android.os.Build
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.taknikiniga.furnitureapp.R

@BindingAdapter("app:bind")
fun ImageView.bind(url: String) {
    Glide.with(this.context).load(url)
        .placeholder(R.drawable.ic_baseline_favorite_24)
        .into(this)
}

@RequiresApi(Build.VERSION_CODES.M)
@BindingAdapter("app:text")
fun TextView.textbind(text: String) {
    val simpleSpanBuilder = SimpleSpanBuilder(this.context)
    simpleSpanBuilder.append("Modern ",1)
    simpleSpanBuilder.append("Furniture ",2)
    simpleSpanBuilder.append("\nFor your ",2)
    simpleSpanBuilder.append("Dream House. ",1)
    this.text = simpleSpanBuilder.build()

}