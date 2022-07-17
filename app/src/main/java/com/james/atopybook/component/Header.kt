package com.james.atopybook.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.james.atopybook.R


@Composable
fun Header(
    title: String,
    subTitle: String,
    modifier: Modifier = Modifier,
    btnOnClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            IconButton(
                onClick = btnOnClick,
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
                    .background(
                        color = colorResource(id = R.color.light_gray_100),
                        shape = RoundedCornerShape(90.dp)
                    ),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_left),
                    contentDescription = "backBtn",
                    modifier = Modifier
                )
            }
            Image(painter = painterResource(id = R.drawable.ic_header_decor), contentDescription = "headerDecor")
        }

        Text(
            text = title, fontSize = 20.sp, color = colorResource(id = R.color.text_black),
            modifier = Modifier.padding(top = 24.dp)
        )
        Text(
            text = subTitle,
            fontSize = 13.sp,
            color = colorResource(id = R.color.text_sub_title_color),
            modifier = Modifier.padding(top = 5.dp, bottom = 20.dp)
        )
    }

}