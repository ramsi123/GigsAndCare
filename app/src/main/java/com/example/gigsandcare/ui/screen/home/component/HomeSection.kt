package com.example.gigsandcare.ui.screen.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeSection(
    modifier: Modifier = Modifier,
    title: String,
    viewAll: String,
    navigateToListScreen: () -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionText(
            title = title,
            viewAll = viewAll,
            navigateToListScreen = { navigateToListScreen() }
        )
        content()
    }
}