package com.example.gigsandcare.navigation

import com.example.gigsandcare.util.Constants.DASHBOARD_SCREEN
import com.example.gigsandcare.util.Constants.FORGOT_PASSWORD_SCREEN
import com.example.gigsandcare.util.Constants.HISTORY_SCREEN
import com.example.gigsandcare.util.Constants.HOME_SCREEN
import com.example.gigsandcare.util.Constants.PROFILE_SCREEN
import com.example.gigsandcare.util.Constants.PROGRAM_DETAIL
import com.example.gigsandcare.util.Constants.SIGN_IN_SCREEN
import com.example.gigsandcare.util.Constants.SIGN_UP_SCREEN
import com.example.gigsandcare.util.Constants.WELCOME_SCREEN

const val ROOT_ROUTE = "root_route"
const val AUTHENTICATION_ROUTE = "authentication_route"
const val BASE_ROUTE = "base_route"
const val DASHBOARD_ROUTE = "dashboard_route"

sealed class Screen(val route: String) {
    object Welcome : Screen(WELCOME_SCREEN)
    object SignUp : Screen(SIGN_UP_SCREEN)
    object SignIn : Screen(SIGN_IN_SCREEN)
    object ForgotPassword : Screen(FORGOT_PASSWORD_SCREEN)
    object Dashboard : Screen(DASHBOARD_SCREEN)
    object Home : Screen(HOME_SCREEN)
    object History : Screen(HISTORY_SCREEN)
    object Profile : Screen(PROFILE_SCREEN)
    object ProgramDetail : Screen("$PROGRAM_DETAIL/{bannerId}/{programId}") {
        fun programDetailRoute(bannerId: Int, programId: Int) = "$PROGRAM_DETAIL/$bannerId/$programId"
    }
}
