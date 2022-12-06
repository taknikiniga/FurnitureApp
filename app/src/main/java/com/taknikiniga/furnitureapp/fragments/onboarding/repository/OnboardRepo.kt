package com.taknikiniga.furnitureapp.fragments.onboarding.repository

import com.taknikiniga.furnitureapp.networking.retrofit.instance.ApiService
import com.taknikiniga.furnitureapp.networking.retrofit.utils.result
import javax.inject.Inject

class OnboardRepo @Inject constructor(private val apiService: ApiService) {

    fun getOnboardData() = result {
        apiService.getOnboardData()
    }
}