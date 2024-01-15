package com.example.gigsandcare.ui.screen.success_donation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.gigsandcare.navigation.Screen
import com.example.gigsandcare.ui.screen.success_donation.component.SuccessDonationContent

@Composable
fun SuccessDonationScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    SuccessDonationContent(
        onClickBackToHome = {
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Home.route) {
                    inclusive = true
                }
            }
        }
    )
}