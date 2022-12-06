package com.taknikiniga.furnitureapp.networking.retrofit.models.response


import com.google.gson.annotations.SerializedName

data class OnboardResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: Int
) {
    data class Data(
        @SerializedName("createdAt")
        val createdAt: String,
        @SerializedName("data")
        val `data`: List<Data>,
        @SerializedName("_id")
        val id: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("updatedAt")
        val updatedAt: String,
        @SerializedName("__v")
        val v: Int
    ) {
        data class Data(
            @SerializedName("_id")
            val id: String,
            @SerializedName("image")
            val image: String,
            @SerializedName("slogs")
            val slogs: String,
            @SerializedName("slogs_desc")
            val slogsDesc: String
        )
    }
}