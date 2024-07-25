package com.example.gigsandcare.ui.screen.signup

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gigsandcare.navigation.Screen
import com.example.gigsandcare.ui.screen.signup.component.SignUp
import com.example.gigsandcare.ui.screen.signup.component.SignUpContent
import com.example.gigsandcare.util.Constants.EMPTY_STRING
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val coroutineScope = rememberCoroutineScope()
    var email by rememberSaveable(
        stateSaver = TextFieldValue.Saver,
        init = {
            mutableStateOf(
                value = TextFieldValue(EMPTY_STRING)
            )
        }
    )
    var password by rememberSaveable(
        stateSaver = TextFieldValue.Saver,
        init = {
            mutableStateOf(
                value = TextFieldValue(EMPTY_STRING)
            )
        }
    )

    // to show pop up filled with google account option
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult(),
        onResult = { result ->
            if (result.resultCode == ComponentActivity.RESULT_OK) {
                coroutineScope.launch {
                    val signInResult = viewModel.signInWithIntentGoogle(
                        intent = result.data ?: return@launch
                    )
                    viewModel.onSignInGoogleResult(signInResult)
                }
            }
        }
    )

    SignUpContent(
        modifier = modifier,
        email = email,
        onEmailChange = {
            email = it
        },
        password = password,
        onPasswordChange = {
            password = it
        },
        onSignUpWithEmail = { email, password ->
            viewModel.signUpWithEmail(email, password)
        },
        onSignUpWithGoogle = {
            coroutineScope.launch {
                val signInIntentSender = viewModel.signInGoogle()
                launcher.launch(
                    IntentSenderRequest.Builder(
                        signInIntentSender ?: return@launch
                    ).build()
                )
            }
        },
        navigateBack = {
            navController.navigateUp()
        },
        navigateToSignInScreen = {
            navController.navigate(Screen.SignIn.route) {
                popUpTo(Screen.Welcome.route) {
                    inclusive = false
                }
            }
        }
    )

    SignUp(
        navigateToHomeScreen = {
            navController.popBackStack()
            navController.navigate(Screen.Dashboard.route) {
                popUpTo(Screen.Welcome.route) {
                    inclusive = true
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(navController = rememberNavController())
}