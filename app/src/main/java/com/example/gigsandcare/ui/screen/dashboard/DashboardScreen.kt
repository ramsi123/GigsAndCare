package com.example.gigsandcare.ui.screen.dashboard

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gigsandcare.components.BottomBar
import com.example.gigsandcare.navigation.BASE_ROUTE
import com.example.gigsandcare.navigation.DASHBOARD_ROUTE
import com.example.gigsandcare.navigation.Screen
import com.example.gigsandcare.navigation.nav_graph.dashboardNavGraph

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    activity: ComponentActivity,
    logOut: () -> Unit
) {
    val navDashboardController = rememberNavController()
    val navBackStackEntry by navDashboardController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute == Screen.Home.route || currentRoute == Screen.History.route || currentRoute == Screen.Profile.route) {
                BottomBar(navController = navDashboardController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navDashboardController,
            startDestination = DASHBOARD_ROUTE,
            route = BASE_ROUTE,
            modifier = modifier.padding(innerPadding)
        ) {
            dashboardNavGraph(
                navController = navDashboardController,
                activity = activity,
                logOut = logOut
            )
        }
    }
}