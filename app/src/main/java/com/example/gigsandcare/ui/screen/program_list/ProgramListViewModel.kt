package com.example.gigsandcare.ui.screen.program_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gigsandcare.data.GigsAndCareRepository
import com.example.gigsandcare.data.model.Program
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProgramListViewModel(private val repository: GigsAndCareRepository) : ViewModel() {

    private val _programs: MutableStateFlow<List<Program>> = MutableStateFlow(emptyList())
    val programs: StateFlow<List<Program>> = _programs.asStateFlow()

    fun getPrograms() {
        viewModelScope.launch {
            repository.getPrograms()
                .collect {
                    _programs.value = it
                }
        }
    }

}