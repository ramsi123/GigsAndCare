package com.example.gigsandcare.ui.screen.welcome

import androidx.lifecycle.ViewModel
import com.example.gigsandcare.data.GigsAndCareRepository

class WelcomeViewModel(private val repository: GigsAndCareRepository) : ViewModel() {

    fun getSignedInUser() = repository.getSignedInUser()

}