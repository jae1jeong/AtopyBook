package com.james.atopybook.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.james.atopybook.R


@Composable
fun SearchFieldOutlined(
    modifier: Modifier = Modifier,
    words: String,
    hint: String,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = words,
        onValueChange = onValueChanged,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = colorResource(id = R.color.outlined_color)
        ),
        label = { Text(text = hint) }
    )
}