package com.james.atopybook.component

import androidx.compose.foundation.layout.*
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
import com.james.atopybook.data.model.Drug


@Composable
fun DrugItem(
    modifier: Modifier = Modifier,
    drug: Drug
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 14.dp, bottom = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = modifier) {
            Row(modifier = modifier) {
                Text(text = drug.name, fontSize = 17.sp, color = colorResource(id = R.color.drug_main_text_color))
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = drug.drugType.name,
                    fontSize = 13.sp,
                    color = colorResource(id = R.color.sub_text_color)
                )
            }
            Text(
                text = "하루 ${drug.perDay}번",
                fontSize = 15.sp,
                color = colorResource(id = R.color.sub_text_color)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        IconButton(onClick = { drug.isSelected = !drug.isSelected }) {
            Icon(
                painter = painterResource(id = if (drug.isSelected) R.drawable.ic_check_active else R.drawable.ic_check_inactive),
                contentDescription = "itemSelected"
            )
        }


    }
}