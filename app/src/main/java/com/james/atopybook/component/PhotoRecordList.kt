package com.james.atopybook.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.james.atopybook.R


@Composable
fun PhotoRecordList(
    photos: List<String?>,
    modifier: Modifier
) {
    val scrollState = rememberScrollState()
    Row(
        modifier = modifier
            .horizontalScroll(scrollState)
            .padding(top = 5.dp)
            .fillMaxWidth()
    ) {
        photos.forEachIndexed { index, photo ->

            Spacer(modifier = Modifier.width(10.dp))
            if(photo == null){
                PhotoAddBtn(modifier = Modifier)
            }else{
                Photo(imageUrl = photo)
            }
            if(photos.lastIndex == index){
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Photo(
    imageUrl: String?,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        onClick = { /*TODO*/ }) {
        Box(modifier = modifier
            .width(130.dp)
            .height(130.dp),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = rememberAsyncImagePainter(model = imageUrl),
                contentDescription = "ImageAddBtn",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(130.dp)
                    .background(
                        color = colorResource(id = R.color.white),
                    )
            )
        }
    }

}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PhotoAddBtn(modifier: Modifier){
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        onClick = { /*TODO*/ }) {
        Box(modifier = modifier
            .width(130.dp)
            .height(130.dp),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_camera), contentDescription = "AddImage",
            )
        }
    }
}