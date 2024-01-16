package com.example.gigsandcare.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gigsandcare.ui.ViewModelFactory
import com.example.gigsandcare.di.Injection
import com.example.gigsandcare.navigation.Screen
import com.example.gigsandcare.ui.screen.home.component.HomeContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideGigsAndCareRepository(LocalContext.current))
    ),
    navController: NavHostController
) {
    val context = LocalContext.current
    var search by remember { mutableStateOf("") }
    val programs by viewModel.programs.collectAsState()

    // get programs
    LaunchedEffect(key1 = true) {
        viewModel.getPrograms()
    }

    HomeContent(
        modifier = modifier,
        context = context,
        programs = programs,
        search = search,
        onSearchChange = {
            search = it
        },
        navigateToBannerDetailScreen = { bannerId ->
            navController.navigate(Screen.ProgramDetail.programDetailRoute(
                bannerId = bannerId,
                programId = -1,
                charityProgramId = -1,
                concertId = -1
            ))
        },
        navigateToProgramDetailScreen = { programId ->
            navController.navigate(Screen.ProgramDetail.programDetailRoute(
                bannerId = -1,
                programId = programId,
                charityProgramId = -1,
                concertId = -1
            ))
        },
        navigateToCharityProgram = {
            navController.navigate(Screen.CharityProgram.route)
        },
        navigateToUpcomingConcert = {},
        navigateToCharityNews = {},
        navigateToEventCalendar = {}
    )
}