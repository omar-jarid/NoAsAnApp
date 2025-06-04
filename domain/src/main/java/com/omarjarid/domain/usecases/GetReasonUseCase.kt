package com.omarjarid.domain.usecases

import com.omarjarid.domain.base.Result
import com.omarjarid.domain.models.ReasonModel
import com.omarjarid.domain.repositories.ReasonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetReasonUseCase @Inject constructor(private val repository: ReasonRepository) {
    operator fun invoke(): Flow<Result<ReasonModel>> = flow {
        try {
            val result = repository.getReason()
            emit(Result.Success(result))
        } catch (e: Exception) { emit(Result.Failure(e)) }
    }
}