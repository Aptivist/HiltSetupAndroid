package com.koderbit.andrestest.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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

@Composable
fun ListItem(modifier: Modifier = Modifier, position: Int) {

    val counter = remember { mutableIntStateOf(0) }

    Card(modifier = modifier.clickable(true, onClick = { counter.intValue++})) {
        Text(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(16.dp), text = "I'm the $position card, count = ${counter.intValue}")
    }
}