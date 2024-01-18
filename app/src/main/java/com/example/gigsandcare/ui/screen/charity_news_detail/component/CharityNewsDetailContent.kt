package com.example.gigsandcare.ui.screen.charity_news_detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.gigsandcare.R
import com.example.gigsandcare.components.TopBar
import com.example.gigsandcare.data.model.News
import com.example.gigsandcare.ui.theme.lightGray
import com.example.gigsandcare.util.Constants.NEWS_DETAIL_TITLE

@Composable
fun CharityNewsDetailContent(
    modifier: Modifier = Modifier,
    news: News,
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(title = NEWS_DETAIL_TITLE, navigateBack = { navigateBack() })
        }
    ) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = modifier
                    .padding(15.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, bottom = 5.dp),
                    text = news.title,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                    fontSize = 18.sp,
                    lineHeight = 22.sp,
                    textAlign = TextAlign.Start
                )
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = "${news.time} min ago",
                    color = lightGray,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start
                )
                Image(
                    modifier = modifier
                        .fillMaxWidth()
                        .size(200.dp)
                        .padding(top = 20.dp, bottom = 20.dp),
                    painter = painterResource(id = news.image),
                    contentDescription = news.title,
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = news.description,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}