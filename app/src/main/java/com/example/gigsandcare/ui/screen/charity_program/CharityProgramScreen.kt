package com.example.gigsandcare.ui.screen.charity_program

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gigsandcare.di.Injection
import com.example.gigsandcare.navigation.Screen
import com.example.gigsandcare.ui.ViewModelFactory
import com.example.gigsandcare.ui.screen.charity_program.component.CharityProgramContent

@Composable
fun CharityProgramScreen(
    modifier: Modifier = Modifier,
    viewModel: CharityProgramViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideGigsAndCareRepository(LocalContext.current))
    ),
    navController: NavHostController
) {
    var search by remember { mutableStateOf("") }
    val charityPrograms by viewModel.charityPrograms.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.getCharityPrograms()
    }

    CharityProgramContent(
        modifier = modifier,
        charityPrograms = charityPrograms,
        search = search,
        onSearchChange = {
            search = it
        },
        navigateToProgramDetailScreen = { charityProgramId ->
            navController.navigate(Screen.ProgramDetail.programDetailRoute(
                bannerId = -1,
                programId = -1,
                charityProgramId = charityProgramId,
                concertId = -1
            ))
        }
    )
}