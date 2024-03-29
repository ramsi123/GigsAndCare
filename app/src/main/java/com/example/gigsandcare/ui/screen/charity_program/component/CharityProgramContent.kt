package com.example.gigsandcare.ui.screen.charity_program.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.gigsandcare.data.model.Program
import com.example.gigsandcare.ui.screen.program_list.component.ProgramListContent

@Composable
fun CharityProgramContent(
    modifier: Modifier = Modifier,
    title: String,
    charityPrograms: List<Program>,
    search: String,
    onSearchChange: (String) -> Unit,
    navigateToProgramDetailScreen: (Int) -> Unit
) {
    ProgramListContent(
        modifier = modifier,
        title = title,
        programs = charityPrograms,
        search = search,
        onSearchChange = {
            onSearchChange(it)
        },
        navigateToProgramDetailScreen = navigateToProgramDetailScreen
    )
}