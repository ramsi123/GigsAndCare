package com.example.gigsandcare.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import com.example.gigsandcare.util.Constants.ADD_EVENT
import com.example.gigsandcare.util.Constants.ADD_UPCOMING_EVENT
import com.example.gigsandcare.util.Constants.DATE
import com.example.gigsandcare.util.Constants.DESCRIPTION
import com.example.gigsandcare.util.Constants.TITLE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEventBottomSheet(
    modifier: Modifier = Modifier,
    sheetState: SheetState,
    title: String,
    onTitleChange: (String) -> Unit,
    date: String,
    description: String,
    onDescriptionChange: (String) -> Unit,
    onDismiss: () -> Unit,
    onClickDatePicker: () -> Unit,
    onClickAddEvent: () -> Unit,
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
                text = ADD_UPCOMING_EVENT,
                textAlign = TextAlign.Start,
                style = TextStyle(
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                )
            )
            Spacer(modifier = modifier.height(20.dp))
            InputField(
                title = TITLE,
                value = title,
                onValueChange = onTitleChange
            )
            Spacer(modifier = modifier.height(15.dp))
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                text = DATE,
                textAlign = TextAlign.Start,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                )
            )
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .clickable {
                        onClickDatePicker()
                    },
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.CalendarToday,
                    contentDescription = null
                )
                Text(
                    text = date,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
                    )
                )
            }
            Spacer(modifier = modifier.height(15.dp))
            InputField(
                title = DESCRIPTION,
                value = description,
                onValueChange = onDescriptionChange
            )
            Spacer(modifier = modifier.height(20.dp))
            Button(
                modifier = modifier.fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorPrimary, contentColor = Color.Black),
                onClick = onClickAddEvent
            ) {
                Text(
                    text = ADD_EVENT,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                    )
                )
            }
        }
    }
}