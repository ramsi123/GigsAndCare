package com.example.gigsandcare.ui.screen.upcoming_concert.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.gigsandcare.data.model.Program
import com.example.gigsandcare.ui.screen.program_list.component.ProgramListContent

@Composable
fun UpcomingConcertContent(
    modifier: Modifier = Modifier,
    title: String,
    concerts: List<Program>,
    search: String,
    onSearchChange: (String) -> Unit,
    navigateToProgramDetailScreen: (Int) -> Unit
) {
    ProgramListContent(
        modifier = modifier,
        title = title,
        programs = concerts,
        search = search,
        onSearchChange = {
            onSearchChange(it)
        },
        navigateToProgramDetailScreen = navigateToProgramDetailScreen
    )
}