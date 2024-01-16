package com.example.gigsandcare.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gigsandcare.R

@Composable
fun RoundedCornerIconButton(
    modifier: Modifier,
    icon: Int,
    title: String,
    onClick: () -> Unit
) {
    /*Box(
        modifier = modifier
            .size(55.dp)
            .background(color = lightYellow, shape = RoundedCornerShape(10.dp))
            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
            .clickable {},
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = modifier.padding(15.dp),
            bitmap = ImageBitmap.imageResource(id = icon),
            contentDescription = "rounded_corner_icon_button"
        )
    }*/
    /*Column(
        verticalArrangement = Arrangement.spacedBy(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .background(color = lightYellow, shape = RoundedCornerShape(10.dp))
                .clickable {},
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = modifier.padding(20.dp),
                bitmap = ImageBitmap.imageResource(id = icon),
                contentDescription = "rounded_corner_icon_button"
            )
        }
        Text(text = title, fontSize = 9.sp)
    }*/
    Column(
        modifier = modifier
            .clickable {
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            modifier = Modifier
                .size(35.dp),
            painter = painterResource(id = icon),
            contentDescription = null
        )
        Text(
            modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 5.dp),
            text = title,
            fontSize = 10.sp,
            textAlign = TextAlign.Center,
            lineHeight = 15.sp
        )
    }
}

@Preview
@Composable
fun RoundedCornerIconButtonPreview() {
    RoundedCornerIconButton(
        modifier = Modifier,
        icon = R.drawable.charity,
        title = "Charity Program",
        onClick = {}
    )
}