package com.example.gigsandcare.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gigsandcare.R
import com.example.gigsandcare.util.Constants.CHARITY_NEWS
import com.example.gigsandcare.util.Constants.CHARITY_PROGRAM
import com.example.gigsandcare.util.Constants.EVENT_CALENDAR
import com.example.gigsandcare.util.Constants.UPCOMING_CONCERT

@Composable
fun ShortcutMenu() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RoundedCornerIconButton(
            modifier = Modifier.weight(1f),
            R.drawable.charity,
            CHARITY_PROGRAM
        )
        Spacer(modifier = Modifier.width(10.dp))
        RoundedCornerIconButton(
            modifier = Modifier.weight(1f),
            R.drawable.ticket,
            UPCOMING_CONCERT
        )
        Spacer(modifier = Modifier.width(10.dp))
        RoundedCornerIconButton(
            modifier = Modifier.weight(1f),
            R.drawable.newspaper,
            CHARITY_NEWS
        )
        Spacer(modifier = Modifier.width(10.dp))
        RoundedCornerIconButton(
            modifier = Modifier.weight(1f),
            R.drawable.calendar,
            EVENT_CALENDAR
        )
    }
}

@Preview
@Composable
fun ShortcutMenuPreview() {
    ShortcutMenu()
}