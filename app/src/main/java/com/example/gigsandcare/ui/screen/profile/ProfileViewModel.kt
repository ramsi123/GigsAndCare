package com.example.gigsandcare.ui.screen.profile

import androidx.lifecycle.ViewModel
import com.example.gigsandcare.ui.screen.signin.component.UserData
import com.example.gigsandcare.data.GigsAndCareRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: GigsAndCareRepository
) : ViewModel() {

    private val _user: MutableStateFlow<UserData> = MutableStateFlow(UserData())
    val user = _user.asStateFlow()

    suspend fun signOut() = repository.signOut()

    fun getSignedInUser() {
        _user.value = repository.getSignedInUser() ?: UserData()
    }

}