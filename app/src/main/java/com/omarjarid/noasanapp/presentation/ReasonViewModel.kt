package com.omarjarid.noasanapp.presentation

import androidx.lifecycle.viewModelScope
import com.omarjarid.domain.models.ReasonModel
import com.omarjarid.domain.usecases.GetReasonUseCase
import com.omarjarid.noasanapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReasonViewModel @Inject constructor(
    private val getReasonUseCase: GetReasonUseCase
) : BaseViewModel() {

    private val _reason = MutableStateFlow(ReasonModel(""))
    val reason: StateFlow<ReasonModel> = _reason

    fun getReason() {
        viewModelScope.launch {
            getReasonUseCase().collectResult { _reason.value = it }
        }
    }
}