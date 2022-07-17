package com.james.atopybook.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.james.atopybook.R
import com.james.atopybook.component.*
import com.james.atopybook.data.model.Drug
import com.james.atopybook.data.model.DrugType
import com.james.atopybook.views.search_drug.SearchDrugViewModel

@Composable
fun SearchDrugScreen(
    viewModel: SearchDrugViewModel,
    searchDrugResults: List<Drug>,
    lastSearchResults: List<Drug>
) {

    var searchWords by remember { mutableStateOf("") }
    val searchWordsChanged: (String) -> Unit = { words: String ->
        searchWords = words
    }
    var isDrugSelected by remember { mutableStateOf(false) }

    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier,
            contentPadding = PaddingValues(20.dp)
          ) {
            item {  Header(
                title = "오늘은 어떤 약을 사용했나요?",
                subTitle = "어제와 비교하며 증상을 객관적으로 기록해주세요.",
                modifier = Modifier
            ) {}
                Spacer(modifier = Modifier.height(20.dp))
                SearchFieldOutlined(
                    hint = "복용/도포 약 검색",
                    onValueChanged = searchWordsChanged,
                    modifier = Modifier,
                    words = searchWords
                )
                if (lastSearchResults.isEmpty()) {
                    Text(text = "자주 사용하는 약", modifier = Modifier.padding(top = 20.dp))
                }
            }
            itemsIndexed(searchDrugResults){ index,drug->
                DrugItem(drug = drug, modifier = Modifier)
            }
            item{
                StickyBottomBtn(
                    text = stringResource(id = R.string.next),
                    onClick = { /*TODO*/ },
                    enabled = isDrugSelected
                )
            }
        }
    }
}