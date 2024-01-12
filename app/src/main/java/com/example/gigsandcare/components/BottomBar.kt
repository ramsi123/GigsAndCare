package com.example.gigsandcare.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gigsandcare.navigation.NavigationItem
import com.example.gigsandcare.navigation.Screen
import com.example.gigsandcare.util.Constants.HISTORY_SCREEN
import com.example.gigsandcare.util.Constants.HOME_SCREEN
import com.example.gigsandcare.util.Constants.PROFILE_SCREEN

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        val navigationItems = listOf(
            NavigationItem(
                title = HOME_SCREEN,
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = HISTORY_SCREEN,
                icon = Icons.Default.History,
                screen = Screen.History
            ),
            NavigationItem(
                title = PROFILE_SCREEN,
                icon = Icons.Default.Person,
                screen = Screen.Profile
            )
        )

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}