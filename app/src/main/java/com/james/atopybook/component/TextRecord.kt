package com.james.atopybook.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.james.atopybook.R


@Composable
fun TextRecord(
    maxLength: Int,
    paddingHorizontal: Dp = 0.dp,
    paddingVertical: Dp = 0.dp
) {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "텍스트 기록")
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            label = {Text("증상에 대한 나의 생각이나 느낌을 기록하세요.\n" +
                    "나중에 의사선생님과 상의할 때 도움이 된답니다!\n" +
                    "(예 : 보습제를 다른 것으로 바꿔야겠어.)")},
            value = text, onValueChange = {
                if (it.length <= maxLength) text = it
            }, modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(200.dp)
                .clip(RoundedCornerShape(16.dp)),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Text(text = "${text.length}/$maxLength", modifier = Modifier
            .padding(top = 5.dp)
            .align(Alignment.End))


    }
}