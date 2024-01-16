package com.example.gigsandcare.ui.screen.buy_ticket.component

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material3.Button
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
import com.example.gigsandcare.components.PaymentInputField
import com.example.gigsandcare.ui.theme.ghostWhite
import com.example.gigsandcare.ui.theme.smoothGray
import com.example.gigsandcare.util.Constants
import com.example.gigsandcare.util.Constants.CONCERT_TICKET_PASS
import com.example.gigsandcare.util.Constants.DONATION_FOR_CHARITY
import com.example.gigsandcare.util.Constants.INA_CURRENCY
import com.example.gigsandcare.util.Constants.PAY_NOW
import com.example.gigsandcare.util.Constants.TOTAL

@Composable
fun BuyTicketContent(
    modifier: Modifier = Modifier,
    title: String,
    organizer: String,
    price: Int,
    onClickPaid: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = ghostWhite)
            .padding(20.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = ghostWhite)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = smoothGray)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                        )
                    )
                    Spacer(modifier = modifier.height(3.dp))
                    Text(
                        text = organizer,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                        )
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    Divider(color = Color.Black, thickness = 1.dp)
                    Spacer(modifier = modifier.height(30.dp))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = CONCERT_TICKET_PASS,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                            )
                        )
                        Text(
                            text = "$INA_CURRENCY $price",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                            )
                        )
                    }
                    Spacer(modifier = modifier.height(5.dp))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = DONATION_FOR_CHARITY,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                            )
                        )
                        Text(
                            text = "$INA_CURRENCY ${price / 10}",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                            )
                        )
                    }
                    Spacer(modifier = modifier.height(120.dp))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = TOTAL,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                            )
                        )
                        Text(
                            text = "$INA_CURRENCY ${price + (price / 10)}",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                            )
                        )
                    }
                }
            }
            Spacer(modifier = modifier.height(10.dp))
            PaymentInputField(
                title = Constants.PAYMENT_METHOD,
                image = R.drawable.auth_icon,
                value = Constants.TEMP_PAYMENT_METHOD
            )
        }

        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = TOTAL,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                    )
                )
                Text(
                    text = "$INA_CURRENCY ${price + (price / 10)}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                    )
                )
            }
            Spacer(modifier = modifier.height(3.dp))
            Button(
                modifier = modifier.fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                contentPadding = PaddingValues(3.dp),
                onClick = onClickPaid
            ) {
                Text(
                    text = PAY_NOW,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
        }
    }
}