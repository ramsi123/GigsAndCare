package com.example.gigsandcare.ui.screen.upcoming_concert

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
import com.example.gigsandcare.di.Injection
import com.example.gigsandcare.navigation.Screen
import com.example.gigsandcare.ui.ViewModelFactory
import com.example.gigsandcare.ui.screen.program_list.component.ProgramListContent
import com.example.gigsandcare.ui.screen.upcoming_concert.component.UpcomingConcertContent
import com.example.gigsandcare.util.Constants.UPCOMING_CONCERT

@Composable
fun UpcomingConcertScreen(
    modifier: Modifier = Modifier,
    viewModel: UpcomingConcertViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideGigsAndCareRepository(LocalContext.current))
    ),
    navController: NavHostController
) {
    var search by remember { mutableStateOf("") }
    val concerts by viewModel.concerts.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.getConcerts()
    }

    UpcomingConcertContent(
        modifier = modifier,
        title = UPCOMING_CONCERT,
        concerts = concerts,
        search = search,
        onSearchChange = {
            search = it
        },
        navigateToProgramDetailScreen = { concertId ->
            navController.navigate(
                Screen.ProgramDetail.programDetailRoute(
                    bannerId = -1,
                    programId = -1,
                    charityProgramId = -1,
                    concertId = concertId
                ))
        }
    )
}