package com.taknikiniga.furnitureapp.networking.retrofit.instance

import android.accounts.NetworkErrorException
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.SocketTimeoutException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProvideInstance {

    const val BASE_URL = "http://10.0.0.52:4000/"

    val client : OkHttpClient = OkHttpClient.Builder().readTimeout(60,TimeUnit.MINUTES).build()

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return try {
            Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory
                    .create())
                .client(client)
                .build()
                .create(ApiService::class.java)
        }catch (e:Exception){
            throw SocketTimeoutException(e.message)
        }
    }

}