package com.koderbit.andrestest.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.koderbit.andrestest.ListItem

@Composable
fun Grids(modifier: Modifier = Modifier) {
    /*LazyHorizontalGrid(
                       modifier = modifier,
                       rows = GridCells.Fixed(3),
                       verticalArrangement = Arrangement.spacedBy(8.dp),
                       horizontalArrangement = Arrangement.spacedBy(8.dp)
                   ) {
                       items(10000){ pos ->
                           ListItem(modifier = Modifier, position = pos)
                       }
                   }*/

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(10000){ pos ->
            ListItem(modifier = Modifier, position = pos)
        }
    }
}