package com.example.gigsandcare.ui.screen.program_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gigsandcare.navigation.Screen
import com.example.gigsandcare.ui.screen.program_list.component.ProgramListContent
import com.example.gigsandcare.util.Constants.PROGRAMS

@Composable
fun ProgramListScreen(
    modifier: Modifier = Modifier,
    viewModel: ProgramListViewModel = hiltViewModel(),
    navController: NavHostController
) {
    var search by remember { mutableStateOf("") }
    val programs by viewModel.programs.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.getPrograms()
    }

    ProgramListContent(
        modifier = modifier,
        title = PROGRAMS,
        programs = programs,
        search = search,
        onSearchChange = {
            search = it
        },
        navigateToProgramDetailScreen = { programId ->
            navController.navigate(
                Screen.ProgramDetail.programDetailRoute(
                bannerId = -1,
                programId = programId,
                charityProgramId = -1,
                concertId = -1
            ))
        }
    )
}