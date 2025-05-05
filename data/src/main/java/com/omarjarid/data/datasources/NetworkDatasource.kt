package com.omarjarid.data.datasources

import com.omarjarid.domain.models.ReasonModel

interface NetworkDatasource { suspend fun getReason(): ReasonModel }