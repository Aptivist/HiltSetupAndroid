package com.koderbit.andrestest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Crop
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.koderbit.andrestest.ui.loginview.LoginView
import com.koderbit.andrestest.ui.theme.AndresTestTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class ComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndresTestTheme {
                Scaffold(topBar = {
                    CenterAlignedTopAppBar(title = {
                        Text("Hi")
                    }, navigationIcon = { Icon(Icons.Default.Menu, contentDescription = "menu")}, colors = TopAppBarDefaults.topAppBarColors())
                },
                    bottomBar = {
                        BottomAppBar() {
                            NavigationBar() {
                                NavigationBarItem(selected = true, onClick = {}, icon = { Icon(Icons.Default.Camera,contentDescription = "nav_icon")})
                                NavigationBarItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.Crop,contentDescription = "nav_icon")})
                            }
                        }
                    }) { padding ->

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

            }
        }
    }
}

@Composable
fun MyCheckButton(modifier: Modifier = Modifier, enabled : Boolean, onToggle : (Boolean) -> Unit) {

    Box(modifier = modifier
        .background(if (enabled) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary)
        .clickable(enabled = true){
            onToggle.invoke(!enabled)
        },
        contentAlignment = Alignment.Center
    ){
        Icon( imageVector = if(enabled) Icons.Default.Close else Icons.Default.Check, contentDescription = "Toggle Button", tint = MaterialTheme.colorScheme.surface)
    }
}

//Containers
@Composable
fun MyContainer(modifier: Modifier = Modifier, content: () -> Unit) {
    content.invoke()
}


//Reusable component
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
