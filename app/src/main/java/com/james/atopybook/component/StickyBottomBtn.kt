package com.james.atopybook.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.james.atopybook.R


@Composable
fun StickyBottomBtn(
    text:String,
    onClick:()->Unit,
    modifier: Modifier = Modifier,
    enabled:Boolean
){
    Box(contentAlignment = Alignment.BottomCenter,
        modifier = modifier
        ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
            , onClick = onClick,
            shape = RoundedCornerShape(16.dp),
            contentPadding = PaddingValues(vertical = 18.dp),
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id =  R.color.purple), disabledBackgroundColor = colorResource(
                id = R.color.disable_purple
            ) )
            ) {
            Text(text = text, color = Color.White, fontSize = 16.sp)
        }
    }
}