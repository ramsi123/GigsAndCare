package com.example.gigsandcare.ui.screen.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gigsandcare.data.GigsAndCareRepository
import com.example.gigsandcare.data.model.UserHistory
import com.example.gigsandcare.ui.screen.signin.component.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HistoryViewModel(private val repository: GigsAndCareRepository) : ViewModel() {

    private val _user: MutableStateFlow<UserData> = MutableStateFlow(UserData(userId = "", email = "", profilePictureUrl = ""))
    val user = _user.asStateFlow()

    private val _userHistory: MutableStateFlow<List<UserHistory>> = MutableStateFlow(emptyList())
    val userHistory = _userHistory.asStateFlow()

    fun getSignedInUser() {
        _user.value = repository.getSignedInUser() ?: UserData(userId = "", email = "", profilePictureUrl = "")
    }

    fun getUserHistory() {
        viewModelScope.launch {
            repository.getUserHistory()
                .collect {
                    _userHistory.value = it
                }
        }
    }

}