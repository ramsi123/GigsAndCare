package com.example.gigsandcare.navigation.nav_graph

import androidx.activity.ComponentActivity
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.gigsandcare.navigation.DASHBOARD_ROUTE
import com.example.gigsandcare.navigation.Screen
import com.example.gigsandcare.ui.screen.buy_ticket.BuyTicketScreen
import com.example.gigsandcare.ui.screen.charity_news.CharityNewsScreen
import com.example.gigsandcare.ui.screen.charity_news_detail.CharityNewsDetailScreen
import com.example.gigsandcare.ui.screen.charity_program.CharityProgramScreen
import com.example.gigsandcare.ui.screen.event_calendar.EventCalendarScreen
import com.example.gigsandcare.ui.screen.home.HomeScreen
import com.example.gigsandcare.ui.screen.profile.ProfileScreen
import com.example.gigsandcare.ui.screen.history.HistoryScreen
import com.example.gigsandcare.ui.screen.program_detail.ProgramDetailScreen
import com.example.gigsandcare.ui.screen.program_list.ProgramListScreen
import com.example.gigsandcare.ui.screen.success_donation.SuccessDonationScreen
import com.example.gigsandcare.ui.screen.upcoming_concert.UpcomingConcertScreen

fun NavGraphBuilder.dashboardNavGraph(
    navController: NavHostController,
    activity: ComponentActivity,
    logOut: () -> Unit
) {
    navigation(
        startDestination = Screen.Home.route,
        route = DASHBOARD_ROUTE
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.History.route) {
            HistoryScreen(navController = navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(
                navController = navController,
                logOut = logOut
            )
        }
        composable(Screen.CharityProgram.route) {
            CharityProgramScreen(navController = navController)
        }
        composable(Screen.UpcomingConcert.route) {
            UpcomingConcertScreen(navController = navController)
        }
        composable(Screen.CharityNews.route) {
            CharityNewsScreen(navController = navController)
        }
        composable(
            route = Screen.CharityNewsDetail.route,
            arguments = listOf(
                navArgument("latestNewsId") { type = NavType.IntType },
                navArgument("recommendedTopicId") { type = NavType.IntType }
            )
        ) {
            val latestNewsId = it.arguments?.getInt("latestNewsId") ?: -1
            val recommendedTopicId = it.arguments?.getInt("recommendedTopicId") ?: -1
            CharityNewsDetailScreen(
                navController = navController,
                latestNewsId = latestNewsId,
                recommendedTopicId = recommendedTopicId
            )
        }
        composable(Screen.EventCalendar.route) {
            EventCalendarScreen(navController = navController)
        }
        composable(Screen.ProgramList.route) {
            ProgramListScreen(navController = navController)
        }
        composable(
            route = Screen.ProgramDetail.route,
            arguments = listOf(
                navArgument("bannerId") { type = NavType.IntType },
                navArgument("programId") { type = NavType.IntType },
                navArgument("charityProgramId") { type = NavType.IntType },
                navArgument("concertId") { type = NavType.IntType }
            )
        ) {
            val bannerId = it.arguments?.getInt("bannerId") ?: -1
            val programId = it.arguments?.getInt("programId") ?: -1
            val charityProgramId = it.arguments?.getInt("charityProgramId") ?: -1
            val concertId = it.arguments?.getInt("concertId") ?: -1
            ProgramDetailScreen(
                navController = navController,
                bannerId = bannerId,
                programId = programId,
                charityProgramId = charityProgramId,
                concertId = concertId
            )
        }
        composable(
            route = Screen.BuyTicket.route,
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("organizer") { type = NavType.StringType },
                navArgument("price") { type = NavType.IntType }
            )
        ) {
            val title = it.arguments?.getString("title")
            val organizer = it.arguments?.getString("organizer")
            val price = it.arguments?.getInt("price")
            BuyTicketScreen(
                navController = navController,
                title = title ?: "",
                organizer = organizer ?: "",
                price = price ?: 0
            )
        }
        composable(Screen.SuccessDonation.route) {
            SuccessDonationScreen(navController = navController)
        }
    }
}
