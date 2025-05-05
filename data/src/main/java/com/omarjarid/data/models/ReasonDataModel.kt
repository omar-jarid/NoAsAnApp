package com.omarjarid.data.models

import com.google.gson.annotations.SerializedName
import com.omarjarid.domain.models.ReasonModel

data class ReasonDataModel(
    @SerializedName("reason")
    val reason: String? = ""
)

fun ReasonDataModel.toDomain(): ReasonModel = ReasonModel(reason.orEmpty())