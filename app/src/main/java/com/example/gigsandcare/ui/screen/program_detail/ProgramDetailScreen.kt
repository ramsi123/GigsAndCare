package com.example.gigsandcare.ui.screen.program_detail

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gigsandcare.components.DonationBottomSheet
import com.example.gigsandcare.data.model.UserDonation
import com.example.gigsandcare.di.Injection
import com.example.gigsandcare.navigation.Screen
import com.example.gigsandcare.ui.ViewModelFactory
import com.example.gigsandcare.ui.screen.program_detail.component.ProgramDetailContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgramDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: ProgramDetailViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideGigsAndCareRepository(LocalContext.current))
    ),
    navController: NavHostController,
    bannerId: Int,
    programId: Int,
    charityProgramId: Int,
    concertId: Int
) {
    var showSheet by remember { mutableStateOf(false) }
    var amount by remember { mutableStateOf("") }
    //val sheetState = rememberModalBottomSheetState()
    val bannerDetail by viewModel.bannerDetail.collectAsState()
    val programDetail by viewModel.programDetail.collectAsState()
    val charityProgramDetail by viewModel.charityProgramDetail.collectAsState()
    val concertDetail by viewModel.concertDetail.collectAsState()

    // to get data for program detail or banner detail
    LaunchedEffect(key1 = true) {
        if (programId == -1 && charityProgramId == -1 && concertId == -1) {
            viewModel.getBannerDetail(bannerId)
        } else if (bannerId == -1 && charityProgramId == -1 && concertId == -1) {
            viewModel.getProgramDetail(programId)
        } else if (bannerId == -1 && programId == -1 && concertId == -1) {
            viewModel.getCharityProgramDetail(charityProgramId)
        } else if (bannerId == -1 && programId == -1 && charityProgramId == -1) {
            viewModel.getConcertDetail(concertId)
        }
    }

    if (showSheet) {
        DonationBottomSheet(
            sheetState = rememberModalBottomSheetState(),
            amount = amount,
            onAmountChange = {
                amount = it
            },
            onDismiss = {
                showSheet = false
            },
            onClickDonate = {
                showSheet = false
                viewModel.addDonation(
                    userDonation = UserDonation(
                        peoplesHelped = 100,
                        totalSpend = amount.toInt(),
                        totalCharityProgram = 1
                    )
                )
                navController.navigate(Screen.SuccessDonation.route)
            }
        )
    }

    ProgramDetailContent(
        modifier = modifier,
        program = if (programId == -1 && charityProgramId == -1 && concertId == -1) {
            bannerDetail
        } else if (bannerId == -1 && charityProgramId == -1 && concertId == -1) {
            programDetail
        } else if (bannerId == -1 && programId == -1 && concertId == -1) {
            charityProgramDetail
        } else {
            concertDetail
        },
        onClickBuyTicketAndDonation = {
            if (programId == -1 && charityProgramId == -1 && concertId == -1) {
                navController.navigate(
                    Screen.BuyTicket.buyDetailRoute(
                        title = bannerDetail.title,
                        organizer = bannerDetail.organizer,
                        price = bannerDetail.price
                    )
                )
            } else if (bannerId == -1 && charityProgramId == -1 && concertId == -1) {
                navController.navigate(
                    Screen.BuyTicket.buyDetailRoute(
                        title = programDetail.title,
                        organizer = programDetail.organizer,
                        price = programDetail.price
                    )
                )
            } else if (bannerId == -1 && programId == -1 && concertId == -1) {
                navController.navigate(
                    Screen.BuyTicket.buyDetailRoute(
                        title = charityProgramDetail.title,
                        organizer = charityProgramDetail.organizer,
                        price = charityProgramDetail.price
                    )
                )
            } else if (bannerId == -1 && programId == -1 && charityProgramId == -1) {
                navController.navigate(
                    Screen.BuyTicket.buyDetailRoute(
                        title = concertDetail.title,
                        organizer = concertDetail.organizer,
                        price = concertDetail.price
                    )
                )
            }
        },
        onClickDonationOnly = {
            showSheet = true
        }
    )
}