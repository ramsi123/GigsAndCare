package com.example.gigsandcare.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
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
import com.example.gigsandcare.ui.theme.lightGray

@Composable
fun PaymentInputField(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes image: Int,
    value: String
) {
    Column {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp),
            text = title,
            textAlign = TextAlign.Start,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
            )
        )
        OutlinedButton(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White),
            border = BorderStroke(width = 1.dp, color = lightGray),
            contentPadding = PaddingValues(start = 13.dp, top = 5.dp, bottom = 5.dp),
            onClick = {}
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    modifier = modifier
                        .padding(end = 8.dp)
                        .size(25.dp),
                    painter = painterResource(id = image),
                    contentDescription = null
                )
                Text(
                    text = value,
                    color = Color.Black
                )
            }
        }
    }
}