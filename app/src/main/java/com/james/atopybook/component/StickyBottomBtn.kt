package com.james.atopybook.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun StickyBottomBtn(
    text:String,
    onClick:()->Unit,
    modifier: Modifier = Modifier
){
    Box(contentAlignment = Alignment.BottomCenter,
        modifier = modifier
        ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
            , onClick = onClick,
            shape = RoundedCornerShape(16.dp),
            contentPadding = PaddingValues(vertical = 18.dp)

            ) {
            Text(text = text, color = Color.White, fontSize = 16.sp)
        }
    }
}