package com.example.gigsandcare.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gigsandcare.data.GigsAndCareRepository
import com.example.gigsandcare.data.model.Program
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: GigsAndCareRepository
) : ViewModel() {

    private val _programs: MutableStateFlow<List<Program>> = MutableStateFlow(emptyList())
    val programs = _programs.asStateFlow()

    fun getPrograms() {
        viewModelScope.launch {
            repository.getPrograms()
                .collect { programs ->
                    val displayPrograms = programs.subList(0, 5)
                    _programs.value = displayPrograms
                }
        }
    }

}