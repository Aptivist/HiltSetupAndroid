package com.koderbit.andrestest.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StateAndReusable(padding: PaddingValues) {

    val enableButton = remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .background(Color.Red)
        .padding(padding)
        .fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {

            Switch(checked = enableButton.value, onCheckedChange = { newValue ->
                enableButton.value = newValue
            })

            FilledTonalButton(
                onClick = {
                    println("I'm Clicked")
                },
                enabled = enableButton.value,
                content = {
                    Text("I'm a button")
                })

            MyCheckButton(modifier= Modifier.width(120.dp), enabled = enableButton.value) { newValue ->
                enableButton.value = newValue
            }
        }

    }
}