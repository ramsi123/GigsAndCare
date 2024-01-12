package com.example.gigsandcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.gigsandcare.components.SetStatusBarColor
import com.example.gigsandcare.ui.theme.GigsAndCareTheme
import com.example.gigsandcare.ui.theme.ghostWhite

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GigsAndCareTheme {
                SetStatusBarColor(color = ghostWhite)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GigsAndCareApp(activity = this)
                }
            }
        }
    }
}