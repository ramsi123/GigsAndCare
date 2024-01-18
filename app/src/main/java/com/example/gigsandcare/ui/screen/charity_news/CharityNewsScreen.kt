package com.example.gigsandcare.ui.screen.charity_news

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gigsandcare.di.Injection
import com.example.gigsandcare.navigation.Screen
import com.example.gigsandcare.ui.ViewModelFactory
import com.example.gigsandcare.ui.screen.charity_news.component.CharityNewsContent
import com.example.gigsandcare.util.Constants.CHARITY_NEWS

@Composable
fun CharityNewsScreen(
    modifier: Modifier = Modifier,
    viewModel: CharityNewsViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideGigsAndCareRepository(LocalContext.current))
    ),
    navController: NavHostController
) {
    var search by remember { mutableStateOf("") }
    val latestNews by viewModel.latestNews.collectAsState()
    val recommendedTopic by viewModel.recommendedTopic.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.getLatestNews()
        viewModel.getRecommendedTopic()
    }

    CharityNewsContent(
        modifier = modifier,
        title = CHARITY_NEWS,
        search = search,
        onSearchChange = {
            search = it
        },
        latestNews = latestNews,
        recommendedTopic = recommendedTopic,
        onClickLatestNews = { latestNewsId ->
            navController.navigate(Screen.CharityNewsDetail.CharityNewsDetailRoute(latestNewsId, -1))
        },
        onClickRecommendedTopic = { recommendedTopicId ->
            navController.navigate(Screen.CharityNewsDetail.CharityNewsDetailRoute(-1, recommendedTopicId))
        }
    )
}