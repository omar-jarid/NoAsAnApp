package com.omarjarid.data.network

import com.omarjarid.data.models.ReasonDataModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("no")
    suspend fun getReason(): Response<ReasonDataModel>
}