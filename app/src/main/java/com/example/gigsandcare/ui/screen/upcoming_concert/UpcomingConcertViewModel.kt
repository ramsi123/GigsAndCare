package com.example.gigsandcare.ui.screen.upcoming_concert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gigsandcare.data.GigsAndCareRepository
import com.example.gigsandcare.data.model.Program
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpcomingConcertViewModel @Inject constructor(
    private val repository: GigsAndCareRepository
) : ViewModel() {

    private val _concerts: MutableStateFlow<List<Program>> = MutableStateFlow(emptyList())
    val concerts: StateFlow<List<Program>> = _concerts.asStateFlow()

    fun getConcerts() {
        viewModelScope.launch {
            repository.getConcerts()
                .collect { concerts ->
                    _concerts.value = concerts
                }
        }
    }

}