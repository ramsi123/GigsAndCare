package com.example.gigsandcare.ui.screen.program_detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gigsandcare.data.GigsAndCareRepository
import com.example.gigsandcare.data.model.Program
import com.example.gigsandcare.data.model.UserDonation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProgramDetailViewModel(private val repository: GigsAndCareRepository) : ViewModel() {

    private val _bannerDetail: MutableStateFlow<Program> = MutableStateFlow(Program())
    val bannerDetail: StateFlow<Program> = _bannerDetail.asStateFlow()

    private val _programDetail: MutableStateFlow<Program> = MutableStateFlow(Program())
    val programDetail: StateFlow<Program> = _programDetail.asStateFlow()

    val _user: MutableStateFlow<UserDonation> = MutableStateFlow(UserDonation())
    val user: StateFlow<UserDonation> = _user.asStateFlow()
    val userData = mutableStateOf(UserDonation())

    fun getBannerDetail(index: Int) {
        viewModelScope.launch {
            repository.getBannerDetail(index)
                .collect { program ->
                    _bannerDetail.value = program
                }
        }
    }

    fun getProgramDetail(index: Int) {
        viewModelScope.launch {
            repository.getProgramDetail(index)
                .collect { program ->
                    _programDetail.value = program
                }
        }
    }

    fun getUserHistoryData() {
        viewModelScope.launch {
            userData.value = repository.getUserHistoryData() ?: UserDonation()
            /*repository.getUserHistoryData()
                .collect { userDonation ->
                    _user.value = userDonation
                }*/
        }
    }

    fun addDonation(userDonation: UserDonation) {
        viewModelScope.launch {
            repository.addDonation(userDonation)
        }
    }

}