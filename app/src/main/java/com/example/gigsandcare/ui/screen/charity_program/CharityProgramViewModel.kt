package com.example.gigsandcare.ui.screen.charity_program

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gigsandcare.data.GigsAndCareRepository
import com.example.gigsandcare.data.model.Program
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharityProgramViewModel(private val repository: GigsAndCareRepository) : ViewModel() {

    private val _charityPrograms: MutableStateFlow<List<Program>> = MutableStateFlow(emptyList())
    val charityPrograms: StateFlow<List<Program>> = _charityPrograms.asStateFlow()

    fun getCharityPrograms() {
        viewModelScope.launch {
            repository.getCharityPrograms()
                .collect {
                    _charityPrograms.value = it
                }
        }
    }

}