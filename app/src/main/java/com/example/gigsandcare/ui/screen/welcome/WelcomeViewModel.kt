package com.example.gigsandcare.ui.screen.welcome

import androidx.lifecycle.ViewModel
import com.example.gigsandcare.data.GigsAndCareRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val repository: GigsAndCareRepository
) : ViewModel() {

    fun getSignedInUser() = repository.getSignedInUser()

}