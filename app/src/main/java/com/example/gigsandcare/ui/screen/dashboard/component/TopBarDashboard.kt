package com.example.gigsandcare.ui.screen.dashboard.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import com.example.gigsandcare.R
import com.example.gigsandcare.ui.theme.colorPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarDashboard(
    modifier: Modifier = Modifier,
    title: String
) {
    CenterAlignedTopAppBar(
        modifier =  modifier.fillMaxWidth(),
        title = {
            Text(
                text = title,
                color = Color.White,
                style = TextStyle(
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily(Font((R.font.josefin_sans_semibold_italic))),
                    fontSize = 22.sp
                )
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = colorPrimary)
    )
}