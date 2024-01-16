package com.example.gigsandcare.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gigsandcare.R
import com.example.gigsandcare.data.model.Program
import com.example.gigsandcare.ui.theme.colorPrimary
import com.example.gigsandcare.ui.theme.lightGray
import com.example.gigsandcare.util.Constants.CONCERT_LOCATION

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgramHomeItem(
    modifier: Modifier = Modifier,
    program: Program,
    onCLick: (Int) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        onClick = {
            onCLick(program.id)
        }
    ) {
        Row(
            modifier = modifier.padding(start = 6.dp, top = 12.dp, end = 12.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = modifier
                    .padding(end = 5.dp)
                    .size(60.dp)
                    .clip(RectangleShape)
                    .weight(0.25f),
                painter = painterResource(id = program.image),
                contentDescription = program.title,
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = modifier.weight(0.5f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = modifier.padding(top = 5.dp, bottom = 1.dp),
                    text = program.title,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Text(
                    modifier = modifier.padding(bottom = 5.dp),
                    text = program.date,
                    color = lightGray,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                    fontSize = 8.sp
                )
                Text(
                    text = CONCERT_LOCATION,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                    fontSize = 10.sp
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = modifier.size(15.dp),
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null
                    )
                    Text(
                        text = program.location,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
                        fontSize = 10.sp,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            }
            val availabilityColor = if (program.availability == "Available") {
                colorPrimary
            } else {
                lightGray
            }
            Box(
                modifier = modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = availabilityColor)
                    .weight(0.25f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = modifier.padding(vertical = 4.dp, horizontal = 6.dp),
                    text = program.availability,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_medium)),
                    fontSize = 8.sp
                )
            }
        }
    }
}