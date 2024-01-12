package com.example.gigsandcare.ui.screen.history.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gigsandcare.ui.theme.colorPrimary
import com.example.gigsandcare.ui.theme.ghostWhite

@Composable
fun HistoryContent(
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxSize(), color = colorPrimary) {
        Card(
            colors = CardDefaults.cardColors(containerColor = ghostWhite),
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
            modifier = modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, top = 20.dp, end = 20.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                /*LazyVerticalGrid(
                    modifier = modifier.heightIn(max = 500.dp),
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(bottom = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(items = dummyTool) { tool ->
                        ToolItem(image = tool.image, name = tool.name)
                    }
                }*/
            }
        }
    }
}