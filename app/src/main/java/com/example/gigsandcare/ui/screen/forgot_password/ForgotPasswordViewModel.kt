package com.example.gigsandcare.ui.screen.forgot_password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agrisight.ui.common.UiState
import com.example.gigsandcare.data.GigsAndCareRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val repository: GigsAndCareRepository
) : ViewModel() {

    var resetPasswordState by mutableStateOf<UiState<Boolean>>(UiState.Idle)
        private set

    fun resetPassword(email: String) = viewModelScope.launch {
        resetPasswordState = UiState.Loading
        resetPasswordState = repository.resetPassword(email) ?: UiState.Success(false)
    }

}