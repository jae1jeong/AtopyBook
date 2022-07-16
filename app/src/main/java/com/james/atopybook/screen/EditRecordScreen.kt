package com.james.atopybook.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.james.atopybook.component.Header
import com.james.atopybook.component.PhotoRecordList
import com.james.atopybook.component.StickyBottomBtn
import com.james.atopybook.component.TextRecord


@Composable
fun EditRecordScreen(
    title: String,
    subTitle: String,
    textInputLength: Int = 500,
    nextBtnOnClick: () -> Unit,
    headerBtnOnClick: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize().background(Color.Magenta)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, top = 20.dp, end = 20.dp)
        ) {
            Header(title = title, subTitle = subTitle, btnOnClick = headerBtnOnClick)
            TextRecord(maxLength = textInputLength, paddingHorizontal = 10.dp)
            Spacer(modifier = Modifier.padding(top = 51.dp))
            Text(text = "사진 기록")
        }
        PhotoRecordList(
            photos = listOf(
                null,
                "https://cdn.spotvnews.co.kr/news/photo/202206/532813_745010_1738.jpg",
                "https://cdn.spotvnews.co.kr/news/photo/202206/532813_745010_1738.jpg"
            ), modifier = Modifier
        )

        StickyBottomBtn(
            text = "다음",
            onClick = nextBtnOnClick,
            modifier = Modifier.padding(top = 51.dp, bottom = 20.dp)
        )


    }

}