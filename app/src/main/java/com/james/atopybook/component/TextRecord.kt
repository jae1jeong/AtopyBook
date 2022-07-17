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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.james.atopybook.R


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
                Text(text = stringResource(id = R.string.edit_symptom_hint), fontSize = 14.sp)
            }else{
                Text(text = text)
            }
        }
        Text(text = "${text.length}/$maxLength", modifier = Modifier
            .padding(top = 5.dp)
            .align(Alignment.End))


    }
}