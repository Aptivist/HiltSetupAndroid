package com.koderbit.andrestest.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyCheckButton(
    modifier: Modifier = Modifier,
    enabled: Boolean,
    onToggle: (Boolean) -> Unit
) {

    Box(
        modifier = modifier
            .background(if (enabled) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary)
            .clickable(enabled = true) {
                onToggle.invoke(!enabled)
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = if (enabled) Icons.Default.Close else Icons.Default.Check,
            contentDescription = "Toggle Button",
            tint = MaterialTheme.colorScheme.surface
        )
    }
}


@Composable
fun ErrorButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
    ) {
        Text(text = text)
    }
}

//Preview
@Preview(device = "spec:width=673dp,height=841dp", showSystemUi = true)
@Preview(device = "spec:width=411dp,height=891dp", showSystemUi = true)
@Composable
fun ErrorButtonPreview() {
    Scaffold { padding ->
        Box(modifier = Modifier.padding(padding)) {
            ErrorButton(text = "Sample", onClick = {})

        }
    }
}