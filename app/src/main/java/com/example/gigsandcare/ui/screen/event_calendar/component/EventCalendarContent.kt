package com.example.gigsandcare.ui.screen.event_calendar.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gigsandcare.R
import com.example.gigsandcare.components.CustomSearchBar
import com.example.gigsandcare.components.FloatingActionButton
import com.example.gigsandcare.data.model.EventCalendar
import com.example.gigsandcare.ui.theme.ghostWhite
import com.example.gigsandcare.ui.theme.lightGray
import com.example.gigsandcare.util.Constants.NO_EVENT_CALENDAR
import com.example.gigsandcare.util.Constants.SEARCH

@Composable
fun EventCalendarContent(
    modifier: Modifier = Modifier,
    title: String,
    search: String,
    eventCalendar: List<EventCalendar>,
    onSearchChange: (String) -> Unit,
    onClickFab: () -> Unit,
    navigateToEventItem: (String) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton {
                onClickFab()
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(color = ghostWhite)
                .padding(innerPadding),
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 35.dp,
                end = 20.dp,
                bottom = 20.dp
            ),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    text = title,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                    fontSize = 26.sp,
                    textAlign = TextAlign.Start
                )
            }
            item {
                CustomSearchBar(
                    modifier = modifier.padding(bottom = 10.dp),
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

            if (eventCalendar.isEmpty()) {
                item {
                    Icon(
                        modifier = modifier
                            .padding(top = 200.dp)
                            .size(50.dp),
                        imageVector = Icons.Default.CalendarToday,
                        contentDescription = null,
                        tint = lightGray
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    Text(
                        text = NO_EVENT_CALENDAR,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                            color = lightGray
                        ),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            } else {
                items(eventCalendar) {
                    EventCalendarCard(
                        eventCalendar = it,
                        onClick = navigateToEventItem
                    )
                }
            }
        }
    }
}