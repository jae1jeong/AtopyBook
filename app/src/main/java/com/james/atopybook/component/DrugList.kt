package com.james.atopybook.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.james.atopybook.data.model.Drug

@Composable
fun DrugList(
    modifier: Modifier = Modifier,
    drugList:List<Drug>
){
    LazyColumn(modifier = modifier.fillMaxWidth()
    ){
        itemsIndexed(drugList){ index,drug->
            DrugItem(drug = drug, modifier = Modifier.wrapContentSize())
        }
    }
    
}
