package com.example.gigsandcare.ui.screen.program_detail.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gigsandcare.R
import com.example.gigsandcare.data.model.Program
import com.example.gigsandcare.ui.theme.colorPrimary
import com.example.gigsandcare.ui.theme.ghostWhite
import com.example.gigsandcare.ui.theme.lightGray
import com.example.gigsandcare.util.Constants.BUYING_TICKET_DONATION
import com.example.gigsandcare.util.Constants.DONATION_DAYS_REMAINING
import com.example.gigsandcare.util.Constants.DONATION_GOAL
import com.example.gigsandcare.util.Constants.DONATION_ONLY
import com.example.gigsandcare.util.Constants.DONATION_PERCENTAGE

@Composable
fun ProgramDetailContent(
    modifier: Modifier = Modifier,
    program: Program,
    onClickBuyTicketAndDonation: () -> Unit,
    onClickDonationOnly: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = ghostWhite)
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(bottom = 60.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = modifier
                    .size(260.dp)
                    .padding(top = 20.dp),
                painter = painterResource(id = program.image),
                contentDescription = program.title,
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = modifier.height(20.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = DONATION_GOAL,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                    )
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Image(
                        modifier = modifier.size(15.dp),
                        imageVector = Icons.Outlined.Timer,
                        contentDescription = null
                    )
                    Text(
                        text = DONATION_DAYS_REMAINING,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                        )
                    )
                }
            }
            Spacer(modifier = modifier.height(5.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LinearProgressIndicator(
                    modifier = modifier
                        .padding(end = 5.dp)
                        .width(20.dp)
                        .weight(1f),
                    progress = 0.34f,
                    color = colorPrimary
                )
                Text(
                    text = DONATION_PERCENTAGE,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = lightGray,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                    )
                )
            }
            Spacer(modifier = modifier.height(20.dp))
            Text(
                modifier = modifier.fillMaxWidth(),
                text = program.title,
                textAlign = TextAlign.Start,
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                )
            )
            Spacer(modifier = modifier.height(5.dp))
            Text(
                text = program.description,
                textAlign = TextAlign.Justify,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                )
            )
        }

        Row(
            modifier = modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                modifier = modifier.weight(1f),
                shape = RoundedCornerShape(5.dp),
                contentPadding = PaddingValues(3.dp),
                enabled = program.availability == "Available" && program.type == "Concert",
                onClick = onClickBuyTicketAndDonation
            ) {
                Text(
                    text = BUYING_TICKET_DONATION,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
            Spacer(modifier = modifier.width(5.dp))
            Button(
                modifier = modifier
                    .weight(0.75f),
                shape = RoundedCornerShape(5.dp),
                contentPadding = PaddingValues(3.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(width = 1.dp, color = colorPrimary),
                enabled = program.availability == "Available",
                onClick = onClickDonationOnly
            ) {
                Text(
                    text = DONATION_ONLY,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
        }
    }
}