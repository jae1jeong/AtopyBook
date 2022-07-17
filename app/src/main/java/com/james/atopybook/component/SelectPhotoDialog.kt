package com.james.atopybook.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.window.Dialog
import com.james.atopybook.R


@Composable
fun SelectPhotoDialog(
    onDismissRequest:()->Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        androidx.compose.material.Surface(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .wrapContentHeight(),
            color = Color.White
        ) {
            Column {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "사진 촬영하기")
                }
                Divider(color = colorResource(id = R.color.light_gray))
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "갤러리에서 가져오기")
                }
            }
        }
    }
}