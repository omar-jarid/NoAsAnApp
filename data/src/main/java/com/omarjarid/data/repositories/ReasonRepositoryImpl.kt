package com.omarjarid.data.repositories

import com.omarjarid.data.datasources.NetworkDatasource
import com.omarjarid.domain.models.ReasonModel
import com.omarjarid.domain.repositories.ReasonRepository
import javax.inject.Inject

class ReasonRepositoryImpl @Inject constructor(
    private val networkDatasource: NetworkDatasource
) : ReasonRepository {

    override suspend fun getReason(): ReasonModel = networkDatasource.getReason()
}