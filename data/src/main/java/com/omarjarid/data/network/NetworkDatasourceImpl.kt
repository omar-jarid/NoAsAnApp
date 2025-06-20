package com.omarjarid.data.network

import com.omarjarid.data.datasources.NetworkDatasource
import com.omarjarid.data.models.toDomain
import com.omarjarid.domain.models.ReasonModel
import javax.inject.Inject

class NetworkDatasourceImpl @Inject constructor(
    private val apiInterface: ApiInterface
) : NetworkDatasource {

    override suspend fun getReason(): ReasonModel = apiInterface.getReason().toDomain()
}