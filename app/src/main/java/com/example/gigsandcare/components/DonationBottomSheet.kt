package com.example.gigsandcare.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
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
import com.example.gigsandcare.ui.theme.colorPrimary
import com.example.gigsandcare.util.Constants.AMOUNT
import com.example.gigsandcare.util.Constants.DONATE_NOW
import com.example.gigsandcare.util.Constants.HOW_MUCH_DONATE
import com.example.gigsandcare.util.Constants.PAYMENT_METHOD
import com.example.gigsandcare.util.Constants.TEMP_PAYMENT_METHOD

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DonationBottomSheet(
    modifier: Modifier = Modifier,
    sheetState: SheetState,
    amount: String,
    onAmountChange: (String) -> Unit,
    onDismiss: () -> Unit,
    onClickDonate: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = HOW_MUCH_DONATE,
                textAlign = TextAlign.Start,
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                )
            )
            Spacer(modifier = modifier.height(20.dp))
            DonationInputField(
                title = AMOUNT,
                value = amount,
                onValueChange = {
                    onAmountChange(it)
                }
            )
            Spacer(modifier = modifier.height(10.dp))
            PaymentInputField(
                title = PAYMENT_METHOD,
                image = R.drawable.mastercard,
                value = TEMP_PAYMENT_METHOD
            )
            Spacer(modifier = modifier.height(20.dp))
            Button(
                modifier = modifier.fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorPrimary, contentColor = Color.Black),
                onClick = onClickDonate
            ) {
                Text(
                    text = DONATE_NOW,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                    )
                )
            }
        }
    }
}