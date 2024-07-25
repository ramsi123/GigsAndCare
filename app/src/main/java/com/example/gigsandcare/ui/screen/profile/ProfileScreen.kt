package com.example.gigsandcare.ui.screen.profile

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gigsandcare.ui.screen.profile.component.ProfileContent
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel(),
    navController: NavHostController,
    logOut: () -> Unit
) {
    val context = LocalContext.current
    var darkmode by remember { mutableStateOf(false) }
    var reminderSound by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val user by viewModel.user.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.getSignedInUser()
    }

    ProfileContent(
        modifier = modifier,
        user = user,
        editProfile = {},
        notificationSettings = {},
        darkMode = darkmode,
        onDarkModeChange = {
            darkmode = it
        },
        reminderSound = reminderSound,
        onReminderSoundChange = {
            reminderSound = it
        },
        logOut = {
            coroutineScope.launch {
                viewModel.signOut()
                Toast.makeText(
                    context,
                    "Signed out",
                    Toast.LENGTH_LONG
                ).show()

                logOut()
            }
        }
    )
}