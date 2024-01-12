package com.example.gigsandcare.ui.screen.home.component

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gigsandcare.R
import com.example.gigsandcare.components.CustomSearchBar
import com.example.gigsandcare.components.ShortcutMenu
import com.example.gigsandcare.components.SlidingBanner
import com.example.gigsandcare.data.model.Program
import com.example.gigsandcare.ui.screen.signin.component.ProgramList
import com.example.gigsandcare.ui.theme.ghostWhite
import com.example.gigsandcare.util.Constants.ANOTHER_PROGRAM
import com.example.gigsandcare.util.Constants.SEARCH
import com.example.gigsandcare.util.Constants.SHORTCUT
import com.example.gigsandcare.util.Constants.TITLE
import com.example.gigsandcare.util.Constants.TOP_PROGRAM
import com.example.gigsandcare.util.Constants.VIEW_ALL

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    context: Context,
    programs: List<Program>,
    search: String,
    onSearchChange: (String) -> Unit,
    navigateToBannerDetailScreen: (Int) -> Unit,
    navigateToProgramDetailScreen: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = ghostWhite)
            .padding(start = 20.dp, top = 15.dp, end = 20.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = modifier.fillMaxWidth(),
            text = TITLE,
            color = Color.Black,
            style = TextStyle(
                fontSize = 30.sp,
                fontFamily = FontFamily(Font(R.font.josefin_sans_semibold))
            ),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = modifier.height(10.dp))
        CustomSearchBar(
            query = search,
            onQueryChange = {
                onSearchChange(it)
            },
            onSearch = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            },
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
        Spacer(modifier = modifier.height(10.dp))
        HomeSection(
            title = TOP_PROGRAM,
            viewAll = "",
            navigateToListScreen = {}
        ) {
            SlidingBanner(
                onClick = navigateToBannerDetailScreen
            )
        }
        HomeSection(
            title = SHORTCUT,
            viewAll = "",
            navigateToListScreen = {}
        ) {
            ShortcutMenu()
        }
        Spacer(modifier = modifier.height(15.dp))
        HomeSection(
            title = ANOTHER_PROGRAM,
            viewAll = VIEW_ALL,
            navigateToListScreen = {}
        ) {
            ProgramList(
                programs = programs,
                onClick = navigateToProgramDetailScreen
            )
        }
    }
}