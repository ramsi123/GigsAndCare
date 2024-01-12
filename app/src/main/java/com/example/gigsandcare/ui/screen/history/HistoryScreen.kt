package com.example.gigsandcare.ui.screen.history

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.gigsandcare.ui.screen.history.component.HistoryContent

@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    HistoryContent(modifier = modifier)
}