package com.taknikiniga.furnitureapp.fragments.onboarding.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.taknikiniga.furnitureapp.R
import com.taknikiniga.furnitureapp.fragments.onboarding.custombind.OnboardBinding
import com.taknikiniga.furnitureapp.fragments.onboarding.repository.OnboardRepo
import com.taknikiniga.furnitureapp.fragments.utils.ProgressDialog
import com.taknikiniga.furnitureapp.networking.retrofit.utils.ApiCallState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardViewModel @Inject constructor(
    private val onboardRepo: OnboardRepo,
) : ViewModel() {

    lateinit var progressDialog: ProgressDialog
    lateinit var bind:OnboardBinding

    fun getStart(view: View) {
        view.findNavController().navigate(R.id.action_navOnboard_to_navHome)
    }

    fun getOnboardData(view: View) = viewModelScope.launch {
        progressDialog = ProgressDialog(view.context)

        onboardRepo.getOnboardData().collectLatest {
            when(it){
                is ApiCallState.Error -> {
                    progressDialog.dismissDialog()
                }
                ApiCallState.Loading -> {
                    progressDialog.showDialogue()
                }
                is ApiCallState.Success -> {
                    progressDialog.dismissDialog()
                    when(it.data.status){
                        212 ->{
                            CoroutineScope(Dispatchers.Main).launch {
                                it.data.data?.let { data ->
                                    data.forEach { its ->

                                        its.data.forEach { datas ->
                                            bind.slogstitle = datas.slogs
                                            bind.image = data[0].data[0].image
                                            bind.slogsdesc = datas.slogsDesc
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }

}