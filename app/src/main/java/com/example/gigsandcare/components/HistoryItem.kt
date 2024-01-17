package com.example.gigsandcare.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gigsandcare.R
import com.example.gigsandcare.data.model.UserHistory

@Composable
fun HistoryItem(
    modifier: Modifier = Modifier,
    userHistory: UserHistory
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            modifier = modifier
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = userHistory.historyTitle1,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                        fontSize = 18.sp
                    )
                    Text(
                        text = userHistory.historyTitle2,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                        fontSize = 18.sp
                    )
                }
                Text(
                    text = userHistory.historyDesc,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                    fontSize = 16.sp
                )
            }
            /*Image(
                modifier = modifier
                    .size(40.dp)
                    .clip(CircleShape),
                painter = painterResource(id = userHistory.image),
                contentDescription = null
            )*/
            Image(
                modifier = modifier
                    .size(40.dp),
                painter = painterResource(id = userHistory.image),
                contentDescription = null
            )
        }
    }
}