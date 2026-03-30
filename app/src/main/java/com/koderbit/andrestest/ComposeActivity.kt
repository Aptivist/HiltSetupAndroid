package com.koderbit.andrestest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.koderbit.andrestest.ui.loginview.LoginView
import com.koderbit.andrestest.ui.theme.AndresTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndresTestTheme {
                Scaffold { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues)){
                        LoginView()
                    }
                }
            }
        }
    }
}


//Reusable component

@Composable
fun ErrorButton(modifier: Modifier = Modifier, text : String, onClick: () -> Unit) {
    Button(modifier = modifier, onClick = onClick, colors = ButtonDefaults.buttonColors(containerColor = Color.Red)) {
        Text(text = text)
    }
}

@Preview(device = "spec:width=673dp,height=841dp", showSystemUi = true)
@Preview(device = "spec:width=411dp,height=891dp", showSystemUi = true)
@Composable
fun ErrorButtonPreview(){
    Scaffold { padding ->
        Box(modifier = Modifier.padding(padding)){
            ErrorButton(text = "Sample", onClick = {})

        }
    }
}
