package com.example.gigsandcare.ui.screen.history

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gigsandcare.data.GigsAndCareRepository
import com.example.gigsandcare.data.model.UserDonation
import com.example.gigsandcare.data.model.UserHistory
import com.example.gigsandcare.ui.screen.signin.component.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repository: GigsAndCareRepository
) : ViewModel() {

    private val _user: MutableStateFlow<UserData> = MutableStateFlow(UserData(userId = "", email = "", profilePictureUrl = ""))
    val user = _user.asStateFlow()

    private val _userHistory: MutableStateFlow<List<UserHistory>> = MutableStateFlow(emptyList())
    val userHistory = _userHistory.asStateFlow()

    private val _userHistoryData: MutableStateFlow<List<UserDonation>> = MutableStateFlow(emptyList())
    val userHistoryData: StateFlow<List<UserDonation>> = _userHistoryData.asStateFlow()

    private val _convertedUserHistory: MutableStateFlow<MutableList<UserHistory>> = MutableStateFlow(mutableListOf())
    val convertedUserHistory: StateFlow<MutableList<UserHistory>> = _convertedUserHistory.asStateFlow()

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

    fun getConvertedUserHistory(userHistory: List<UserHistory>, totalPeoplesHelped: Int, totalDonation: Int, totalProgram: Int) {
        val result: MutableList<UserHistory> = mutableListOf()
        result.clear()
        result.add(userHistory[0].copy(historyTitle1 = totalPeoplesHelped.toString()))
        result.add(userHistory[1].copy(historyTitle2 = totalDonation.toString()))
        result.add(userHistory[2].copy(historyTitle1 = totalProgram.toString()))
        _convertedUserHistory.value = result
    }

    fun getUserHistoryData() {
        viewModelScope.launch {
            repository.getUserHistoryData()
                .catch {
                    Log.e("Error", "$it")
                }
                .collect { userDonation ->
                    _userHistoryData.value = userDonation
                }
        }
    }

}