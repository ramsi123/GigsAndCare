package com.example.gigsandcare.ui.screen.buy_ticket

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.gigsandcare.navigation.Screen
import com.example.gigsandcare.ui.screen.buy_ticket.component.BuyTicketContent

@Composable
fun BuyTicketScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    title: String,
    organizer: String,
    price: Int
) {
    BuyTicketContent(
        title = title,
        organizer = organizer,
        price = price,
        onClickPaid = {
            navController.navigate(Screen.SuccessDonation.route)
        }
    )
}