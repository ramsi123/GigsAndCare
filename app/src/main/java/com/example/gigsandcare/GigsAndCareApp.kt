package com.example.gigsandcare

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gigsandcare.ui.screen.dashboard.DashboardScreen
import com.example.gigsandcare.navigation.AUTHENTICATION_ROUTE
import com.example.gigsandcare.navigation.ROOT_ROUTE
import com.example.gigsandcare.navigation.Screen
import com.example.gigsandcare.navigation.nav_graph.authNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GigsAndCareApp(
    modifier: Modifier = Modifier,
    activity: ComponentActivity
) {
    val navAuthController = rememberNavController()

    NavHost(
        navController = navAuthController,
        startDestination = AUTHENTICATION_ROUTE,
        route = ROOT_ROUTE,
        modifier = modifier
    ) {
        authNavGraph(navController = navAuthController)
        composable(Screen.Dashboard.route) {
            DashboardScreen(
                activity = activity,
                logOut = {
                    navAuthController.navigate(ROOT_ROUTE) {
                        popUpTo(Screen.Dashboard.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}