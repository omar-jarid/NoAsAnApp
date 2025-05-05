package com.omarjarid.data.network

import com.omarjarid.domain.models.ReasonModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("no")
    suspend fun getReason(): Response<ReasonModel>
}