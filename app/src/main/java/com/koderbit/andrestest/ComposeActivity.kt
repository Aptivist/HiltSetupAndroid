package com.koderbit.andrestest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.koderbit.andrestest.ui.theme.AndresTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndresTestTheme {
                Scaffold() { padding ->
                    Box(modifier = Modifier.padding(padding).fillMaxSize().background(Color.Cyan)){

                        Column(modifier = Modifier.align(Alignment.BottomCenter).background(Color.Yellow)) {

                            ErrorButton(modifier = Modifier, text = "Click Me") {
                                println("Button Clicked")
                            }

                            ErrorButton(modifier = Modifier.align(Alignment.End), text = "Other Button", onClick = { println("Other Button Clicked") })
                            ErrorButton(modifier = Modifier.fillMaxWidth(0.8f), text = "Other Button", onClick = { println("Other Button Clicked") })
                            ErrorButton(text = "Other Button", onClick = { println("Other Button Clicked") })
                            ErrorButton(text = "Other Button", onClick = { println("Other Button Clicked") })
                            ErrorButton(text = "Other Button", onClick = { println("Other Button Clicked") })
                        }


                    }
                }
            }
        }
    }
}


@Composable
fun ErrorButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Button(modifier = modifier, onClick = onClick, colors = ButtonDefaults.buttonColors(containerColor = Color.Red)) {
        Text(text = text)
    }
}
