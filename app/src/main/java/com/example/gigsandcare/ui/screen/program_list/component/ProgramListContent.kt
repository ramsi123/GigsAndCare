package com.example.gigsandcare.ui.screen.program_list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.gigsandcare.components.ProgramCardItem
import com.example.gigsandcare.data.model.Program
import com.example.gigsandcare.ui.theme.ghostWhite
import com.example.gigsandcare.util.Constants.SEARCH

@Composable
fun ProgramListContent(
    modifier: Modifier = Modifier,
    title: String,
    programs: List<Program>,
    search: String,
    onSearchChange: (String) -> Unit,
    navigateToProgramDetailScreen: (Int) -> Unit
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
        items(programs) { program ->
            ProgramCardItem(
                program = program,
                onClick = navigateToProgramDetailScreen
            )
        }
    }
}