package com.example.gigsandcare.ui.screen.signin

import android.content.Intent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agrisight.ui.common.UiState
import com.example.gigsandcare.data.GigsAndCareRepository
import com.example.gigsandcare.ui.screen.signin.component.SignInResult
import com.example.gigsandcare.ui.screen.signin.component.SignInState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: GigsAndCareRepository
) : ViewModel() {

    private val _googleAccountState = MutableStateFlow(SignInState())
    val googleAccountState = _googleAccountState.asStateFlow()

    var signInEmailState by mutableStateOf<UiState<Boolean>>(UiState.Idle)
        private set

    suspend fun signInGoogle() = repository.signInGoogle()
    suspend fun signInWithIntentGoogle(intent: Intent) = repository.signInWithIntentGoogle(intent)

    fun onSignInGoogleResult(result: SignInResult) {
        val signInResult = repository.onSignInGoogleResult(result)
        _googleAccountState.update { it.copy(
            isSignInSuccessful = signInResult.data != null,
            signInError = signInResult.errorMessage
        ) }
    }

    fun resetGoogleAccountState() {
        _googleAccountState.update { repository.resetGoogleAccountState() }
    }

    fun signInWithEmail(email: String, password: String) = viewModelScope.launch {
        signInEmailState = UiState.Loading
        signInEmailState =
            repository.signInWithEmail(email, password) ?: UiState.Success(false)
    }

}