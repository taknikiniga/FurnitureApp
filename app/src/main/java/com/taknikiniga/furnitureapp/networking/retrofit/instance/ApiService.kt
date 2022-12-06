package com.taknikiniga.furnitureapp.networking.retrofit.instance

import com.taknikiniga.furnitureapp.networking.retrofit.models.response.OnboardResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("get_onboard")
    suspend fun getOnboardData():Response<OnboardResponse>

}