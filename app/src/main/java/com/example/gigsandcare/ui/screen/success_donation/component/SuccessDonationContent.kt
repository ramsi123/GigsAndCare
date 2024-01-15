package com.example.gigsandcare.ui.screen.success_donation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gigsandcare.R
import com.example.gigsandcare.ui.theme.colorPrimary
import com.example.gigsandcare.ui.theme.lightGray
import com.example.gigsandcare.util.Constants.BACK_TO_HOME
import com.example.gigsandcare.util.Constants.SUCCESS_DONATION_DESCRIPTION
import com.example.gigsandcare.util.Constants.SUCCESS_DONATION_TITLE

@Composable
fun SuccessDonationContent(
    modifier: Modifier = Modifier,
    onClickBackToHome: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = modifier.size(250.dp),
                painter = painterResource(id = R.drawable.successfull_donation),
                contentDescription = null
            )
            Text(
                text = SUCCESS_DONATION_TITLE,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 26.sp,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                )
            )
            Spacer(modifier = modifier.height(15.dp))
            Text(
                modifier = modifier.padding(bottom = 100.dp),
                text = SUCCESS_DONATION_DESCRIPTION,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold)),
                    color = lightGray
                )
            )
        }

        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                modifier = modifier.fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                contentPadding = PaddingValues(3.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(width = 1.dp, color = colorPrimary),
                onClick = onClickBackToHome
            ) {
                Text(
                    text = BACK_TO_HOME,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
        }
    }
}