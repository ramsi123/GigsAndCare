package com.example.gigsandcare.ui.screen.program_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gigsandcare.data.GigsAndCareRepository
import com.example.gigsandcare.data.model.Program
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

}