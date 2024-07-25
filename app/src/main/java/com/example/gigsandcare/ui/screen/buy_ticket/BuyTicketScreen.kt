package com.example.gigsandcare.ui.screen.buy_ticket

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gigsandcare.data.model.UserDonation
import com.example.gigsandcare.navigation.Screen
import com.example.gigsandcare.ui.screen.buy_ticket.component.BuyTicketContent

@Composable
fun BuyTicketScreen(
    modifier: Modifier = Modifier,
    viewModel: BuyTicketViewModel = hiltViewModel(),
    navController: NavHostController,
    title: String,
    organizer: String,
    price: Int
) {
    BuyTicketContent(
        modifier = modifier,
        title = title,
        organizer = organizer,
        price = price,
        onClickPaid = {
            viewModel.addDonation(
                userDonation = UserDonation(
                    peoplesHelped = 100,
                    totalSpend = price / 10,
                    totalCharityProgram = 1
                )
            )
            navController.navigate(Screen.SuccessDonation.route)
        }
    )
}