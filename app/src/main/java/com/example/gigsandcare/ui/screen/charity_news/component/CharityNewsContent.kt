package com.example.gigsandcare.ui.screen.charity_news.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gigsandcare.R
import com.example.gigsandcare.components.CustomSearchBar
import com.example.gigsandcare.data.model.News
import com.example.gigsandcare.ui.screen.charity_program.component.CharityNewsSection
import com.example.gigsandcare.ui.theme.ghostWhite
import com.example.gigsandcare.util.Constants.LATEST_NEWS
import com.example.gigsandcare.util.Constants.RECOMMENDED_TOPIC
import com.example.gigsandcare.util.Constants.SEARCH

@Composable
fun CharityNewsContent(
    modifier: Modifier = Modifier,
    title: String,
    search: String,
    onSearchChange: (String) -> Unit,
    latestNews: List<News>,
    recommendedTopic: List<News>,
    onClickLatestNews: (Int) -> Unit,
    onClickRecommendedTopic: (Int) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = ghostWhite),
        contentPadding = PaddingValues(start = 20.dp, top = 35.dp, end = 20.dp, bottom = 20.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        item {
            Text(
                text = title,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                fontSize = 26.sp
            )
        }
        item {
            CustomSearchBar(
                query = search,
                onQueryChange = {
                    onSearchChange(it)
                },
                onSearch = {},
                active = false,
                onActiveChange = {},
                placeHolder = {
                    Text(text = SEARCH)
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            ) {}
        }
        item {
            CharityNewsSection(
                title = LATEST_NEWS,
                viewAll = "",
                navigateToListScreen = {}
            ) {
                LazyRow(
                    contentPadding = PaddingValues(start = 3.dp, end = 3.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(latestNews) { latestNews ->
                        LatestNewsCard(
                            news = latestNews,
                            onClick = onClickLatestNews
                        )
                    }
                }
            }
        }
        item {
            CharityNewsSection(
                title = RECOMMENDED_TOPIC,
                viewAll = "",
                navigateToListScreen = {}
            ) {
                LazyColumn(
                    modifier = modifier.heightIn(max = 520.dp),
                    contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(recommendedTopic) { recommendedTopic ->
                        RecommendedTopicCard(
                            news = recommendedTopic,
                            onClick = onClickRecommendedTopic
                        )
                    }
                }
            }
        }
    }
}