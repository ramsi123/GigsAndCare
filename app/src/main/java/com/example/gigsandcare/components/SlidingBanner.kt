package com.example.gigsandcare.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.example.gigsandcare.data.model.banner
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SlidingBanner(
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit
) {
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = 3,
        state = pagerState,
        itemSpacing = 20.dp,
    ) { page ->
        Image(
            modifier = modifier
                .fillMaxWidth()
                .clickable {
                    onClick(page)
                },
            bitmap = ImageBitmap.imageResource(id = banner[page]),
            contentScale = ContentScale.FillWidth,
            contentDescription = "sliding_banner_image"
        )
    }

    HorizontalPagerIndicator(
        pagerState = pagerState,
        modifier = modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 10.dp),
    )
}