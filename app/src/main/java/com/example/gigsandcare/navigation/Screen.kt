package com.example.gigsandcare.navigation

import com.example.gigsandcare.util.Constants.BUY_TICKET_SCREEN
import com.example.gigsandcare.util.Constants.CHARITY_NEWS_DETAIL_SCREEN
import com.example.gigsandcare.util.Constants.CHARITY_NEWS_SCREEN
import com.example.gigsandcare.util.Constants.CHARITY_PROGRAM_SCREEN
import com.example.gigsandcare.util.Constants.DASHBOARD_SCREEN
import com.example.gigsandcare.util.Constants.EVENT_CALENDAR_SCREEN
import com.example.gigsandcare.util.Constants.FORGOT_PASSWORD_SCREEN
import com.example.gigsandcare.util.Constants.HISTORY_SCREEN
import com.example.gigsandcare.util.Constants.HOME_SCREEN
import com.example.gigsandcare.util.Constants.PROFILE_SCREEN
import com.example.gigsandcare.util.Constants.PROGRAM_DETAIL_SCREEN
import com.example.gigsandcare.util.Constants.PROGRAM_LIST_SCREEN
import com.example.gigsandcare.util.Constants.SIGN_IN_SCREEN
import com.example.gigsandcare.util.Constants.SIGN_UP_SCREEN
import com.example.gigsandcare.util.Constants.SUCCESS_DONATION_SCREEN
import com.example.gigsandcare.util.Constants.UPCOMING_CONCERT_SCREEN
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
    object CharityProgram : Screen(CHARITY_PROGRAM_SCREEN)
    object UpcomingConcert : Screen(UPCOMING_CONCERT_SCREEN)
    object CharityNews : Screen(CHARITY_NEWS_SCREEN)
    object EventCalendar : Screen(EVENT_CALENDAR_SCREEN)
    object CharityNewsDetail : Screen("$CHARITY_NEWS_DETAIL_SCREEN/{latestNewsId}/{recommendedTopicId}") {
        fun CharityNewsDetailRoute(latestNewsId: Int, recommendedTopicId: Int) = "$CHARITY_NEWS_DETAIL_SCREEN/$latestNewsId/$recommendedTopicId"
    }
    object ProgramList : Screen(PROGRAM_LIST_SCREEN)
    object ProgramDetail : Screen("$PROGRAM_DETAIL_SCREEN/{bannerId}/{programId}/{charityProgramId}/{concertId}") {
        fun programDetailRoute(
            bannerId: Int, programId: Int, charityProgramId: Int, concertId: Int
        ) = "$PROGRAM_DETAIL_SCREEN/$bannerId/$programId/$charityProgramId/$concertId"
    }
    object BuyTicket : Screen("$BUY_TICKET_SCREEN/{title}/{organizer}/{price}") {
        fun buyDetailRoute(title: String, organizer: String, price: Int) = "$BUY_TICKET_SCREEN/$title/$organizer/$price"
    }
    object SuccessDonation : Screen(SUCCESS_DONATION_SCREEN)
}
