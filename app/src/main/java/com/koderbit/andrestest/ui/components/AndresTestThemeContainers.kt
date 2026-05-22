package com.koderbit.andrestest.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessibilityNew
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Crop
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//Containers
@Composable
fun MyContainer(modifier: Modifier = Modifier, content: () -> Unit) {
    content.invoke()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContainersSample(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Hi")
                },
                navigationIcon = {
                    Icon(
                        Icons.Default.Menu,
                        contentDescription = "menu"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors()
            )
        },
        bottomBar = {
            BottomAppBar() {
                NavigationBar() {
                    NavigationBarItem(
                        selected = true,
                        onClick = {},
                        icon = {
                            Icon(
                                Icons.Default.Camera,
                                contentDescription = "nav_icon"
                            )
                        })
                    NavigationBarItem(
                        selected = false,
                        onClick = {},
                        icon = {
                            Icon(
                                Icons.Default.Crop,
                                contentDescription = "nav_icon"
                            )
                        })
                }
            }
        }) { padding ->

        Box(modifier = Modifier
            .padding(padding)
            .fillMaxSize(), contentAlignment = Alignment.Center){

            Column(verticalArrangement = Arrangement.spacedBy(50.dp)) {

                OutlinedCard(modifier = Modifier
                    .size(120.dp)
                    .clickable(true, onClick = {}),
                    colors = CardDefaults.cardColors().copy(containerColor = MaterialTheme.colorScheme.surface,
                        contentColor = MaterialTheme.colorScheme.onSurface)) {

                    Icon(Icons.Default.AccessibilityNew, contentDescription = null)
                    Text("ferf")

                }

                Surface(
                    modifier = Modifier
                        .size(120.dp)
                        .clickable(true, onClick = {}),
                    shape = CardDefaults.shape,
                    border = BorderStroke(1.dp, Color.Black),
                    shadowElevation = 10.dp,
                ) {
                    Column(content = {
                        Icon(Icons.Default.AccessibilityNew, contentDescription = null)
                        Text("ferf")
                    })
                }

                MyCard(
                    modifier = Modifier
                        .size(120.dp)
                        .clickable(true, onClick = {}),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Icon(Icons.Default.AccessibilityNew, contentDescription = null)
                    Text("ferf")
                }
            }
        }
    }
}