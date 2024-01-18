package com.example.gigsandcare.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gigsandcare.data.GigsAndCareRepository
import com.example.gigsandcare.ui.screen.charity_news.CharityNewsViewModel
import com.example.gigsandcare.ui.screen.charity_news_detail.CharityNewsDetailViewModel
import com.example.gigsandcare.ui.screen.charity_program.CharityProgramViewModel
import com.example.gigsandcare.ui.screen.event_calendar.EventCalendarViewModel
import com.example.gigsandcare.ui.screen.forgot_password.ForgotPasswordViewModel
import com.example.gigsandcare.ui.screen.history.HistoryViewModel
import com.example.gigsandcare.ui.screen.home.HomeViewModel
import com.example.gigsandcare.ui.screen.profile.ProfileViewModel
import com.example.gigsandcare.ui.screen.program_detail.ProgramDetailViewModel
import com.example.gigsandcare.ui.screen.program_list.ProgramListViewModel
import com.example.gigsandcare.ui.screen.signin.SignInViewModel
import com.example.gigsandcare.ui.screen.signup.SignUpViewModel
import com.example.gigsandcare.ui.screen.upcoming_concert.UpcomingConcertViewModel
import com.example.gigsandcare.ui.screen.welcome.WelcomeViewModel

class ViewModelFactory(private val repository: GigsAndCareRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WelcomeViewModel::class.java)) {
            return WelcomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            return SignUpViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(SignInViewModel::class.java)) {
            return SignInViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(ForgotPasswordViewModel::class.java)) {
            return ForgotPasswordViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(ProgramDetailViewModel::class.java)) {
            return ProgramDetailViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(HistoryViewModel::class.java)) {
            return HistoryViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CharityProgramViewModel::class.java)) {
            return CharityProgramViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(UpcomingConcertViewModel::class.java)) {
            return UpcomingConcertViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(ProgramListViewModel::class.java)) {
            return ProgramListViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CharityNewsViewModel::class.java)) {
            return CharityNewsViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CharityNewsDetailViewModel::class.java)) {
            return CharityNewsDetailViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(EventCalendarViewModel::class.java)) {
            return EventCalendarViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}