package com.omarjarid.noasanapp.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omarjarid.domain.base.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    private val _error = MutableSharedFlow<Exception>(extraBufferCapacity = 1)
    val error: SharedFlow<Exception> = _error.asSharedFlow()

    suspend fun <T> Flow<Result<T>>.collectResult(onSuccess: (T) -> Unit) = collect { result ->
        when (result) {
            is Result.Success -> result.value?.let { onSuccess(it) }
            is Result.Failure -> viewModelScope.launch { _error.emit(result.e) }
        }
    }
}