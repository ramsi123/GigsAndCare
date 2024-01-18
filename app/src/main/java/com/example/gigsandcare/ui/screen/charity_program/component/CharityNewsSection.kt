package com.example.gigsandcare.ui.screen.charity_program.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.gigsandcare.ui.screen.home.component.HomeSection

@Composable
fun CharityNewsSection(
    modifier: Modifier = Modifier,
    title: String,
    viewAll: String,
    navigateToListScreen: () -> Unit,
    content: @Composable () -> Unit
) {
    HomeSection(
        modifier = modifier,
        title = title,
        viewAll = viewAll,
        navigateToListScreen = navigateToListScreen,
        content = content
    )
}