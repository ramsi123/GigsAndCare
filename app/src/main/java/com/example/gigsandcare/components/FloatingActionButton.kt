package com.example.gigsandcare.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.runtime.Composable
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import com.example.gigsandcare.ui.theme.colorPrimary
import com.example.gigsandcare.ui.theme.ghostWhite

@Composable
fun FloatingActionButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
        containerColor = colorPrimary,
        contentColor = ghostWhite
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = null)
    }
}