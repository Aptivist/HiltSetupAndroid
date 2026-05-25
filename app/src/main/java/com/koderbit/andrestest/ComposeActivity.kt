package com.koderbit.andrestest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessibilityNew
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Crop
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.koderbit.andrestest.ui.components.ColumnPlusLazy
import com.koderbit.andrestest.ui.components.Grids
import com.koderbit.andrestest.ui.components.MyCard
import com.koderbit.andrestest.ui.components.MyCheckButton
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

                val navController = rememberNavController()

                var isLoggedIn by remember { mutableStateOf(false) }

                NavHost(navController = navController,
                    startDestination = if (isLoggedIn) Screen.Home.route else Screen.Login.route,
                    builder = {
                        composable(Screen.Login.route) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                Column{
                                    Text("Login Screen")
                                    Button(onClick = { navController.navigate(Screen.Home.route) }) {
                                        Text("Go to home")
                                    }
                                }
                            }
                        }
                        composable(Screen.Home.route) {
                            HomeView(Modifier.fillMaxSize()){
                                navController.navigate(Screen.Settings.route, NavOptions.Builder().setPopUpTo(
                                    Screen.Home.route, true).build())
                            }
                        }
                        composable(Screen.Settings.route) {

                            SettingsView(Modifier.fillMaxSize()){
                                val route = when(it){
                                    SettingsViewActions.NavigateToHome -> Screen.Home.route
                                    SettingsViewActions.NavigateToLogin -> Screen.Login.route
                                }
                                navController.navigate(route, NavOptions.Builder().setPopUpTo(Screen.Home.route, true).build())
                            }
                        }
                    })

            }
        }
    }
}


@Composable
fun HomeView(modifier: Modifier = Modifier, onNavigateToSettings : () -> Unit) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column{
            Text("home Screen")
            Button(onClick = onNavigateToSettings) {
                Text("Go to settings")
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeView() {
    HomeView(modifier = Modifier.fillMaxSize()) {}
}

@Composable
fun SettingsView(modifier: Modifier, onSettingsViewAction : (SettingsViewActions) -> Unit){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text("settings Screen")
            Button(onClick = {
                onSettingsViewAction.invoke(SettingsViewActions.NavigateToLogin)
            }) {
                Text("Go to login")
            }
            Button(onClick = {
                onSettingsViewAction.invoke(SettingsViewActions.NavigateToHome)
            }) {
                Text("Go to home")
            }
        }
    }
}

sealed class SettingsViewActions() {
    data object NavigateToLogin : SettingsViewActions()
    data object NavigateToHome : SettingsViewActions()
}


sealed class Screen(val route: String) {
    data object Home: Screen("home")
    data object Settings: Screen("settings")
    data object Login: Screen("login")
}

enum class ScreenEnum(val route: String){
    HOME("home"),
    SETTINGS("settings"),
    LOGIN("login")
}