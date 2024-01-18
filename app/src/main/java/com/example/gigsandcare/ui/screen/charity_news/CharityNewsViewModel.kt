package com.example.gigsandcare.ui.screen.charity_news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gigsandcare.data.GigsAndCareRepository
import com.example.gigsandcare.data.model.News
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharityNewsViewModel(private val repository: GigsAndCareRepository) : ViewModel() {

    private val _latestNews: MutableStateFlow<List<News>> = MutableStateFlow(emptyList())
    val latestNews: StateFlow<List<News>> = _latestNews.asStateFlow()

    private val _recommendedTopic: MutableStateFlow<List<News>> = MutableStateFlow(emptyList())
    val recommendedTopic: StateFlow<List<News>> = _recommendedTopic.asStateFlow()

    fun getLatestNews() {
        viewModelScope.launch {
            repository.getLatestNews()
                .collect {
                    _latestNews.value = it
                }
        }
    }

    fun getRecommendedTopic() {
        viewModelScope.launch {
            repository.getRecommendedTopic()
                .collect {
                    _recommendedTopic.value = it
                }
        }
    }

}