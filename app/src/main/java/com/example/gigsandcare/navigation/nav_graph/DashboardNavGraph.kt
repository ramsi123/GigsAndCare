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
import com.example.gigsandcare.ui.screen.home.HomeScreen
import com.example.gigsandcare.ui.screen.profile.ProfileScreen
import com.example.gigsandcare.ui.screen.history.HistoryScreen
import com.example.gigsandcare.ui.screen.program_detail.ProgramDetailScreen

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
        composable(
            route = Screen.ProgramDetail.route,
            arguments = listOf(
                navArgument("bannerId") { type = NavType.IntType },
                navArgument("programId") { type = NavType.IntType }
            )
        ) {
            val bannerId = it.arguments?.getInt("bannerId") ?: -1
            val programId = it.arguments?.getInt("programId") ?: -1
            ProgramDetailScreen(
                navController = navController,
                bannerId = bannerId,
                programId = programId
            )
        }
    }
}
