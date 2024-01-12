package com.example.gigsandcare.ui.screen.program_detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gigsandcare.di.Injection
import com.example.gigsandcare.ui.ViewModelFactory
import com.example.gigsandcare.ui.screen.program_detail.component.ProgramDetailContent

@Composable
fun ProgramDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: ProgramDetailViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideGigsAndCareRepository(LocalContext.current))
    ),
    navController: NavHostController,
    bannerId: Int,
    programId: Int
) {
    val bannerDetail by viewModel.bannerDetail.collectAsState()
    val programDetail by viewModel.programDetail.collectAsState()

    LaunchedEffect(key1 = true) {
        if (bannerId == -1) {
            viewModel.getProgramDetail(programId)
        } else {
            viewModel.getBannerDetail(bannerId)
        }
    }

    ProgramDetailContent(
        modifier = modifier,
        program = if (bannerId == -1) programDetail else bannerDetail
    )
}