package com.example.gigsandcare.ui.screen.buy_ticket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gigsandcare.data.GigsAndCareRepository
import com.example.gigsandcare.data.model.UserDonation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BuyTicketViewModel @Inject constructor(
    private val repository: GigsAndCareRepository
) : ViewModel() {

    fun addDonation(userDonation: UserDonation) {
        viewModelScope.launch {
            repository.addDonation(userDonation)
        }
    }

}