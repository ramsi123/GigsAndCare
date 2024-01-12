package com.example.gigsandcare.ui.screen.signin.component

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gigsandcare.ui.ViewModelFactory
import com.example.agrisight.ui.common.UiState
import com.example.gigsandcare.ui.screen.signin.SignInViewModel
import com.example.gigsandcare.components.ProgressBar
import com.example.gigsandcare.di.Injection

@Composable
fun SignIn(
    viewModel: SignInViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideGigsAndCareRepository(LocalContext.current))
    ),
    navigateToHomeScreen: () -> Unit
) {
    val context = LocalContext.current
    val signInGoogleState by viewModel.googleAccountState.collectAsStateWithLifecycle()
    val signInEmailState = viewModel.signInEmailState

    // Error handling for sign in with google
    LaunchedEffect(key1 = signInGoogleState.signInError) {
        signInGoogleState.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    // Success handling for sign in with google
    LaunchedEffect(key1 = signInGoogleState.isSignInSuccessful) {
        if (signInGoogleState.isSignInSuccessful) {
            Toast.makeText(
                context,
                "Sign In Success",
                Toast.LENGTH_LONG
            ).show()

            navigateToHomeScreen()
            viewModel.resetGoogleAccountState()
        }
    }

    // handling for sign in with email
    when (signInEmailState) {
        is UiState.Idle -> {
            Unit
        }
        is UiState.Loading -> {
            ProgressBar()
        }
        is UiState.Success -> {
            LaunchedEffect(key1 = signInEmailState) {
                Toast.makeText(context, "Sign In Success", Toast.LENGTH_SHORT).show()
                navigateToHomeScreen()
            }
        }
        is UiState.Error -> signInEmailState.apply {
            LaunchedEffect(key1 = signInEmailState) {
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}