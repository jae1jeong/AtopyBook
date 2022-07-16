package com.james.atopybook.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TextRecord(
    maxLength: Int,
    text: String,
    onValueChanged:(String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = "텍스트 기록")
        Spacer(modifier = Modifier.height(5.dp))
        // TODO: add focus listener then clear hint
        BasicTextField(
            value = text, onValueChange = onValueChanged,
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(200.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color.White)
                .padding(20.dp),
        ){
            if(text.isEmpty()){
                Text(text = "증상에 대한 나의 생각이나 느낌을 기록하세요.\n" +
                        "나중에 의사선생님과 상의할 때 도움이 된답니다!\n" +
                        "(예 : 보습제를 다른 것으로 바꿔야겠어.)", fontSize = 14.sp)
            }else{
                Text(text = text)
            }
        }
        Text(text = "${text.length}/$maxLength", modifier = Modifier
            .padding(top = 5.dp)
            .align(Alignment.End))


    }
}