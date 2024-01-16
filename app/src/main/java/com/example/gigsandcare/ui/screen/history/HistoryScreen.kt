package com.example.gigsandcare.ui.screen.history

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gigsandcare.di.Injection
import com.example.gigsandcare.ui.ViewModelFactory
import com.example.gigsandcare.ui.screen.history.component.HistoryContent

@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    viewModel: HistoryViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideGigsAndCareRepository(LocalContext.current))
    ),
    navController: NavHostController
) {
    val user by viewModel.user.collectAsState()
    val userHistory by viewModel.userHistory.collectAsState()

    // get signed user and user donation history
    LaunchedEffect(key1 = true) {
        viewModel.getSignedInUser()
        viewModel.getUserHistory()
    }

    HistoryContent(
        modifier = modifier,
        user = user,
        userHistory = userHistory
    )
}