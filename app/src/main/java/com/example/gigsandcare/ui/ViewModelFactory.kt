package com.example.gigsandcare.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gigsandcare.data.GigsAndCareRepository
import com.example.gigsandcare.ui.screen.forgot_password.ForgotPasswordViewModel
import com.example.gigsandcare.ui.screen.home.HomeViewModel
import com.example.gigsandcare.ui.screen.profile.ProfileViewModel
import com.example.gigsandcare.ui.screen.program_detail.ProgramDetailViewModel
import com.example.gigsandcare.ui.screen.signin.SignInViewModel
import com.example.gigsandcare.ui.screen.signup.SignUpViewModel
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
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}