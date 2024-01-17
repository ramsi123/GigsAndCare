package com.example.gigsandcare.ui.screen.history

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    var totalPeoplesHelped by remember { mutableIntStateOf(0) }
    var totalDonation by remember { mutableIntStateOf(0) }
    var totalProgram by remember { mutableIntStateOf(0) }
    val user by viewModel.user.collectAsState()
    val userHistory by viewModel.userHistory.collectAsState()
    val userHistoryData by viewModel.userHistoryData.collectAsState()
    val convertedUserHistory by viewModel.convertedUserHistory.collectAsState()

    // get signed user and user donation history
    LaunchedEffect(key1 = true) {
        viewModel.getSignedInUser()
        viewModel.getUserHistory()
        viewModel.getUserHistoryData()
    }

    // calculate user's activity and convert it from UserDonation into UserHistory
    LaunchedEffect(key1 = userHistoryData) {
        for (data in userHistoryData) {
            totalPeoplesHelped += data.peoplesHelped
            totalDonation += data.totalSpend
            totalProgram += data.totalCharityProgram
        }
        if (userHistory.isNotEmpty()) {
            viewModel.getConvertedUserHistory(
                userHistory,
                totalPeoplesHelped,
                totalDonation,
                totalProgram
            )
        }
    }

    HistoryContent(
        modifier = modifier,
        user = user,
        userHistory = if (userHistoryData.isNotEmpty()) convertedUserHistory else userHistory
    )
}