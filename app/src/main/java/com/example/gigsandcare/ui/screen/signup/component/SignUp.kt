package com.example.gigsandcare.ui.screen.signup.component

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gigsandcare.ui.ViewModelFactory
import com.example.agrisight.ui.common.UiState
import com.example.gigsandcare.ui.screen.signup.SignUpViewModel
import com.example.gigsandcare.components.ProgressBar
import com.example.gigsandcare.di.Injection

@Composable
fun SignUp(
    viewModel: SignUpViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideGigsAndCareRepository(LocalContext.current))
    ),
    navigateToHomeScreen: () -> Unit
) {
    val context = LocalContext.current
    val state by viewModel.googleAccountState.collectAsStateWithLifecycle()
    val signUpEmailState = viewModel.signUpEmailState

    // Error handling for sign up with google
    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    // Success handling for sign up with google
    LaunchedEffect(key1 = state.isSignInSuccessful) {
        if (state.isSignInSuccessful) {
            Toast.makeText(
                context,
                "Sign up successful",
                Toast.LENGTH_LONG
            ).show()

            navigateToHomeScreen()
            viewModel.resetGoogleAccountState()
        }
    }

    // handling for sign up with email
    when (signUpEmailState) {
        is UiState.Idle -> {
            Unit
        }
        is UiState.Loading -> {
            ProgressBar()
        }
        is UiState.Success -> {
            LaunchedEffect(key1 = signUpEmailState) {
                Toast.makeText(context, "Sign Up Success", Toast.LENGTH_SHORT).show()
                navigateToHomeScreen()
            }
        }
        is UiState.Error -> signUpEmailState.apply {
            LaunchedEffect(key1 = signUpEmailState) {
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}