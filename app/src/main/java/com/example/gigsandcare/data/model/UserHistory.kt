package com.example.gigsandcare.data.model

import androidx.annotation.DrawableRes
import com.example.gigsandcare.R
import com.example.gigsandcare.util.Constants.INA_CURRENCY
import com.example.gigsandcare.util.Constants.PEOPLES
import com.example.gigsandcare.util.Constants.PEOPLES_HELPED_DESC
import com.example.gigsandcare.util.Constants.PROGRAMS
import com.example.gigsandcare.util.Constants.PROGRAMS_DESC
import com.example.gigsandcare.util.Constants.TOTAL_SPEND_FOR_CHARITY

data class UserHistory(
    val historyTitle1: String = "",
    val historyTitle2: String = "",
    val historyDesc: String = "",
    @DrawableRes val image: Int = R.drawable.people_helped
)

val dummyUserHistory = listOf(
    UserHistory(historyTitle1 = "0", historyTitle2 = PEOPLES, historyDesc = PEOPLES_HELPED_DESC, image = R.drawable.people_helped),
    UserHistory(historyTitle1 = INA_CURRENCY, historyTitle2 = "0", historyDesc = TOTAL_SPEND_FOR_CHARITY, image = R.drawable.payment_history),
    UserHistory(historyTitle1 = "0", historyTitle2 = PROGRAMS, historyDesc = PROGRAMS_DESC, image = R.drawable.programs)
)