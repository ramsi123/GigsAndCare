package com.example.gigsandcare.ui.screen.charity_news_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gigsandcare.data.GigsAndCareRepository
import com.example.gigsandcare.data.model.News
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharityNewsDetailViewModel @Inject constructor(
    private val repository: GigsAndCareRepository
) : ViewModel() {

    private val _latestNewsDetail: MutableStateFlow<News> = MutableStateFlow(News())
    val latestNewsDetail: StateFlow<News> = _latestNewsDetail.asStateFlow()

    private val _recommendedTopicDetail: MutableStateFlow<News> = MutableStateFlow(News())
    val recommendedTopicDetail: StateFlow<News> = _recommendedTopicDetail.asStateFlow()

    fun getLatestNewsDetail(index: Int) {
        viewModelScope.launch {
            repository.getLatestNewsDetail(index)
                .collect {
                    _latestNewsDetail.value = it
                }
        }
    }

    fun getRecommendedTopicDetail(index: Int) {
        viewModelScope.launch {
            repository.getRecommendedTopicDetail(index)
                .collect {
                    _recommendedTopicDetail.value = it
                }
        }
    }

}