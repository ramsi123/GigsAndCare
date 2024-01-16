package com.example.gigsandcare.ui.screen.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Switch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.NightlightRound
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.gigsandcare.ui.screen.signin.component.UserData
import com.example.gigsandcare.R
import com.example.gigsandcare.ui.theme.ghostWhite
import com.example.gigsandcare.ui.theme.lightGray
import com.example.gigsandcare.util.Constants.EDIT_PROFILE
import com.example.gigsandcare.util.Constants.LOG_OUT
import com.example.gigsandcare.util.Constants.NIGHT_MODE
import com.example.gigsandcare.util.Constants.NOTIFICATION_SETTINGS
import com.example.gigsandcare.util.Constants.PROFILE_PICTURE
import com.example.gigsandcare.util.Constants.REMINDER_SOUND

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    user: UserData,
    editProfile: () -> Unit,
    notificationSettings: () -> Unit,
    darkMode: Boolean,
    onDarkModeChange: (Boolean) -> Unit,
    reminderSound: Boolean,
    onReminderSoundChange: (Boolean) -> Unit,
    logOut: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = ghostWhite)
            .padding(start = 20.dp, top = 60.dp, end = 20.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            shape = RoundedCornerShape(5.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (user.profilePictureUrl.isNullOrEmpty()) {
                    Image(
                        modifier = modifier.size(50.dp),
                        imageVector = Icons.Default.Person,
                        contentDescription = PROFILE_PICTURE
                    )
                } else {
                    AsyncImage(
                        modifier = modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        model = user.profilePictureUrl,
                        contentDescription = PROFILE_PICTURE,
                        contentScale = ContentScale.Crop
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = user.name ?: "",
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                        fontSize = 18.sp
                    )
                    Text(
                        text = user.email ?: "",
                        color = lightGray,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                        fontSize = 14.sp
                    )
                }
            }
        }
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            onClick = editProfile,
            colors = CardDefaults.cardColors(containerColor = Color.White, contentColor = Color.Black),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = Icons.Default.PersonOutline,
                    contentDescription = null
                )
                Text(
                    modifier = modifier.weight(1f),
                    text = EDIT_PROFILE,
                    fontFamily = FontFamily(Font(R.font.josefin_sans_semibold))
                )
                Icon(
                    imageVector = Icons.Default.NavigateNext,
                    contentDescription = null
                )
            }
        }
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            onClick = notificationSettings,
            colors = CardDefaults.cardColors(containerColor = Color.White, contentColor = Color.Black),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = Icons.Default.NotificationsNone,
                    contentDescription = null
                )
                Text(
                    modifier = modifier.weight(1f),
                    text = NOTIFICATION_SETTINGS,
                    fontFamily = FontFamily(Font(R.font.josefin_sans_semibold))
                )
                Icon(
                    imageVector = Icons.Default.NavigateNext,
                    contentDescription = null
                )
            }
        }
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White, contentColor = Color.Black),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = modifier.padding(start = 12.dp),
                    imageVector = Icons.Default.NightlightRound,
                    contentDescription = null
                )
                Text(
                    modifier = modifier.weight(1f),
                    text = NIGHT_MODE,
                    fontFamily = FontFamily(Font(R.font.josefin_sans_semibold))
                )
                Switch(
                    modifier = modifier.weight(0.4f),
                    checked = darkMode,
                    onCheckedChange = {
                        onDarkModeChange(it)
                    }
                )
            }
        }
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White, contentColor = Color.Black),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = modifier.padding(start = 12.dp),
                    imageVector = Icons.Default.NotificationsNone,
                    contentDescription = null
                )
                Text(
                    modifier = modifier.weight(1f),
                    text = REMINDER_SOUND,
                    fontFamily = FontFamily(Font(R.font.josefin_sans_semibold))
                )
                Switch(
                    modifier = modifier.weight(0.4f),
                    checked = reminderSound,
                    onCheckedChange = {
                        onReminderSoundChange(it)
                    }
                )
            }
        }
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            onClick = logOut,
            colors = CardDefaults.cardColors(containerColor = Color.White, contentColor = Color.Red),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = Color.Red)
                )
                Text(
                    text = LOG_OUT,
                    fontFamily = FontFamily(Font(R.font.josefin_sans_semibold))
                )
            }
        }
    }
}