package com.example.gigsandcare.ui.screen.history.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.gigsandcare.R
import com.example.gigsandcare.components.HistoryItem
import com.example.gigsandcare.data.model.UserHistory
import com.example.gigsandcare.ui.screen.signin.component.UserData
import com.example.gigsandcare.ui.theme.ghostWhite
import com.example.gigsandcare.util.Constants
import com.example.gigsandcare.util.Constants.YOUR_ACTIVITY

@Composable
fun HistoryContent(
    modifier: Modifier = Modifier,
    user: UserData,
    userHistory: List<UserHistory>
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = ghostWhite)
            .padding(start = 15.dp, top = 60.dp, end = 15.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (user.profilePictureUrl.isNullOrEmpty()) {
            Image(
                modifier = modifier.size(100.dp),
                imageVector = Icons.Default.Person,
                contentDescription = Constants.PROFILE_PICTURE
            )
        } else {
            AsyncImage(
                modifier = modifier
                    .size(100.dp)
                    .clip(CircleShape),
                model = user.profilePictureUrl,
                contentDescription = Constants.PROFILE_PICTURE,
                contentScale = ContentScale.Crop
            )
        }
        Text(
            modifier = modifier.padding(top = 10.dp, bottom = 30.dp),
            text = if (user.name.isNullOrEmpty()) user.email ?: "" else user.name,
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp),
            text = YOUR_ACTIVITY,
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
            fontSize = 20.sp,
            textAlign = TextAlign.Start
        )
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(max = 480.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(vertical = 5.dp)
        ) {
            items(userHistory) {
                HistoryItem(
                    userHistory = it
                )
            }
        }
    }
}