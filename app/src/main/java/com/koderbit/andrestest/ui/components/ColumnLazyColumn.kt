package com.koderbit.andrestest.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.koderbit.andrestest.ListItem

@Composable
fun ColumnPlusLazy(modifier: Modifier = Modifier) {

    val scrollableState = rememberScrollState()

    Column(modifier = modifier.then(Modifier.verticalScroll(scrollableState)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for (i in 0..1000) {
            ListItem(modifier = Modifier.fillMaxWidth(0.9f), i)
        }
    }

   /* LazyColumn(modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(50000){ position ->
            ListItem(modifier = Modifier.fillMaxWidth(0.9f), position)
        }
    }*/

}