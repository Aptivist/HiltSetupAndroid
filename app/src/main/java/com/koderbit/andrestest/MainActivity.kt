package com.koderbit.andrestest

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.koderbit.andrestest.di.modules.Person
import com.koderbit.andrestest.di.modules.RandomNumber
import com.koderbit.andrestest.ui.theme.AndresTestTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //field injection
    @Inject
    lateinit var greeting : IGreetingService
    @Inject
    lateinit var number : RandomNumber


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndresTestTheme {
               Scaffold { paddingValues ->
                   Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
                       Text(greeting.getGreeting())
                       Text("Random number: ${number.number}")
                   }
               }
            }
        }
    }

}
