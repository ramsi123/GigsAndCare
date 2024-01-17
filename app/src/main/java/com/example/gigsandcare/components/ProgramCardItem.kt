package com.example.gigsandcare.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gigsandcare.R
import com.example.gigsandcare.data.model.Program
import com.example.gigsandcare.ui.theme.lightGray
import com.example.gigsandcare.util.Constants.DONATION_DAYS_REMAINING

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgramCardItem(
    modifier: Modifier = Modifier,
    program: Program,
    onClick: (Int) -> Unit
) {
    Card(
        onClick = {
            onClick(program.id)
        },
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Image(
            modifier = modifier.fillMaxWidth(),
            painter = painterResource(id = program.image),
            contentDescription = program.title,
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.Center
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = modifier.weight(1f)
            ) {
                Text(
                    text = program.title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                        color = Color.Black
                    ),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = modifier.height(1.dp))
                Text(
                    text = program.date,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                        color = Color.Black
                    ),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = modifier.height(5.dp))
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
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
                        fontSize = 12.sp,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            }

            Row(
                modifier = modifier.weight(0.4f),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = modifier.size(15.dp),
                    imageVector = Icons.Outlined.Timer,
                    contentDescription = null
                )
                Text(
                    text = DONATION_DAYS_REMAINING,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                    ),
                    maxLines = 1
                )
            }
        }
    }
}