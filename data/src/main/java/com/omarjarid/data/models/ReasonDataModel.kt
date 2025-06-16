package com.omarjarid.data.models

import com.omarjarid.domain.models.ReasonModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReasonDataModel(
    @SerialName("reason")
    val reason: String
)

fun ReasonDataModel.toDomain(): ReasonModel = ReasonModel(reason)