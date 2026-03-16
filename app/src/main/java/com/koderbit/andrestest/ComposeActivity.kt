package com.koderbit.andrestest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.koderbit.andrestest.ui.theme.AndresTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndresTestTheme(darkTheme = true, dynamicColor = false, content = {

            })

            AndresTestTheme(darkTheme = true, dynamicColor = false) {

            }
        }
    }
}

@Composable
fun MyComposable(modifier: Modifier = Modifier) {

}