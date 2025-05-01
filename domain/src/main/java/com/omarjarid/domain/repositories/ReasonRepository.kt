package com.omarjarid.domain.repositories

import com.omarjarid.domain.models.ReasonModel

interface ReasonRepository { suspend fun getReason(): ReasonModel }