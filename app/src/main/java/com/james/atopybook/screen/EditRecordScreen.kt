package com.james.atopybook.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.james.atopybook.R
import com.james.atopybook.component.*


@Composable
fun EditRecordScreen(
    title: String,
    subTitle: String,
    textInputLength: Int = 200,
    nextBtnOnClick: (String,List<String>) -> Unit,
    headerBtnOnClick: () -> Unit,
) {
    var bottomBtnEnabled by remember {
        mutableStateOf(false)
    }
    var symptomText by remember {
        mutableStateOf("")
    }

    var showSelectPhotoDialog by remember {
        mutableStateOf(false)
    }

    val symptomTextChanged = { text: String ->
        if (text.length <= textInputLength) symptomText = text
        bottomBtnEnabled = symptomText.isNotEmpty()
    }

    var photos by remember {
        mutableStateOf(listOf(
            null,
            "https://cdn.spotvnews.co.kr/news/photo/202206/532813_745010_1738.jpg",
            "https://cdn.spotvnews.co.kr/news/photo/202206/532813_745010_1738.jpg"
        ))
    }

    if(showSelectPhotoDialog){
        SelectPhotoDialog(){
            showSelectPhotoDialog = !showSelectPhotoDialog
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.noel))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, top = 20.dp, end = 20.dp)
        ) {
            Header(title = title, subTitle = subTitle, btnOnClick = headerBtnOnClick)
            TextRecord(
                maxLength = textInputLength,
                text = symptomText,
                onValueChanged = symptomTextChanged,
            )
            Spacer(modifier = Modifier.padding(top = 51.dp))
            Text(text = stringResource(id = R.string.photo_record))
        }
        PhotoRecordList(
            photos = photos, modifier = Modifier
        ) {
            showSelectPhotoDialog = true
        }

        StickyBottomBtn(
            text = stringResource(id = R.string.next),
            onClick = {nextBtnOnClick(symptomText,photos.filterNotNull())},
            modifier = Modifier.padding(top = 51.dp, bottom = 20.dp),
            enabled = bottomBtnEnabled
        )
    }

}