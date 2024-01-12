package com.example.gigsandcare.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gigsandcare.R
import com.example.gigsandcare.ui.theme.lightYellow

@Composable
fun RoundedCornerIconButton(
    modifier: Modifier,
    icon: Int,
    title: String
) {
    Box(
        modifier = modifier
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
    }
    /*Column(
        verticalArrangement = Arrangement.spacedBy(3.dp)
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
}

@Preview
@Composable
fun RoundedCornerIconButtonPreview() {
    RoundedCornerIconButton(
        modifier = Modifier,
        icon = R.drawable.charity,
        title = "Charity Program"
    )
}