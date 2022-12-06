package com.taknikiniga.furnitureapp.fragments.utils

import android.content.Context
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.taknikiniga.furnitureapp.R
import com.taknikiniga.furnitureapp.databinding.ProgressBarLytBinding
import javax.inject.Inject

class ProgressDialog  (private val context: Context) {

    lateinit var binding : ProgressBarLytBinding
    val dialog = MaterialAlertDialogBuilder(context).create()

    fun showDialogue(){
        binding = ProgressBarLytBinding.inflate(LayoutInflater.from(context))
        dialog.setView(binding!!.root)
        binding!!.prgcTxtData.text="Loading Data"
        dialog.show()

    }

    fun dismissDialog(){
        dialog.dismiss()
    }

}