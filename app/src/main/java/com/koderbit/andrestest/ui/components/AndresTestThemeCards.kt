package com.koderbit.andrestest.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun MyCard(modifier: Modifier = Modifier, shape : Shape = CardDefaults.shape, content: @Composable ColumnScope.() -> Unit) {
    Surface(
        modifier = modifier,
        shape = shape,
        border = BorderStroke(1.dp, Color.Black),
        shadowElevation = 10.dp,
    ) {
        Column(content = content)
    }
}