package com.example.gigsandcare.ui.screen.charity_news.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gigsandcare.R
import com.example.gigsandcare.data.model.News
import com.example.gigsandcare.ui.theme.colorPrimary
import com.example.gigsandcare.ui.theme.lightGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LatestNewsCard(
    modifier: Modifier = Modifier,
    news: News,
    onClick: (Int) -> Unit
) {
    Card(
        onClick = {
            onClick(news.id)
        },
        modifier = modifier.size(270.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Image(
            modifier = modifier
                .fillMaxWidth(),
            painter = painterResource(id = news.image),
            contentDescription = news.title,
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.Center
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
            Text(
                text = news.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                    color = Color.Black
                ),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = news.author,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                        color = colorPrimary
                    ),
                    maxLines = 1
                )
                Text(
                    text = "${news.time} min ago",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                        color = lightGray
                    ),
                    maxLines = 1
                )
            }
        }
    }
}