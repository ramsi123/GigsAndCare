package com.example.gigsandcare.ui.screen.charity_news_detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gigsandcare.ui.screen.charity_news_detail.component.CharityNewsDetailContent

@Composable
fun CharityNewsDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: CharityNewsDetailViewModel = hiltViewModel(),
    navController: NavHostController,
    latestNewsId: Int,
    recommendedTopicId: Int
) {
    val latestNewsDetail by viewModel.latestNewsDetail.collectAsState()
    val recommendedTopicDetail by viewModel.recommendedTopicDetail.collectAsState()

    LaunchedEffect(key1 = true) {
        if (latestNewsId == -1) {
            viewModel.getRecommendedTopicDetail(recommendedTopicId)
        } else {
            viewModel.getLatestNewsDetail(latestNewsId)
        }
    }

    CharityNewsDetailContent(
        modifier = modifier,
        news = if (latestNewsId == -1) recommendedTopicDetail else latestNewsDetail,
        navigateBack = {
            navController.navigateUp()
        }
    )
}